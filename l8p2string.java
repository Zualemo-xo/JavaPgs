package week8;

import java.util.*;



class common extends Thread
{
	String s1,s2;
	common(String st1,String st2)
	{
		s1=st1.toLowerCase();
		s2=st2.toLowerCase();
		
	}
	public void run()
	{
		System.out.println("Current thread name:"+ Thread.currentThread().getName()+" used for finding common ele");

		System.out.println("Strings used");
		System.out.println(s1);
		System.out.println(s2);
		//remove duplicates with set
		LinkedHashSet<Character> set1=new LinkedHashSet();
		LinkedHashSet<Character> set2=new LinkedHashSet();
		for(int i=0;i<s1.length();i++)
		{
			set1.add(s1.charAt(i));
		}
		for(int i=0;i<s2.length();i++)
		{
			set2.add(s2.charAt(i));
		}
		//System.out.println(set1);
		System.out.print("Common characters are:");
		for(Character ch1:set1)
		{
			for(Character ch2:set2)
			{
				if(ch1==ch2)
				{
					System.out.print(ch1);
				}
				
			}

		}
		System.out.println();
		System.out.println();

	}
}


class repeat extends Thread
{
	String s1,s2;
	repeat(String st1,String st2)
	{
		s1=st1.toLowerCase();
		s2=st2.toLowerCase();
		
	}
	
	public void run()
	{
		System.out.println("Current thread name:"+ Thread.currentThread().getName()+" used for finding repeated ele");

		System.out.println("Strings used");
		System.out.println(s1);
		System.out.println(s2);
		
		//sort strings
        char t1[] = s1.toCharArray();//as .sort() works inly on char array
        Arrays.sort(t1);
        
        char t2[] = s2.toCharArray();
        Arrays.sort(t2);
		//System.out.println(t1);
		//System.out.println(t2);
        
        //compare and display duplicate for each
		System.out.print("For "+s1 + " repeated characters are:");
		
		for(int i=1;i<t1.length-1;i++)
		{
			if(t1[i]==t1[i-1] && t1[i]!=t1[i+1])
			{
				System.out.print(t1[i]);
			}
		}
		System.out.println();
		
		System.out.print("For "+s2 + " repeated characters are:");
		for(int i=0;i<t2.length-1;i++)
		{
			if(t2[i]==t2[i+1])
			{
				System.out.print(t2[i]);
			}
		}
		System.out.println();
		System.out.println();

	}
}


class mergez extends Thread
{
	StringBuffer s1,s2;
	mergez(String st1,String st2)
	{
		s1=new StringBuffer(st1.toLowerCase());
		s2=new StringBuffer(st2.toLowerCase());
		
	}
	
	public void run()
	{
		System.out.println("Current thread name:"+ Thread.currentThread().getName()+" in merge");
		System.out.println("Strings used");
		System.out.println(s1);
		System.out.println(s2);


		int l1=s1.length();
		int l2=s2.length();
		int cnt1=0,cnt2=0;
		StringBuffer s3=new StringBuffer();
		while(1<2)
		{
			if(cnt1<l1 && cnt2<l2)
			{
				s3.append(s1.substring(cnt1, cnt1+1));
				s3.append(s2.substring(cnt2, cnt2+1));
				//System.out.print(s1.substring(cnt2, cnt2+1));
				//System.out.println(s3);
				cnt1++;
				cnt2++;

			}
			else if(cnt1==l1)
			{
				s3.append(s2.substring(cnt2));
				break;
			}
			
			else if(cnt2==l2)
			{
				s3.append(s1.substring(cnt1));
				break;
			}
		}
		System.out.println("Merged: "+s3);
		System.out.println();

		
	}
}

public class l8p2string {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner s = new Scanner(System.in);
		 System.out.println("Enter no of strings(n): ");
		 int n=s.nextInt();
		 System.out.println("Enter strings: ");
		 String st[]=new String[n];
		 for(int i=0;i<n;i++)
		 {
			 st[i]=s.next();
		 }
		 
		 for(int i=0;i<n/2;i++)
		 {
			 common c1=new common(st[i],st[n-i-1]);
			 c1.start();
				try{c1.join();}
				catch(Exception ex) {
					System.out.println("Thread creation unsuccessful\n");}
	
			 repeat r=new repeat(st[i],st[n-i-1]);
			 r.start();
				try{r.join();}
				catch(Exception ex) {
					System.out.println("Thread creation unsuccessful\n");}
			 
			 mergez m=new mergez(st[i],st[n-i-1]);
			 m.start();
				try{m.join();}
				catch(Exception ex) {
					System.out.println("Thread creation unsuccessful\n");}
		 }

	}

}
