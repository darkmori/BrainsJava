<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>사칙 연산</title>
</head>
<body>

덧셈의 결과는? <%= request.getAttribute("sum")%> <br/>
뺄셈의 결과는? <%= request.getAttribute("differenc")%> <br/>
곱셈의 결과는? <%= request.getAttribute("product")%> <br/> 
나눗셈의 결과는? <%= request.getAttribute("quotient")%> <br/>


</body>
</html>