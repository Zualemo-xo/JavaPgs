package week9;
import java.io.*;

import java.util.Scanner;
import java.util.regex.*;  

public class l9p1read {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ch; 
		//InputStream f=null; 
		BufferedReader f=null; 
		String line;
		String words[]=new String[50];
		try 
		{
		  f = new BufferedReader(new FileReader("./q1.txt"));

		}
		//InputStream f = new FileInputStream ("../q1.txt");
		catch (FileNotFoundException fe) 
        {              System.out.println("File not found");          }  
		
		int cnt_exp=0,cnt_op=0,cnt_ip=0;
        try 
        {
//		while ((ch=f.read())!=-1) 
//            System.out.print((char)ch); 
//        f.close(); 
        	  while((line = f.readLine()) != null)
        	  {
        	   System.out.println(line);
        	   words=line.split(" ");
        	   //System.out.println(words);
        	   for (String w : words)
        	   {
               	   //System.out.println(" catched:"+w);
        		   if(Pattern.matches("(.*)catch(.*)", w))
        		   {
        			   cnt_exp++;
        		   }
        		   if(Pattern.matches("(.*)print(.*)", w))
        		   {
        			   cnt_op++;
        		   }
        		   if(Pattern.matches("(.*)next(.*)", w))
        		   {
        			   cnt_ip++;
        		   }
        	   }
        	  }
           System.out.println();  
       	   System.out.println("Final Count:");  
       	   System.out.println("Exceptions catched:"+cnt_exp);
       	   System.out.println("Output statements used:"+cnt_op);
       	   System.out.println("Input statements used:"+cnt_ip);

        }
        catch(IOException i)
        {
        	System.out.println("IO Exception"); 
        }



	}

}
