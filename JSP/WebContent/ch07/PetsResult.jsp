<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>아이 러브 펫</title>
</head>
<body>
	아이디 : ${param.Id} <br/><br />
	 선택한 동물 : ${paramValues.Animal[0]} ${paramValues.Animal[1]}
	${paramValues.Animal[2]}

</body>
</html>