<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String name = request.getParameter("name");

	session.setAttribute("id", id);
	session.setAttribute("pw", pw);
	session.setAttribute("name", name);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>회원가입</title>
</head>
<body>

	<h3>약관</h3>
	-----------------------------------------------
	<br /> 1. 회원정보는 웹 사이트의 운영을 위해서만 사용됩니다.
	<br /> 2. 웹 사이트의 정상 운영을 방해하는 회원은 탈퇴 처리합니다.
	<br /> -----------------------------------------------
	<br />
	<form action="Subscribe.jsp" method="post">
		위의 약관에 동의 하십니까? 
		<input type="radio" name="agree" value="yes" />동의함
		<input type="radio" name="agree" value="no" />동의하지 않음 <br />
			<br /> <input type="submit" value="확인" />
	</form>


</body>
</html>