package com.malldb;

//package
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class JDBCExample1 {
	public static void main(String args[]) {
		// 1단계: DB연결을 위한 커넥션 인터페이스
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		// try~catch문에서 DB연결중에 예외가 발생하는지 검사
		try {
			// 2단계 :JDBC드라이버를 로드한다
			Class.forName("com.mysql.jdbc.Driver");
			// 3단계: 드라이버매니저 클래스는 DB를 연결한다.
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/malldb", "root", "12345");
			System.out.println("데이터베이스에 접속했습니다.");
			// malldb접속정보->
			// show processlist;
			// select now();
			// 커넥션 객채가 Statement객체를 저장
			stmt = conn.createStatement();
			// DML쿼리 SQL 실행 후
			rs = stmt.executeQuery("SELECT jumincd,	pname,	gender,	age from person;");
			if (rs.next()) {
				System.out.println(rs.getString(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getInt(4));
			}
			// 4단계: DB연결을 종료한다.
			conn.close();
		} catch (ClassNotFoundException cnfe) {
			System.out.println("해당 클래스를 찾을 수 없습니다." + cnfe.getMessage());

		} catch (SQLException se) {
			System.out.println(se.getMessage());
		}
	}
}