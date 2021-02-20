package j17_02_2021;

import java.util.Scanner;

class flat{
	int flatno;
	float length;
	float breadth;
	int floorno;
	double charge;
	flat(int flatn,int l,int b,int fln)
	{
		flatno=flatn;
		length=l;
		breadth=b;
		floorno=fln;
	}
	
	void maintenance()
	{
		double chargez=length*breadth*1.25;
		//chargez=chargez+chargez/10;
		System.out.println("Charge:"+chargez);
		charge=chargez;

	}
	void finalz(float total)
	{
		charge=charge+total/10;
		System.out.println("Final Charge:"+charge);

	}
	
	void display()
	{
		System.out.println("flatno:"+flatno);
		System.out.println("length:"+length);
		System.out.println("breadth:"+breadth);
		System.out.println("Floorno:"+floorno);
		System.out.println("Charge:"+charge);

	}

}

public class apartmentz {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		flat f[]=new flat[3];
		f[0]=new flat(1,2500,5000,1);
		f[1]=new flat(2,1000,4000,2);
		f[2]=new flat(3,5000,3000,3);
		for(int i=0;i<3;i++)
		{
			System.out.println("Initial charge for flat"+i+":");
			f[i].maintenance();
		}

		float tot=0;
		for(int i=0;i<3;i++)
		{
			//
			tot+=f[i].charge;
		}
		for(int i=0;i<3;i++)
		{
			System.out.println("Final charge for flat"+i+":");
			f[i].finalz(tot);
		}
		int fnomax=0;
				double ch=0;
		for(int i=0;i<3;i++)
		{
			if(f[i].charge>ch)
			{
				fnomax=i;
			}
		}
		System.out.println("Max Charge flat details is:");
		f[fnomax].display();
		
	}

}
