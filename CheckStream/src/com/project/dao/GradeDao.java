/*
 * ----------------------------------------------------
 * 		public class GradeDao extends AbstractDao
 * ----------------------------------------------------
 * 
 * public AttendDao() //생성자
 * public Vector getAllAttend() //출석정보 모두 가져오기
 * public Vector getIdAttend(String id) // 아이디로 검색해서 가져오기
 *  //출석정보 추가하기
 * public boolean addAttend(String id, String attend, String late, String early, String finish, String adate)
 *   //출석정보 수정
 * public boolean updateAttend(String id, String attend, String late, String early, String finish, String adate, String bdate)
 * public AttendDto getAttend(String id, String aDate) //아이디와 날짜로 검색해서 1개만 가져오기
 * public boolean checkAttend(String id, boolean chk, String aDate) // 사용자 출근기록 
 * public boolean checkFinish(String id, boolean chk, String aDate) // 사용자 퇴근 기록
 * public boolean isAttend(StudentDto dto, Calendar cal) // 오늘 출석했는지
 * public boolean isGohome(StudentDto dto, Calendar cal) //오늘 퇴근했는지
 * 
 * 성적정보 grade에 대한 DAO
 * 
 */

package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.project.util.StudentMethod;
import com.project.util.StudentUtil;
import com.project.dto.GradeDto;

public class GradeDao extends AbstractDao {

	public GradeDao() {
		super();//
	}

	public Vector getAllGrade() throws SQLException {
		Vector v = new Vector(2, 2);
		Connection conn = null;
		PreparedStatement passwordmt = null;
		ResultSet rs = null;
		try {

			conn = this.getConnection();
			// System.out.println("2/6 성공");

			passwordmt = conn.prepareStatement(StudentUtil.GETALLGRADE);

			// System.out.println("3/6 성공");

			rs = passwordmt.executeQuery();
			// System.out.println("4/6 성공");

			while (rs.next()) {
				int i = 2;
				String id = StudentMethod.toStrNull(rs.getString(i++));
				String grade = StudentMethod.toStrNull(rs.getString(i++));
				String subject = StudentMethod.toStrNull(rs.getString(i++));

				v.add(new GradeDto(id, grade, subject));
			}
			// System.out.println("5/6 성공");

		} catch (SQLException e) {
			// System.out.println("5/6 실패");
			throw new SQLException("getAllGrade 실패" + e);
		} finally {
			this.close(conn, passwordmt, rs);
		}
		return v;

	}

	public Vector getIdGrade(String ids) throws SQLException {
		Vector v = new Vector(2, 2);

		Connection conn = null;
		PreparedStatement passwordmt = null;
		ResultSet rs = null;
		try {
			conn = this.getConnection();
			// System.out.println("2/6 성공");
			// 3/6
			passwordmt = conn.prepareStatement(StudentUtil.GETIDGRADE);
			passwordmt.setString(1, ids.trim());
			// System.out.println("3/6 성공");
			// 4/6
			rs = passwordmt.executeQuery();
			// System.out.println("4/6 성공");

			while (rs.next()) {
				int i = 2;
				String id = StudentMethod.toStrNull(rs.getString(i++));
				String grade = StudentMethod.toStrNull(rs.getString(i++));
				String subject = StudentMethod.toStrNull(rs.getString(i++));

				v.add(new GradeDto(id, grade, subject));
			}
			// System.out.println("5/6 성공");

		} catch (SQLException e) {
			// System.out.println("5/6 실패");
			throw new SQLException("getIdGrade 실패" + e);
		} finally {
			this.close(conn, passwordmt, rs);
		}
		return v;
	}

	public Vector getSubjectGrade(String subject) throws SQLException {
		Vector v = new Vector(2, 2);

		Connection conn = null;
		PreparedStatement passwordmt = null;
		ResultSet rs = null;
		try {
			conn = this.getConnection();
			// System.out.println("2/6 성공");
			// 3/6
			passwordmt = conn.prepareStatement(StudentUtil.GETSUBJECTGRADE);
			passwordmt.setString(1, subject.trim());
			// System.out.println("3/6 성공");
			// 4/6
			rs = passwordmt.executeQuery();
			// System.out.println("4/6 성공");

			while (rs.next()) {
				int i = 2;
				String id = StudentMethod.toStrNull(rs.getString(i++));
				String grade = StudentMethod.toStrNull(rs.getString(i++));
				String subjects = StudentMethod.toStrNull(rs.getString(i++));

				v.add(new GradeDto(id, grade, subjects));
			}
			// System.out.println("5/6 성공");

		} catch (SQLException e) {
			System.out.println("5/6 실패");
			throw new SQLException("getIdGrade 실패" + e);
		} finally {
			this.close(conn, passwordmt, rs);
		}
		return v;
	}

	public boolean AddGrade(String id, String grade, String subject) throws SQLException {
		boolean ins = false;
		Connection conn = null;
		PreparedStatement passwordmt = null;
		int count = 0;

		try {

			conn = this.getConnection();

			passwordmt = conn.prepareStatement(StudentUtil.ADDGRADE);
			passwordmt.setString(1, id.trim());
			passwordmt.setString(2, grade.trim());
			passwordmt.setString(3, subject.trim());

			count = passwordmt.executeUpdate();
			if (count > 0) {
				ins = true;
			}
		} catch (SQLException e) {
			System.out.println("실패 했습니다, AddGrade" + e);
			throw new SQLException("실패 했습니다, AddGrade" + e);

		} finally {
			close(conn, passwordmt, null);
		}
		return ins;

	}

	public boolean updateGrade(String id, String grade, String subject1, String subject2) throws SQLException {
		boolean upd = false;
		Connection conn = null;
		PreparedStatement passwordmt = null;
		int count = 0;

		GradeDto dto = new GradeDto();
		dto = this.getGrade(id, subject2);
		if (grade.equals(null) || grade.equals("")) {
			grade = dto.getGrade();
		}
		if (subject1.equals(null) || subject1.equals("")) {
			subject1 = dto.getSubject();
		}

		try {

			conn = this.getConnection();

			passwordmt = conn.prepareStatement(StudentUtil.UPDATEGRADE);
			passwordmt.setString(1, grade.trim());
			passwordmt.setString(2, subject1.trim());
			passwordmt.setString(3, id.trim());
			passwordmt.setString(4, subject2.trim());

			count = passwordmt.executeUpdate();
			if (count < 0) {
				upd = true;
			}
		} catch (SQLException e) {
			System.out.println("실패 했습니다, updateGrade" + e);
			throw new SQLException("실패 했습니다, updateGrade" + e);
		} finally {
			close(conn, passwordmt, null);
		}
		return upd;
	}

	public GradeDto getGrade(String id, String subject) throws SQLException {
		GradeDto dto = new GradeDto();
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		try {
			conn = this.getConnection();
			// System.out.println("2/6 연결 성공 : getIdAttend");
			// 3/6
			psmt = conn.prepareStatement(StudentUtil.GETATTEND);
			psmt.setString(1, id);
			psmt.setString(2, subject);
			// System.out.println("3/6 쿼리 준비 성공 : getIdAttend");
			// 4/6
			rs = psmt.executeQuery();
			// System.out.println("4/6 쿼리 성공 : getIdAttend");
			while (rs.next()) {
				int i = 2;
				String ids = rs.getString(i++);
				String grades = StudentMethod.toStrNull(rs.getString(i++));
				String subjects = StudentMethod.toStrNull(rs.getString(i++));

				dto.setId(ids.trim());
				if (grades != null) {
					dto.setGrade(grades.trim());
				}
				if (subjects != null) {
					dto.setSubject(subjects.trim());
				}
			}
			// System.out.println("5/6 성공 : getIdAttend");
		} catch (SQLException e) {
			System.out.println("실패 : getIdAttend" + e);
			throw new SQLException("getIdAttend" + e);
		} finally {
			this.close(conn, psmt, rs);
		}
		return dto;
	}

	public boolean deleteGrade(String id, String subject) throws SQLException {
		boolean del = false;
		Connection conn = null;
		PreparedStatement passwordmt = null;
		int count = 0;

		try {
			conn = this.getConnection();

			passwordmt = conn.prepareStatement(StudentUtil.DELETEGRADE);
			passwordmt.setString(1, id.trim());
			passwordmt.setString(2, subject.trim());

			count = passwordmt.executeUpdate();
			if (count < 0) {
				del = true;
			}
		} catch (SQLException e) {
			System.out.println("실패 했습니다, deleteGrade" + e);
			throw new SQLException("실패 했습니다, deleteGrade" + e);

		} finally {
			close(conn, passwordmt, null);
		}
		return del;

	}

	public boolean hasSubject(String subject) {
		boolean hasl = false; // 리턴값을 주기위한 변수

		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		try {
			conn = this.getConnection();// 2/6

			psmt = conn.prepareStatement(StudentUtil.HASSUBJECT); // 3/6
			psmt.setString(1, subject.trim());

			rs = psmt.executeQuery(); // 4/6

			// 5/6
			if (rs.next()) {
				hasl = true;
			}

		} catch (SQLException e) {
			System.out.println("hasSubject 실패");
		} finally {
			close(conn, psmt, rs);
		}
		return hasl;
	} // hasId
}
