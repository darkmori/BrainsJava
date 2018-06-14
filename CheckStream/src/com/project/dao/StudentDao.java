package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.project.dto.StudentDto;
import com.project.util.StudentMethod;
import com.project.util.StudentUtil;

public class StudentDao extends AbstractDao {

	public StudentDao() {
		super();
	}

	public Vector getAllStudent() throws SQLException {
		Vector v = new Vector(2, 2);
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		try {
			conn = this.getConnection();
			// System.out.println("2/6성공--getAllStudent");

			psmt = conn.prepareStatement(StudentUtil.GETALLSTUDENT);
			// System.out.println("3/6성공--getAllStudent");

			rs = psmt.executeQuery();
			// System.out.println("4/6성공--getAllStudent");

			while (rs.next()) {
				int i = 1;
				String id = rs.getString(i++);
				String pass = rs.getString(i++);
				String name = rs.getString(i++);
				int no = rs.getInt(i++);
				String addr = rs.getString(i++);
				String birth = rs.getString(i++);
				v.add(new StudentDto(id, pass, name, no, addr, birth));
			}
			// System.out.println("5/6성공--getAllStudent");

		} catch (SQLException e) {
			System.out.println("실패--getAllStudent" + e);
			throw new SQLException("getAllStudent 실패" + e);
		} finally {
			this.close(conn, psmt, rs);
		}
		return v;

	}// getallstudent

	public StudentDto getStudent(String id) throws SQLException {
		StudentDto dto = new StudentDto();

		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		try {
			conn = this.getConnection();
			// System.out.println("2/6성공--getStudent");

			psmt = conn.prepareStatement(StudentUtil.GETSTUDENT);
			psmt.setString(1, id);
			// System.out.println("3/6성공--getStudent");

			rs = psmt.executeQuery();
			// System.out.println("4/6성공--getStudent");
			// 5/6
			while (rs.next()) {
				int i = 1;
				String ids = StudentMethod.toStrNull(rs.getString(i++));
				String password = StudentMethod.toStrNull(rs.getString(i++));
				String name = StudentMethod.toStrNull(rs.getString(i++));
				int no = rs.getInt(i++);
				String addr = StudentMethod.toStrNull(rs.getString(i++));
				String birth = StudentMethod.toStrNull(rs.getString(i++));
				dto.setId(ids.trim());
				dto.setPass(password.trim());
				dto.setName(name.trim());
				dto.setNo(no);
				dto.setAddr(addr.trim());
				dto.setBirth(birth.trim());
			}
			// System.out.println("5/6성공--getStudent");

		} catch (SQLException e) {
			System.out.println("실패--getStudent" + e);
			throw new SQLException("getStudent 실패" + e);
		} finally {
			this.close(conn, psmt, rs);
		}
		return dto;

	}// getStudent

	public boolean joinStudent(String id, String pass, String name, int no, String addr, String birth)
			throws SQLException {
		boolean ins = false;
		Connection conn = null;
		PreparedStatement psmt = null;

		int count = 0;
		try {

			conn = this.getConnection();

			psmt = conn.prepareStatement(StudentUtil.JOINSTUDENT);
			psmt.setString(1, id.trim());
			psmt.setString(2, pass.trim());
			psmt.setString(3, name.trim());
			psmt.setInt(4, no);
			psmt.setString(5, addr.trim());
			psmt.setString(6, birth.trim());

			count = psmt.executeUpdate();
			if (count > 0) {
				ins = true;
			}
		} catch (SQLException e) {
			System.out.println("실패했습니다.  --insertStudent" + e);
			throw new SQLException();
		} finally {
			close(conn, psmt, null);
		}

		return ins;
	}// joinstudent

	public boolean deleteStudent(String id) throws SQLException {
		boolean ins = false;
		Connection conn = null;
		PreparedStatement psmt = null;

		int count = 0;
		try {

			conn = this.getConnection();

			psmt = conn.prepareStatement(StudentUtil.DELETESTUDENT);
			psmt.setString(1, id.trim());

			count = psmt.executeUpdate();
			if (count > 0) {
				ins = true;
			}
		} catch (SQLException e) {
			System.out.println("실패했습니다.  --DELETESTUDENTS" + e);
			throw new SQLException();
		} finally {
			close(conn, psmt, null);
		}
		return ins;
	}// deletestudent

	public boolean updateStudent(String id, String pass, String name, int no, String addr, String birth)
			throws SQLException {
		boolean ins = false;
		Connection conn = null;
		PreparedStatement psmt = null;

		StudentDto dto = new StudentDto();
		dto = this.getStudent(id);
		if (pass.equals(null) || pass.equals("")) {
			pass = dto.getPass();
		}
		if (name.equals(null) || name.equals("")) {
			name = dto.getName();
		}
		if ((no + "").equals(null) || (no + "").equals("")) {
			no = dto.getNo();
		}
		if (addr.equals(null) || addr.equals("")) {
			addr = dto.getAddr();
		}
		if (birth.equals(null) || birth.equals("")) {
			birth = dto.getBirth();
		}

		int count = 0;
		try {

			conn = this.getConnection();

			psmt = conn.prepareStatement(StudentUtil.UPDATESTUDENT);
			psmt.setString(1, pass.trim());
			psmt.setString(2, name.trim());
			psmt.setInt(3, no);
			psmt.setString(4, addr.trim());
			psmt.setString(5, birth.trim());
			psmt.setString(6, id.trim());

			count = psmt.executeUpdate();
			if (count > 0) {
				ins = true;
			}

		} catch (SQLException e) {
			System.out.println("실패했습니다.  --UPDATESTUDENTS" + e);
			throw new SQLException();
		} finally {
			close(conn, psmt, null);
		}

		return ins;
	}// updatestudent

	// 아이디 있는 아이디인지 아닌지를 확인
	public boolean hasId(String id) {
		boolean hasl = false; // 리턴값을 주기위한 변수

		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		try {
			conn = this.getConnection();// 2/6

			psmt = conn.prepareStatement(StudentUtil.HASSTUDENT); // 3/6
			psmt.setString(1, id.trim());

			rs = psmt.executeQuery(); // 4/6

			// 5/6
			if (rs.next()) {
				hasl = true;
			}

		} catch (SQLException e) {
			System.out.println("hasId 실패");
		} finally {
			close(conn, psmt, rs);
		}
		return hasl;
	} // hasId

}
