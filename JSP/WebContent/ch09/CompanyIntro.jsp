<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setBundle basename="Intro"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>
<fmt:message key="TITLE"/>
</title>
</head>
<body>
<h3><fmt:message key="TITLE"/></h3>
<fmt:message key="GREETING"/><br><br>
<fmt:message key="BODY"/><br><br>
<font size="2"><fmt:message key="COMPANY_NAME"/></font>
</body>
</html>