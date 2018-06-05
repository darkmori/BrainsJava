/**
 * 
 */
package math;

import geometry.polygon.Rectangle;

public class PackExample2 {

	public static void main(String[] args) {
		Rectangle rect = new Rectangle(2, 3);
		// geometry.polygon.Rectangle rectangle = new geometry.polygon.Rectangle(2, 3);
		System.out.println("넓이 = " + rect.width);
		System.out.println("높이 = " + rect.height);
		System.out.println("면적 = " + rect.getArea());
	}

}
