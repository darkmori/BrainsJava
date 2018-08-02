<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="DBError.jsp"%>
<%@page import="java.sql.*"%>
<%
	request.setCharacterEncoding("UTF-8");

	String name = request.getParameter("name");
	String id = request.getParameter("id");
	String password = request.getParameter("password");

	if (name == null || id == null || password == null)
		throw new Exception("데이터를 입력하세요.");

	Connection conn = null;
	PreparedStatement pstmt = null;
	//Statement stmt = null;

	try {
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/webdb?useUnicode=true&characterEncoding=utf8", "root", "12345");

		if (conn == null)
			throw new Exception("데이터베이스에 연결할수 없습니다.<br>");
		String sql = "INSERT INTO userinfo(uname, uid, upassword) VALUES(?,?,?)";
		pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, name);
		pstmt.setString(2, id);
		pstmt.setString(3, password);
		//stmt = conn.createStatement();
		//String command = String.format("INSERT INTO userinfo (uname, uid, upassword) values('%s','%s','%s');",name, id, password);
		//String command="INSERT INTO userinfo(uname, uid, upassword) VALUES ('" + name + "'," + "'" + id + "'," + "'" + password + "')"; 

		int rowNum = pstmt.executeUpdate();
		if (rowNum < 1)
			throw new Exception("데이터를 DB에 입력할수 없습니다.");
	} finally {
		try {
			pstmt.close();
		} catch (Exception ignored) {

		}
		try {
			conn.close();
		} catch (Exception ignored) {

		}
	}
	response.sendRedirect("SubscriptionResult.jsp");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>