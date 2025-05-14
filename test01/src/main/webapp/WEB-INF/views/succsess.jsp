<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	이름: ${user.name }
	나이: ${user.age }
	
	<button onclick="f()">실행</button>
	<div id="demo">-----</div>
	
	<script>
	const demo1 = document.getElementById("demo");
		function f(){
			const xhr = new XMLHttpRequest();
			xhr.onload = function(){
				demo.innerHTML = xhr.responseText;//여기도 잘 까먹는 부분 xhr
			}
			xhr.open('GET','getdata?n=1');
			xhr.send();
			
		}
	</script>
</body>
</html>