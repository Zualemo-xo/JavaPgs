package j17_02_2021;

import java.util.Scanner;

class date{
	int day;
	int month;
	int year;
	String name;
	 Scanner s = new Scanner(System.in);

	date()
	{
		//assume asc order of dates
	    System.out.println("Enter d,m,y,name: ");
		day=s.nextInt();
		month=s.nextInt();
		year=s.nextInt();
		name=s.next();
	}
	void findday()
	{
		String s[]={"monday","tuesday","wednesday","thursday","friday","saturday","sunday"};
	    System.out.println("3 days after day is:");
		for(int i=0;i<s.length;i++)
		{
			if(name.equals(s[i]))
			{
				i+=3;
				if(i>s.length)
				{
					i-=s.length;
				}
			    System.out.println(s[i]);
			    break;

			}
		}
		
	}
	void difference(date d1)
	{
		int d=d1.day-day;
		int m=(d1.month-month)*31;
		int y=(d1.year-year)*365;
		int dz=d+m+y;
	    System.out.println("Diff btwn d,m,y is:"+dz);

	}
	void display()
	{
	    System.out.println("Date is"+day+"/"+month+"/"+year);
	}
}
public class datez {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner s = new Scanner(System.in);
		 date d1=new date();
		 date d2=new date();
		 d1.findday();
		 d2.findday();
		 d1.difference(d2);
		 d1.display();
		 d2.display();
	}

}
