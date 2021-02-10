import java.util.Scanner;

public class reflectionarray {

	public static void main(String[] args) {
	    Scanner s = new Scanner(System.in);
	    System.out.println("Enter size of matrix:");
	    int n=s.nextInt();
	    int m=s.nextInt();
	    double a[][]= new double[n][m];
	    double b[][]= new double[n][m];
	    double c[][]= new double[n][m];
	    System.out.println("Enter elements:");
	    for(int i=0;i<n;i++) 
	    {
	    	for(int j=0;j<m;j++) 
	    	{
	    		a[i][j]=s.nextDouble();
	    		b[i][j]=a[i][j];
	    		c[i][j]=a[i][j];
	    	}
	    }
	    
	    for(int i=0;i<n;i++) 
	    {
	    	for(int j=0;j<m;j++) 
	    	{

	    		b[i][j]=a[i][m-1-j];
	    		c[i][j]=a[n-1-i][j];
	    	}
	    }

	    System.out.println("Horizontal:");
	    for(int i=0;i<n;i++) 
	    {
	    	for(int j=0;j<m;j++) 
	    	{
	    	    System.out.print(b[i][j]+" ");

	    	}
		    System.out.println();

	    }
	    System.out.println("Vertical:");
	    for(int i=0;i<n;i++) 
	    {
	    	for(int j=0;j<m;j++) 
	    	{
	    	    System.out.print(c[i][j]+" ");

	    	}
		    System.out.println();

	    }
	    //difference
	    System.out.println("Difference is:");
	    for(int i=0;i<n;i++) 
	    {
	    	for(int j=0;j<m;j++) 
	    	{
	    		b[i][j]-=c[i][j];
	    	    System.out.print(b[i][j]+" ");

	    	}
		    System.out.println();

	    }
	    

	}

}
