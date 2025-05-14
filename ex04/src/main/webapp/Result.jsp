<%@page import="VO.Member"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="service.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = (String)request.getAttribute("id");
	String pw = (String)request.getAttribute("pw");
	String name = (String)request.getAttribute("name");
	String grade = (String)request.getAttribute("grade");

	
	
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원가입 성공!</h1>
	<table border ="1">
		<thead>
			<tr>
				<td>아이디</td>
				<td>비밀번호</td>
				<td>이름</td>
				<td>등급</td>
			</tr>
		</thead>
		<tbody>
			
			<tr>
				<td><%=id %></td>
				<td><%=pw %></td>
				<td><%=name %></td>
				<td><%=grade %></td>
			</tr>
			
		</tbody>
	</table>
	<a href="Login.jsp">로그인</a>
</body>
</html>