<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String path = request.getContextPath();
	%>
<%-- 	<%=path %>/index.jsp --%>
	
	<script>
		//location.href="<%=path%>/joinus.tm0";
		location.href="<%=path%>/main.tm0";
		//location.href="${pageContext.request.contextPath}/login.tm0";
	</script>
</body>
</html>