package j06_02_2021;

import java.util.Scanner;

public class maxmin {

	public static void main(String[] args) {
	    Scanner s = new Scanner(System.in);
	    int arrmin[] = new int[10];
	    int arrmax[] = new int[10];
	    System.out.println("Enter no: ");
		int n=s.nextInt();
		int size=0,x;
 	   while(n!=0)
 	   {
 		   x=n%10;
 		   n=n/10;
 		   arrmin[size]=x;
 		   arrmax[size++]=x;
 	   }
 	   for(int i=0;i<size;i++)
 	   {
 		   for(int j=i+1;j<size;j++)
 		   {
 			   if(arrmin[i]>arrmin[j])
 			   {
 				   int t=arrmin[i];
 				   arrmin[i]=arrmin[j];
 				   arrmin[j]=t;
 			   }
 			   if(arrmax[i]<arrmax[j])
 			   {
 				   int t=arrmax[i];
 				   arrmax[i]=arrmax[j];
 				   arrmax[j]=t;
 			   }
 		   }
 	   }
 	  System.out.print("Min:");
 	   for(int i=0;i<size;i++)
 	   {
 		    System.out.print(arrmin[i]);
 	   }
 	  System.out.println();
 	 System.out.print("Max:");
	   for(int i=0;i<size;i++)
	   {
		    System.out.print(arrmax[i]);
	   }
	}

}
