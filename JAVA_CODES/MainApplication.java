import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

 class ReportGenerator extends TimerTask {

  public void run() {
 Calendar date = Calendar.getInstance();date.set(Calendar.DAY_OF_WEEK,Calendar.MONDAY);System.out.print(date.get(Calendar.DAY_OF_WEEK));
    System.out.println("Generating report");
    //TODO generate report
  }

}

class MainApplication {

  public static void main(String[] args) {
    Timer timer = new Timer();
    Calendar date = Calendar.getInstance();
    /*date.set(Calendar.DAY_OF_WEEK,Calendar.SUNDAY);
  System.out.print(date.get(Calendar.DAY_OF_WEEK));
    date.set(Calendar.HOUR, 0);
    date.set(Calendar.MINUTE, 0);
    date.set(Calendar.SECOND, 0);
    date.set(Calendar.MILLISECOND, 0);*/
    // Schedule to run every Sunday in midnight
    timer.schedule(
      new ReportGenerator(),
      date.getTime(),
      1000 * 60 * 60 * 24 * 7
    );
  }
}