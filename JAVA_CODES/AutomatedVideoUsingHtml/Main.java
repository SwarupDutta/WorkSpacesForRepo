package test;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
	 
	public static void main(String[] args) {
		Timer timer = new Timer();
		TimerTask tt = new TimerTask(){
			public void run(){
				Calendar cal = Calendar.getInstance(); //this is the method you should use, not the Date(), because it is desperated.
 
				int hour = cal.get(Calendar.HOUR_OF_DAY);//get the hour number of the day, from 0 to 23
				System.out.println(hour);
				if(hour == 4){
					File htmlFile = new File("C:/Users/DUTTA/Desktop/DD.html");
		        	try {
						Desktop.getDesktop().browse(htmlFile.toURI());
						System.exit(0);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		timer.schedule(tt, 1000, 1000*5);//	delay the task 1 second, and then run task every five seconds
	}
}
