//equal elements considered to be a lesser aptitude
package WEEK2;
import java.util.Scanner;

public class L2P2APTITUDE {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter n:");
		int n=s.nextInt();
		int a[][]=new int[n][n];
		int b[][]=new int[n][n];
		System.out.println("Enter aptitude level:");
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				a[i][j]=s.nextInt();
			}
		}
		//System.out.println(a[n+1][n+1]);
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				int cnt=0;
				//boundary
				if(i==0 && j==0)
				{
					if(a[0][1]>=a[i][j])
					{
						cnt+=1;
					}
					if(a[1][1]>=a[i][j])
					{
						cnt+=1;
					}
					if(a[1][0]>=a[i][j])
					{
						cnt+=1;
					}
					if(cnt>=2)
					{
						b[i][j]=-1;
					}
					else
						b[i][j]=1;
				}
				else if(i==0 && j==n-1)
				{
					if(a[0][n-2]>=a[i][j])
					{
						cnt+=1;
					}
					if(a[1][n-2]>=a[i][j])
					{
						cnt+=1;
					}
					if(a[1][n-1]>=a[i][j])
					{
						cnt+=1;
					}
					if(cnt>=2)
					{
						b[i][j]=-1;
					}
					else
						b[i][j]=1;
				}
				else if(i==n-1 && j==0)
				{
					if(a[n-1][1]>=a[i][j])
					{
						cnt+=1;
					}
					if(a[n-2][1]>=a[i][j])
					{
						cnt+=1;
					}
					if(a[n-2][0]>=a[i][j])
					{
						cnt+=1;
					}
					if(cnt>=2)
					{
						b[i][j]=-1;
					}
					else
						b[i][j]=1;
				}
				
				else if(i==n-1 && j==n-1)
				{
					if(a[n-2][n-2]>=a[i][j])
					{
						cnt+=1;
					}
					if(a[n-1][n-2]>=a[i][j])
					{
						cnt+=1;
					}
					if(a[n-2][n-1]>=a[i][j])
					{
						cnt+=1;
					}
					if(cnt>=2)
					{
						b[i][j]=-1;
					}
					else
						b[i][j]=1;
				}
				
				
				//1st and last rows and cols
				else if(i==0)
				{
					if(a[i+1][j-1]>=a[i][j])
					{
						cnt+=1;
					}
					if(a[i+1][j]>=a[i][j])
					{
						cnt+=1;
					}
					if(a[i+1][j+1]>=a[i][j])
					{
						cnt+=1;
					}
					if(a[i][j-1]>=a[i][j])
					{
						cnt+=1;
					}
					if(a[i][j+1]>=a[i][j])
					{
						cnt+=1;
					}
					//condn
					if(cnt>=3)
					{
						b[i][j]=-1;
					}
					else
						b[i][j]=1;
				}
				
				
				else if(i==n-1)
				{
					if(a[i-1][j-1]>=a[i][j])
					{
						cnt+=1;
					}
					if(a[i-1][j]>=a[i][j])
					{
						cnt+=1;
					}
					if(a[i-1][j+1]>=a[i][j])
					{
						cnt+=1;
					}
					if(a[i][j-1]>=a[i][j])
					{
						cnt+=1;
					}
					if(a[i][j+1]>=a[i][j])
					{
						cnt+=1;
					}
					//condn
					if(cnt>=3)
					{
						b[i][j]=-1;
					}
					else
						b[i][j]=1;
				}
				
				
				else if(j==0)
				{
					if(a[i-1][j+1]>=a[i][j])
					{
						cnt+=1;
					}
					if(a[i][j+1]>=a[i][j])
					{
						cnt+=1;
					}
					if(a[i+1][j+1]>=a[i][j])
					{
						cnt+=1;
					}
					if(a[i-1][j]>=a[i][j])
					{
						cnt+=1;
					}
					if(a[i+1][j]>=a[i][j])
					{
						cnt+=1;
					}
					//condn
					if(cnt>=3)
					{
						b[i][j]=-1;
					}
					else
						b[i][j]=1;
				}
				
				
				else if(j==n-1)
				{
					if(a[i-1][j-1]>=a[i][j])
					{
						cnt+=1;
					}
					if(a[i][j-1]>=a[i][j])
					{
						cnt+=1;
					}
					if(a[i+1][j-1]>=a[i][j])
					{
						cnt+=1;
					}
					if(a[i-1][j]>=a[i][j])
					{
						cnt+=1;
					}
					if(a[i+1][j]>=a[i][j])
					{
						cnt+=1;
					}
					//condn
					if(cnt>=3)
					{
						b[i][j]=-1;
					}
					else
						b[i][j]=1;
				}
				
				
				//other non border elements
				else
				{
					if(a[i-1][j-1]>=a[i][j])
					{
						cnt+=1;
					}
					if(a[i-1][j]>=a[i][j])
					{
						cnt+=1;
					}
					if(a[i-1][j+1]>=a[i][j])
					{
						cnt+=1;
					}
					if(a[i][j-1]>=a[i][j])
					{
						cnt+=1;
					}
					if(a[i][j+1]>=a[i][j])
					{
						cnt+=1;
					}
					if(a[i+1][j-1]>=a[i][j])
					{
						cnt+=1;
					}
					if(a[i+1][j]>=a[i][j])
					{
						cnt+=1;
					}
					if(a[i+1][j+1]>=a[i][j])
					{
						cnt+=1;
					}
					//condn
					if(cnt==4)
					{
						b[i][j]=0;
					}
					else if(cnt>4)
					{
						b[i][j]=-1;
					}
					else
					{
						b[i][j]=1;
					}
				}
			}
		}
		
		System.out.println("Output:");
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				System.out.print(b[i][j]+" ");
			}
			System.out.println();

		}
	}

}
