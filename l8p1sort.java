package week8;

import java.util.Scanner;



class sort extends Thread
{
	//Scanner s = new Scanner(System.in);
	int size;
	int a[]=new int[50];
	int fullsize;
	sort(int az[],int m,int n)
	{
		a=az;
//		for(int i=0;i<m;i++)
//		{
//			a[i]=az[i];
//		}
		size=m;
		fullsize=n;
	}
	synchronized public void run()
	{
		System.out.println("Current thread name:"+ Thread.currentThread().getName()+" used for sorting sub arrays");
		
		for(int i=0;i<size;i++)
		{
			for(int j=i+1;j<size;j++)
			{
				if(a[i]>a[j])
				{
					int temp=a[i];
					a[i]=a[j];
					a[j]=temp;
				}
			}
		}
		for(int i=0;i<size;i++)
		{
			System.out.print(a[i]+" ");
		}
		System.out.println();
		merge me;
		me=new merge(a,size,fullsize);
		me.start();
		try { 
		me.join();
		}
		catch (InterruptedException ex) {
		System.out.println("Thread interrupted.");
		}
		System.out.println(Thread.currentThread().getName()+" ends");

	}
}
class merge extends Thread
{
	
	static int cnt=0;
	int size;
	int maxsize=0;
	static int a[]=new int[50];
	merge(int az[],int m,int n)
	{
		for(int i=0;i<m;i++)
		{
			a[cnt++]=az[i];
			//System.out.print("no:"+a[cnt-1]+" "+"cnt:"+cnt);
		}
		//System.out.println();

		maxsize=n;
	}
	synchronized public void run()
	{
		System.out.println("Current thread name:"+ Thread.currentThread().getName()+" used for merging");
		if(cnt==maxsize)
		{
			System.out.println("Whole array before merging:");
			for(int i=0;i<maxsize;i++)
			{
				System.out.print(a[i]+" ");
			}
			System.out.println();
			for(int i=0;i<maxsize;i++)
			{
				for(int j=i+1;j<maxsize;j++)
				{
					if(a[i]>a[j])
					{
						int temp=a[i];
						a[i]=a[j];
						a[j]=temp;
					}
				}
			}
			System.out.println("Whole array after merging:");
			for(int i=0;i<maxsize;i++)
			{
				System.out.print(a[i]+" ");
			}
			System.out.println();

		}
		System.out.println(Thread.currentThread().getName()+" ends");

	}
	
}


public class l8p1sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner s = new Scanner(System.in);
		 System.out.println("Enter no of elements(n) and threads(m): ");	
		 int n=s.nextInt();
		 int m=s.nextInt();
		 int i;
		 int arr[]=new int[n];
		 System.out.println("Enter the elements: ");	
		 for(i=0;i<n;i++)
		 {
			 arr[i]=s.nextInt();
		 }
		 
		 int a[][]=new int[m][n];
		 int cnt=0,k=0,j=0;
		 i=0;
		 int lastsize=0;
		 while(i<n)
		 {
			 //if(i+m>)
			 //for(i=cnt;i<m;i++)
			 while(cnt<m)
			 {
				 a[k][j++]=arr[i++];
				 cnt++;
			 }
			 cnt=0;
			 if(k==m-1)
			 {
				 while(i<n)
				 {
					 a[k][j++]=arr[i++];
				 }
				 lastsize=j;
			 }
			 k++;
			 j=0;
		 }
		 
		 for(i=0;i<m;i++)
		 {
			 sort e;
			 //merge me;
			 if(i==m-1)
			 {
				 e=new sort(a[i],lastsize,n);
				 //me=new merge(a[i],lastsize,n);
			 }
			 else 
			 {
				 e=new sort(a[i],m,n);
				 //me=new merge(a[i],m,n);
			 }
      
		    	e.start(); 
	      		//me.start();  
			try { e.join();
				//me.join();
				}
			catch (InterruptedException ex) {
			System.out.println("Thread interrupted.");
			}
				 System.out.println();	
//
//			 for(j=0;j<a[i].length;j++)
//			 {
//				 System.out.print(a[i][j]+" "); 
//			 }
//			 System.out.println();
			
		 }
		 
		 
	}

}
