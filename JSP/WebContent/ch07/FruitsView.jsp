<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>인기 상품 목록</title>
</head>
<body>
<h3>이달에 가장 많이 팔린 과일입니다.</h3>
<c:forEach items="${Fruits}" var="fruits" varStatus="status">
${status.count}등. ${fruits}<br/>

</c:forEach>

<%-- 
1위. ${Fruits[0] }<br/>
2위. ${Fruits[1] }<br/>
3위. ${Fruits[2] }<br/>
 --%>

</body>
</html>