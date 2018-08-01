<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="false"%>
<% 
	String cookieName = request.getParameter("cookie_Name");
	String cookieVaule = request.getParameter("cookie_Value");
	
	cookieName = URLEncoder.encode(cookieName , "UTF-8");
	response.addCookie(new Cookie(cookieName, cookieVaule));
	response.sendRedirect("DisPlayCookies.jsp");
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<body>

</body>
</html>