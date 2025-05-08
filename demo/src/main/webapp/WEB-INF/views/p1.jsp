<%@page import="com.example.demo.dto.Member"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<Member> m = (List<Member>)request.getAttribute("list");
%>    
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>p1페이지 입니다...</h1>
	<ul>
		<%for(Member m1 : m){ %>
		<li>name: ${m1.name }</li>
		<li>id: ${m1.id }</li>
		<li>pw: ${m1.pw }</li>
		<%} %>
	</ul>
	${Member }
	<script>
		
		
	</script>
</body>

</html>