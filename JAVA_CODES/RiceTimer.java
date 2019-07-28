import java.awt.Toolkit ; import java.util.Timer ; import java.util.TimerTask ;

public class RiceTimer { private final Timer timer = new Timer () ; private final int minutes ; public RiceTimer( int minutes ) { this.minutes = minutes ; } public void start() { timer.schedule(new TimerTask() { public void run () { playSound () ; timer.cancel () ; } private void playSound() { System.out.println ( " Your rice is ready! " ); Toolkit.getDefaultToolkit().beep() ; } }, minutes * 60 * 1000); } public static void main( String[] args ) { RiceTimer riceTimer = new RiceTimer (1) ; riceTimer.start () ; } }

