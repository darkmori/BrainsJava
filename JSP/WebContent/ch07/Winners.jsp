<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%
	String winners[] = new String[3];
	winners[0] = "이수현";
	winners[1] = "정세훈";
	winners[2] = "김진희";
	request.setAttribute("Winners", winners);
	RequestDispatcher dispatcher = request.getRequestDispatcher("WinnersView.jsp");
	dispatcher.forward(request, response);
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title></title>
</head>
<body>

</body>
</html>