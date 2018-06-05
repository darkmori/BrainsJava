import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class JDBCExample0 {
	public static void main(String args[]) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/malldb", "root", "12345");
			System.out.println("데이터베이스에 접속했습니다.");
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select custinfoname, address, phoneno from custinfo");
			System.out.println("이름====================주소================전화번호");

			while (rs.next()) {
				String pname = rs.getString(1);
				String address = rs.getString(2);
				String phoneno = rs.getString(3);

				System.out.println(pname + "-" + address + "-" + phoneno);
			}
			conn.close();

		} catch (ClassNotFoundException cnfe) {
			System.out.println("해당 클래스를 찾을수 없습니다." + cnfe.getMessage());
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		}
	}
}