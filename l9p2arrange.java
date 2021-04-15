package week9;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class l9p2arrange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader f=null; 
		String line;
		String words[]=new String[50];
		try 
		{
		  f = new BufferedReader(new FileReader("E:/Eclipse/Data/JAVA LAB/src/week9/inputL9.txt"));

		}
		//InputStream f = new FileInputStream ("../q1.txt");
		catch (FileNotFoundException fe) 
        {              System.out.println("File not found");          }  
	   String sdot[]=new String[50];
	   String scaps[]=new String[50];
	   String snone[]=new String[50];
	   int cnt1=0,cnt2=0,cnt3=0;
	  try
	  {
	  	  while((line = f.readLine()) != null)
	  	  {
	  	   //System.out.println(line);
	  	   words=line.split(" ");
	  	 //System.out.println(words);
	  	   
			  //System.out.println(words[words.length-1]);
	  	   String t=words[words.length-1];
	  	   //System.out.println(t.charAt(t.length()-1));
	  	   char c=t.charAt(t.length()-1);
	  	   if(Character.isUpperCase(words[0].charAt(0)))
	  	   {
		  	   //System.out.println(words[0]);
		  	   scaps[cnt2++]=line;
	  	   }

	  	   else if(c=='.')
	  	   {
		  	   //System.out.println(line);
		  	   sdot[cnt1++]=line;
	  	   }
	  	   
	  	   else
	  	   {
		  	   snone[cnt3++]=line;

	  	   }
	  	  }
	  	  
	  	  //sort part
	  	  
	  	  //fullstops
	        for (int i = 0; i < cnt1; i++) 
	        {
	            for (int j = i + 1; j < cnt1; j++) 
	            {
	                if (sdot[i].compareTo(sdot[j])>0) 
	                {
	                    String temp = sdot[i];
	                    sdot[i] = sdot[j];
	                    sdot[j] = temp;
	                }
	            }
	        }
	        //caps
	        for (int i = 0; i < cnt2; i++) 
	        {
	            for (int j = i + 1; j < cnt2; j++) 
	            {
	                if (scaps[i].compareTo(scaps[j])>0) 
	                {
	                    String temp = scaps[i];
	                    scaps[i] = scaps[j];
	                    scaps[j] = temp;
	                }
	            }
	        }
	        
	        //neutral no sort
	        //display chk
//	        for (int i = 0; i < cnt3; i++) 
//	        {
//	        	System.out.println(sdot[i]);
//	        }
 
	  }
      catch(IOException i)
      {
      	System.out.println("IO Exception"); 
      }
	  
	  //write into file
	  
		 try {
			PrintWriter pw = new PrintWriter(new FileWriter("E:/Eclipse/Data/JAVA LAB/src/week9/q2OUTPUT.txt", true)); //true USED TO APPEND CONTENT
			for(int i=0;i<cnt2;i++)
			pw.println(scaps[i]);
			
			for(int i=0;i<cnt3;i++)
			pw.println(snone[i]);
			
			for(int i=0;i<cnt1;i++)
			pw.println(sdot[i]);
			
			pw.close();
			System.out.println("Contents added successfully");
		}
		catch (FileNotFoundException fe) 
     {              System.out.println("File not found");          } 
		catch (IOException fe) 
	        {              System.out.println("File not found");          }
		
	}

}
