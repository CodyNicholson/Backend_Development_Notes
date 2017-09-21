import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.FileOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleFTPClient {
	Socket client_socket;
	DataInputStream input;
	DataOutputStream output;

	public SimpleFTPClient( int port_number ) throws IOException {
		client_socket= new Socket("localhost", port_number);
		input= new DataInputStream( client_socket.getInputStream() );
		output= new DataOutputStream( client_socket.getOutputStream() );
	}
	
	public long getFile( String file_name ) throws IOException {
		output.writeUTF( file_name );
		long file_size= input.readLong();
		if ( file_size == 0 )
			return 0;
		FileOutputStream file_out= new FileOutputStream( file_name );	
		int number_read;
		byte[] buffer= new byte[1500];
		while( (number_read= input.read( buffer)) != -1 )
			file_out.write( buffer, 0, number_read );
		file_out.close();
		return file_size;
	}
	
	public void close() throws IOException {
		client_socket.close();
	}
	
	public static void main(String[] args) {
		// get port number and file name from command line
		if ( args.length != 2 )
		{
			System.out.println( "Usage: java SimpleFTPClient <port number> <file name>" );
			return;
		}
		int port_number= Integer.valueOf( args[0] );
		try{
			SimpleFTPClient client= new SimpleFTPClient(port_number);
			long file_size= client.getFile(args[1]);
			if ( file_size > 0 )
				System.out.println( "File length: " + file_size );
			else
				System.out.println( "No file received" );						
		}
		catch ( Exception e ){
			System.out.println( e.getMessage() );
		}		
	}

}
