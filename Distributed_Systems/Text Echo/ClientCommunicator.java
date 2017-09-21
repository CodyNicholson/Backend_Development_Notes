/**
 * ClientCommunicator.java
 * Performs the communication for the EchoClient
 * 
 * @author Karen Heart
 * 
 * Last modified: 4-1-15
 */

import java.net.InetAddress;
import java.net.Socket;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class ClientCommunicator {
	int port_number;
	InetAddress loopback;
	Socket client_socket;
	PrintWriter output;
	BufferedReader input;

	public ClientCommunicator( int port ) throws IOException
	{
		port_number= port;
		loopback= InetAddress.getLoopbackAddress();
		// try to connect to the server
		client_socket= new Socket( loopback, port_number );
		// grab the output and input streams
		output= new PrintWriter( client_socket.getOutputStream(), true );
		input= new BufferedReader( new InputStreamReader( client_socket.getInputStream() ) );
	}

	void communicate( String message ) throws IOException
	{
		// send a message
		System.out.println( "Sending message to the server..." );
		output.println( message );
		
		// receive a message
		String response= input.readLine();
		if ( response.isEmpty() )
			System.out.println( "(server did not reply with a message)" );
		else
		{
			System.out.println( "Server response:" );
			System.out.println( response );
		}		
	}
	
	void close()
	{
		try
		{
			client_socket.close();
		}
		catch( Exception e )
		{
			// ignore
		}
	}
}
