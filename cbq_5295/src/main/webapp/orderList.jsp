<%@page import="vo.OrderList"%>
<%@page import="java.util.List"%>
<%@page import="vo.OrderDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>    
<%
	OrderDao od = new OrderDao();
	List<OrderList> list = od.selectlist();

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
					<td>할인점코드</td><td>점포명</td><td>주문번호</td><td>주문일자</td><td>제품코드</td>
					<td>제품명</td><td>주문수량</td><td>단가</td><td>소비자가격</td><td>할인가격</td>
				</tr>
			</thead>
			<tbody>
			
			<%for(OrderList ol: list){ %>
				<tr>
					<td><%=ol.getShopno() %></td><td><%=ol.getShopname() %></td><td><%=ol.getOrderno() %></td><td><%=ol.getOrderdate() %></td><td><%=ol.getPcode() %></td>
					<td><%=ol.getPname() %></td><td><%=ol.getAmount() %></td>
					<td><fmt:formatNumber value="<%=ol.getCost() %>" pattern="#,###"/></td>
					<td><fmt:formatNumber value="<%=ol.getMsrp() %>" pattern="#,###"/></td>
					<td><fmt:formatNumber value="<%=ol.getDismsrp() %>" pattern="#,###"/></td>
				</tr>
				<%} %>
			</tbody>
		</table>
	</section>

</body>
</html>