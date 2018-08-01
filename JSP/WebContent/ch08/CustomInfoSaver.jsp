<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean class="ch08.PersonalInfo" id="pinfo" scope="request" />
<jsp:setProperty property="name" name="pinfo" value="김현수" />
<jsp:setProperty property="name" name="gender" value="남" />
<jsp:setProperty property="name" name="age" value="23" />
<jsp:forward page="CustomerInfoViewer.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>