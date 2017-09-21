import java.net.*;
import java.io.*;


public class SimpleFTPServer {
	ServerSocket server_socket;
	Socket client_socket;
	DataInputStream input;
	DataOutputStream output;
	
	public SimpleFTPServer( int port_number ) throws IOException {
		server_socket= new ServerSocket( port_number );
		client_socket= server_socket.accept();
	}
	
	public void serviceRequest() throws IOException {
		input= new DataInputStream( client_socket.getInputStream() );
		output= new DataOutputStream( client_socket.getOutputStream() );		
		String file_name= input.readUTF();
		File file= new File( file_name );
		if ( file.exists() && file.canRead() )
		{
			// return the number of bytes in the file as a long int
			long file_size= file.length();
			if ( file_size > 0 )
				output.writeLong( file_size );
			else
			{
				output.writeLong( 0L );
				return;
			}
		}
		else
		{
			output.writeLong( 0L );			
			return;
		}
		FileInputStream file_input= new FileInputStream(file);
		System.out.println( "Transmitting file: " + file_name );
		byte[] file_buffer= new byte[1500];
		int number_read;
		while( (number_read= file_input.read( file_buffer )) != -1 )
			output.write( file_buffer, 0, number_read );
		file_input.close();		
	}
	
	public void close() throws IOException {
		client_socket.close();
		server_socket.close();
	}

	public static void main(String[] args) {
		if ( args.length != 1 )
		{
			System.out.println( "Usage: java SimpleFTPServer <port number>" );
			return;
		}
		int port_number= Integer.valueOf( args[0] );
		try{
			SimpleFTPServer server= new SimpleFTPServer( port_number );
			server.serviceRequest();
			server.close();			
		}
		catch ( Exception e ){
			System.out.println( e.getMessage() );
		}
	}

}
