<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setBundle basename="Intro"/>
<fmt:message var="title" key="TITLE"/>
<fmt:message var="greeting" key="GREETING"/>
<fmt:message var="body" key="BODY"/>
<fmt:message var="company_name" key="COMPANY_NAME"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>
</title>
</head>
<body>
	<h3>${title }</h3>
	${greeting }<br><br>
	${body }<br><br>
	<font size="2">${company_name }</font>
</body>
</html>