<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>종료된 영화</h1>
	<jsp:include page="./layout/header.jsp"/>
	<table>
		<thead>
			<tr>
				<th>포스터
				<th>제목</th>
				<th>개봉일</th>
				<th>종료일</th>
				<th>연령제한</th>
				<th>제작사</th>
				<th>줄거리</th>
			</tr>

		</thead>
		<c:forEach var="item" items="${list }" varStatus="status">
			<tr>
				<td><img alt="영화포스터" src="./images/posterSample.jpeg"></td>
				<td><a href="/detail?movie_code=${item.movie_code}">${item.title }</a></td>
				<td>${item.season_start }</td>
				<td>${item.season_end }</td>
				<td>${item.age_limit }</td>
				<td>${item.adment }</td>
				<td>${item.plot }</td>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>