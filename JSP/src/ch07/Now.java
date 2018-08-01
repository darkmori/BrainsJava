/**
 * 
 */
package ch07;

import java.util.GregorianCalendar;

/**
 * @author kim
 *
 */
public class Now {
	public static String printNow() {
		GregorianCalendar now = new GregorianCalendar();
		String nowDate = String.format("%TF %TT", now ,now);
		System.out.println(nowDate);
		return nowDate;
	}
	
	/*public static void main(String [] args) {
		String date = Now.printNow();
		System.out.println(date);
		printNow();
	}*/

}
