<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>관리자 페이지</title>
</head>
<body>
<h1>관리자 페이지</h1>
관리자만 보여져야함.<br>
로그인한 사용자를 관리자라고 하면<br>
로그인 한 사람만 여기 페이지가 보여 지게끔 해야함.<br>
<br>
<a href="<%=path %>/logout.tm0">로그아웃</a>
</body>
</html>