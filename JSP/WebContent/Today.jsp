<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <%@page import="java.util.GregorianCalendar" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>지금 시간</title>
</head>
<body>

<%
	GregorianCalendar now = new GregorianCalendar();

%>

<%=
String.format("%TY년 %Tm월 %Td일 " , now, now ,now )

%>

</body>
</html>