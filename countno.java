package j06_02_2021;

import java.util.Scanner;

public class countno {

	public static void main(String[] args) {
       Scanner s = new Scanner(System.in);
       int arr[] = new int[10];
       System.out.println("Enter total nos: ");
       int n=s.nextInt();
       System.out.println("Enter nos: ");
       for(int i=0;i<n;i++)
       {
    	   int t=s.nextInt();
    	   int last=0;
    	   while(t!=0)
    	   {
    		   last=t%10;
    		   t=t/10;
    	   }
    	   arr[last]++;
    	   
       }
       for(int i=0;i<10;i++)
       {
    	   System.out.println("Count of "+i+" is: "+arr[i]);
       }
	}

}
