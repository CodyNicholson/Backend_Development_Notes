
public class Main {

	public static void main(String[] args) {
		
		// start two threads
		Sleepy s1= new Sleepy( "Hello", 5, 0 );
		Sleepy s2= new Sleepy( "World", 5, 1000 );
		Thread t1= new Thread( s1 );
		Thread t2= new Thread( s2 );
		t1.start();
		t2.start();
		try
		{
			t1.join();
			t2.join();
		}
		catch( Exception e )
		{
			// we don't care if the thread was interrupted....
		}
		
		System.out.println( "Exiting program..." );
	}

}
