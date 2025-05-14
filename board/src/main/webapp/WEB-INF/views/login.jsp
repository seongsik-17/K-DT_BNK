<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인</h1>
	<hr>
	<form action="/login" method="POST">
		<input type="text" name="id" placeholder="아이디" required><br>
		<input type="text" name="pw" placeholder="비밀번호" required><br>
		<input type="submit" value="로그인">
		<input type="button" onclick="regist_m()" value="회원가입">
	</form>
	<div id="checklog">-----</div>
	
	<script>
		function regist_m(){
			alert("회원가입!");
			location.href="/regist_m";
		}
		
		
		
		
		
	</script>
</body>
</html>