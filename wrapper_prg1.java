package j12_02_2021;

import java.util.Scanner;

public class wrapper_prg1 {

	public static void main(String[] args) {
	       Scanner s = new Scanner(System.in);
	       System.out.println("Enter string: ");
	       String str = s.next();

	       String []array3=new String[50];
	       Integer iz = 10;
	       int cnt1=0,cnt2=0,cnt3=0,cnt4=0;
	       for(int i=0;i<str.length()-1;i++)
	       {
	    	   
	    	   //System.out.println(str.substring(i, i+1));
	    	   int cnt=0;
	    	   if(iz.valueOf(str.substring(i, i+1))<10)
	    	   {
	    		   for(int j=i+1;j<str.length();j++)
	    		   {
	    			   if(iz.valueOf(str.substring(j, j+1))<10)
	    			   {
	    				   cnt++;
	    			   }
	    			   else
	    				   break;
	    		   }

	    		   
	    		   array3[cnt3++]=str.substring(i, i+1+cnt);
	    		   
	    	   }
	    	   i=i+cnt-1;
	    	   //str.substring(i, i+1)
	       }
	       
	       
	       for(int i=0;i<cnt3;i++)
	       {
	    	   System.out.println(array3[i]);
	       }
	}

}
