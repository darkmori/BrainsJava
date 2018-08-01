<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>오늘의 메뉴</title>
</head>
<body>
<h3>오늘의 메뉴</h3>
- 짜장면 <br/>
- 볶음밥 <br/>
- 짬뽕 <br/><br/>

<%
/* flush()를 통해서 위에걸 먼저 실행시키고 그 다음 밑에 코딩을 실행시킴

	위의 내용을 실행*/
out.flush();
RequestDispatcher dispatcher = request.getRequestDispatcher("Now.jsp");
dispatcher.include(request, response);
%>

</body>
</html>