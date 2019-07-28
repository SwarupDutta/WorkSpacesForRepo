package com.journaldev.files;

import java.io.File;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * This utility class can be used to delete 
 * folders recursively in java
 * @author swarup
 */
public class DeleteFolderRecursively 
{
	static AtomicInteger fileCount;
	static AtomicInteger directoryCount;
	public static String startingPOint=null;
    public static void main(String[] args) {
    	 fileCount=new AtomicInteger(0);
    	 directoryCount=new AtomicInteger(0);
        String folder = "D:\\hhh";
        //delete folder recursively
        recursiveDelete(new File(folder));
    }
    
    private static void recursiveDelete(File file) 
    {
    	if(startingPOint==null)
    		startingPOint=file.getAbsolutePath();
        //to end the recursive loop
        if (!file.exists())
            return;
        
        //if directory, go inside and call recursively
        if (file.isDirectory()) {
            for (File f : file.listFiles()) {
                //call recursively
                recursiveDelete(f);
            }
        }
        //call delete to delete files and empty directory
        if(file.isDirectory())
        {
        	directoryCount.addAndGet(1);
        }
        else
        {
        	fileCount.addAndGet(1);
        }
        file.delete();
        System.out.println("Deleted file/folder: "+file.getAbsolutePath());
        if(file.getAbsolutePath().equalsIgnoreCase(startingPOint))
        {
        	System.out.println("Number of files deleted ::"+fileCount);
        	System.out.println("Number of folders deleted ::"+directoryCount);
        }
    }

}