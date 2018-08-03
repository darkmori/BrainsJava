<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="DBError.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DBConnection Pool Test</title>
</head>
<body>
	<h3>DBConnection Pool Test</h3>
	<%
		Class.forName("org.apache.commons.dbcp.PoolingDriver");
		Class.forName("com.mysql.jdbc.Driver");
		//Connection conn = DriverManager.getConnection("jdbc:apache:commons:dbcp:/webdb_pool");
		Connection conn = DriverManager.getConnection("jdbc:apache:commons:dbcp:/wdbpool");

		if (conn != null) {
			out.println("연결취득완료<br>");
			conn.close();
			out.println("연결반환완료<br>");
		} else {
			out.println("연결취득실패<br>");
		}
	%>
</body>
</html>