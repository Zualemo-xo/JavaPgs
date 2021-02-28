package week4;

import java.util.Scanner;

class Employee
{
	int Emp_id;
	String name;
	String designation;
	Scanner s=new Scanner(System.in);
	Employee(char p_t)
	{
		int i=0;
		//checking emp_id format
		while(i<1)
		{
		    System.out.println("Enter employee id:");
		    Emp_id=s.nextInt();
		    if( p_t=='p')
		    {
		    	String emp=String.valueOf(Emp_id);
		    	if((emp.substring(0, 1)).equals("5") && emp.length()==5)
		    	{
		    		i+=1;
		    	}
		    	else {
				    System.out.println("Please enter in correct format");

		    	}
		    }
		    
		    else if(p_t=='t')
		    {
		    	String emp=String.valueOf(Emp_id);
		    	if((emp.substring(0, 1)).equals("1") && emp.length()==5)
		    	{
		    		i+=1;
		    	}
		    	else {
				    System.out.println("Please enter in correct format");

		    	}
		    }
		}
	    System.out.println("Enter name:");
	    name=s.next();
	    System.out.println("Enter designation:");
	    designation=s.next();
	}

}
class permanent extends Employee
{
	float BP;
	double NP,GP;
	permanent()
	{
		super('p');
	    System.out.println("Enter BP:");
		BP=s.nextFloat();
	}
	
	//3.Write display functions to display the pay roll details of permanent and temporary  employees separately.
	static void display(permanent p[],int n)
	{
		for(int i=0;i<n;i++)
		{
			double DA=0.15*p[i].BP;
			p[i].GP=p[i].BP+(DA)+8000+(0.05*DA);
			
			p[i].NP=p[i].GP-(0.02*p[i].GP)-1250;
		    System.out.println("Payment for "+p[i].Emp_id+" "+p[i].designation+" "+p[i].name+" is:");
		    System.out.println("Basic Pay:"+p[i].BP);
		    System.out.println("Gross Pay:"+p[i].GP);
		    System.out.println("Net Pay:"+p[i].NP);

		}
	}
	

	
	//•	Display the permanent employee details whose employee Id is within the given range.
	static void id(permanent p[],int n)
	{
		Scanner s=new Scanner(System.in);
	    System.out.println("Enter Lower limit for empid:");
	    int ll=s.nextInt();
	    System.out.println("Enter Upper limit for empid:");
	    int ul=s.nextInt();
	    for(int i=0;i<n;i++)
	    {
	    	if(p[i].Emp_id>ll && p[i].Emp_id<ul)
	    	{
			    System.out.println("Payment for "+p[i].Emp_id+" "+p[i].designation+" "+p[i].name+" is:");
			    System.out.println("Basic Pay:"+p[i].BP);
			    System.out.println("Gross Pay:"+p[i].GP);
			    System.out.println("Net Pay:"+p[i].NP);		    
	    	}
	    }

	}
	
	//•	Display all managers  net pay with their employee ID
	static void manager(permanent p[],int n)
	{
		for(int i=0;i<n;i++)
		{
			if((p[i].designation).equals("manager"))
			{
			    System.out.println("Net Pay:"+p[i].NP+" "+"Emp Id:"+p[i].Emp_id);		
			    System.out.println();		    

			}
		}
	}

}

class temporary extends Employee
{
	float salary_per_hour,total_hours,total_salary;
	temporary()
	{
		super('t');
	    System.out.println("Enter salary per hour:");
	    salary_per_hour=s.nextFloat();
	    System.out.println("Enter total hours:");
	    total_hours=s.nextInt();
	}
	
	//3.Write display functions to display the pay roll details of permanent and temporary  employees separately.
	static void display(temporary t[],int m)
	{
		for(int i=0;i<m;i++)
		{
			t[i].total_salary=t[i].salary_per_hour*t[i].total_hours;
		    System.out.println("Payment for "+t[i].Emp_id+" "+t[i].designation+" "+t[i].name+" is:"+t[i].total_salary);

		}
	}
	
	static void amt(temporary t[],int m)
	{
		for(int i=0;i<m;i++)
		{
			if(t[i].total_salary>20000)
		    System.out.println(t[i].name);

		}
	}

	
}

public class l4p1emp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
	    System.out.println("Enter total no of permanent employees:");
	    int n=s.nextInt();
	    permanent p[]=new permanent[n];
		for(int i=0;i<n;i++)
		{
			p[i]=new permanent();
		}
		
	    System.out.println("Enter total no of temporary employees:");
	    int m=s.nextInt();
	    temporary t[]=new temporary[m];
		for(int i=0;i<m;i++)
		{
			t[i]=new temporary();
		}
		//pay roll details of permanent and temporary  employees separately.
	    System.out.println("Salary of permanent employees:");
		permanent.display(p,n);
	    System.out.println();
	    System.out.println("Salary of temporary employees:");
		temporary.display(t,m);
		//•	Display the permanent employee details whose employee Id is within the given range
	    System.out.println();
	    System.out.println("Check permanent emp details within range:");
		permanent.id(p,n);
		//all temporary employee’s name whose crossed salary above 20000
	    System.out.println();
	    System.out.println("Name of temporary employees with sal>20000:");
		temporary.amt(t,m);
		//•	Display all managers  net pay with their employee ID
	    System.out.println();
	    System.out.println("Manager net pay and employee id details:");
		permanent.manager(p,n);

	}
	
}
