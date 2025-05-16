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
	<a href="p1?name=james&age=11">p1으로 가기</a><!-- GET방식으로 요청 -->
	<a href="p2/suji/33">p2로 가기</a>
	<form action="reg" method="GET">
		<input type="text" name="name">
		<input type="text" name="age">
		<input type="submit" value="등록">
	</form>
	<div id="demo">----</div><br>
	<button onclick="f()">실행</button>
	
	<script>
	const demo1 = document.getElementById("demo");
		function f(){
			const xhr = new XMLHttpRequest();
			xhr.onload = function(){
				var obj = JSON.parse(xhr.responseText);
				demo.innerHTML = "이름: "+obj.name+" 나이: "+obj.age;//여기도 잘 까먹는 부분 xhr
			}
			xhr.open('GET','getdata2?n=1');
			xhr.send();
			
		}
	</script>
</body>
</html>