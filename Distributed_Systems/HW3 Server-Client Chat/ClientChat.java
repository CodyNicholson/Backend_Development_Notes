import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;

public class ClientChat
{
	class InputSimul implements Runnable
    {
		Socket socket;

		InputSimul(Socket socket)
        {
			this.socket = socket;
		}

		@Override
		public void run()
        {
			String line;
			try
            {
				DataOutputStream output = new DataOutputStream(socket.getOutputStream());
				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				while((line = reader.readLine())!=null)
                {
					if(line.equals("")){output.writeUTF(""); return;}
					output.writeUTF((line));
				}
				socket.close();
				System.exit(0);
			}
            catch (Exception e)
            {
				System.exit(1);
			}
		}
	}


	public static void main(String[] args)
    {

		if(args.length<1 || args.length>2)
        {
			System.out.println("Invalid arguments. Expected <port number> [optional: <server address>]");
			System.exit(0);
		}

		int port = Integer.parseInt(args[0]);
		try
        {
			InetAddress address = (args.length==2)?InetAddress.getByName(args[1]):InetAddress.getLoopbackAddress();
			Socket client_socket = new Socket(address, port);
			DataInputStream input = new DataInputStream(client_socket.getInputStream());
			ClientChat m = new ClientChat();
			InputSimul is = m.new InputSimul(client_socket);
			Thread thr = new Thread(is);
			thr.start();

			String line;
			while((line = input.readUTF())!=null)
            {
				if(line.equals("")){break;}
				System.out.println(line);
			}
			client_socket.close();
			System.exit(0);
		}
        catch (Exception e)
        {
			// Do nothing
		}
	}
}
