import java.util.Timer ;
import java.util.TimerTask ;
public class MyTimer extends TimerTask
{ 
	Timer timer ; 
	int count = 0 ; 
	public MyTimer () { } 
	public MyTimer ( Timer timer ) 
	{ 
		this.timer = timer ; 
	} 
	public void toDo() 
	{ 		System.out.println( " Count-> " + (count++) + " : Hello World ! This is java scheduler " ); 
	} 
	@Override
	 public void run () 
	 { 
		toDo () ; 
		if (count > 10) 
		{
		// this is the condition when you want to stop the //
		timer.cancel () ; 
		} 
	 } 
}
