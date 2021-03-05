package week5;

import java.util.Scanner;

abstract class MotorVehicle{
	String modelname;
	int modelnumber;
	double modelprice;
	
	public abstract void display();
}

class Car extends MotorVehicle{
	int discountrate;
	Car(String mn,int mno,double mp,int dr)
	{
		modelname=mn;
		modelnumber=mno;
		modelprice=mp;
		discountrate=dr;

	}
	public void display()
	{
		 System.out.println("The modelname is: "+modelname);
		 System.out.println("The modelnumber is: "+modelnumber);
		 System.out.println("The modelprice is: "+modelprice);
		 System.out.println("The discountrate is: "+discountrate);


	}
	
	public void discount()
	{
		 //System.out.println("The discis: "+discountrate*0.01);

		modelprice=modelprice-(modelprice)*(discountrate*0.01);
		 //System.out.println("The modelprice is: "+modelprice);

	}
}
public class motor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("Enter modelname: ");
		String mn=s.next();
		System.out.println("Enter modelnumber: ");
		int mno=s.nextInt();
		System.out.println("Enter modelprice: ");
		double mp=s.nextDouble();
		System.out.println("Enter discountrate: ");
		int dr=s.nextInt();

		Car c=new Car(mn,mno,mp,dr);
		c.discount();
		c.display();
	}

}
