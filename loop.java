package j06_02_2021;

import java.util.Scanner;

public class loop {

	public static void main(String[] args) {
	    Scanner s = new Scanner(System.in);
	    System.out.println("Enter height,width,char: ");
	    int n=s.nextInt();
	    int m=s.nextInt();
	    String S=s.next();
	    for(int i=0;i<n;i++)
	    {
	    	for(int j=0;j<m;j++)
	    	{
	    	    System.out.print(S);
	    	}
	    	System.out.println();
	    }

	}

}
