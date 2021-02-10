import java.util.Scanner;

public class common {

	public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter array sizes: ");
		int a1=s.nextInt();
		int a2=s.nextInt();
        double arr1[]=new double[a1];
		double arr2[]=new double[a2];
        System.out.println("Enter array elements 1: ");
        for(int i=0;i<a1;i++)
        {
        	arr1[i]=s.nextDouble();
        }
        System.out.println("Enter array elements 2: ");
        for(int i=0;i<a2;i++)
        {
        	arr2[i]=s.nextDouble();
        }
        for (int i=0;i<a1;i++)
        {
        	for(int j=0;j<a2;j++)
        	{
        		if(arr1[i]==arr2[j])
        		{
        			arr1[i]=-1;
        			arr2[j]=-1;
        		}
        	}
        }
        
        for(int i=0;i<a1;i++)
        {
        	if(arr1[i]!=-1)
                System.out.print(arr1[i]+" ");
        }
        System.out.println();
        for(int i=0;i<a2;i++)
        {
        	if(arr2[i]!=-1)
                System.out.print(arr2[i]+" ");
        }
	}

}
