<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="java.util.Locale"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.io.*"%>
<%@page import="sun.swing.FilePane"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>글쓰기</title>
</head>
<body>

	<h2>글쓰기</h2>
	<%
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("NAME");
		String title = request.getParameter("TITLE");
		String content = request.getParameter("CONTENT");
		String result;
		Date date = new Date();
		Long time = date.getTime();

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd HH_mm_ss", Locale.KOREA);
		Date currentTime = new Date();
		String strTime = simpleDateFormat.format(currentTime);

		String fileName = strTime + ".txt";
		PrintWriter writer = null;

		try {
			String filePath = application.getRealPath("WEB-INF/bbs/" + fileName);
			writer = new PrintWriter(filePath);
			writer.printf("제목 : %s %n", title);
			writer.printf("글쓴이 : %s %n", name);
			writer.printf(content);
			result = "success";
			out.println("저장 되었습니다.");

		} catch (IOException ioe) {
			result = "fail";
			out.println("파일에 데이터를 쓸 수 없습니다.");
		} finally {
			try {
				writer.close();
			} catch (Exception e) {

			}
		}
		response.sendRedirect("BBSPostResult.jsp?result=" + result);
	%>


</body>
</html>