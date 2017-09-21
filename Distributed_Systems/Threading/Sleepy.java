
public class Sleepy implements Runnable {
	String data;
	int count, delay_start;
	
	public Sleepy( String data, int count, int delay_start )
	{
		this.data= data;
		this.count= count;
		this.delay_start= delay_start;
	}

	public void run()
	{
		waitForIt( delay_start );
		for( int i= 0; i < count; i++ )
		{
			waitForIt( 2000 );
			printMessage();
		}
	}
	
	void waitForIt( int millis )
	{
		try
		{
			Thread.sleep( millis );
		}
		catch( Exception e )
		{
			System.err.println( "Couldn't sleep..." );
		}
	}
	
	void printMessage()
	{		
		System.out.println( data );
	}
}
