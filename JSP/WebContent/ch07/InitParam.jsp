<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>애플리케이션 초기화 파라미터 예제</title>
</head>
<body>
<h2>DB_NAME 초기화 파라미터의 값은?${initParam.DB_NAME }</h2> <br/>

<h2>DB_Test 초기화 파라미터의 값은?${initParam.DB_Test }</h2><br/>

<h2>요청 URI : ${pageContext.request.requestURI } </h2><br/>
</body>
</html>