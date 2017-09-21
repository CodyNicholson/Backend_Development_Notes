import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Messenger
{
	// Implement runnable to use threads
	class ReadMessage implements Runnable
	{
		BufferedReader reader;
		DataOutputStream output;

		ReadMessage(DataOutputStream dos, BufferedReader br)
		{
			reader = br;
			output = dos;
		}

		// Every time we start a thread the run method will be called
		public void run()
		{
			String line;

			try
			{
				while((line = reader.readLine()) != null)
				{
					if(line.equals(""))
					{
						output.writeUTF("");
						return;
					}
					output.writeUTF((line));
				}
			}
			catch (Exception e)
			{
				System.exit(1);
			}
		}
	}

	public static void main(String[] args) throws InterruptedException
	{
		// Server code
		if(args.length == 2  && args[0].equals("-l"))
		{
			// Get port number
			int port_number = Integer.parseInt(args[1]);

			try
			{
				// Creates a socket
				ServerSocket socket = new ServerSocket(port_number);

				// Listens for a connection to be made to this socket and accepts it
				Socket wait_socket = socket.accept();

				// Gets the input stream for this socket
				DataInputStream input = new DataInputStream(wait_socket.getInputStream());

				// Gets the output stream for this socket
				DataOutputStream output = new DataOutputStream(wait_socket.getOutputStream());

				// An InputStreamReader is a bridge from byte streams to character streams:
				// It reads bytes and decodes them into characters using a specified charset
				InputStreamReader ISR = new InputStreamReader(System.in);

				// Reads text from a character-input stream, buffering characters so as to
				// provide for the efficient reading of characters, arrays, and lines
				BufferedReader reader = new BufferedReader(ISR);

				String line = "";
				Messenger messenger = new Messenger();

				// Allocate a new Thread object using the ReadMessage class and run it
				ReadMessage rm = messenger.new ReadMessage(output, reader);
				Thread thread = new Thread(rm);
				thread.start();

				// Keep reading and outputting inputs until the user enters null as an input
				while((line = input.readUTF()) != null)
				{
					if(line.length() == 0)
					{
						break;
					}
					System.out.println(line);
				}

				// Stop since the user is done
				socket.close();
				wait_socket.close();
				System.exit(0);
			}
			catch (Exception e)
			{
				// Do nothing
			}
		}
		// Client code
		else if ((args.length == 1 || args.length == 2))
		{
			// Get port number
			int port_number = Integer.parseInt(args[0]);

			try
			{
				// Get the server address if one was provided
				InetAddress server_address;
				if(args.length == 2)
				{
					server_address = InetAddress.getByName(args[1]);
				}
				else
				{
					server_address = InetAddress.getLoopbackAddress();
				}

				// Create a client socket
				Socket client_socket = new Socket(server_address, port_number);

				// Get the input stream for this socket
				DataInputStream input = new DataInputStream(client_socket.getInputStream());

				// Get the output stream for thsi socket
				DataOutputStream output = new DataOutputStream(client_socket.getOutputStream());

				// An InputStreamReader is a bridge from byte streams to character streams:
				// It reads bytes and decodes them into characters using a specified charset
				InputStreamReader ISR = new InputStreamReader(System.in);

				// Reads text from a character-input stream, buffering characters so as to
				// provide for the efficient reading of characters, arrays, and lines
				BufferedReader reader = new BufferedReader(ISR);

				String line = "";
				Messenger messenger = new Messenger();

				// Allocate a new Thread object using the ReadMessage class and run it
				ReadMessage rm = messenger.new ReadMessage(output, reader);
				Thread thread = new Thread(rm);
				thread.start();

				// Keep reading and outputting inputs until the user enters a null value
				while((line = input.readUTF()) != null)
				{
					if(line.length() == 0)
					{
						break;
					}
					System.out.println(line);
				}

				// Close the socket since the user is done
				client_socket.close();
				System.exit(0);
			}
			catch (Exception e)
			{
				// Do nothing
			}
		}
	}
}
