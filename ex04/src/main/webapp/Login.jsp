<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인 page</h1>
	<hr>
	<form action="Logcheck" method="POST">
		ID: <input type="text" name="id"><br>
		PW: <input type="text" name="pw"><br>
		<input type="submit" value="로그인">
	</form>
	<a href="index.jsp">회원가입하러가기</a>
	<a href="onlymembers.jsp">회원전용 페이지</a>
</body>
</html>