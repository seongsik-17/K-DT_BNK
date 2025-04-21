<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
   String url = "jdbc:oracle:thin:@localhost:1521:testdb";
   String user = "green";
   String password = "1234";
   
   Class.forName("oracle.jdbc.driver.OracleDriver");
   Connection conn = DriverManager.getConnection(url, user, password);
   
   String query = "SELECT * FROM student1";
   
   PreparedStatement pstmt = conn.prepareStatement(query);
   ResultSet rs = pstmt.executeQuery();
   
  
  
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table  border = "1">
<thead>
<tr>
<th>stu_no</th><th>stu_name</th>
</tr>
</thead>
<tbody>
<%while(rs.next()){ %>
	<tr>
		<td><%=rs.getString("stu_no") %></td><td><a href=b.jsp?stu_no=<%=rs.getString("stu_no")%>><%=rs.getString("stu_name") %></a></td>
	</tr>
<%} %>
</tbody>

</body>
</html>