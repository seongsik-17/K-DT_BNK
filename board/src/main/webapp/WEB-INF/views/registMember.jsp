<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원가입</h1>
	<hr>
	<form action="/insert" method="POST">
		<input type="text" name="id" placeholder="사용할 ID" required><br>
		<input type="text" name="pw" placeholder="사용할 PW" required><br>
		<input type="text" name="name" placeholder="이름" required><br>
		<input type="text" name="phone" placeholder="전화번호" required><br>
		<input type="text" name="grade" placeholder="등급" required><br>
		<input type="submit" value="회원가입">
	</form>
</body>
</html>