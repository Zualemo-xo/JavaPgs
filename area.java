package j06_02_2021;

import java.util.Scanner;

public class area {

	public static void main(String[] args) {
	    Scanner s = new Scanner(System.in);
	    System.out.println("Enter radius: ");
	    int r=s.nextInt();
	    double arin = Math.sqrt(2) * r;
	    arin *= arin;//squared
	    float arout = 2 * r;
	    arout *= arout;//squared
	    double diff = arout - arin;
	    System.out.println("Diff in areas:"+diff);
	}

}
