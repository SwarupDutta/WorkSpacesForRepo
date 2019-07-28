/*

Written by:Swarup Dutta

EmpId:SW840330 

EmailId:swarup.dutta@wipro.com)

INPUT : java mydir (your directory path) your output file name

EX: java mydir C:/softwares output.text

OUTPUT: Open your file containing result of recursive traversal As well as print on the Standard input stream (MONITOR)

*/

import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;
class mydir
{
	public static PrintWriter pw;//TO WRITE OUTPUT IN FILEOUTPUTSTREAM
	public static String argus="";//TO HOLD ARGUMENT GIVEN IN COMMAND PROMPT
	public static void main(String args[]) 
	{
		try
		{
			if(args.length>=2)
			{
				for(int c=0;c<args.length-1;c++)//THIS LOOP IS FOR FORMATING ARGUMENT
				{
					if(c==0)
						argus=args[c];
					else
						argus=argus+ " "+args[c];
				}
				pw = new PrintWriter(args[args.length-1]);//CREATING PRINT WRITER OBJECT TO WRITE INTO FILE(LAST ARGUMENT HOLDS NAME OF OUTPUT FILE)
				File[] files = new File(argus).listFiles();
				showFiles(files);
				pw.close();
				 try 
				 {
	      					String dosCommand = "cmd /c notepad  "+args[args.length-1];//CREATES DOS COMMAND
             					Process p = Runtime.getRuntime().exec("cmd /c "+dosCommand);//EXECUTE CREATED DOS COMMAND
             		
       				} 
				catch (IOException e) 
				{
              					 
						System.out.println("Unable to open your output file .....");//EXCEPTION MESSAGE
       				}
			}
			else
			{
				System.out.println("Enter path of folder Ex: java mydir D:/pkg1 youroutputfilename");//ERROR MESSAGE TO INFORM USER ABOUT PASSING PARAMETERS
			}
	
		}
		catch(Exception e)
		{
			System.out.println("Given path not exists /Output file missing");//ERROR MESSAGE TO INFORM ABOUT EXISTENCE OF GIVEN PATH 
		}
	}

	public static void showFiles(File[] files) 
	{
    		for (File file : files) 
    		{
			try
			{
        			if (file.isDirectory()) //CHECKING WHETHER IT IS DIRECTORY OR NOT
				{

					pw.println("Directory: " + file.getName()+"\t "+Filecount(file));//WRITING TO FILEOUTPUT
					System.out.println("Directory: " + file.getName()+"\t "+Filecount(file));//PRINT ON THE SCREEN
            				showFiles(file.listFiles()); //THEN CALLS AGAIN
        			} 
				else //IF IT IS NOT DIRECTORY
				{
	   				 SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");//CREATING HUMAN READABLE DATE FORMAT
					 pw.println("File: " + file.getName()+" "+sdf.format(file.lastModified()));//OBTAINING NAME OF FILE AND LAST ACCESS INFO AND WRITING TO FILE
					 System.out.println("File: " + file.getName()+" "+sdf.format(file.lastModified()));//PRINT ON THE SCREEN
        			}
			}
			catch(Exception e)
			{
					System.out.println("ERROR ");
			}
    		}
	}
	public static  int Filecount(File folder)
	{
		 int count=0;
		 File[] files = folder.listFiles();//CREATING ARRAY CONTAINING CONTENT OF FOLDER  
		 for(File file: files)
		 {
            		if(file.isFile())//CHECKING WHETHER IT IS FILE OR NOT
			{
                		count++;//IF IT IS FILE THEN INCERMENT COUNT
            		}
        	}
		return count;//RETURNS NUMBER OF FILES PRESENT IN THAT DIRECTORY
	}

}