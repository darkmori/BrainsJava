<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%
Cookie cookie = new Cookie("job", "programmer");
cookie.setPath("JSP/ch04/sub1/");
//cookie.setDomain(".kosea.com");	// it.kosea.com, jp.kosea.com
response.addCookie(cookie);

%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>쿠키 데이터 저장하기</title>
</head>
<body>
job 쿠키가 저장되었습니다.<br/><br/>

</body>
</html>