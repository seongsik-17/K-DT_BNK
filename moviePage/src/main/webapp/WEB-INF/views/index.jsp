<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
/* 기본 설정 */
* {
	box-sizing: border-box;
	margin: 0;
	padding: 0;
}

body {
	font-family: 'Noto Sans KR', sans-serif;
	background-color: #f7f9fb;
	color: #333;
	padding: 40px;
}

/* 헤더 전체 스타일 */
header {
	background-color: #343a40;
	padding: 15px 30px;
}

/* 네비게이션 바 스타일 */
header ul {
	list-style: none;
	display: flex;
	justify-content: flex-start;
	align-items: center;
	gap: 20px;
	padding: 0;
	margin: 0;
}

/* 메뉴 항목 (li > a) */
header ul li a {
	color: #ffffff;
	text-decoration: none;
	font-weight: bold;
	padding: 8px 14px;
	border-radius: 4px;
	display: flex;
	align-items: center;
	transition: background-color 0.3s ease;
}

/* 메뉴 hover 효과 */
header ul li a:hover {
	background-color: rgba(255, 255, 255, 0.2);
}

/* 메뉴 안의 이미지 (예: 스패너) */
header ul li img {
	width: 16px;
	height: 16px;
	margin-right: 8px;
	object-fit: contain;
	filter: invert(1); /* 흰색 배경에서도 잘 보이도록 */
}

/* 반응형: 화면이 작을 때 메뉴 세로 정렬 */
@media (max-width: 768px) {
	header ul {
		flex-direction: column;
		align-items: flex-start;
	}
}


/* 메뉴 버튼들 */
.menu {
	display: flex;
	gap: 20px;
	flex-wrap: wrap;
}

.menu a {
	color: #ffffff;
	text-decoration: none;
	font-weight: bold;
	padding: 6px 12px;
	border-radius: 4px;
	transition: background-color 0.3s;
}

.menu a:hover {
	background-color: rgba(255, 255, 255, 0.2);
}

/* 로그인 / 회원가입 링크 */
#head a {
	color: #ffffff;
	text-decoration: none;
	margin-left: 15px;
	font-weight: bold;
}

#head a:hover {
	text-decoration: underline;
}

/* 제목 */
h1 {
	text-align: center;
	margin-bottom: 20px;
}

/* 테이블 스타일 */
table {
	width: 100%;
	border-collapse: collapse;
	background-color: #ffffff;
	box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
}

thead {
	background-color: #007bff;
	color: white;
}

th, td {
	padding: 12px 15px;
	text-align: center;
	border-bottom: 1px solid #ddd;
}

tr:hover {
	background-color: #f1f1f1;
}

/* 포스터 이미지 */
img {
	width: 80px;
	height: 120px;
	object-fit: cover;
	border-radius: 4px;
}

/* 반응형 디자인 */
@media ( max-width : 768px) {
	table, thead, tbody, th, td, tr {
		display: block;
	}
	thead {
		display: none;
	}
	tr {
		margin-bottom: 15px;
		background-color: white;
		padding: 10px;
		border-radius: 8px;
		box-shadow: 0 1px 4px rgba(0, 0, 0, 0.1);
	}
	td {
		padding: 10px;
		text-align: left;
		border: none;
		position: relative;
	}
	td::before {
		content: attr(data-label);
		font-weight: bold;
		display: block;
		margin-bottom: 5px;
	}
	img {
		width: 100%;
		height: auto;
	}
}
</style>

</head>
<body>
	<h1>Index Page</h1>
	<jsp:include page="./layout/header.jsp"/>
	<hr>
	<table>
		<thead>
			<tr>
				<th>포스터
				<th>제목</th>
				<th>개봉일</th>
				<th>연령제한</th>
				<th>한줄평</th>
				<th>줄거리</th>
			</tr>

		</thead>
		<c:forEach var="item" items="${list }" varStatus="status">
			<tr>
				<td><img alt="영화포스터" src="./images/posterSample.jpeg"></td>
				<td><a href="/detail?movie_code=${item.movie_code}">${item.title }</a></td>
				<td>${item.season_start }</td>
				<td>${item.age_limit }</td>
				<td>${item.adment }</td>
				<td>${item.plot }</td>
			</tr>
		</c:forEach>
	</table>
	<div id="admin"></div>
	<script>
	window.onload = function () {
		const adminBtn = document.getElementById("admin");
		<%-- JSTL 또는 스크립틀릿으로 member 객체의 id 비교 --%>
		<c:if test="${member.id eq 'admin'}">
			alert("관리자 로그인!!");
			adminBtn.innerHTML = '<button onclick="admin()">영화추가</button>';
		</c:if>
	}

	function admin() {
		window.location.href = "/insertMovie"; // 영화 추가 페이지로 이동
	}
</script>

</body>
</html>