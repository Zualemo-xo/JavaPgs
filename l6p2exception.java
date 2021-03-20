package week6;

import java.util.*;

public class l6p2exception {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner s = new Scanner(System.in);
		 System.out.println("Enter n: ");
		 int n=s.nextInt();
		 int a[]=new int[50];
		 String b[]=new String[50];
		 System.out.println("Enter n numbers: ");
		 int cnt=0;
		 for(int i=0;i<n;i++)
		 {
			 try 
			 {
				 String t=s.next();
				 b[i]=t;
				 a[i]=Integer.parseInt(t);
				 //a[i]=s.nextInt();
				 if(a[i]==0)
					 throw new NullPointerException();
				 if(a[i]<10)
					 throw new IllegalArgumentException();

				 if(a[i]>=100)
					 throw new NoSuchElementException();
			 }

			 catch(NumberFormatException e)
			 {
				 System.out.println(e);
				 cnt++;
			 }
			 
			 catch(IllegalArgumentException e)
			 {
				 System.out.println(e);
				 cnt++;
			 }
			 catch(NullPointerException e)
			 {
				 System.out.println(e);
				 cnt++;
			 }

			 catch(NoSuchElementException e)
			 {
				 System.out.println(e);
				 cnt++;
			 }
		 }
		 if(cnt==0)
		 {
			StringBuffer finalz=new StringBuffer(b[0]);
			for(int i=1;i<n;i++)
			{
				finalz.insert(i,b[i]);
			}
			 System.out.println(finalz);
		 }

	}

}
