package j19_02_2021;

import java.util.Scanner;

class student
{
	int rno;
	static int rnocount=1000;
	String ccode[];
	int marks[];
    Scanner s = new Scanner(System.in);
	student()
	{
		rno=rnocount++;
		System.out.println("Enter no of course code:");
		int n=s.nextInt();
		System.out.println("Enter n Course code:");
		ccode=new String[n];
		marks=new int[n];
		int i=0;
		while(i<n)
		{
			ccode[i]=s.next();
			if((ccode[i].substring(0,3)).equals("CSE"))
			{
				i+=0;
			}
			else
			{
				System.out.println("Invalid Course code,enter again");
				i-=1;
			}
			i+=1;
		}
		System.out.println("Enter n marks:");
		i=0;
		while(i<n)
		{
			marks[i]=s.nextInt();
			if(marks[i]>100 || marks[i]<0)
			{
				System.out.println("Invalid mark,reenter");
				i-=1;
			}

			i+=1;
		}

	}
	static float avg[]=new float[50];
	static int cnt=0;
	static float pass[]=new float[50];
	static float maxmark[]=new float[50];
	//static int regno[]=new int[50];
	void calc(int len)
	{
		cnt++;
		for(int i=0;i<len;i++)
		{
			avg[i]+=marks[i];
			if(marks[i]>50)
			{
				pass[i]+=1;
			}
			if(marks[i]>maxmark[i])
				maxmark[i]=marks[i];
				//regno[i]=rno
		}
		System.out.println(avg);

	}
	static void finalz(int len)
	{
		for(int i=0;i<len;i++)
		{
			//System.out.println(ccode[i]);
			avg[i]/=cnt;
			System.out.println("Class average:"+avg[i]);
			float pail=cnt-pass[i];
			System.out.println("Below 50:"+pail);

			pass[i]=(pass[i]/cnt)*100;
			System.out.println("Pass percentage:"+pass[i]);

		}
	}
	
	static void max(int len)
	{
		float ultramaxpro=0;
		for(int i=0;i<len;i++)
		{
			System.out.println("Max mark:"+maxmark[i]);
			if(ultramaxpro<maxmark[i])
				ultramaxpro=maxmark[i];
		}
		System.out.println("Overall Max mark:"+ultramaxpro);

	}
}
public class studentz {

	public static void main(String[] args) {
	    Scanner s = new Scanner(System.in);
		System.out.println("Enter n value of students:");
		int n=s.nextInt();
	    student st[]=new student[n];
	    for(int i=0;i<n;i++)
	    {
			System.out.println("For"+i+" student,enter:");
		    st[i]=new student();
	    }
	    
	    for(int i=0;i<n;i++)
	    {
	    	st[i].calc(st[i].marks.length);
	    }
		System.out.println("Details for course codes separately in order is:");
	    student.finalz(st[0].marks.length);
		System.out.println("Max mark for each courses:");
	    student.max(st[0].marks.length);

	}

}
