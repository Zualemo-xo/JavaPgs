package week7;

import java.util.*;
import java.util.regex.*;

class profile
{
	Scanner s = new Scanner(System.in);

	String name,regno,phno;
	int age;
	profile()
	{
		try 
		{
			System.out.println("Enter name:");
			name=s.next();
			if(Pattern.matches("^[a-zA-Z]*$", name))
			{
			}
			else {
				throw new NameException();
			}
			
			
			System.out.println("Enter regno:");
			regno=s.next();
			if(Pattern.matches("[0-9]{2}[A-Z]{3}[0-9]{4}", regno))
			{
			}
			else {
				throw new RegnoException();
			}
			
			
			System.out.println("Enter age:");
			age=s.nextInt();
			if(age<18 || age>21)
			{
				throw new AgeException();
			}
			
			
			System.out.println("Enter phno:");
			phno=s.next();
			if(Pattern.matches("[0-9]{10}", phno))
			{
			}
			else {
				throw new PhnoException();
			}
			
		}
		catch(NameException n)
		{
			System.out.println(n);

		}
		catch(AgeException a)
		{
			System.out.println(a);
		}
		catch(RegnoException r)
		{
			System.out.println(r);
		}
		catch(PhnoException p)
		{
			System.out.println(p);
		}
	}
}

class NameException extends Exception
{
	NameException()
	{
		System.out.println("Name should contain only alphabets –No numbers and special characters");
	}
}

class RegnoException extends Exception
{
	RegnoException()
	{
		System.out.println("Register Number in the format two numbers three characters four numbers");
	}
}

class AgeException extends Exception
{
	AgeException()
	{
		System.out.println("Age should be greater than 18 and less than 21");
		
	}
}

class PhnoException extends Exception
{
	PhnoException()
	{
		System.out.println("Phone no should be 10 digits");
		
	}
}

public class l7p1exception {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		profile p=new profile();
		int y=Integer.valueOf(p.regno.substring(0, 2));
		int year=2000+y;
		String email=p.name+year+"@vitstudent.ac.in";
		String password=p.name.substring(0, 4).toUpperCase()+p.regno.substring(5)+"@";
		System.out.println("Email Id:"+email);
		System.out.println("Password:"+password);

	}

}
