<%@page import="vo.OrderStatus"%>
<%@page import="java.util.List"%>
<%@page import="vo.OrderDao"%>
<%@page import="vo.Order"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	OrderDao dao = new OrderDao();
	List<OrderStatus>list = dao.selectorderlist();
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
					<td>할인점코드</td><td>제품코드</td>
					<td>제품명</td><td>주문총수량</td>
				</tr>
			</thead>
			<tbody>
			<%for(OrderStatus od:list){ %>
				<tr>
					<td><%=od.getShopno() %></td><td><%=od.getPcode() %></td>
					<td><%=od.getPname() %></td><td><%=od.getTotalorder() %></td>
				</tr>
				<%} %>
			</tbody>
		</table>
	</section>
</body>
</html>