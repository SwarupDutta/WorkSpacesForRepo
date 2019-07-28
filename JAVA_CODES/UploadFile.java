import java.io.FileInputStream;   
import java.io.IOException;  
import java.io.File; 
import java.net.SocketException;   
import org.apache.commons.net.ftp.FTPClient;   
import java.util.logging.Logger;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter; 
public class UploadFile 
{   
	public static Logger logger= Logger.getLogger("MyLog");
    	public  static FileHandler handler=null;
 	public static void main(String args[]) 
	{   
  
  		// get an ftpClient object   
  		FTPClient ftpClient = new FTPClient();   
  		FileInputStream inputStream = null;   
  		try 
		{  
			//logger = Logger.getLogger(RollingLogFile.class.getName()); 
			handler =new FileHandler("D:/test/Upload_log_info.log",true);
    			handler.setFormatter(new SimpleFormatter());
    			logger.addHandler(handler);
    			logger.setUseParentHandlers(false);
   			// pass directory path on server to connect   
   			ftpClient.connect("10.141.60.252");   
  
   			// pass username and password, returned true if authentication is   // successful   
   			boolean login = ftpClient.login("asap702", "asap702");   
  
   			if (login) 
			{   
    				logger.info("Connection established...");
				String directory = "D:\\java\\jdk1.6.0_45\\bin\\sourcedir";
				File[] files = new File(directory).listFiles();  
				for(File file : files)
				{

					//inputStream = new FileInputStream("D://Java//jdk1.6.0_45//bin//trigger2.txt");
					inputStream = new FileInputStream(file.getAbsolutePath());
    					//boolean uploaded = ftpClient.storeFile("uploadedFile1.txt",inputStream);
					boolean uploaded = ftpClient.storeFile("/OFC/home/asap702/swarup/"+file.getName(),inputStream);    
    					if (uploaded) 
					{   
     						logger.info("File uploaded successfully !");   
    					} 
					else 
					{   
     						logger.info("Error in uploading file !");   
    					}   
				}   
  				
  
    				// logout the user, returned true if logout successfully   
    				boolean logout = ftpClient.logout();   
    				if (logout) 
				{   
     					logger.info("Connection close...");   
    				}   
   		       } 
		       else 
		       {   
    					logger.info("Connection fail...");   
   		       }   
  
  		} 
		catch (SocketException e) 
		{   
   					logger.warning(e.toString());   
  		} 
		catch (IOException e) 
		{   
   					logger.warning(e.toString());   
  		} 
		finally 
		{   
   					try 
					{   
    						ftpClient.disconnect();   
   					} 
					catch (IOException e) 
					{   
    						logger.warning(e.toString());      
   					}   
  		}   
 	}   
}  
