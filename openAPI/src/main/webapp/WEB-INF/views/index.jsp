<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	img{
		height: 100px;
		weidth: 100px;
	}
</style>
</head>
<body>
	<h1>경상남도 자주찾는 문화제</h1>
	<br>
	<button onclick="getAll()">문화재 전체 조회(1)</button>
	<button onclick="getAll2()">문화재 전체 조회(2)</button>
	<div id="view">-----</div>
	
	<script>
	const view = document.getElementById("view");
		function getAll(){
			const xhr = new XMLHttpRequest();
			xhr.onload = function(){
				var obj = JSON.parse(xhr.responseText);
				var list = obj.gyeongnamculturallist.body.items.item;
				
				let html = '<br><table border="1">';
				html+='<tr><td>지정번호</td><td>명칭</td><td>명칭(한문)</td><td>문화재 설명</td>';
				list.forEach(item=>{
					html+='<tr>'+
								'<td>'+item.DOJIJUNG_NO+'</td>'+
								'<td>'+item.MYONGCHING+'</td>'+
								'<td>'+item.MYONGCHING_HANMUN+'</td>'+
								'<td>'+item.CONTENT+'</td>'+
								'<td>'+'<img src='+item.fileurl1+'>'+'</td>'+
						'</tr>'	;
				});
				html+='</table>'
				view.innerHTML = html;
				
			}
			xhr.open('GET','getAll');
			xhr.send();
		}
		
		//두번째 페이지
		function getAll2(){
			const xhr = new XMLHttpRequest();
			xhr.onload = function(){
				var obj = JSON.parse(xhr.responseText);
				var list = obj.gyeongnamculturallist.body.items.item;
				
				let html = '<br><table border="1">';
				html+='<tr><td>지정번호</td><td>명칭</td><td>명칭(한문)</td><td>문화재 설명</td>';
				list.forEach(item=>{
					html+='<tr>'+
								'<td>'+item.DOJIJUNG_NO+'</td>'+
								'<td>'+item.MYONGCHING+'</td>'+
								'<td>'+item.MYONGCHING_HANMUN+'</td>'+
								'<td>'+item.CONTENT+'</td>'+
								'<td>'+'<img src='+item.fileurl1+'>'+'</td>'+
						'</tr>'	;
				});
				html+='</table>'
				view.innerHTML = html;
				
			}
			xhr.open('GET','getAll2');
			xhr.send();
		}
	</script>
</body>
</html>