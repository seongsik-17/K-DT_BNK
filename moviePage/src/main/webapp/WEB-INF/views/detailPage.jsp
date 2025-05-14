<%@page import="com.example.moviePage.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>    
<%
	MemberDTO member = (MemberDTO)session.getAttribute("member");
	int tf;
	if(member != null){
		tf = 1;
	}else{
		tf = 0;
	}
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detailpage</title>
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
/* 감상평 입력 영역 */
.comment-form {
	margin: 20px 0;
	display: flex;
	flex-direction: column;
	gap: 10px;
}

.comment-form input[type="text"] {
	padding: 10px;
	border: 1px solid #ccc;
	border-radius: 6px;
	font-size: 14px;
	width: 100%;
}

.comment-form input[type="submit"] {
	align-self: flex-end;
	background-color: #28a745;
	color: white;
	padding: 10px 20px;
	border: none;
	border-radius: 6px;
	cursor: pointer;
	transition: background-color 0.3s ease;
}

.comment-form input[type="submit"]:hover {
	background-color: #218838;
}

/* 감상평 테이블 (목록) */
.comment-table {
	width: 100%;
	border-collapse: collapse;
	margin-top: 20px;
	background-color: #ffffff;
	box-shadow: 0 2px 8px rgba(0, 0, 0, 0.05);
}

.comment-table th {
	background-color: #6c757d;
	color: white;
	padding: 10px;
	text-align: center;
}

.comment-table td {
	padding: 12px;
	text-align: center;
	border-bottom: 1px solid #eee;
}

/* 반응형 감상평 테이블 */
@media (max-width: 768px) {
	.comment-table, .comment-table thead, .comment-table tbody, .comment-table th, .comment-table td, .comment-table tr {
		display: block;
	}
	.comment-table thead {
		display: none;
	}
	.comment-table tr {
		background-color: white;
		margin-bottom: 15px;
		border-radius: 8px;
		padding: 10px;
		box-shadow: 0 1px 4px rgba(0,0,0,0.1);
	}
	.comment-table td {
		text-align: left;
		padding: 10px;
		position: relative;
	}
	.comment-table td::before {
		content: attr(data-label);
		display: block;
		font-weight: bold;
		color: #666;
		margin-bottom: 5px;
	}
}

</style>
</head>
<body>
	<h1>상세보기</h1>
	<hr>
	<jsp:include page="./layout/header.jsp"/>
	<table border="1">
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
			<tr>
				<td><img alt="영화포스터" src="./images/posterSample.jpeg"></td>
				<td>${m.title }</td>
				<td>${m.season_start }</td>
				<td>${m.age_limit }</td>
				<td>${m.adment }</td>
				<td>${m.plot }</td>
			</tr>
	</table>
	<hr>
	<h3>감상평</h3>
<form class="comment-form" action="regComent" method="POST" onsubmit="return logcheck()">
	<input type="text" name="coment" placeholder="감상평을 입력해주세요...">
	<input type="hidden" name="id" value="${member.id}">
	<input type="hidden" name="movie_code" value="${m.movie_code}">
	<input type="submit" value="등록">
</form>

<table class="comment-table">
	<thead>
		<tr>
			<th>작성자</th>
			<th>내용</th>
			<th>작성일</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="list" items="${list}" varStatus="status">
			<tr>
				<td data-label="작성자">${list.id}</td>
				<td data-label="내용">${list.coment}</td>
				<td data-label="작성일">${list.regDate}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

	<script>
		function logcheck(){
			const tf = <%=tf %>;
			console.log(tf);
			if(tf == 0){
				alert("로그인이 필요합니다!!");
				location.href="login";
				return false;
			}else{
				return true;
			}
		}
		
		
	</script>
	
</body>
</html>