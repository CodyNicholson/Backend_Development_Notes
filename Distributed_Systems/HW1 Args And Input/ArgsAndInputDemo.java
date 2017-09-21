import java.io.InputStreamReader;
import java.io.BufferedReader;

public class ArgsAndInputDemo {

	public static void main(String[] args) {
		// read the command line args
		if ( args.length < 2 )
		{
			System.err.println( "ArgsAndInputDemo requires 2 command line arguments" );
			return;
		}
		System.out.println( "Arg[0] is " + args[0] );
		System.out.println( "Arg[1] is " + args[1] );
		
		// read standard input
		try	{
			// input the message from standard input
			BufferedReader input= new BufferedReader( 
			  new InputStreamReader(System.in) );
			String line;
			while( (line= input.readLine()) != null )				
				System.out.println( "You entered: " + line );			
		}
		catch ( Exception e ) {
			System.out.println( e.getMessage() );
		}
	}
}
