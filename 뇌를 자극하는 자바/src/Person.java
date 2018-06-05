/**
 * 2018. 5. 3. Dev By Jeong.K.S
 * 
 * Person.java
 */

public class Person {

	String name;
	int age;

	// 생성자
	public Person() {
	}

	// 매개변수 1개있는 생성자
	public Person(String name) {
		this.name = name;
	}

	// 매개변수 2개(String,int)있는 생성자
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
		System.out.println("Person(String name,int age) 매개변수 2개있는 생성자 호출");
	}

	// 매개변수 2개(String,int)있는 생성자
	public Person(int age, String name) {
		this.age = age;
		this.name = name;
		System.out.println("Person(int age, String name) 매개변수 2개있는 생성자 호출");

	}

	public void showPerson() {
		System.out.println("이름: " + name + ", 나이: " + age);
	}

	public void showPerson(Person obj) {
		System.out.println("showPerson(Person obj)메소드 호출");
		System.out.println("이름: " + name);
		System.out.println("나이: " + age + "입니다.");

		obj.name = "ichi";
		obj.age = 15;
	}
}