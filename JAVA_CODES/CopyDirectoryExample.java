import java.io.*;
import java.io.File.*;
class Rename
{
public void renameFile(File old_src,File new_src) 
{
 
	//File newFile = new File(src.getAbsolutePath()+"\\"+src.getName()+".old");
	if (old_src.renameTo(new_src)) 
	{
            			System.out.println("File has been renamed.");
        } 
	else 
	{
            			System.out.println("Error renmaing file");
        }
}
}
public class CopyDirectoryExample
{
    public static void main(String[] args) throws IOException
    {	
    	File srcFolder = new File("D:\\java\\jdk1.6.0_20\\bin\\sourcedir");
    	File destFolder = new File("D:\\java\\jdk1.6.0_20\\bin\\destdir");
 
    	//make sure source exists
    	if(!srcFolder.exists()){
 
           System.out.println("Directory does not exist.");
           //just exit
           System.exit(0);
 
        }else{
 
           try{
        	copyFolder(srcFolder,destFolder);
           }catch(IOException e){
        	e.printStackTrace();
        	//error, just exit
                System.exit(0);
           }
        }
 
    	System.out.println("Done");
    }
 
    public static void copyFolder(File src, File dest)
    	throws IOException{
 
    	if(src.isDirectory()){
 
    		//if directory not exists, create it
    		if(!dest.exists()){
    		   dest.mkdir();
    		   System.out.println("Directory copied from " 
                              + src + "  to " + dest);
    		}
 
    		//list all the directory contents
    		String files[] = src.list();
 
    		for (String file : files) {
    		   //construct the src and dest file structure
    		   File srcFile = new File(src, file);
    		   File destFile = new File(dest, file);
    		   //recursive copy
    		   copyFolder(srcFile,destFile);
    		}
 
    	}
	else
	{
		
    	        if(!src.getName().endsWith(".old"))// If not all ready read
	        {
	      		 InputStream in = new FileInputStream(src);
    	       		 OutputStream out = new FileOutputStream(dest); 
			 byte[] buffer = new byte[1024];
			 int length;
    	        		//copy the file content in bytes 
    	        		while ((length = in.read(buffer)) > 0)
			{
    	    	 		  out.write(buffer, 0, length);
    	        		}
			 in.close();
    	      		 out.close();
			File srcnew=new File(src.getName()+".old");
			new Rename().renameFile(src,new File(src.getAbsolutePath()+".old"));
    	       		 //System.out.println("File copied from " + src + " to " + dest);
	      }
    	}
    }
}