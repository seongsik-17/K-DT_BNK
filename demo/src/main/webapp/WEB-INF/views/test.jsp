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
	<a href="p1?name=james&age=23">p1페이지로 가기</a>
	<!-- 아이디 패스워드 이름 -->
	<form action="p1" method="POST">
		ID: <input type="text" name="id">
		PW: <input type="password" name="pw">
		name: <input type="text" name="name">
		<input type="submit" value="등록">
		
		
	</form>
	
	<hr>
	<!-- 아이디 패스워드 이름 -->
	<form action="p2" method="POST">
		ID: <input type="text" name="id">
		PW: <input type="password" name="pw">
		name: <input type="text" name="name">
		<input type="submit" value="등록">
	</form>
	
	<hr>
	<!-- 아이디 패스워드 이름 -->
	<form action="p3" method="GET">
		ID: <input type="text" name="id">
		PW: <input type="password" name="pw">
		<input type="submit" value="등록">
	</form>
	<hr>
	<a href="p3/aaa/1234">PathVariable로 파라미터 처리하기</a>
</body>
</html>