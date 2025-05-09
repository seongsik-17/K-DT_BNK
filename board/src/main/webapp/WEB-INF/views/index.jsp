<%@page import="com.example.board.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = (String)session.getAttribute("id");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Index Page</h1>
	<hr>
	<h1>접속중인 사용자: <%=id %></h1>
	<a href="/listContent">게시글 전체조회</a>
</body>
<script>
	
</script>
</html>