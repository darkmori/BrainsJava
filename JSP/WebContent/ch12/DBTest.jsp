<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DB연결</title>
</head>
<body>
	<%
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/webdb", "root", "12345");
		if (conn != null) {
			out.println("webdb 데이터 연결<br>");
			conn.close();
			out.println("webdb 데이터 연결 끊음<br>");
			
		}else{
			out.println("webdb 연결 불가<br>");

		}
	%>
</body>
</html>