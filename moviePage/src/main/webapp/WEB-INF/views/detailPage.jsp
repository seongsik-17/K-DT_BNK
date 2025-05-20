<%@page import="com.example.moviePage.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<%
MemberDTO member = (MemberDTO) session.getAttribute("member");
int tf = (member != null) ? 1 : 0;
%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title>영화 상세보기</title>
	<link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;600&display=swap" rel="stylesheet">
	<style>
		body {
			font-family: 'Inter', sans-serif;
			margin: 0;
			padding: 0;
			background-color: #f4f6f8;
			color: #333;
		}
		.container {
			width: 90%;
			max-width: 1200px;
			margin: 30px auto;
			background-color: #fff;
			padding: 30px;
			border-radius: 12px;
			box-shadow: 0 8px 24px rgba(0, 0, 0, 0.1);
		}
		h1 {
			text-align: center;
			font-size: 32px;
			color: #007bff;
		}
		.movie-box {
			display: flex;
			flex-wrap: wrap;
			gap: 20px;
			margin-top: 30px;
		}
		.movie-box img {
			width: 300px;
			border-radius: 10px;
		}
		.movie-info {
			flex: 1;
		}
		.movie-info h2 {
			font-size: 26px;
			color: #222;
		}
		.movie-info p {
			font-size: 16px;
			margin: 10px 0;
			line-height: 1.6;
		}
		.reserve-button {
			background-color: #28a745;
			color: white;
			border: none;
			padding: 12px 24px;
			font-size: 16px;
			border-radius: 6px;
			cursor: pointer;
			margin-top: 15px;
		}
		.reserve-button:hover {
			background-color: #218838;
		}
		.comment-section {
			margin-top: 50px;
		}
		.comment-section h3 {
			font-size: 22px;
			margin-bottom: 15px;
		}
		form.comment-form {
			display: flex;
			flex-direction: column;
			gap: 10px;
		}
		form.comment-form input[type="text"] {
			padding: 10px;
			font-size: 16px;
			border: 1px solid #ccc;
			border-radius: 6px;
		}
		form.comment-form input[type="submit"] {
			background-color: #007bff;
			color: white;
			padding: 10px 20px;
			border: none;
			font-size: 16px;
			border-radius: 6px;
			cursor: pointer;
			width: 100px;
		}
		form.comment-form input[type="submit"]:hover {
			background-color: #0056b3;
		}
		table.comment-table {
			width: 100%;
			border-collapse: collapse;
			margin-top: 20px;
			background-color: #fdfdfd;
		}
		.comment-table th, .comment-table td {
			padding: 12px;
			text-align: center;
			border-bottom: 1px solid #ddd;
		}
		.comment-table th {
			background-color: #e9ecef;
			color: #333;
		}
		button.delete-btn {
			background-color: #dc3545;
			color: white;
			border: none;
			padding: 6px 12px;
			border-radius: 4px;
			cursor: pointer;
		}
		button.delete-btn:hover {
			background-color: #c82333;
		}
		@media (max-width: 768px) {
			.movie-box {
				flex-direction: column;
				align-items: center;
			}
			.movie-box img {
				width: 100%;
			}
		}
	</style>
</head>
<body>
	<div class="container">
		<h1>🎬 상세보기</h1>
		<jsp:include page="./layout/header.jsp" />

		<div class="movie-box">
			<img src="./images/posterSample.jpeg" alt="영화 포스터" />
			<div class="movie-info">
				<h2>${m.title}</h2>
				<p><strong>개봉일:</strong> ${m.season_start}</p>
				<p><strong>연령제한:</strong> ${m.age_limit}</p>
				<p><strong>한줄평:</strong> ${m.adment}</p>
				<p><strong>줄거리:</strong><br>${m.plot}</p>
				<c:if test="${m.status == 1}">
					<button class="reserve-button">예매하기</button>
				</c:if>
			</div>
		</div>

		<div class="comment-section">
			<c:if test="${m.status == 0}">
				<h3>🎥 감상평</h3>
			</c:if>
			<c:if test="${m.status == 2}">
				<h3>📣 응원멘트</h3>
			</c:if>

			<c:if test="${m.status == 0 || m.status == 2}">
				<form class="comment-form" action="regComent" method="POST" onsubmit="return logcheck()">
					<input type="text" name="coment" placeholder="내용을 입력해주세요...">
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
							<th>관리</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="list" items="${list}">
							<tr>
								<td>${list.id}</td>
								<td>${list.coment}</td>
								<td>${list.regDate}</td>
								<td>
									<c:if test="${member != null && member.id == list.id}">
										<button class="delete-btn" onclick="remove(${list.comentId}, ${m.movie_code})">삭제</button>
									</c:if>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:if>
		</div>
	</div>

	<script>
		function logcheck() {
			const tf = <%=tf%>;
			if (tf === 0) {
				alert("로그인이 필요합니다!");
				location.href = "login";
				return false;
			}
			return true;
		}
		function remove(comentId, movieCode) {
			if (confirm("정말 삭제하시겠습니까?")) {
				location.href = `/rmComent/\${comentId}/\${movieCode}`;
			}
		}
	</script>
</body>
</html>
