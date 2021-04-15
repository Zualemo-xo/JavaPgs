package week9;
import java.io.*;

import java.util.Scanner;
import java.util.regex.*;  

public class l9p3phone {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner s = new Scanner(System.in);
		 //write into file
		 System.out.println("Enter n: ");
		 int n=s.nextInt();
		 for(int i=0;i<n;i++)
		 {

			 System.out.println("Enter model name: ");
			 String model=s.next();	
			 System.out.println("Enter brand name: ");
			 String brand=s.next();	
			 System.out.println("Enter year of release: ");
			 String year=s.next();
			 System.out.println("Enter price: ");
			 String price=s.next();

			 try {
			PrintWriter pw = new PrintWriter(new FileWriter("./q3.txt", true)); //true USED TO APPEND CONTENT
			pw.println(model);
			pw.println(brand);
			pw.println(year);
			pw.println(price);
			pw.close();
			}
			catch (FileNotFoundException fe) 
	        {              System.out.println("File not found");          } 
			catch (IOException fe) 
		        {              System.out.println("File not found");          }

		 }
		 System.out.println("For q3: ");
		 System.out.println("Enter brand name for calc: ");
		 String cbrand=s.next();			 
		 System.out.println("Enter year of release for calc: ");
		 int cyear=s.nextInt();

		 
		 //read from file
		 BufferedReader f=null;
		 String lmodel;
		 String r1[]=new String[50];
		 String r2[]=new String[50];
		 String r3[]=new String[50];
		 String r4[]=new String[50];
		 int cnt1=0,cnt2=0,cnt3=0,cnt4=0;
		 int tprice=0,cntprice=0;
		 try 
		 {
			  f = new BufferedReader(new FileReader("./q3.txt"));
		 }
		catch (FileNotFoundException fe) 
	     {              
				System.out.println("File not found");          
	     }
		
        try 
        {
			 System.out.println("Q1)Models released in 2020: ");
		   	  while((lmodel = f.readLine()) != null)
		   	  {
		   		String lbrand=f.readLine();
		   		int lyear = Integer.parseInt(f.readLine());
		   		int lprice = Integer.parseInt(f.readLine());
		   		//q1 calc
		   		if(lyear==2020)
		   		{
					 System.out.println(lmodel);
		   		}
		   		//q3calc
		   		if(lbrand.equals(cbrand) && lyear==cyear)
		   		{
		   			tprice+=lprice;
		   			cntprice++;
		   		}
		   		//q2calc
		   		if(lprice>30000)
		   		{
		   			r4[cnt4++]=lmodel;
		   			r4[cnt4++]=String.valueOf(lprice);
		   		}
		   		else if(lprice>20000)
		   		{
		   			r3[cnt3++]=lmodel;
		   			r3[cnt3++]=String.valueOf(lprice);
		   		}
		   		else if(lprice>10000)
		   		{
		   			r2[cnt2++]=lmodel;
		   			r2[cnt2++]=String.valueOf(lprice);
		   		}
		   		else if(lprice<10000)
		   		{
		   			r1[cnt1++]=lmodel;
		   			r1[cnt1++]=String.valueOf(lprice);
		   		}
		   		
		   	  }
		   	  
			System.out.println("Q2)Categories: ");
			System.out.println("Price <10000: ");
			for(int i=0;i<cnt1;i+=2)
			{
				System.out.println(r1[i]);
				System.out.println(r1[i+1]);
			}
			System.out.println("Price >10000 and <20000: ");
			for(int i=0;i<cnt2;i+=2)
			{
				System.out.println(r2[i]);
				System.out.println(r2[i+1]);
			}
			System.out.println("Price >20000 and <30000: ");
			for(int i=0;i<cnt3;i+=2)
			{
				System.out.println(r3[i]);
				System.out.println(r3[i+1]);
			}
			System.out.println("Price >30000: ");
			for(int i=0;i<cnt4;i+=2)
			{
				System.out.println(r4[i]);
				System.out.println(r4[i+1]);
			}
			
			tprice/=cntprice;
			System.out.println("Q3)Avg price of "+cbrand+" in "+cyear+" is :"+tprice);


        }
        catch(IOException i)
        {
        	System.out.println("IO Exception"); 
        }
   	  
   	  }
		 

}
