<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보</title>
</head>
<body>

	<jsp:useBean class="ch08.PersonalInfo" id="pinfo" />
	<jsp:getProperty property="name" name="pinfo" param="NAME" />
	<jsp:getProperty property="gender" name="pinfo" param="GENDER"/>
	<jsp:getProperty property="age" name="pinfo" param="AGE"/>
	
	이름:<jsp:getProperty property="name" name="pinfo" /><br>
	성별:<jsp:getProperty property="gender" name="pinfo"/><br>
	나이:<jsp:getProperty property="age" name="pinfo"/>
</body>
</html>