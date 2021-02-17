package j15_02_2021;

import java.util.Scanner;

public class TIME {
	public int calc(String strs,String stre)
	{
		int hr1=60*Integer.parseInt(strs.substring(0, 2));  
		int hr2=60*Integer.parseInt(stre.substring(0, 2));  
		int min1=Integer.parseInt(strs.substring(3));  
		int min2=Integer.parseInt(stre.substring(3));  
		int timez=hr2-hr1+min2-min1;
		return(timez);
	}

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter s,e time in 24hrs format");
		String strs=s.next();
		String stre=s.next();
		TIME m = new TIME();
		int dur=m.calc(strs,stre);
		System.out.println(dur);

	}

}
