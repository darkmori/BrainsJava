<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<body>

<jsp:useBean class="ch08.PersonalInfo" id="pinfo"></jsp:useBean>

<jsp:setProperty property="name" name="pinfo" value="김연희"/>
<jsp:setProperty property="gender" name="pinfo" value="여"/>
<jsp:setProperty property="age" name="pinfo" value="29"/>

이름 : <jsp:getProperty property="name" name="pinfo"/>
성별 : <jsp:getProperty property="gender" name="pinfo"/>
나이 : <jsp:getProperty property="age" name="pinfo"/>

</body>
</html>