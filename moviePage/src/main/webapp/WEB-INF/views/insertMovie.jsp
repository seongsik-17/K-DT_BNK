<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>관리자용 페이지</h1>
	<form action="insertMovie" method="POST">
		<input type="text" name="title" placeholder="제목">
		<input type="date" name="season_start" placeholder="개봉일">
		<input type="date" name="season_end" placeholder="종료일">
		<input type="text" name="age_limit" placeholder="연령제한">
		<input type="text" name="adment" placeholder="제작사">
		<input type="text" name="ploat" placeholder="줄거리">
		<input type="text" name="status" placeholder="상태">
		<input type="submit" value="적용">
	</form>
</body>
</html>