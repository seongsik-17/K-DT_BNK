<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>IndexPage</h1>
	<hr>
	<a href = "studentlist.jsp">a로 이동</a>
	<a href = "emplist.jsp">사원 목록 보기</a>
	<form action="req1.jsp" method="GET">
	<!-- ?username=1111&age=2222&hobbies=코딩&pagecolor=blue -->
		username: <input type="text" name="username"><br> 
		age : <input type="text" name="age"><br> 
			hobby : <input type="checkbox" name="hobbies" value="독서">책읽기&nbsp<br> 
			        <input type="checkbox" name="hobbies" value="코딩">코딩하기<br>

		Bgcolor: <select name="pagecolor">
			<option value="red">빨강</option>
			<option value="blue">파랑</option>
		</select> <input type="submit" value="전송">
	</form>
	<form action = "a.jsp" method = "GET">
	학생번호: <input type = "text" name = "stu_no"><br>
	학생이름: <input type = "text" name = "stu_name"><br>
	학과: <input type = "text" name = "stu_dept"><br>
	학년: <input type = "text" name = "stu_grade"><br>
	반: <input type = "text" name = "stu_class"><br>
	성별: <input type = "text" name = "stu_gender"><br>
	키: <input type = "text" name = "stu_height"><br>
	몸무게: <input type = "text" name = "stu_weight"><br>
	</select> <input type="submit" value="전송">
	</form>
</body>
</html>