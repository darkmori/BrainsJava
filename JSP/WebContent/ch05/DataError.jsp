<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java"  contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
    
<%
	//에러코드를 200이라는 정상코드를 바꿔서
	//정상으로 속임. 에러는 500
	//response.setStatus(200);
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>덧셈 프로그램 - 에러화면</title>
</head>
<body>
<h1>잘못된 데이터가 입력 되었습니다.</h1>

상세 에러 메시지 : <%= exception.getMessage() %>
</body>
</html>