import java.util.Scanner;

public class sort {

	public static void main(String[] args) {
        Scanner s = new Scanner(System.in);	
        System.out.println("Enter no of elements: ");
        int n=s.nextInt();
        int a[]=new int[n];
        int lastdigit[]=new int[n];
        System.out.println("Enter digits: ");
        for(int i=0;i<n;i++)
        {
        	 a[i]=s.nextInt();
        }

        for(int i=0;i<n;i++)
        {
        	for(int j=i+1;j<n;j++)
        	{
        		if(a[i]%10>a[j]%10)
        		{
        			int temp=a[i];
        			a[i]=a[j];
        			a[j]=temp;
        		}
        	}
        }
        System.out.println("Numbers sorted based on last digits are: ");

        for(int i=0;i<n;i++)
        {
            System.out.println(a[i]);

        }

	}

}
