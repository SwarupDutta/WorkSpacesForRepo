 import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


public class UtilLogTest {
	public static void main(String[] args) {  

		Logger logger = Logger.getLogger("MyLog"); 
		logger.setUseParentHandlers(false);
		FileHandler fh;  
		System.out.println(System.getProperty("user.dir")+System.getProperty("file.separator"));
		try {  

			// This block configure the logger with handler and formatter  
			String directoryString=System.getProperty("user.dir")+System.getProperty("file.separator")+"DebugLog";
			System.out.println(new SimpleDateFormat("yy").format(new Date())); 

			System.out.println(new SimpleDateFormat("yyyy").format(new Date())); 
			System.out.println(new SimpleDateFormat("dd").format(new Date())); 
			//System.out.println(new SimpleDateFormat("dddd").format(new Date())); 
			System.out.println(new SimpleDateFormat("MMMM").format(new Date())); 
		//	System.out.println(new SimpleDateFormat("MM").format(new Date())); 

			
			File dir=new File(directoryString);
			if(dir.exists())
			{
				System.out.println("Chilo");
				if(dir.isFile())
				{
					System.out.println("Chilo kintu directory na");

					dir.mkdirs();
				}


			}
			else
			{
				System.out.println("Chiloi na");

				dir.mkdirs();
			}
			File LogFile=new File(dir.getAbsolutePath()+System.getProperty("file.separator")+"MyLog.log");
			if(!LogFile.exists())LogFile.createNewFile();
			fh = new FileHandler(LogFile.getAbsolutePath(),true);  
			logger.addHandler(fh);
			SimpleFormatter formatter = new SimpleFormatter();  
			fh.setFormatter(formatter);  

			// the following statement is used to log any messages  
			logger.info("My first log");  

		} catch (SecurityException e) {  
			e.printStackTrace();  
		} catch (IOException e) {  
			e.printStackTrace();  
		}  

		logger.info("Hi How r u?");  

	}
}
