/**
 * EchoClient.java
 * Connects with an EchoServer, sends a message, and displays any reply message
 * 
 * @author Karen Heart
 * 
 * Last modified: 4-1-15
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

 public class EchoClient {

	public static void main(String[] args) {
		if ( args.length != 1 )
		{
			System.out.println( "Usage:" );
			System.out.println( "   EchoClient <port number>" );
			return;
		}
		
		// retrieve command line argument for port
		int port_number= Integer.valueOf( args[0] );		
		
		try
		{
			// input the message from standard input
			BufferedReader reader= new BufferedReader( 
					 new InputStreamReader(System.in) );
			System.out.print( "Enter message: " );
			String message= reader.readLine();
			
			ClientCommunicator client= new ClientCommunicator( port_number );
			client.communicate(message);
			client.close();
		}
		catch ( Exception e )
		{
			System.out.println( e.getMessage() );
		}
}

}
