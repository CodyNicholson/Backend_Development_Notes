/**
 * ServerCommunicator.java
 * Performs the communication for the EchoServer
 * 
 * @author Karen Heart
 * 
 * Last modified: 4-1-15
 */

import java.net.ServerSocket;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ServerCommunicator {
	int port_number;
	ServerSocket server_socket;
	Socket client_socket;

	public ServerCommunicator( int port ) throws IOException {
		port_number= port;
		server_socket= new ServerSocket( port_number );
		System.out.println( "Listening on port " + Integer.toString( port_number ) );
	}
	
	public void listen() throws IOException
	{
		// listen for a connection
		client_socket= server_socket.accept();
		
		// grab the input and output streams
		BufferedReader reader= new BufferedReader( 
				 new InputStreamReader(client_socket.getInputStream()) );
		PrintWriter output= new PrintWriter( client_socket.getOutputStream(), true );
		
		// read the input
		String input_line= reader.readLine();
		System.out.println( "Received from client: " );
		System.out.println( input_line );

		// send the message back to the client
		output.println( input_line );
	}
	
	void close()
	{
		try
		{
			client_socket.close();
			System.out.println( "Listening concluded; shutting down..." );
			server_socket.close();
		}
		catch( Exception e )
		{
			// ignore
		}
	}
}
