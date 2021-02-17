package j15_02_2021;

import java.util.Scanner;

public class maeks {

	static String[][] calc(int a[][],int n,int m)
	{
		int avg[]=new int[n];
		int sumz=0;
		String grade[][]=new String[n][m];
		for(int i=0;i<n;i++)
		{
			sumz=0;
			for(int j=0;j<m;j++)
			{
				sumz+=a[i][j];
			}
			avg[i]=sumz/m;
			//System.out.println(avg[i]);

		}
		
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				if(a[i][j]-avg[i]>=5)
				{
					grade[i][j]="A";
				}
				
				else if(a[i][j]-avg[i]>=0)
				{
					grade[i][j]="B";
				
				}
				else if(a[i][j]-avg[i]<=-4)
				{
					grade[i][j]="C";
				}
				
				else
				{
					grade[i][j]="D";
				}
			}
		}
		return(grade);
	}
	
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter n,m");
		int n=s.nextInt();
		int m=s.nextInt();
		int a[][]=new int[n][m];
	      for(int i=0;i<n;i++)
	      {
	    	  for(int j=0;j<m;j++)
	    	  {
	    		  a[i][j]=s.nextInt();
	    	  }
	      }
		String str[][]=new String[n][m];
	     str=calc(a,n,m);
	      
	      for(int i=0;i<n;i++)
	      {
	    	  for(int j=0;j<m;j++)
	    	  {
	    			System.out.print(str[i][j]);

	    	  }
	  		System.out.println();

	      }
	}

}
