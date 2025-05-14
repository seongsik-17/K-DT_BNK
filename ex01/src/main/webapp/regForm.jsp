<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>RegisdtForm</h1>
	<hr>
	<form action="registProc.jsp" method ="GET">
		책 제목: <input type = "text" name = "title"><br>
		내용: <input type = "text" name = "content"><br>
		저자: <input type = "text" name = "writer"><br>
		<input type="submit" value="전송">
	</form>

</body>
</html>