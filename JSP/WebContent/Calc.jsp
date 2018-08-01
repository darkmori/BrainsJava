<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cal</title>
</head>
<body>
<%
int a =1, b=3;
%>
a 와 b의 합은? <%= a + b %> <br>
a 와 b의 곱은? <%= a * b %> <br>
a 와 b의 제곱근은? <%= Math.sqrt(a+b) %>


</body>
</html>