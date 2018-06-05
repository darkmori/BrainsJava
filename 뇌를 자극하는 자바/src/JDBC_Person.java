/**
 * 2018. 5. 8. Dev By Jeong.K.S
 * 
 * JDBC_Person.java
 */

//package
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

class Person {
	String jumincd = null;
	String pname = null;
	String gender = null;
	int age = 0;

	public Person()// 기본 생성자
	{
		this.jumincd = "주민번호 입력 누락";
		this.pname = "이름 입력 누락";
		this.gender = "성별 입력 누락";
		this.age = 0;
	}

	public String getJumincd() {
		return jumincd;
	}

	public void setJumincd(String jumincd) {
		this.jumincd = jumincd;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}

class JDBC_Person {
	public static void main(String args[]) {

		ArrayList<Person> listPerson = new ArrayList<Person>();
		// Person person;

		/////////////// JDBC시작////////////////
		// 1단계: DB연결을 위한 커넥션 인터페이스
		Connection conn = null;
		// Statement Interface - SQL 실행.
		Statement stmt = null;
		// ResultSet Interface - SQL 결과를 저장
		ResultSet rs = null;
		// try~catch문에서 DB연결중에 예외가 발생하는지를 검사.
		try {
			// String jumincd = null;
			// String pname = null;
			// String gender = null;
			int age = 0;
			// 2단계 :JDBC드라이버를 로드한다
			Class.forName("com.mysql.jdbc.Driver");
			// 3단계: 드라이버매니저 클래스는 DB를 연결한다.
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "12345");
			System.out.println("데이터베이스에 접속했습니다.");

			// 커넥션 객체가 Statement객채를 생성
			stmt = conn.createStatement();
			// DML SQL Query 실행후 결과를 저장
			rs = stmt.executeQuery("select jumincd, pname, gender, age from person where gender ='m'");
			System.out.println("주민번호 이름 성별 나이");

			while (rs.next()) {
				// Person person;
				// person = new Person();
				Person person = new Person();

				person.setJumincd(rs.getString(1));
				person.setPname(rs.getString(2));
				person.setGender(rs.getString(3)); // person.setGender(rs.getString("gender"));
				person.setAge(rs.getInt(4));

				listPerson.add(person);
			}
			// 4단계: DB연결을 종료한다.
			conn.close();
			System.out.println("=====================================");

			for (int i = 0; i < listPerson.size(); i++) {
				System.out.print(listPerson.get(i).getJumincd() + ",");
				System.out.print(listPerson.get(i).getPname() + ",");
				System.out.print(listPerson.get(i).getGender() + ",");
				System.out.print(listPerson.get(i).getAge());
				System.out.println();
			}

		} catch (ClassNotFoundException cnfe) {
			System.out.println("해당 클래스를 찾을 수 없습니다." + cnfe.getMessage());

		} catch (SQLException se) {
			System.out.println(se.getMessage());
		}
	}
}