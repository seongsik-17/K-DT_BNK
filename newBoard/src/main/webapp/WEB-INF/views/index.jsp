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
	<h1>INDEX PAGE</h1>
	<table border="1">
		<thead>
			<tr>
				<th>게시번호</th><th>제목</th>
				<th>내용</th><th>작성자</th><th>게시일</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="content" items="${list }" varStatus="status">
			<tr>
				<td>${content.bno }</td><td>${content.title }</td><td>${content.content }</td><td>${content.writer }</td><td>${content.regdate }</td>
			</tr>
			</c:forEach>
		</tbody>
		
	</table>
	<div id="div1">${msg }</div>
	<form action="insertContent" method="post">
		<input type="text" name="title" placeholder="제목">
		<input type="text" name="content" placeholder="내용">
		<input type="text" name="writer" placeholder="작성자">
		<input type="submit" value="등록">
	</form>
	<input type="text" id="serchWord">
	<button onclick="serch()">검색</button>
	<script>
	function serch(){
		const serch = 
	}
	const msg = document.getElementById("div1").value;
		if(msg != null){
			alert="등록실패!";
		}
	</script>
</body>
</html>