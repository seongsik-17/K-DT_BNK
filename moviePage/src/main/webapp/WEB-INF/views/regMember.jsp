<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>

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

		<input type="password" name="pw" placeholder="비밀번호 입력" 
       pattern="^(?=.*[A-Za-z])(?=.*[^A-Za-z0-9]).{8,}$" 
       title="비밀번호는 8자 이상이며, 영문자와 특수문자를 포함해야 합니다." 
       required>

		<input type="password" name="pwCheck" placeholder="PW를 한번 더 입력해주세요" required>
		<div id="hidPw"></div>

		<input type="text" name="name" placeholder="이름을 입력해주세요" required>
		<input type="text" name="phone" placeholder="전화번호를 입력해주세요" required>

		<input type="submit" value="회원가입">
	</form>
</div>

<script>
let idChecked = false;

function checkId() {
	const hidId = document.getElementById("hidId");
	const id = document.querySelector('input[name="id"]').value;

	const xhr = new XMLHttpRequest();

	xhr.onload = function () {
		hidId.innerHTML = xhr.responseText;

		if (xhr.responseText.includes("사용가능한")) {
			idChecked = true;
		} else {
			idChecked = false;
		}
	};

	xhr.open('GET', 'checkId?id=' + id);
	xhr.send();
}

document.querySelector('form').addEventListener('submit', function (e) {
	const pw = document.querySelector('input[name="pw"]').value;
	const pwCheck = document.querySelector('input[name="pwCheck"]').value;
	const hidPw = document.getElementById("hidPw");
	
	if(idChecked && pw == pwCheck){
		alert("회원가입을 축하합니다 로그인 페이지로 이동합니다...")
	}

	if (!idChecked) {
		e.preventDefault();
		alert("아이디 중복을 확인해주세요!!!");
		document.getElementById("hidId").textContent = "ID 중복 확인을 해주세요.";
		return;
	}

	if (pw !== pwCheck) {
		e.preventDefault();
		hidPw.textContent = "비밀번호가 일치하지 않습니다.";
	}
});

	
</script>
</body>
</html>
