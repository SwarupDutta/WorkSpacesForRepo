package com.coolsstory;

import java.io.*; 

public class doscmd 
{ 
    public static void main(String args[]) 
    { 
        try 
        { 
        	String str=new File("../EjbprojectClient/ejbModule/com/coolsstory/TehBeanRemote.java").getAbsolutePath();
        	System.out.println(str);
            Process p=Runtime.getRuntime().exec("cmd /c type "+str); 
           // System.out.println("HO");
           // p.waitFor(); 
           //.out.println("waiting comp");
            BufferedReader reader=new BufferedReader(
                new InputStreamReader(p.getInputStream())
            ); 
            String line=null; 
            while((line = reader.readLine()) != null) 
            { 
                System.out.println(line);
            } 

        }
        catch(IOException e1) {} 
      //  catch(InterruptedException e2) {} 

        System.out.println("Done"); 
    } 
}