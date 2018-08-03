package ch12;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;

import javax.servlet.ServletException;

public class BBSItem {
	private int seqNo;
	private String title;
	private String content;
	private String writer;
	private Date date;
	private Time time;

	public void setSeqNo(int seqNo) {
		this.seqNo = seqNo;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public String getWriter() {
		return writer;
	}

	public Date getDate() {
		return date;
	}

	public Time getTime() {
		return time;
	}

	public void readDB() throws ServletException {
		Connection conn = null;
		Statement stmt = null;

		try {
			Class.forName("org.apache.commons.dbcp.PoolingDriver");
			conn = DriverManager.getConnection("jdbc:apache:commons:dbcp:/webdb_pool");
			if (conn == null)
				throw new Exception("데이터베이스에 연결할수 없습니다.<br>");
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from bbs where seqNo = '" + seqNo + "';");

			if (rs.next()) {

				title = rs.getString("title");
				content = rs.getString("content");
				writer = rs.getString("writer");
				date = rs.getDate("date");
				time = rs.getTime("time");
			}
		} catch (Exception e) {
			throw new ServletException();

		} finally {
			try {
				stmt.close();
			} catch (Exception ignored) {

			}
			try {
				conn.close();
			} catch (Exception ignored) {

			}

		}
	}

}