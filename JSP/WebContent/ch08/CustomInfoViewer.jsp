<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보</title>
</head>
<body>
	<jsp:useBean class="ch08.PersonalInfo" id="pinfo" scope="request"/>
	이름:<jsp:getProperty property="name" name="pinfo"/>
	성별:<jsp:getProperty property="gender" name="pinfo"/>
	나이:<jsp:getProperty property="age" name="pinfo"/>
</body>
</html>