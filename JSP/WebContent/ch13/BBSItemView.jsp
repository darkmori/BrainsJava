<%@page import="ch12.BBSItem"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	int seqNo = Integer.parseInt(request.getParameter("SEQ_NO"));
	BBSItem bbsItem = new BBSItem();
	bbsItem.setSeqNo(seqNo);
	bbsItem.readDB();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 읽기</title>
</head>
<body>
	<h4>게시글 읽기</h4>
	[제목]<%= bbsItem.getTitle()%><br> 
	[작성자]<%= bbsItem.getWriter()%>
	[작성일시]<%= bbsItem.getDate()%><%= bbsItem.getTime()%><br>
	=======================================================
	<br>
	<%=bbsItem.getContent()%>
</body>
</html>