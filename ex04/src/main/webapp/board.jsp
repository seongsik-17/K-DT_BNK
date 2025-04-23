<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="VO.Board"%>
<%@page import="service.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	BoardDao dao = new BoardDao();
	Board b = new Board();
	List<Board> list = new ArrayList<>();
	list = dao.select();
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>전체게시판</h1>
	<hr>
	<table border = "1">
		<thead>
			<tr>
				<td>번호</td> <td>제목</td>
				<td>내용</td> <td>작성자</td>
				<td>작성일자</td>
			</tr>
		</thead>
		<tbody>
			<%for(Board b1: list){ %>
			<tr>
				<td><%=b1.getBno() %></td><td><%=b1.getTitle() %></td>
				<td><%=b1.getContent() %></td><td><%=b1.getWriter() %>></td>
				<td><%=b1.getRegdate() %></td>
			</tr>
			<%} %>
		</tbody>
	</table>
	<a href="onlymembers.jsp">회원전용페이지로 돌아가기</a>

</body>
</html>