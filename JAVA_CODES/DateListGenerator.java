import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class DateListGenerator 
{
	static List<String> getPreviousNDates(int n) 
	{
		List<String> PreviousNDates=new ArrayList<String>();

	    Calendar cal = Calendar.getInstance();
	    Date endDate=new Date();
	    cal.setTime(endDate);
	    cal.add(Calendar.DAY_OF_MONTH, -n);
	    Date startDate=cal.getTime();
	   for(Date oDate: getDaysBetweenDates(startDate,endDate))
	   {
			PreviousNDates.add(new SimpleDateFormat("yyyy-MM-dd").format(oDate).trim());

	   }
	   PreviousNDates.remove(new SimpleDateFormat("yyyy-MM-dd").format(endDate).trim());
	   return PreviousNDates;
	}
	static List<String> getYesterdayDateString() 
	{
		List<String> PreviousDate=new ArrayList<String>();

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		PreviousDate.add(dateFormat.format(cal.getTime()).trim());
		return PreviousDate;
	}
	static List<String> getPreviousMonthDates()
	{
		List<String> PreviousMonthDates=new ArrayList<String>();
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.MONTH, cal.get(Calendar.MONTH)-1);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		int maxDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		PreviousMonthDates.add(df.format(cal.getTime()).trim());
		for (  int i = 1; i < maxDay; i++) {
			cal.set(Calendar.DAY_OF_MONTH, i + 1);
			PreviousMonthDates.add(df.format(cal.getTime()).trim());

		}
		return PreviousMonthDates;
	}
	static List<String> getPrevioushWeekDates()
	{
		List<String> PreviousWeekDates=new ArrayList<String>();


		Date date = new Date();  

		Calendar c = Calendar.getInstance();
		SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");

		c.setTime(date);
		int i = c.get(Calendar.DAY_OF_WEEK) -( c.getFirstDayOfWeek()+1);
		c.add(Calendar.DATE, -i - 7);
		Date start = c.getTime();
		c.add(Calendar.DATE, 6);
		Date end = c.getTime();
		for(Date d:getDaysBetweenDates(start,end))
		{
			PreviousWeekDates.add(df1.format(d).trim());
		}
		return PreviousWeekDates;
	}



	static List<Date> getDaysBetweenDates(Date startdate, Date enddate)
	{
		List<Date> dates = new ArrayList<Date>();
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(startdate);

		while (calendar.getTime().before(enddate) || calendar.getTime().equals(enddate))
		{
			Date result = calendar.getTime();
			dates.add(result);
			calendar.add(Calendar.DATE, 1);
		}
		//calendar.add(Calendar.DATE, 1);

		return dates;
	}
	public static void main(String argv[])
	{
		System.out.println(getPreviousNDates(8 ));
		System.out.println(getPrevioushWeekDates());
		System.out.println(getPreviousMonthDates());
		
		try 
		{
			Date startDate=new SimpleDateFormat("yyyy-MM-dd").parse("2014-01-01");
			Date endDate=new SimpleDateFormat("yyyy-MM-dd").parse("2016-02-30");
			System.out.println(getDaysBetweenDates(startDate,endDate));

		} 
		catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		/*
		 * 
		 * 
		 * #include <stdio.h>
 
int main()
{
  int year;
 
  printf("Enter a year to check if it is a leap year\n");
  scanf("%d", &year);
 
  if ( year%400 == 0)
    printf("%d is a leap year.\n", year);
  else if ( year%100 == 0)
    printf("%d is not a leap year.\n", year);
  else if ( year%4 == 0 )
    printf("%d is a leap year.\n", year);
  else
    printf("%d is not a leap year.\n", year);  
 
  return 0;
}
		 * 
		 * 
		 * 
		 */
		
		
	}
}


