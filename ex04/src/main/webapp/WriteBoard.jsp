<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	if(session.getAttribute("id") == null){
		response.sendRedirect("Login.jsp");
	}
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시글 작성</h1>
	<hr>
	<form action="wbServlet" method=POST>
		<input type="text" name="title">
		<input type="text" name="content">
		<input type="submit" value ="작성하기">
	</form>
</body>
</html>