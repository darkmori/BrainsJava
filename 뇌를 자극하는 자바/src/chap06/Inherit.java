package chap06;

//슈퍼 클래스, 부모클리스
class Person {
	int money;

	public Person() {
		// 기본생성자
		System.out.println("부모클래스의 기본 생성자 Person() 호출");
	}

	public Person(int money) {
		this.money = money;
		System.out.println("부모클래스에 Person(int money)생성자 호출");

	}

	public int displatMoney() {
		// System.out.println("재산: " + money);
		return money;
	}
}

// 서브클래스 ,자식클래스
class Child extends Person {
	public Child() {
		System.out.println("자식 클래스에 Child() 기본 생성자 생성");
		super.displatMoney();
	}
}

public class Inherit {

	public static void main(String[] args) {

		Person person = new Person(1000000000);
		// System.out.println(person.money);
		Child child = new Child();
		child.displatMoney();
		// System.out.println(child.money);
	}

}
