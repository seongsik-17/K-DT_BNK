<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%	//4대 저장소 -> 내부 저장소
    	pageContext.setAttribute("x","page_X");//해당 페이지에만 존재하는 저장소->넘어가면 정보가 사라짐
    	request.setAttribute("x","request_X");//하나의 페이지에만 저장소 할당 -> 하지만 다른 페이지로 복사가 가능
    	session.setAttribute("x", "session_X");//브라우저에 귀속되는 저장소 -> 사용자에게 저장 -> 개인화된 저장소
    	application.setAttribute("x","application_X");//가장 큰 저장소 -> 해당 서비스를 이용하는 모든 사람들이 이용 가능한 저장소
    	
    	String s = "hello";
    	
    	pageContext.setAttribute("x", s);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
page 저장소 값 <%=pageContext.getAttribute("x") %><br>
request 저장소 값 <%=request.getAttribute("x") %><br>
session 저장소 값 <%=session.getAttribute("x") %><br>
application 저장소 값 <%=application.getAttribute("x") %>
<hr>
<!-- el표기법 -->
page 저장소 값 : ${pageScope.x}</br> <!-- page영역이 제일 가깝다 = 범위가 제일 작은거-->
request 저장소 값 : ${requestScope.x}</br> <!-- 2위 -->
session 저장소 값 : ${sessionScope.x}</br> <!-- 3위 세션은 사용자를 기억하기 위한 특수한 저장소 @브라우저를 끄기 전까지 사용자 정보를 저장하고있다...-->
application 저장소 값 : ${applicationScope.x}<br><!-- 4위 -->
s(EL): ${s }<br>
s(표현식) : <%=s %><br>
파라미터 y: ${param.y }<br>
</body>
</html>