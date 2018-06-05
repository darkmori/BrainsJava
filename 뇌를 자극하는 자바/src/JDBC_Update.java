/**
 * 2018. 5. 8. Dev By Jeong.K.S
 * 
 * JDBC_Update.java
 */

//package
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class JDBC_Update {
	public static void main(String args[]) {
		// 1단계: DB연결을 위한 커넥션 인터페이스
		Connection conn = null;
		// Statement Interface - SQL 실행.
		Statement stmt = null;
		// ResultSet Interface - SQL 결과를 저장
		ResultSet rs = null;
		// try~catch문에서 DB연결중에 예외가 발생하는지를 검사.
		try {
			String jumincd = null;
			String pname = null;
			String gender = null;
			int age = 0;
			// 2단계 :JDBC드라이버를 로드한다
			Class.forName("com.mysql.jdbc.Driver");
			// 3단계: 드라이버매니저 클래스는 DB를 연결한다.
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "12345");
			System.out.println("데이터베이스에 접속했습니다.");

			// DB SQL작업
			stmt = conn.createStatement();
			String sql = "update person SET age=22 WHERE jumincd='7803101574311'";
			int changeRecord = stmt.executeUpdate(sql);

			// 4단계: DB연결을 종료한다.
			conn.close();

			System.out.println(changeRecord + "건이 수정되었습니다.");
		} catch (ClassNotFoundException cnfe) {
			System.out.println("해당 클래스를 찾을 수 없습니다." + cnfe.getMessage());

		} catch (SQLException se) {
			System.out.println(se.getMessage());
		}
	}
}