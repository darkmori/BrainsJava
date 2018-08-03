<%@page import="org.apache.commons.dbcp.PoolingDriver"%>
<%@page import="org.apache.commons.dbcp.PoolableConnectionFactory"%>
<%@page import="org.apache.commons.dbcp.DriverManagerConnectionFactory"%>
<%@page import="org.apache.commons.pool.impl.GenericObjectPool"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	GenericObjectPool objectPool = new GenericObjectPool();
	DriverManagerConnectionFactory connectionFactory = new DriverManagerConnectionFactory(
			"jdbc:mysql://localhost:3306/webdb", "root", "12345");
	new PoolableConnectionFactory(connectionFactory, objectPool, null, null, false, true);
	PoolingDriver driver = new PoolingDriver();
	driver.registerPool("/webdb_pool", objectPool);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DB커넥션 풀생성</title>
</head>
<body>
<h3>DB커넥션 풀생성</h3>
데이터 베이스 커넥션 풀을 생성하고 등록했습니다.<br/><br/>
풀이름 :/webdb_pool
</body>
</html>