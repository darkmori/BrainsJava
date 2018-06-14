/*
 * ----------------------------------------------------
 * 		public abstract class AbstractDao
 * ----------------------------------------------------
 * 
 * public AbstractDao()					-> 생성자 init()호출
 * private void init()					-> DB드라이버 로딩
 * public Connection getConnection()	-> DB 연결
 * public void close(Connection conn, Statement stmt, ResultSet rs) -> DB연결 닫기
 * 
 * 
 * 
 * DAO 들에서 DB사용을 위한 공통적인 
 * 드라이버로딩, 연결, 닫기를 추상클래스로 상속 줌
 * 
 */

package com.project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.project.util.StudentUtil;

public abstract class AbstractDao {

	public AbstractDao() {
		init();
	} // 생성자

	// 1/6 드라이버 로딩
	private void init() {
		try {
			Class.forName(StudentUtil.DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println(" 1/6 드라이버 로딩 실패" + StudentUtil.DRIVER);
		}
	}

	// 2/6 연결
	public Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(StudentUtil.url, StudentUtil.USER, StudentUtil.PASS);
		} catch (SQLException e) {
			System.out.println("2/6 연결 실패 :" + StudentUtil.url);
		}
		return conn;
	}

	// 6/6 닫기
	public void close(Connection conn, Statement stmt, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
			}
		} // rs
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
			}
		} // stmt
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println("6/6 닫기 실패 : ");
			}
		} // conn
	}// close
}