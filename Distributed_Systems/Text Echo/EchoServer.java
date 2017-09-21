/**
 * EchoServer.java
 * Listens for an EchoClient, receives a message, and responds with the same message
 * 
 * @author Karen Heart
 * 
 * Last modified: 4-1-15
 */

public class EchoServer {

	public static void main(String[] args) {
		if ( args.length != 1 )
		{
			System.out.println( "Usage:" );
			System.out.println( "   EchoServer <port number>");
			return;
		}
		
		int port_number= Integer.valueOf( args[0] );
		ServerCommunicator server= null;
		try
		{
			server= new ServerCommunicator( port_number );
			server.listen();
		}
		catch ( Exception e )
		{
			System.out.println( e.getMessage() );
		}
		server.close();
	}

}
