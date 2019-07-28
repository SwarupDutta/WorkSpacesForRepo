package extra;
import java.io.File;


public class TestDir 
{
                
                public static int numberOfFoldersDeleted=0;
                public static int numberOfFilesDeleted=0;
                public static String xyz=".svn";
                public static void main(String[] args) 
                {
                	            displayDirectoryContents(new File("C:\\Users\\sw840330\\Desktop\\TestECINMS"));
                	
                				
                               
                               /* File currentDir = new File(args[0]);
                               // deleteDirectoryContents(new StringBuffer(currentDir.toString()),new StringBuffer(args[1]));
                                numberOfFilesDeleted = numberOfFilesDeleted-numberOfFoldersDeleted;
                                System.out.println("Number of files deleted : "+numberOfFilesDeleted);
                                System.out.println("Number of folders deleted : "+numberOfFoldersDeleted);*/
                                
                }
                
               public static void displayDirectoryContents(File dir) {
            		try {
            			File[] files = dir.listFiles();
            			for (File file : files) 
            			{
            				if (file.isDirectory()) 
            				{
            					//System.out.println("directory:" + file.getAbsolutePath()+" ,"+file.getName());
            					if(file.getName().equalsIgnoreCase(xyz))
            					{
            						deleteDirectoryContents(file)       ;     						
            						/*deleteDirectoryContents(new StringBuffer(file.getAbsolutePath()),new StringBuffer(xyz));
            						deleteDirectoryContents(new StringBuffer(file.getAbsolutePath()),new StringBuffer(xyz));*/

            					}
            					else
            					{
            						displayDirectoryContents(file);
            					}
            				} 
            				else if(file.isFile())
            				{
            					if(file.getName().equalsIgnoreCase(xyz))

            						deleteDirectoryContents(file)       ;     						
            				}
            			}
            		} 
            		catch (Exception e) 
            		{
            			e.printStackTrace();
            		}
            	}

               {
            	   
               }
               public static boolean deleteDirectoryContents(File file)
               {

            	   
               	if(file.isDirectory()){
            
               		//directory is empty, then delete it
               		if(file.list().length==0){
            
               		   file.delete();
               		   System.out.println("Directory is deleted : " 
                                                            + file.getAbsolutePath());
            
               		}else{
            
               		   //list all the directory contents
                   	   String files[] = file.list();
            
                   	   for (String temp : files) {
                   	      //construct the file structure
                   	      File fileDelete = new File(file, temp);
            
                   	      //recursive delete
                   	   deleteDirectoryContents(fileDelete);
                   	   }
            
                   	   //check the directory again, if empty then delete it
                   	   if(file.list().length==0){
                      	     file.delete();
                   	     System.out.println("Directory is deleted : " 
                                                             + file.getAbsolutePath());
                   	   }
               		}
            
               	}else{
               		//if file, then delete it
               		file.delete();
               		System.out.println("File is deleted : " + file.getAbsolutePath());
               	}
               return true;
               }
               
                
}
