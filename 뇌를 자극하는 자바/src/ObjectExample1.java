/**
 * 2018. 5. 2. Dev By Jeong.K.S
 * 
 * ObjectExample1.java
 */

public class ObjectExample1 {

	public static void main(String[] args) {

		StringBuffer obj;
		obj = new StringBuffer("Hey, Java");
		obj.deleteCharAt(1);
		obj.deleteCharAt(1);
		obj.insert(1, 'i');

		System.out.println(obj);
		int length = obj.length();
		System.out.println("문자열" + obj + "의 길이는 " + length);

		// replace 메소드를 사용하여 Hi, Java -> Hello, Java 로 치환
		obj.replace(0, 2, "Hello");
		System.out.println(obj);
	}
}
