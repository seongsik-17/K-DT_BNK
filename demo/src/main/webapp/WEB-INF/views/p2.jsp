<%@page import="com.example.demo.dto.Member"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%List<Member> list = (List<Member>)request.getAttribute("list"); %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>p2 Page</h1>
		<ul>
		<%for(Member m1 : list){ %>
		<li>name: <%=m1.getName() %></li>
		<li>id: <%=m1.getId() %></li>
		<li>pw: <%=m1.getPw() %></li>
		<%} %>
	</ul>
</body>
</html>