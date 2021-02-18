package WEEK2;

import java.util.Scanner;

public class L2P1REVERSE {

	public static void main(String[] args) {
	       Scanner s = new Scanner(System.in);
	       System.out.println("Enter string: ");
	       StringBuffer str = new StringBuffer(s.next());
	       int n=str.length();
	       if(str.length()%2!=0)
	       {
	    	   n=str.length()-1;
	       }
	       
	       for(int i=0;i<n;i+=2)
	       {
	    	   //System.out.println(str.charAt (i));
	    	   StringBuffer a1=new StringBuffer(str.substring(i,i+2));
	    	   a1.reverse();
	    	   //System.out.println(a1);
	    	   str.replace(i,i+2,a1.toString());
	       }
	       System.out.println(str);
	}

}
