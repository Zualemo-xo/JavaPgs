package j_15_03_2021;
import java.util.*;
import java.text.*;
import java.time.*;
import java.text.*;
import java.time.LocalDate;  

public class datez {

	static void chkregno(String rno,String dojyr)
	{
		 String ryr=rno.substring(0, 2);
		 Date dnow = new Date();
		 int year=dnow.getYear()+1900;
		 //System.out.println(year);
		 String yr=String.valueOf(year);
		 String cyr=yr.substring(2);
		 if(dojyr.equals(ryr))
		 {
			 Integer yearz=Integer.valueOf(cyr)-Integer.valueOf(ryr);
			 //System.out.printf("%d th year /n",yearz);
			 System.out.println(yearz+" year ");
		 }
		 else
		 {
			 System.out.println("Invalid"); 
		 }
	}
	static void birth(LocalDate dobirth)
	{
		LocalDate present=LocalDate.now();
		//int year=;
	      //SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
	      //Date date = formatter.parse(dobirth);
		 //System.out.println(date);
		 int age=Period.between(dobirth, present).getYears();
		 int agem=Period.between(dobirth, present).getMonths();
		 int aged=Period.between(dobirth, present).getDays();
		 System.out.println("Age:"+age+" years "+agem+" months "+aged+" days "); 

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner s = new Scanner(System.in);
		 System.out.println("Enter register no: ");
		 String rno=s.next();
		 System.out.println("Enter name: ");
		 String name=s.next();
		 System.out.println("Enter date of join as dd mm yy: ");
		 int dojd=s.nextInt();
		 int dojm=s.nextInt();
		 String dojy=s.next();
		 
		 System.out.println("Enter date of birth as dd mm yy: ");
		 int dobd=s.nextInt();
		 int dobm=s.nextInt();
		 int doby=s.nextInt();
		 System.out.println("Enter date of birth full yyyy: ");
		 int dobyyyy=s.nextInt();
		 LocalDate dobirth =LocalDate.of(dobyyyy,dobm,dobd);
		 
		 //System.out.println(dobirth);
		 chkregno(rno,dojy);
		 birth(dobirth);
	}

}
