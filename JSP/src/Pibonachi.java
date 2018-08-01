/**
 * 
 */

/**
 * @author kim
 *
 */
public class Pibonachi {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 1, b = 1, c = 0;

		while (true) {
			c = a + b;
			a = b;
			b = c;
			if(c<100) {
				System.out.println(c);
			}
			else {
				break;
			}
			
			

		}
	}

}
