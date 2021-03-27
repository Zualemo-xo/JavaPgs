package week7;

import java.util.Scanner;

class even extends Thread
{
	Scanner s = new Scanner(System.in);
	int n,flag=0;
	//print name
	even(int no)
	{
		n=no;
	}
	even(int no,int f)
	{
		n=no;
		flag=f;
	}
	public void run()
	{
		System.out.println();
		System.out.println("Inside even,Current thread name:"+ Thread.currentThread().getName());	
		if(n%2==0)
		{
			System.out.println("Even");
		}
		
		else
		{
			System.out.println("Odd");
		}
		if(flag==1 && n%2!=0)
		{
			prime p=new prime(n,1);
			p.start();
			try{p.join();}
			catch(Exception ex) {
				System.out.println("Thread creation unsuccessful\n");}
		}
	}
}

class prime extends Thread
{
	Scanner s = new Scanner(System.in);
	int n,cnt=0,flag=0;
	prime(int no)
	{
		n=no;
	}
	prime(int no,int f)
	{
		n=no;
		flag=f;
	}
	public void run()
	{
		System.out.println();
		System.out.println("Inside prime,Current thread name:"+ Thread.currentThread().getName());	
		for(int i=2;i<n;i++)
		{
			if(n%i==0)
			{
				cnt+=1;
				break;
			}
		}
		if(cnt==0)
		{
			System.out.println("Prime");
		}
		else
			System.out.println("Not Prime");
		if(cnt==0 && flag==1)
		{
			sum su=new sum(n);
			su.start();
			try{su.join();}
			catch(Exception ex) {
				System.out.println("Thread creation unsuccessful\n");}
		}

	}
}

class sum extends Thread
{
	Scanner s = new Scanner(System.in);
	int n,sum=0,t;
	
	sum(int no)
	{
		n=no;
	}
	public void run()
	{
		System.out.println();
		System.out.println("Inside sum,Current thread name:"+ Thread.currentThread().getName());	
		while(n!=0)
		{
			t=n%10;
			n=n/10;
			sum+=t;
		}
		System.out.println("Sum of digits:"+sum);
	}
}

public class l7p2threadz {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("Enter total number of elements:");
		int n=s.nextInt();
		int a[]=new int[n];
		
		for(int i=0;i<n;i++)
		{
			a[i]=s.nextInt();
		}
		//PART 1 for each ele run all threads
		System.out.println("PART 1 :For each element run all threads:");
		for(int i=0;i<n;i++)
		{
			System.out.println();			
			System.out.println("Element: "+a[i]);			
			even e=new even(a[i]);
			e.start();
			prime p=new prime(a[i]);
			p.start();
			sum su=new sum(a[i]);
			su.start();
			try{
			    e.join();
				p.join();
				su.join();
				}
				catch(Exception ex) {
					System.out.println("Thread creation unsuccessful\n");
				}
		}
		//PART 2 All ele
		System.out.println();			
		System.out.println("PART 2: For all elements run each threads:");
		for(int i=0;i<n;i++)
		{
			System.out.println();			
			System.out.println("Element: "+a[i]);			
			even e=new even(a[i]);
			e.start();
			try{e.join();}
			catch(Exception ex) {
				System.out.println("Thread creation unsuccessful\n");}
		}
		for(int i=0;i<n;i++)
		{
			System.out.println();			
			System.out.println("Element: "+a[i]);			
			prime p=new prime(a[i]);
			p.start();
			try{p.join();}
			catch(Exception ex) {
				System.out.println("Thread creation unsuccessful\n");}
		}
		for(int i=0;i<n;i++)
		{
			System.out.println();			
			System.out.println("Element: "+a[i]);			
			sum su=new sum(a[i]);
			su.start();
			try{su.join();}
			catch(Exception ex) {
				System.out.println("Thread creation unsuccessful\n");}
		}
		System.out.println();			
		System.out.println("PART 3: For nested threads:");		
		//PART 3 Nested
		for(int i=0;i<n;i++)
		{
			System.out.println();			
			System.out.println("Element: "+a[i]);			
			even e=new even(a[i],1);
			e.start();
			try{e.join();}
			catch(Exception ex) {
				System.out.println("Thread creation unsuccessful\n");}
		}	
	}

}
