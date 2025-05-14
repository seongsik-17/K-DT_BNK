<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% response.sendRedirect("studentlist.jsp"); %>
    <%
    String url = "jdbc:oracle:thin:@localhost:1521:testdb";
    String user = "green";
    String password = "1234";
    
    Class.forName("oracle.jdbc.driver.OracleDriver");
    Connection conn = DriverManager.getConnection(url, user, password);
   
    String query = "INSERT INTO student1 VALUES(?,?,?,?,?,?,?,?)";
    PreparedStatement pstmt = conn.prepareStatement(query);
    pstmt.setString(1, request.getParameter("stu_no"));
    pstmt.setString(2,request.getParameter("stu_name"));
    pstmt.setString(3,request.getParameter("stu_dept"));
    pstmt.setInt(4,Integer.parseInt(request.getParameter("stu_grade")));
    pstmt.setString(5, request.getParameter("stu_class"));
    pstmt.setString(6,request.getParameter("stu_gender"));
    pstmt.setInt(7,Integer.parseInt(request.getParameter("stu_height")));
    pstmt.setInt(8,Integer.parseInt(request.getParameter("stu_weight")));
   
    
    int result = pstmt.executeUpdate();
    
   
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>A page</h1>
<hr>
A.jsp 페이지 입니다.<br><br>
<a href = "b.jsp">b페이지로 가기</a>
</body>
</html>