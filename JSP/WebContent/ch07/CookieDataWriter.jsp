<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%
	Cookie cookie = new Cookie("Name","John");
	response.addCookie(cookie);

%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>쿠키 데이터 저장 프로그램</title>
</head>
<body>
쿠키 값이 설정되었습니다.
<a href="CookieDataReader.jsp">CookieDataReader.jsp
</a>

</body>
</html>