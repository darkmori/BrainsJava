import java.util.ArrayList;

/**
 * 
 */

public class ArrayList_Test {

	public static void main(String[] args) {
		ArrayList<String> fruits = new ArrayList<String>(3);
		fruits.add("포도");
		fruits.add("딸기");
		fruits.add("복숭아");
		fruits.add("아보카도");
		fruits.add("배");
		fruits.add("수박");

		// String[] fruits = new String[3];
		// fruits[0] = "포도";
		// fruits[1] = "사과";
		// fruits[2] = "배";
		// // fruits[3]="수박";

		System.out.println("과일 출력");

		int size = fruits.size();

		for (int i = 0; i < size; i++) {
			System.out.println(fruits.get(i));
		}

		System.out.println("================================== ");
		fruits.remove(2);
		
		for (int i = 0; i < size; i++) {
			System.out.println(fruits.get(i));
		}
		// System.out.println(fruits.get(0));
		// System.out.println(fruits.get(1));
		// System.out.println(fruits.get(2));
	}

}
