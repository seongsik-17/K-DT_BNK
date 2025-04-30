<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name = (String)request.getAttribute("name");
	
	
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인 성공!</h1>
	<h3><%=session.getAttribute("name") %>님 환영합니다!</h3>
	
	<a href="onlymembers.jsp">회원전용 페이지로 이동하기</a>
	
</body>
</html>