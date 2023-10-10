package scan;

import java.util.Scanner;

public class Scan {
	
	private Scanner scan=new Scanner(System.in) ;
	public Scan() {
		
		this.scan=new Scanner(System.in);
	}
	
	/**
	 * get an int from the user
	 * @return an int 
	 */
	public static int scanInt() { 
		try {
		Scanner scan = new Scanner(System.in) ; 
		int res =scan.nextInt();
		return res ;
		}
		catch(Exception e ) {
			System.out.println("an integer please");
			return Scan.scanInt();
		}
		
	}
	
	/**
	 * get aStringfrom the user
	 * @return a String  
	 */
	public static String scanStr() {
		try {
			Scanner scan = new Scanner(System.in) ; 
			String res =scan.next();
			return res ;
			}
			catch(Exception e ) {
				System.out.println("a String please");
				return Scan.scanStr();
			}
		
	}
	

}
