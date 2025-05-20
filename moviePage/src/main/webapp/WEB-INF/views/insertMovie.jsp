<%@page import="com.example.moviePage.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%	
	boolean tf = true;
	MemberDTO member = (MemberDTO)session.getAttribute("member");
	System.out.println(member);
	
	if(member != null && member.getId().equals("admin")){
		tf = false;
	}
	System.out.println(tf);
%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화 등록 - 관리자 페이지</title>

</head>
<body>

	<div class="form-wrapper">
		<h1>영화 등록</h1>
		<form action="insertMovie" method="POST">
			<div>
				<label for="title">제목</label> <input type="text" id="title"
					name="title" placeholder="영화 제목을 입력하세요" required>
			</div>

			<div>
				<label for="season_start">개봉일</label> <input type="date"
					id="season_start" name="season_start" required>
			</div>

			<div>
				<label for="season_end">종료일</label> <input type="date"
					id="season_end" name="season_end">
			</div>

			<div>
				<label for="age_limit">연령제한</label> <input type="text"
					id="age_limit" name="age_limit" placeholder="예: 12세 이상">
			</div>

			<div>
				<label for="adment">한줄평</label> <input type="text" id="adment"
					name="adment" placeholder="예: 긴장감 넘치는 스릴러">
			</div>

			<div>
				<label for="plot">줄거리</label>
				<textarea id="plot" name="plot" placeholder="줄거리를 입력하세요..."></textarea>
			</div>

			<div>
				<label for="status">상태</label> <input type="text" id="status"
					name="status" placeholder="예: 상영중 / 종료">
			</div>

			<input type="submit" class="submit-btn" value="등록하기">
		</form>
	</div>
	<script>
		
		if(<%=tf%>){
			alert("관리자 로그인이 필요합니다!!!");
			location.href="/login";
		}
	</script>
</body>
</html>
