<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    
    String stu_no = request.getParameter("stu_no");
     String url = "jdbc:oracle:thin:@localhost:1521:testdb";
   String user = "green";
   String password = "1234";
   
   Class.forName("oracle.jdbc.driver.OracleDriver");
   Connection conn = DriverManager.getConnection(url, user, password);
   
   String query = "SELECT * FROM student1 WHERE stu_no = ?";
   
   PreparedStatement pstmt = conn.prepareStatement(query);
   ResultSet rs = pstmt.executeQuery();
   pstmt.setString(1, stu_no);
   System.out.println(stu_no);
   if(rs.next()){
	   
   }
   
   %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>B page</h1>
<hr>
<table>
	<thead>
	<tr><td>학번</td><td>이름</td><td>학과</td><td>학년</td>
	<td>반</td><td>성별</td><td>키</td><td>몸무게</td>
	</tr>
	</thead>
	<tbody>
	<%while(rs.next()) {%>
	<tr>
	<td><%=rs.getString("stu_no") %></td>
	<td><%=rs.getString("stu_name") %></td>
	<td><%=rs.getString("stu_dept") %></td>
	<td><%=rs.getInt("stu_grade") %></td>
	<td><%=rs.getString("stu_class") %></td>
	<td><%=rs.getString("stu_gender") %></td>
	<td><%=rs.getInt("stu_height") %></td>
	<td><%=rs.getInt("stu_weight") %></td>
	</tr>
	<%} %>
	</tbody>

</table>
<a href = "index.jsp">index 페이지로 가기</a>

</body>
</html>