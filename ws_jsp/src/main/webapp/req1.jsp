
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    
    String param1 = request.getParameter("username");
    String param2 = request.getParameter("age");
    String[] hobbies = request.getParameterValues("hobbies");
    System.out.println(hobbies[0]);
    System.out.println(hobbies[1]);
    String pagecolor = request.getParameter("pagecolor");
   
    
    
   
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	body{ background-color:<%=pagecolor%>;
	}


</style>
</head>
<body>

<h1>REQ1 Page</h1>
<hr>
username = <%=param1%><br>
age = <%=param2 %><br>
hobby1 = <%=hobbies[0] %><br>
hobby2 = <%=hobbies[1] %><br>
background-color = <%=pagecolor%><br>

</body>
</html>