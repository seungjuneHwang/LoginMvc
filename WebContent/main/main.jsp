<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	String path = request.getContextPath();
    	String name = (String)session.getAttribute("name");
    %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>메인 페이지</title>
</head>
<body>
<h1>메인 페이지</h1>
<% if (name != null) { %>
	<%=name %> 님 환영 합니다.<br>
	<a href="<%=path%>/admin.tm0">관리자페이지</a><br>
	<a href="<%=path%>/logout.tm0">로그아웃</a><br>
<% } else { %>
	<h3>회원 가입이나 로그인을 하세요.</h3>
	<a href="<%=path%>/login.tm0">로그인</a><br>
	<a href="<%=path%>/joinus.tm0">회원 가입</a><br>
<% } %>



</body>
</html>