package chap19;

import java.awt.Container;
import java.awt.Dimension;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Pro_JDBCExample {

	public static void main(String[] args) {

		String driver = null;
		String url = null;
		String username = null;
		String password = null;

		try {

			// 프로퍼티 파일 위치
			String propFile = "db.properties";

			// 프로퍼티 객체 생성
			Properties props = new Properties();

			// 프로퍼티 파일 스트림에 담기
			FileInputStream fis = new FileInputStream(propFile);

			// 프로퍼티 파일 로딩
			props.load(new java.io.BufferedInputStream(fis));

			// driver 읽기
			driver = props.getProperty("driver");
			url = props.getProperty("url");
			username = props.getProperty("username");
			password = props.getProperty("password");

		} catch (Exception e) {
			e.printStackTrace();
		}
		// 1단계: DB연결을 위한 커넥션 인터페이스
		Connection conn = null;
		try {
			// 2단계 :JDBC드라이버를 로드한다
			if (driver != null) {
				Class.forName(driver);
			}

			// Class.forName("com.mysql.jdbc.Driver");
			// 3단계: 드라이버매니저 클래스는 DB를 연결한다.
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("데이터베이스에 접속했습니다.");

			// 4단계: DB연결을 종료한다.
			conn.close();
		} catch (ClassNotFoundException cnfe) {
			System.out.println("해당 클래스를 찾을 수 없습니다." + cnfe.getMessage());

		} catch (SQLException se) {
			System.out.println(se.getMessage());
		}
	}

}
