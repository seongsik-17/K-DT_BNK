<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Index Page</h1>
<hr>
<ul>
	<li><a href="regForm.jsp">게시글 작성하기</a></li>
	<li><a href="boardList.jsp">게시글 조회하기</a></li>
	<li><a href="test">test</a></li>
	<li><a href="test4">test4</a></li>
</ul>	
	<hr>
	<h1>GET방식</h1>
	<form action="test1" method ="GET">
		<input type="text" name="name" value="aaa">
		<input type="submit" value="전송">
	</form>
	<hr>
	<h1>POST방식</h1>
	<form action="test2" method ="POST">
		<input type="text" name="name" value="aaa">
		<input type="submit" value="전송">
	</form>

</body>
</html>