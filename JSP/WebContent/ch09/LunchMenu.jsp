<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	String arr[] = { "불고기 백반", "오므라이스", "콩국수" };
	request.setAttribute("MENU", arr);
%>
<jsp:forward page="LunchMenuView.jsp" />
<html>
<head>
<meta charset="UTF-8">
<title>구내 식당</title>
</head>
<body>

</body>
</html>