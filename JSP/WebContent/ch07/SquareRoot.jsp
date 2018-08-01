<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="m" uri="http://localhost:8080/JSP/ch07/math-functions.tld" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>2018. 7. 13.</title>

<link href="css/bootstrap.min.css" rel="stylesheet">
   <!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->

   <script
      src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
   <!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
   <script src="js/bootstrap.min.js"></script>
</head>
<body>

   ${param.NUM} 의 제곱근은? ${m:squareroot(param.NUM) }<br/>
   
   ${param.NUM1 }부터 ${param.NUM2 }까지의 합은?<br/><br/>
   답 : ${m:total(param.NUM1, param.NUM2) }<br/>
   
</body>
</html>