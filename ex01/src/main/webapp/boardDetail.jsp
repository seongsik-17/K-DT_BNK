<%@page import="java.sql.ResultSet"%>
<%@page import="com.sun.net.httpserver.Authenticator.Result"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	//1.파라미터 받기
	String bno = request.getParameter("bno");
	//2.DB접속하기
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:testdb","green","1234");
	//3.쿼리 싨행하기
	String query = " SELECT * FROM tbl_board WHERE bno = ?";
	PreparedStatement pstmt = conn.prepareStatement(query);
	pstmt.setString(1, bno);
	ResultSet rs = pstmt.executeQuery();
	rs.next();
	
	
	
	
	
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Board Detail Page</h1>
	<hr>
	<ul>
		<li><%=rs.getString("bno")%></li>
		<li><%=rs.getString("title")%></li>
		<li><%=rs.getString("writer") %></li>
		<li><%=rs.getString("regdate") %></li>
	</ul>
</body>
</html>