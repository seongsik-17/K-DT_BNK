<%@page import="com.example.moviePage.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<%
MemberDTO member = (MemberDTO) session.getAttribute("member");
System.out.println("index 세션 저장정보: " + member);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화 메인 페이지</title>
<style>
/* 전체 레이아웃 */
body {
	background-color: #f2f4f6;
	font-family: 'Noto Sans KR', sans-serif;
	margin: 0;
	padding: 20px;
}

/* 제목 */
h1 {
	text-align: center;
	color: #2c3e50;
	margin-bottom: 20px;
}

/* 구분선 */
hr {
	margin: 20px 0;
	border: none;
	height: 1px;
	background-color: #ccc;
}

/* 공통 테이블 스타일 */
table {
	width: 100%;
	border-collapse: collapse;
	margin-bottom: 40px;
	background-color: #fff;
	box-shadow: 0 2px 6px rgba(0, 0, 0, 0.05);
	border-radius: 8px;
	overflow: hidden;
}

thead {
	background-color: #007bff;
	color: white;
}

th, td {
	padding: 12px 16px;
	text-align: center;
	border-bottom: 1px solid #ddd;
}

td img {
	width: 80px;
	height: 120px;
	object-fit: cover;
	border-radius: 4px;
}

a {
	color: #007bff;
	text-decoration: none;
	font-weight: bold;
}

a:hover {
	text-decoration: underline;
}

/* 관리자 버튼 */
#admin {
	text-align: center;
	margin-top: 30px;
}

#admin button {
	padding: 12px 20px;
	font-size: 16px;
	background-color: #28a745;
	color: white;
	border: none;
	border-radius: 8px;
	cursor: pointer;
	box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
	transition: background-color 0.3s ease;
}

#admin button:hover {
	background-color: #218838;
}

/* 반응형 테이블 - 모바일 대응 */
@media ( max-width : 768px) {
	table, thead, tbody, th, td, tr {
		display: block;
	}
	thead {
		display: none;
	}
	tr {
		margin-bottom: 20px;
		background: #fff;
		border-radius: 8px;
		padding: 12px;
		box-shadow: 0 1px 6px rgba(0, 0, 0, 0.05);
	}
	td {
		text-align: left;
		padding-left: 50%;
		position: relative;
		border: none;
	}
	td::before {
		content: attr(data-label);
		position: absolute;
		left: 16px;
		top: 12px;
		font-weight: bold;
		color: #333;
	}
	td img {
		width: 100%;
		height: auto;
	}
}
</style>
</head>
<body>
	<h1>IndexPage</h1>

	<jsp:include page="./layout/header.jsp" />
	<hr>
	<h3>📢 공지사항</h3>
	<table>
		<thead>
			<tr>
				<th>번호</th>
				<th>내용</th>
				<th>작성일자</th>
				<th>작성자</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="nt" items="${notice}" varStatus="status">
				<tr>
					<td data-label="번호">${nt.n_id}</td>
					<td data-label="내용">${nt.n_content}</td>
					<td data-label="작성일자">${nt.n_regdate}</td>
					<td data-label="작성자">${nt.n_writer}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<h3>상영중인 영화</h3>
	<table>
		<thead>
			<tr>
				<th>포스터</th>
				<th>제목</th>
				<th>개봉일</th>
				<th>연령제한</th>
				<th>한줄평</th>
				<th>줄거리</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${list}" varStatus="status">
				<tr>
					<td data-label="포스터"><img alt="영화포스터"
						src="./images/posterSample.jpeg"></td>
					<td data-label="제목"><a
						href="/detail?movie_code=${item.movie_code}">${item.title}</a></td>
					<td data-label="개봉일">${item.season_start}</td>
					<td data-label="연령제한">${item.age_limit}</td>
					<td data-label="한줄평">${item.adment}</td>
					<td data-label="줄거리">${item.plot}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<!-- 관리자만 보이는 버튼 -->
	<div id="admin"></div>

	<script>
		window.onload = function () {
			const adminBtn = document.getElementById("admin");
			<c:if test="${member != null && member.id eq 'admin'}">
				
				adminBtn.innerHTML = '<button onclick="admin()">🎬 영화 추가</button>';
			</c:if>
		};

		function admin() {
			window.location.href = "/insertMovie";
		}
	</script>
</body>
</html>
