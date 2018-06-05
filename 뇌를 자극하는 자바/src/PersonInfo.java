/**
 * 2018. 5. 3. Dev By Jeong.K.S
 * 
 * PersonInfo.java
 */

public class PersonInfo {

	public static void main(String[] args) {

		// Class 변수
		Person obj;

		// 매개변수 없는 default 생성자 호출하여 객체생성
		obj = new Person();

		// String 매개변수 1개있는 생성자 호출하여 객체생성
		// person = new Person("홍길동");

		// String, int 매개변수 2개있는 생성자 호출하여 객체생성
		// person = new Person("홍길동", 20);

		// int,String 매개변수 2개있는 생성자 호출하여 객체생성
		obj = new Person(20, "홍길동");

		// 메소드 호출
		obj.showPerson(obj);
		obj.showPerson();

		// System.out.println(obj);

	}

}