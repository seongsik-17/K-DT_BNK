<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원 가입</h1>
	<hr>
	<form action="rege" method="POST">
		<input type="text" name="id">id<br>
		<input type="text" name="pw">pw<br>
		<input type="text" name="name">name<br>
		<input type="submit" value="제출">
	</form>
	<hr>
	<a href="storege.jsp?y=yyy">회원전용 페이지로 이동</a>
	<a href="#">게시판 조회</a>
</body>
</html>