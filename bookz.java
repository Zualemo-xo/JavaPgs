package j26_02_2021;

import java.util.*;
//Publisher class
class publisher 
{
 String name,ISBN;
 publisher(String d, String e)
 {
     name =d;
     ISBN=e;
 }
 
 void display()
 {   
     
     System.out.print(name+"\t");
     System.out.print(ISBN+"\t");
     System.out.println();
 }
}
//Inherited book class
class book extends publisher
{
 String title,author1,author2;
 book(String a,String b, String c,String d,String e)
 {
     super(d,e);
     title=a;
     author1=b;
     author2=c;
     
     
 }
 
 void display()
 {
     
     System.out.print(title+"\t");
     System.out.print(author1+"\t");
     System.out.print(author2+"\t");
     super.display();
     
 }
}

class book_sale extends book
{
	int hard_price;
	int kindle_price;
	book_sale(String a,String b, String c,String d,String e,int f,int g)
	{
		super(a,b,c,d,e);
		hard_price=f;
		kindle_price=g;
	}
	
}







public class bookz {

	 // Method to search for the  particular  book title in a book object array
//	 static void search( book b[],int size, String title)
//	 {
//	     System.out.println("Books details of title ="+title);
//	     for(int i=0; i< size;i++)
//	     {
//	        if (b[i].title.equals(title))
//	         {
//	             System.out.println(b[i].title+"  "+b[i].author1+"  "+b[i].author2+" "+b[i].name+" "+b[i].ISBN);
//	         }
//	     }
//	 }
	static void hardcopy_price(book_sale b[],int size)
	{
		Scanner s= new Scanner(System.in);
		System.out.println("Enter title of the book  :");
		String t=s.next();
	     for(int i=0; i< size;i++)
	     {
	        if (b[i].hard_price<1000 && (b[i].title).equals(t))
	         {
	             System.out.println(b[i].title+" "+b[i].author1+" ");
	         }
	     }
	}
	
	
	static void publisher_disp(book_sale b[],int size)
	{
		Scanner s= new Scanner(System.in);
		System.out.println("Enter publisher name of the book  :");
		String t=s.next();
	     for(int i=0; i< size;i++)
	     {
	        if ((b[i].name).equals(t))
	         {
	             System.out.println(b[i].title+" "+b[i].name+" ");
	         }
	     }
	}
	 
	 
		public static void main(String[] args) {
			book_sale b1[]=new book_sale[3];
			for(int i=0;i<3;i++)
			{
				Scanner s= new Scanner(System.in);
			System.out.println("Enter Title of the book  :");
			String a=s.next();
			System.out.println("Enter first author of the book  :");
			String b=s.next();
			System.out.println("Enter second author of the book  :");
			String c=s.next();
			System.out.println("Enter publisher name of the book  :");
			String d=s.next();
			System.out.println("Enter ISBN number of the publisher name   :");
			String e=s.next();
			System.out.println("Enter hard price   :");
			int f=s.nextInt();
			System.out.println("Enter kindle price   :");
			int g=s.nextInt();
			b1[i]=new book_sale(a,b,c,d,e,f,g);
			}
	System.out.println("LIST OF ALL BOOKS");
			for(int i=0;i<3;i++)
			{
			    b1[i].display();
			}
		hardcopy_price(b1,3);
		publisher_disp(b1,3);
		//search(b1,3,"java");
		}
	}


