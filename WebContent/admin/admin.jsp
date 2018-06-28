<%@page import="com.team0.vo.UserVO"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String path = request.getContextPath();
	// 사용자 리스트를 담은 리스트를 불러 불러 오자
	// AdminServlet에 저장 시킨 getList를 받아 올수 있다.
	ArrayList<UserVO> getList = (ArrayList<UserVO>)request.getAttribute("userlist");
	
// 	for (UserVO vo : getList) { 
// 		System.out.println("idx: " + vo.getU_idx());
// 		System.out.println("이름: " + vo.getName());
// 		System.out.println(vo.getEmail());
// 		System.out.println(vo.getPhone());
// 		System.out.println(vo.getPw());
// 		System.out.println("=======================");
// 	}
	

%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>관리자 페이지</title>
</head>
<body>
<%-- 	<%=vo.getU_idx() %> --%>
<div class="container">
<h1>관리자 페이지</h1>
관리자만 보여져야함.<br>
로그인한 사용자를 관리자라고 하면<br>
로그인 한 사람만 여기 페이지가 보여 지게끔 해야함.<br>
<br>
<a href="<%=path %>/logout.tm0">로그아웃</a>
  <h2>관리자님 안녕하세요</h2>
  <p>회원 정보 입니다.</p>            
  <table class="table table-hover">
    <thead>
      <tr>
      	<th>번호</th>
        <th>이름</th>
        <th>이메일</th>
        <th>전화번호</th>
        <th>비밀번호</th>
      </tr>
    </thead>
    <tbody>
    <%	for (UserVO vo : getList) { %> 
      <tr>
      	<td><%=vo.getU_idx()%></td>
        <td><%=vo.getName()%></td>
        <td><%=vo.getEmail()%></td>
        <td><%=vo.getPhone()%></td>
        <td><%=vo.getPw()%></td>
      </tr>
      <%	} %>
     </tbody>
  </table>
</div>

</body>
</html>