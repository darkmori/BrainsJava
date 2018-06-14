/*
 * ----------------------------------------------------
 * 		public class AttendDao extends AbstractDao
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
 * 출석정보 attend에 대한 DAO
 * 
 */

package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Vector;

import com.project.dto.StudentDto;
import com.project.dto.AttendDto;
import com.project.util.StudentMethod;
import com.project.util.StudentUtil;

public class AttendDao extends AbstractDao {

	public AttendDao() { // 생성자 부모호출
		super();
	}

	public Vector getAllAttend() throws SQLException { // 모두 가져오기
		Vector v = new Vector(2, 2);
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		try {
			conn = this.getConnection();
			// 3/6
			psmt = conn.prepareStatement(StudentUtil.GETALLATTEND);
			// 4/6
			rs = psmt.executeQuery();

			while (rs.next()) { // rs에 다음값 있으면 돌린다.
				int i = 2;
				String id = rs.getString(i++);
				String attend = StudentMethod.toStrNull(rs.getString(i++));
				String late = StudentMethod.toStrNull(rs.getString(i++));
				String early = StudentMethod.toStrNull(rs.getString(i++));
				String finish = StudentMethod.toStrNull(rs.getString(i++));
				String adate = StudentMethod.toStrNull(rs.getString(i++));

				v.add(new AttendDto(id, attend, late, early, finish, adate)); // dto로 벡터에 넣는다.
			} // while
		} catch (SQLException e) {
			System.out.println("실패 : getAllAttend" + e);
			throw new SQLException("getAllAttend" + e);
		} finally {
			this.close(conn, psmt, rs);
		} // try-catch
		return v;
	} // getAllAttend

	public Vector getIdAttend(String id) throws SQLException { // 아이디로 가져오기
		Vector v = new Vector(2, 2);
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		try {
			conn = this.getConnection();
			// 3/6
			psmt = conn.prepareStatement(StudentUtil.GETIDATTEND);
			psmt.setString(1, id);
			// 4/6
			rs = psmt.executeQuery();
			while (rs.next()) {
				int i = 2;
				String ids = rs.getString(i++);
				String attend = StudentMethod.toStrNull(rs.getString(i++));
				String late = StudentMethod.toStrNull(rs.getString(i++));
				String early = StudentMethod.toStrNull(rs.getString(i++));
				String finish = StudentMethod.toStrNull(rs.getString(i++));
				String adate = StudentMethod.toStrNull(rs.getString(i++));

				// 출석 합계 계산을 위해서 값이 없거나 0이면 0으로 그렇지 않으며 모두 1로 처리
				v.add(new AttendDto(ids, (attend.equals("") || attend.equals("0")) ? 0 + "" : 1 + "",
						(late.equals("") || late.equals("0")) ? 0 + "" : 1 + "",
						(early.equals("") || early.equals("0")) ? 0 + "" : 1 + "",
						(finish.equals("") || early.equals("0")) ? 0 + "" : 1 + "", adate));
			} // while
		} catch (SQLException e) {
			System.out.println("실패 : getIdAttend" + e);
			throw new SQLException("getIdAttend" + e);
		} finally {
			this.close(conn, psmt, rs);
		} // try-catch
		return v;
	} // getIdAttend

	// 출석 추가하기
	public boolean addAttend(String id, String attend, String late, String early, String finish, String adate)
			throws SQLException {
		boolean ins = false;

		Connection conn = null;
		PreparedStatement psmt = null;

		try {
			conn = this.getConnection();
			// 3/6
			psmt = conn.prepareStatement(StudentUtil.ADDATTEND);
			psmt.setString(1, id.trim());
			psmt.setString(2, attend.trim());
			psmt.setString(3, late.trim());
			psmt.setString(4, early.trim());
			psmt.setString(5, finish.trim());
			psmt.setString(6, adate.trim());
			// 4/6
			int count = 0;
			count = psmt.executeUpdate();
			if (count > 0) {
				ins = true;
			}
		} catch (SQLException e) {
			System.out.println("실패 : addAttend" + e);
			throw new SQLException("addAttend" + e);
		} finally {
			this.close(conn, psmt, null);
		} // try-catch
		return ins;
	} // addAttend

	// 출석수정
	public boolean updateAttend(String id, String attend, String late, String early, String finish, String adate,
			String bdate) throws SQLException {
		boolean ins = false;
		AttendDto dto = new AttendDto();
		Connection conn = null;
		PreparedStatement psmt = null;

		// 입력받지 않은 정보가 초기화되지 않도록 원래값을 받아와서
		// 입력받지 않은 값들은 다시 원래의 값을 넣어준다.
		dto = this.getAttend(id, adate);
		if (attend.equals(null) || attend.equals("")) {
			attend = dto.getAttend();
		}
		if (late.equals(null) || late.equals("")) {
			late = dto.getLate();
		}
		if (early.equals(null) || early.equals("")) {
			early = dto.getEarly();
		}
		if (finish.equals(null) || finish.equals("")) {
			finish = dto.getFinish();
		}
		if (bdate.equals(null) || bdate.equals("")) {
			bdate = dto.getAdate();
		}

		try {
			conn = this.getConnection();
			// 3/6

			psmt = conn.prepareStatement(StudentUtil.UPDATEATTEND);
			psmt.setString(1, attend);
			psmt.setString(2, late);
			psmt.setString(3, early);
			psmt.setString(4, finish);
			psmt.setString(5, bdate);
			psmt.setString(6, id);
			psmt.setString(7, adate);
			// 4/6
			int count = 0;
			count = psmt.executeUpdate();
			if (count > 0) {
				ins = true;
			}
		} catch (SQLException e) {
			System.out.println("실패 : updateAttend" + e);
			throw new SQLException("updateAttend" + e);
		} finally {
			this.close(conn, psmt, null);
		} // try-catch finally
		return ins;
	}// updateAttend

	public AttendDto getAttend(String id, String aDate) throws SQLException {
		AttendDto dto = new AttendDto();
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		try {
			conn = this.getConnection();
			// System.out.println("2/6 연결 성공 : getIdAttend");
			// 3/6
			psmt = conn.prepareStatement(StudentUtil.GETATTEND);
			psmt.setString(1, id);
			psmt.setString(2, aDate);
			// System.out.println("3/6 쿼리 준비 성공 : getIdAttend");
			// 4/6
			rs = psmt.executeQuery();
			// System.out.println("4/6 쿼리 성공 : getIdAttend");
			while (rs.next()) {
				int i = 2;
				String ids = rs.getString(i++);
				String attend = StudentMethod.toStrNull(rs.getString(i++));
				String late = StudentMethod.toStrNull(rs.getString(i++));
				String early = StudentMethod.toStrNull(rs.getString(i++));
				String finish = StudentMethod.toStrNull(rs.getString(i++));
				String bdate = StudentMethod.toStrNull(rs.getString(i++));

				dto.setId(ids.trim()); // 값이 없으면 오류나서 null아닌것만 set
				if (attend != null) {
					dto.setAttend(attend.trim());
				}
				if (late != null) {
					dto.setLate(late.trim());
				}
				if (early != null) {
					dto.setEarly(early.trim());
				}
				if (finish != null) {
					dto.setFinish(finish.trim());
				}
				dto.setAdate(bdate.trim());
			}
			// System.out.println("5/6 성공 : getIdAttend");
		} catch (SQLException e) {
			System.out.println("실패 : getIdAttend" + e);
			throw new SQLException("getIdAttend" + e);
		} finally {
			this.close(conn, psmt, rs);
		} // try-catch
		return dto;
	} // getAttend

	public boolean checkAttend(String id, boolean chk, String aDate) throws SQLException {
		boolean ins = false;
		Connection conn = null;
		PreparedStatement psmt = null;

		try {
			conn = this.getConnection();
			// 3/6
			psmt = conn.prepareStatement(StudentUtil.CHECKATTEND);
			psmt.setString(1, id);
			psmt.setString(2, "1");
			if (chk == true) { // chk 지각이면 1 아니면 ""
				psmt.setString(3, "1");
			} else {
				psmt.setString(3, "");
			}
			psmt.setString(4, "");
			psmt.setString(5, "");
			psmt.setString(6, aDate);

			int count = 0;
			count = psmt.executeUpdate();
			if (count > 0) {
				ins = true;
			}

		} catch (SQLException e) {
			System.out.println("실패 : checkAttend" + e);
			throw new SQLException("checkAttend" + e);
		} finally {
			this.close(conn, psmt, null);
		} // try-catch
		return ins;
	} // checkAttend

	public boolean checkFinish(String id, boolean chk, String aDate) throws SQLException {
		boolean ins = false;
		Connection conn = null;
		PreparedStatement psmt = null;

		try {
			conn = this.getConnection();
			// 3/6
			psmt = conn.prepareStatement(StudentUtil.CHECKFINISH);
			psmt.setString(1, id);
			psmt.setString(2, "");
			psmt.setString(3, "");
			if (chk == true) { // 조퇴면 1, 아니면 ""
				psmt.setString(4, "1");
			} else {
				psmt.setString(4, "");
			}
			psmt.setString(5, "1");
			psmt.setString(6, aDate);

			int count = 0;
			count = psmt.executeUpdate();
			if (count > 0) {
				ins = true;
			}

		} catch (SQLException e) {
			System.out.println("실패 : checkFinish" + e);
			throw new SQLException("checkFinish" + e);
		} finally {
			this.close(conn, psmt, null);
		}
		return ins;
	} // checkFinish

	// 오늘 출석했는지를 확인하기 위한 메서드. 출석했으면 또 출석 안하도록
	public boolean isAttend(StudentDto dto, Calendar cal) {
		Vector v = new Vector(2, 2);
		AttendDto atDto = new AttendDto();
		boolean isAtd = false;

		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		try {
			conn = this.getConnection(); // 2/6

			psmt = conn.prepareStatement(StudentUtil.ISATTEND); // 3/6
			psmt.setString(1, dto.getId().trim());
			rs = psmt.executeQuery(); // 4/6

			while (rs.next()) { // 5/6
				String date = rs.getString(7); // 날짜 정보만 필요하기 때문에...
				v.add(new AttendDto(null, null, null, null, null, date));
			}

		} catch (SQLException e) {
			System.out.println("실패 -- getStudent" + e);
		} finally {
			this.close(conn, psmt, rs);
		}

		for (int i = 0; i < v.size(); i++) {
			atDto = (AttendDto) v.get(i);
			String str = atDto.getAdate();
			int idx = str.indexOf(' '); // 날짜가 "월/일 시:분"이므로 공백의 위치 찾아온다.
			// 처음부터 공백까지 잘라와서 오늘 월/일과 비교
			if (str.substring(0, idx).equals((cal.get(Calendar.MONTH) + 1) + "/" + cal.get(Calendar.DATE))) { // 오늘 날짜
																												// 있는지 확
				isAtd = true;
			}
		}
		return isAtd;
	} // isAttend

	// 오늘 출석했는지를 확인하기 위한 메서드.
	public boolean isGohome(StudentDto dto, Calendar cal) {
		Vector v = new Vector(2, 2);
		AttendDto atDto = new AttendDto();
		boolean isAtd = false;

		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		try {
			conn = this.getConnection(); // 2/6

			psmt = conn.prepareStatement(StudentUtil.ISGOHOME); // 3/6
			psmt.setString(1, dto.getId().trim());
			psmt.setString(2, "1");
			rs = psmt.executeQuery(); // 4/6

			while (rs.next()) { // 5/6
				String date = rs.getString(7); // 날짜만 필요하므로
				v.add(new AttendDto(null, null, null, null, null, date));
			}

		} catch (SQLException e) {
			System.out.println("실패 -- getStudent" + e);
		} finally {
			this.close(conn, psmt, rs);
		}

		for (int i = 0; i < v.size(); i++) {
			atDto = (AttendDto) v.get(i);
			String str = atDto.getAdate();
			int idx = str.indexOf(' '); // 월일 잘라내기 위해서 공백 찾아와서 잘라내서 오늘꺼랑 비교
			if (str.substring(0, idx).equals((cal.get(Calendar.MONTH) + 1) + "/" + cal.get(Calendar.DATE))) { // 오늘 날짜
																												// 있는지 확
				isAtd = true;
			}
		}
		return isAtd;
	} // isGohome
}
