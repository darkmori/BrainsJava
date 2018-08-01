<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setBundle basename="Welcome">
	<fmt:message var="title" key="TITLE" />
	<fmt:message var="greeting" key="GREETING">
		<fmt:param>${ID }</fmt:param>
		<fmt:param>${VNUM }</fmt:param>
	</fmt:message>
	<fmt:message var="body" key="BODY" />
	<fmt:message var="companyName" key="COMPANY_NAME" />
</fmt:setBundle>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<h3>${title }</h3>
	${greeting }
	<br>
	<br> ${body }
	<br>
	<br>
	<font size="2">${companyName }</font>
</body>
</html>