import java.io.FileOutputStream;   
import java.io.IOException;   
import java.net.SocketException;   
import org.apache.commons.net.ftp.FTPClient; 
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.io.Util;
import org.apache.commons.net.ftp.FTP;
import java.util.logging.Logger;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;
import java.io.File; 
public class DownloadFile 
{   
	public static Logger logger= Logger.getLogger("MyLog");;
    	public  static FileHandler handler=null;
 	public static void main(String args[]) 
	{   
  
  			// get an ftpClient object   
  			FTPClient ftpClient = new FTPClient();   
  			FileOutputStream fos = null;   
  
  			try 
			{ 
				
			        //logger = Logger.getLogger(RollingLogFile.class.getName()); 
				handler =new FileHandler("D:/test/Download_log_info.log",true);
    				handler.setFormatter(new SimpleFormatter());
    				logger.addHandler(handler);
    				logger.setUseParentHandlers(false);  
   				// pass directory path on server to connect   
   				ftpClient.connect("10.141.60.252");   

				// pass username and password, returned true if authentication is  successful   
   				boolean login = ftpClient.login("asap702", "asap702");   
  
   				if (login) 
				{   
    					logger.info("Connection established...");   
  					//FTPFile[] files = ftpClient.listFiles();
					FTPFile[] files = ftpClient.listFiles("/OFC/home/asap702/swarup");
					for (FTPFile ftpFile : files)
					{
						if(!ftpFile.isDirectory())
						{
							String file_name=ftpFile.getName();
						  //Name after being down loaded
							if(!file_name.endsWith(".old"))
							{
								fos = new FileOutputStream("D://Download//"+ file_name); 
								boolean download = ftpClient.retrieveFile("/OFC/home/asap702/swarup/"+file_name,fos); 
								if (download) 
								{   
     									logger.info("File : "+file_name+" downloaded successfully !");   
    								} 
								else 
								{   
     									logger.info("Error in downloading file !");   
    								}   
  								//ftpClient.deleteFile("/OFC/home/asap702/Jit/"+file_name);
								ftpClient.rename("/OFC/home/asap702/swarup/"+file_name, "/OFC/home/asap702/swarup/"+file_name+".old");
    							}
							

    						}
					}
    					
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
