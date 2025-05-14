<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<style>
	body {
		font-family: 'Noto Sans KR', sans-serif;
		background-color: #f2f4f6;
		display: flex;
		justify-content: center;
		align-items: center;
		height: 100vh;
		margin: 0;
	}
	.container {
		background-color: #fff;
		padding: 40px 50px;
		border-radius: 12px;
		box-shadow: 0 10px 20px rgba(0,0,0,0.1);
		width: 400px;
	}
	h1 {
		text-align: center;
		color: #333;
		margin-bottom: 20px;
	}
	form {
		display: flex;
		flex-direction: column;
	}
	input[type="text"],
	input[type="password"] {
		padding: 12px;
		margin-bottom: 10px;
		border: 1px solid #ccc;
		border-radius: 6px;
		font-size: 14px;
	}
	input[type="submit"],
	button {
		padding: 12px;
		background-color: #007bff;
		color: white;
		border: none;
		border-radius: 6px;
		cursor: pointer;
		font-size: 15px;
		transition: background-color 0.3s ease;
	}
	button {
		margin-left: 10px;
	}
	input[type="submit"]:hover,
	button:hover {
		background-color: #0056b3;
	}
	#hidId, #hidPw {
		font-size: 13px;
		color: #d9534f;
		margin-bottom: 10px;
	}
	.id-check-wrapper {
		display: flex;
		align-items: center;
	}
</style>
</head>
<body>
<div class="container">
	<h1>회원가입</h1>
	<hr>
	<form action="insertMember" method="POST">
		<div class="id-check-wrapper">
			<input type="text" name="id" id="id" placeholder="사용할 ID를 입력해주세요" required>
			<button type="button" onclick="checkId()">중복확인</button>
		</div>
		<div id="hidId">ID 중복을 확인해주세요.</div>

		<input type="password" minlength="8" name="pw" placeholder="사용할 PW를 입력해주세요" required>
		<input type="password" name="pwCheck" placeholder="PW를 한번 더 입력해주세요" required>
		<div id="hidPw"></div>

		<input type="text" name="name" placeholder="이름을 입력해주세요" required>
		<input type="text" name="phone" placeholder="전화번호를 입력해주세요" required>

		<input type="submit" value="회원가입">
	</form>
</div>

<script>
	function checkId() {
		const hidId = document.getElementById("hidId");
		const id = document.querySelector('input[name="id"]').value;

		const xhr = new XMLHttpRequest();

		xhr.onload = function() {
			hidId.innerHTML = xhr.responseText;
		};

		xhr.open('GET', 'checkId?id=' + id);
		xhr.send();
	}
	document.querySelector('form').addEventListener('submit', function (e) {
		const pw = document.querySelector('input[name="pw"]').value;
		const pwCheck = document.querySelector('input[name="pwCheck"]').value;
		const hidPw = document.getElementById("hidPw");

		if (pw !== pwCheck) {
			e.preventDefault(); // 제출 막기
			hidPw.textContent = "비밀번호가 일치하지 않습니다.";
		}
	});

</script>
</body>
</html>
