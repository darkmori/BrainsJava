package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.project.util.StudentMethod;
import com.project.util.StudentUtil;
import com.project.dto.PenaltyDto;

public class PenaltyDao extends AbstractDao {

	public PenaltyDao() {
		super();//
	}

	public Vector getAllPenalty() throws SQLException {
		Vector v = new Vector(2, 2);
		Connection conn = null;
		PreparedStatement passwordmt = null;
		ResultSet rs = null;
		try {
			conn = this.getConnection();
			// System.out.println("2/6 성공");

			passwordmt = conn.prepareStatement(StudentUtil.GETALLPENALTY);

			// System.out.println("3/6 성공");

			rs = passwordmt.executeQuery();
			// System.out.println("4/6 성공");

			while (rs.next()) {
				int i = 2;
				String id = StudentMethod.toStrNull(rs.getString(i++));
				int amount = rs.getInt(i++);
				String why = StudentMethod.toStrNull(rs.getString(i++));
				String pdate = StudentMethod.toStrNull(rs.getString(i++));

				v.add(new PenaltyDto(id, amount, why, pdate));

			}
			// System.out.println("5/6 성공");

		} catch (SQLException e) {
			System.out.println("5/6 실패");
			throw new SQLException("getAllPenalty 실패" + e);
		} finally {
			this.close(conn, passwordmt, rs);
		}
		return v;
	}

	public Vector getIdPenalty(String ids) throws SQLException {
		Vector v = new Vector(2, 2);

		Connection conn = null;
		PreparedStatement passwordmt = null;
		ResultSet rs = null;
		try {
			conn = this.getConnection();
			// System.out.println("2/6 성공");

			passwordmt = conn.prepareStatement(StudentUtil.GETIDPENALTY);
			passwordmt.setString(1, ids.trim());
			// System.out.println("3/6 성공");

			rs = passwordmt.executeQuery();
			// System.out.println("4/6 성공");

			while (rs.next()) {
				int i = 2;
				String id = StudentMethod.toStrNull(rs.getString(i++));
				int amount = rs.getInt(i++);
				String why = StudentMethod.toStrNull(rs.getString(i++));
				String pdate = StudentMethod.toStrNull(rs.getString(i++));
				v.add(new PenaltyDto(id, amount, why, pdate));
			}
		} catch (SQLException e) {
			System.out.println("5/6 실패");
			throw new SQLException("getIdPenalty 실패" + e);
		} finally {
			this.close(conn, passwordmt, rs);
		}
		return v;
	}

	public boolean AddPenalty(String id, int amount, String why, String pdate) throws SQLException {
		boolean ins = false;
		Connection conn = null;
		PreparedStatement passwordmt = null;
		int count = 0;

		try {

			conn = this.getConnection();

			passwordmt = conn.prepareStatement(StudentUtil.ADDPENALTY);
			passwordmt.setString(1, id.trim());
			passwordmt.setInt(2, amount);
			passwordmt.setString(3, why.trim());
			passwordmt.setString(4, pdate.trim());

			count = passwordmt.executeUpdate();
			if (count > 0) {
				ins = true;
			}
		} catch (SQLException e) {
			System.out.println("실패 했습니다, insertPenalty" + e);
			throw new SQLException("실패 했습니다, insertPenalty" + e);

		} finally {
			close(conn, passwordmt, null);
		}
		return ins;
	}

	public boolean updatePenalty(String id, String why, String pdate, int amount2, String why2) throws SQLException {
		boolean upd = false;
		Connection conn = null;
		PreparedStatement passwordmt = null;
		int count = 0;

		PenaltyDto dto = new PenaltyDto();
		dto = this.getPenalty(id, why, pdate);
		if ((amount2 + "").equals(null) || (amount2 + "").equals("")) {
			amount2 = dto.getAmount();
		}
		if (why2.equals(null) || why2.equals("")) {
			why2 = dto.getWhy();
		}

		try {
			conn = this.getConnection();

			passwordmt = conn.prepareStatement(StudentUtil.UPDATEPENALTY);
			passwordmt.setInt(1, amount2);
			passwordmt.setString(2, why2.trim());
			passwordmt.setString(3, id.trim());
			passwordmt.setString(4, pdate.trim());
			passwordmt.setString(5, "%" + why.trim() + "%");

			count = passwordmt.executeUpdate();
			if (count < 0) {
				upd = true;
			}
		} catch (SQLException e) {
			System.out.println("실패 했습니다, insertPenalty" + e);
			throw new SQLException("실패 했습니다, insertPenalty" + e);

		} finally {
			close(conn, passwordmt, null);
		}
		return upd;
	}

	public PenaltyDto getPenalty(String id, String why, String pDate) throws SQLException {
		PenaltyDto dto = new PenaltyDto();
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		try {
			conn = this.getConnection();
			// System.out.println("2/6 연결 성공 : getIdPenalty");
			// 3/6
			psmt = conn.prepareStatement(StudentUtil.GETPENALTY);
			psmt.setString(1, id);
			psmt.setString(2, pDate);
			psmt.setString(3, why);
			// System.out.println("3/6 쿼리 준비 성공 : getIdPenalty");
			// 4/6
			rs = psmt.executeQuery();
			// System.out.println("4/6 쿼리 성공 : getIdPenalty");
			while (rs.next()) {
				int i = 2;
				String ids = rs.getString(i++);
				int amount = rs.getInt(i++);
				String whys = StudentMethod.toStrNull(rs.getString(i++));
				String pDates = StudentMethod.toStrNull(rs.getString(i++));

				dto.setId(ids.trim());
				dto.setAmount(amount);

				if (whys != null) {
					dto.setWhy(whys.trim());
				}
				if (pDates != null) {
					dto.setPdate(pDates.trim());
				}
			}
			// System.out.println("5/6 성공 : getIdPenalty");
		} catch (SQLException e) {
			System.out.println("실패 : getIdPenalty" + e);
			throw new SQLException("getIdPenalty" + e);
		} finally {
			this.close(conn, psmt, rs);
		}
		return dto;
	}

	public boolean deletePenalty(String id, String why, String pdate) throws SQLException {
		boolean del = false;
		Connection conn = null;
		PreparedStatement passwordmt = null;
		int count = 0;

		try {

			conn = this.getConnection();

			passwordmt = conn.prepareStatement(StudentUtil.DELETEPENALTY);
			passwordmt.setString(1, pdate.trim());

			count = passwordmt.executeUpdate();
			if (count < 0) {
				del = true;
			}
		} catch (SQLException e) {
			System.out.println("실패 했습니다, deletePenalty" + e);
			throw new SQLException("실패 했습니다, deletePenalty" + e);

		} finally {
			close(conn, passwordmt, null);
		}
		return del;

	}
}
