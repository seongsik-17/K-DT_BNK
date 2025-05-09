<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 조회</title>
</head>
<body>
	<h1>게시판 조회</h1>
	<hr>
	<table border="1" id="tbl">
		<thead>
			<tr>
				<th>BNO</th><th>TITLE</th><th>CONTENT</th><th>WRITER</th><th>DATE</th>
			</tr>
		</thead>
		<tbody id="body">
			<c:forEach var="content" items="${list}" varStatus="status">
			<tr>
				<td><button onclick="detail(${content.bno})">${content.bno}</button></td>
				<td>${content.title}</td>
				<td>${content.content}</td>
				<td>${content.writer}</td>
				<td>${content.regdate}</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<script>
		const tbl = document.getElementById("tbl");
		
		function detail(bno) {
			const xhr = new XMLHttpRequest();
			xhr.onload = function() {
				
				const obj = JSON.parse(xhr.responseText);
				console.log(obj);
				tbl.innerHTML = 
					'<thead>' +
					'<tr>' +
					'<th>BNO</th><th>TITLE</th><th>CONTENT</th><th>WRITER</th><th>DATE</th>' +
					'</tr>' +
					'</thead>' +
					'<tbody>' +
					'<tr>' +
					'<td>' + obj.bno + '</td>' +
					'<td>' + obj.title + '</td>' +
					'<td>' + obj.content + '</td>' +
					'<td>' + obj.writer + '</td>' +
					'<td>' + obj.regdate + '</td>' +
					'</tr>' +
					'</tbody>';
			};
			xhr.open('GET', 'detail?id=' + bno);
			xhr.send();
		}
	</script>
</body>
</html>
