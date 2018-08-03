<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="DBError.jsp"%>
<%
	String code = request.getParameter("code");
	Connection conn = null;
	Statement stmt = null;
	try {
		Class.forName("org.apache.commons.dbcp.PoolingDriver");
		conn = DriverManager.getConnection("jdbc:apache:commons:dbcp:/webdb_pool");
		if (conn == null)
			throw new Exception("데이터베이스에 연결할수 없습니다.<br>");
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from goodsinfo where code = '" + code + "';");

		if (rs.next()) {
			String title = rs.getString("title");
			String writer = rs.getString("writer");
			int price = rs.getInt("price");
			request.setAttribute("CODE", code);
			request.setAttribute("TITLE", title);
			request.setAttribute("WRITER", writer);
			request.setAttribute("PRICE", price);
		}
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
	RequestDispatcher dispatcher = request.getRequestDispatcher("GoodsinfoViewer.jsp");
	dispatcher.forward(request, response);
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