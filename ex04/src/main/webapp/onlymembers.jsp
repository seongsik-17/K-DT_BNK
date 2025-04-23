<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	if(session.getAttribute("id")==null){
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
	<h1>회원전용 페이지</h1>
	<h3><%=session.getAttribute("name") %>님 환영합니다...</h3>
	<a href="board.jsp">게시판 조회</a>
	<a href="WriteBoard.jsp">게시판 글쓰기</a>
	<form action="logout" method="POST">
		<input type="submit" value="로그아웃">
	</form>

</body>
</html>