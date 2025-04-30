<%@page import="vo.PcodeSelect"%>
<%@page import="java.util.List"%>
<%@page import="vo.OrderDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>      
    
<%
	OrderDao dao = new OrderDao();
	List<PcodeSelect> list = dao.pcodeselect();
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<header>
		<h1>할인점 주문프로그램 ver 1.0</h1>
	</header>
	<nav>
		<table>
			<tr>
			<td><a href="regestOrder.jsp">주문등록</a></td>
				<td><a href="orderList.jsp">주문목록조회</a></td>
				<td><a href="orderStatus.jsp">점포별주문현황</a></td>
				<td><a href="pcodeSelect.jsp">제품코드조회</a></td>
				<td><a href="index.jsp">홈으로</a></td>
			</tr>
		</table>
	</nav>
	<section>
		<table border="1">
			<thead>
				<tr>
					<td>제품코드</td><td>제품명</td>
					<td>단가</td><td>할인률(10%)</td>
					<td>할인률(15%)</td>
				</tr>
			</thead>
			<tbody>
			<% for (PcodeSelect p: list){%>
				<tr>
					<td><%=p.getPcode() %></td><td><%=p.getPname() %></td>
					<td><fmt:formatNumber value="<%=p.getCost() %>" pattern="#,###"/></td><td><fmt:formatNumber value="<%=p.getTen() %>" pattern="#,###"/></td>
					<td><fmt:formatNumber value="<%=p.getFiftin() %>" pattern="#,###"/></td>
				</tr>
			<%} %>	
			</tbody>
		</table>
	</section>
</body>
</html>