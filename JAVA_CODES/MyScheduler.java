import java.util.Timer ; 
public class MyScheduler 
{ 
	public static void main( String [] args ) 
	{ 
		Timer timer = new Timer() ;
		MyTimer myTask = new MyTimer ( timer ) ; 
		int firstSart = 1000 ; // it means after 1 second. 
		int period = 1000*2 ; //after which the task will repeat; 				
		timer.schedule(myTask, firstSart, period) ;//the time specifiedin millisecond. 
	} 
}
