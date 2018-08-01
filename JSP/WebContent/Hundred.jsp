<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<!-- HTML의 주석 표시 -->
<body>
<%-- JSP의 주석 표시, 실제 표시될때는 이 주석은 보여주지 않는다. --%>
	<%
		int total = 0;
		for (int cnt = 1; cnt <= 100; cnt++) {
			total +=cnt;
			/* 자바 주석	*/

		}
	%>

	1+2+3+4+5+....+100 = <%= total %>


</body>
</html>