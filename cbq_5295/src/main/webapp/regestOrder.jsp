<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>OrderSystem</title>
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
		<h3>주문등록</h3>
		<form action="orderin" method="post">
		<table border="1">
			<tr>
				<td>주문번호</td><td><input type="text" name="orderno" required></td>
			</tr>
			<tr>	
				<td>주문점포</td>
				<td><label for="shopno"></label>
						<select id="shoipno" name="shopno">
								<option value="">점포선택</option>
								<option value="S001">AA할인점</option>	
								<option value="S002">BB할인점</option>	
								<option value="S003">CC할인점</option>	
								<option value="S004">DD할인점</option>	
						</select></td>
			</tr>
			<tr>			
				<td>주문일자</td><td><input type="text" name="orderdate" required></td>
			</tr>	
				<td>제품코드</td><td><label for="pcode"></label>
						<select id="pcode" name="pcode">
								<option value="">코드선택</option>
								<option value="AA01">삼각김밥</option>	
								<option value="AA02">도시락</option>	
								<option value="AA03">봉지만두</option>	
								<option value="AA04">컵라면</option>
								<option value="AA05">아메리카노</option>	
								<option value="AA06">콜라</option>		
						</select></td></td>
			<tr>	
				<td>주문수량</td><td><input type="text" name="amount" required></td>
			</tr>
			<tr>	
				<td><input type="submit" value="주문등록"><input type="reset" value="다시쓰기"> </td>
			</tr>
		</table>
	</form>
	</section>

</body>
</html>