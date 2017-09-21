import java.io.FileReader;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class ReadFile {

	public static void main(String[] args) {
		// get the name of the file from the command line argument
		if ( args.length != 1 )
		{
			System.out.println( "Usage:" );
			System.out.println( "   java ReadFile <file name>" );
			return;
		}
		
		try
		{
			// open the file for reading
			BufferedReader file= new BufferedReader( new FileReader( args[0] ) );
			
			// read the contents and output it to stdout
			String line= null;
			while( (line= file.readLine()) != null )
				System.out.println( line );
			file.close();
		}
		catch ( Exception e )
		{
			System.out.println( e.getMessage() );
		}
	}
}
