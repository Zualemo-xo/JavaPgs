package week5;

import java.util.Scanner;
import java.lang.Math; 

abstract class shape{
	public abstract void area();
	public abstract void perimeter();
}

class rectangle extends shape{
	int l,b;
	double area,perimeter;
	rectangle(int l,int b)
	{
		this.l=l;
		this.b=b;
	}
	public void area()
	{
		area=l*b;
	}
	
	public void perimeter()
	{
		perimeter=2*(l+b);
	}
	
	void display()
	{
		 System.out.println("The area of a rectangle is: "+area);
		 System.out.println("The perimeter of a rectangle is: "+perimeter);

	}
}


class triangle extends shape{
	int base,height;
	double area,perimeter;
	//right angled triangle
	triangle(int base,int height)
	{
		this.base=base;
		this.height=height;
	}
	public void area()
	{
		area=0.5*base*height;
	}
	
	public void perimeter()
	{
		perimeter=base+height+Math.pow(Math.pow(base,2)+Math.pow(height,2),0.5);
	}
	
	void display()
	{
		 System.out.println("The area of a triangle is: "+area);
		 System.out.println("The perimeter of a triangle is: "+perimeter);

	}

}


public class shapez {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner s = new Scanner(System.in);
		 System.out.println("Enter length of rectangle: ");
		 int l=s.nextInt();
		 System.out.println("Enter breadth of rectangle: ");
		 int b=s.nextInt();
		rectangle r=new rectangle(l,b);
		
		 System.out.println("Enter base of triangle: ");
		 int base=s.nextInt();
		 System.out.println("Enter height of triangle: ");
		 int height=s.nextInt();
		triangle t=new triangle(base,height);
		r.area();
		r.perimeter();
		t.area();
		t.perimeter();
		r.display();
		t.display();

	}

}
