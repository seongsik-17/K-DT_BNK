<%@page import="com.example.moviePage.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	MemberDTO member = (MemberDTO)session.getAttribute("member");
	String id = null;
	boolean b;
	if(member == null){
		b = false;
	}else{
		 id = member.getId();
		b = true;
	}

%>    
<style>
	header {
	background: linear-gradient(135deg, #007bff, #0056b3);
	padding: 16px 0;
	box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
}

header ul {
	display: flex;
	justify-content: center;
	align-items: center;
	list-style: none;
	margin: 0;
	padding: 0;
	gap: 30px;
}

header ul li a {
	color: white;
	text-decoration: none;
	font-weight: 500;
	font-size: 16px;
	transition: color 0.3s ease, transform 0.3s ease;
	padding: 8px 12px;
	border-radius: 8px;
}

header ul li a:hover {
	color: #ffd700;
	background-color: rgba(255, 255, 255, 0.15);
	transform: translateY(-2px);
}

/* 모바일 반응형 */
@media (max-width: 768px) {
	header ul {
		flex-direction: column;
		gap: 10px;
	}
}
	
</style>    
<header>
		<ul>
			<li><a href="/endMovieList">상영종료</a></li>
			<li><a href="/">상영중</a></li>
			<li><a href="/expectedMovie">상영예정</a></li>
			<li><a href="#">Q&A</a></li>
			<li><a href="#">이벤트</a></li>
			<li id="logbtn"><a href="login">로그인</a></li>
			<li id="adminBtn"></li>
			
		</ul>
</header>
<script>
	const logbtn = document.getElementById("logbtn");
	const b = <%=b %>;
	if(b){
		logbtn.innerHTML='<li id="logbtn"><a href="/" onclick="logout()">로그아웃</a></li>';
	}
	function logout(){
		location.href="/logout"
		alert("로그아웃 되었습니다!!");
	}
	const adminInfo = "<%=id%>";
	
	if(adminInfo == "admin"){
		document.getElementById("adminBtn").innerHTML = "<li id='adminBtn'><a href='#'>관리자페이지</a></li>";
	}
</script>