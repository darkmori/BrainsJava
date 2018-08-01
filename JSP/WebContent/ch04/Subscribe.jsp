<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="java.io.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String agree = request.getParameter("agree");
	String result = null;
	if(agree.equals("yes")){
		String id = (String) session.getAttribute("id");
		String pw = (String) session.getAttribute("pw");
		String name = (String) session.getAttribute("name");
		
		PrintWriter writer = null;
		try{
			String filePath = application.getRealPath("/WEB-INF/" + id + ".txt");
			writer = new PrintWriter(filePath);
			writer.println("아이디 : " + id); 
			writer.println("패스워드 : " + pw); 
			writer.println("이름 : " + name); 
			result = "success";
			
		}
		catch(IOException ioe){
			result = "fail";
		}
		finally{
			try{
				writer.close();
			}
			catch(Exception e){
				
			}
		}
	}
	else{
		result = "fail";
	}
	session.invalidate();
	response.sendRedirect("Result.jsp?result="+result);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<body>

</body>
</html>