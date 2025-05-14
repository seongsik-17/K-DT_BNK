<%@page import="com.example.moviePage.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<%
MemberDTO member = (MemberDTO) session.getAttribute("member");

int tf;
if (member != null) {
	tf = 1;
} else {
	tf = 0;
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detailpage</title>

</head>
<body>
	<h1>상세보기</h1>
	<hr>
	<jsp:include page="./layout/header.jsp" />
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
	<button class="reserve-button">예매하기</button>

	<hr>
	<h3>감상평</h3>
	<form class="comment-form" action="regComent" method="POST"
		onsubmit="return logcheck()">
		<input type="text" name="coment" placeholder="감상평을 입력해주세요...">
		<input type="hidden" name="id" value="${member.id}"> <input
			type="hidden" name="movie_code" value="${m.movie_code}"> <input
			type="submit" value="등록">
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
					<td data-label="관리"><c:if
							test="${member != null && member.id == list.id}">
							<button onclick="remove(${list.comentId},${m.movie_code })">삭제하기</button>
						</c:if></td>
				</tr>
			</c:forEach>

		</tbody>
	</table>

	<script>
		function logcheck(){
			const tf = <%=tf%>;
			console.log(tf);
			if(tf == 0){
				alert("로그인이 필요합니다!!");
				location.href="login";
				return false;
			}else{
				return true;
			}
		}
		
		function remove(comentid,movie_code){
			if(confirm("정말 삭제하시겠습니까?")){
				location.href = "/rmComent/" + comentid+"/"+movie_code;
			}
		}

		
		
	</script>

</body>
</html>