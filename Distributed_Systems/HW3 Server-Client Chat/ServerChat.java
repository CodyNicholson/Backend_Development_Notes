import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


public class ServerChat
{
	static ArrayList<Socket> clientList = new ArrayList<Socket>();

	class ReadSimulServer implements Runnable
	{
		Socket socket;

		ReadSimulServer(Socket socket)
		{
			this.socket = socket;
		}

		@Override
		public void run()
		{
			String line;
			try
			{
				DataInputStream input = new DataInputStream(socket.getInputStream());
				while((line = input.readUTF())!=null)
				{
					if(line.equals("")){
						clientList.remove(socket);
						DataOutputStream output = new DataOutputStream(socket.getOutputStream());
						output.writeUTF("");
						break;
					}
					System.out.println(line);
					for(Socket s: clientList)
					{
						DataOutputStream output = new DataOutputStream(s.getOutputStream());
						if(!socket.equals(s)) output.writeUTF(line);
					}
				}
			}
			catch (Exception e)
			{
				System.exit(1);
			}
		}
	}

	class MultipleClients implements Runnable
	{
		ServerSocket servSock;
		MultipleClients(ServerSocket ss)
		{
			servSock = ss;
		}

		@Override
		public void run()
		{
			try
			{
				while(true)
				{
					Socket s = servSock.accept();
					clientList.add(s);
					ServerChat m = new ServerChat();
					ReadSimulServer rs = m.new ReadSimulServer(s);
					Thread thr = new Thread(rs);
					thr.start();
				}
			}
			catch (IOException e)
			{
				// Do Nothing
			}
		}
	}

	public static void main(String[] args)
	{
		if(args.length!=2 || !args[0].equals("-l"))
		{
			System.out.println("Invalid arguments. Expected -l <port number>");
			System.exit(0);
		}
		int port = Integer.parseInt(args[1]);
		try
		{
			ServerSocket socket = new ServerSocket(port);
			ServerChat m = new ServerChat();
			MultipleClients mc = m.new MultipleClients(socket);
			Thread mcthread = new Thread(mc);
			mcthread.start();
			String line;
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

			while(clientList.size()==0)
			{
				Thread.sleep(1000);
			}


			while((line = reader.readLine())!=null)
			{
				if(line.equals(""))
				{
					for(Socket i: clientList)
					{
						DataOutputStream output = new DataOutputStream(i.getOutputStream());
						output.writeUTF((line));
					}
					break;
				}
				for(Socket i: clientList)
				{
					DataOutputStream output = new DataOutputStream(i.getOutputStream());
					output.writeUTF((line));
				}
			}

			socket.close();
			System.exit(0);
		}
		catch (Exception e)
		{
			// Do nothing
		}
	}
}
