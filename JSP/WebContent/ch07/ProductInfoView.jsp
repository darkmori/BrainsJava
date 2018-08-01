<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" s />
<title>상품 정보</title>
</head>
<body>
	<h3>상품 정보</h3>
	상품명 : ${Product.name }
	<br />
	<%-- 
가격 :  ${Product.value }원 <br/>
 --%>
	<fmt:setLocale value="ja_jp" />
	가격 :
	<fmt:formatNumber value="${Product.value}" groupingUsed="true"
		type="currency"></fmt:formatNumber>

</body>
</html>