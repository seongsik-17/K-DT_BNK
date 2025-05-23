<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ManageMentPage</title>
<script src="https://cdn.jsdelivr.net/npm/echarts@5.6.0/dist/echarts.min.js"></script>
</head>
<body>
	<h1>ManagementPage🛠</h1>
	<header>
		<nav>
			<ul>
				<li><div onclick="getQna()">QnAList</div></li>
				<li><div onclick="getUserList()">회원현황</div></li>
				<li><div onclick="getUser()">개별회원 조회</div></li>
				<li><div onclick="getReservationList()">예약현황</div></li>
				<li><div onclick="productStatistics()">매출보고</div></li>
				<li><div onclick="monthlySalse()">월별 매출보고</div>
				<li><div onclick="">보고서생성</div></li>
			</ul>
		</nav>
	</header>
	<div id="main" style="width: 1000px;height:800px;">
		<div id="qnaDisplay">
			<h3>QnA List</h3>
			<table>
				<thead>
					<tr>
						<th>식별번호</th>
						<th>유저 ID</th>
						<th>제목</th>
						<th>내용</th>
						<th>조회수</th>
						<th>작성일자</th>
						<!-- 6개 -->
					</tr>
				</thead>
				<tbody>
					<c:forEach var="qna" items="${list }" varStatus="status">
						<tr>
							<td>${qna.qna_id }</td>
							<td>${qna.user_id }</td>
							<td>${qna.title }</td>
							<td>${qna.content }</td>
							<td>${qna.views }</td>
							<td>${qna.created_at }</td>
							<td><input type="text" id="answer">
								<button type="button" onclick="registAnswer()">답변등록(아직
									작동X)</button></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<hr>
	</div>
	<div id="sub">
		
	</div>
	<script>
	
function getQna(){
	  location.href='/management';
}
	
  function getUserList() {
	
    fetch('/getUserList')
      .then(response => {
        if (!response.ok) {
          throw new Error('응답 없음');
        }
        return response.json();
      })
      .then(userList => {
        const main = document.getElementById('main');

        let html = `
          <table border="1">
            <thead>
              <tr>
                <th>UserID</th><th>비밀번호</th><th>이름</th><th>이메일</th>
                <th>전화번호</th><th>생일</th><th>성별</th><th>주소</th>
                <th>가입일</th><th>역할</th><th>최근로그인</th><th>MBTI</th><th>성향</th><th>주량</th>
              </tr>
            </thead>
            <tbody>
        `;

        userList.forEach(user => {
          html += `
            <tr>
              <td>\${user.user_id}</td>
              <td>\${user.password}</td>
              <td>\${user.name}</td>
              <td>\${user.email}</td>
              <td>\${user.phone}</td>
              <td>\${user.birth_date}</td>
              <td>\${user.gender}</td>
              <td>\${user.address}</td>
              <td>\${user.join_date}</td>
              <td>\${user.role}</td>
              <td>\${user.lastLogin}</td>
              <td>\${user.mbti}</td>
              <td>\${user.personalities}</td>
              <td>\${user.drinking_level}</td>
            </tr>
          `;
        });

        html += `
            </tbody>
          </table>
        `;

        main.innerHTML = html;
      })
      .catch(error => {
    	  const main = document.getElementById('main');
    	  alert("데이터 로딩에 실패하였습니다!");
    	  return;
      });
  }
  
  function getReservationList(){
	  fetch('/getReservations')
	  .then(response => {
		  if(!response.ok){
			  throw new Error('응답없음')
		  }
		  return response.json();
	  })
	  .then(reservationList => {
		  console.log(reservationList)
		  let html = `
		    <table border="1">
		      <thead>
		        <tr>
		          <th>예약번호</th>
		          <th>유저ID</th>
		          <th>상품ID</th>
		          <th>예약일</th>
		          <th>예약인원</th>
		          <th>total_price</th>
		          <th>상태</th>
		        </tr>
		      </thead>
		      <tbody>
		  `;

		  reservationList.forEach(reservation => {
		    html += `
		      <tr>
		        <td>\${reservation.reservation_id}</td>
		        <td>\${reservation.user_id}</td>
		        <td>\${reservation.product_id}</td>
		        <td>\${reservation.reservation_date}</td>
		        <td>\${reservation.num_people}</td>
		        <td>\${reservation.total_price}</td>
		        <td>\${reservation.status}</td>
		      </tr>
		    `;
		  });

		  html += `
		      </tbody>
		    </table>
		  `;

		  document.getElementById('main').innerHTML = html;
		})
		.catch(error => {
	    	  alert("데이터 로딩에 실패하였습니다!");
	    	  return;
		});
		}
  
  function getUser() {
	  const main = document.getElementById("main");
	  main.innerHTML = `
	    <form id="userForm">
	      <input type="text" name="name" placeholder="성명" required>
	      생년월일&nbsp;<input type="date" name="birth_date" >&nbsp;
	      <input type="submit" value="찾기">
	    </form>
	    <div id="result"></div>
	  `;

	  const form = document.getElementById("userForm");

	  form.addEventListener("submit", function(event) {
	    event.preventDefault(); // 폼의 기본 제출 방지

	    const formData = new FormData(form);
	    const queryString = new URLSearchParams(formData).toString();

	    fetch("getUser?" + queryString, {
	      method: "GET",
	    })
	    .then(response => response.json()) // 서버가 HTML이나 텍스트를 반환할 경우
	    .then(data => {
	    	console.log(data);
	      document.getElementById("result").innerHTML =`
	      <table>
	    	  <thead>
              <tr>
                <th>UserID</th><th>비밀번호</th><th>이름</th><th>이메일</th>
                <th>전화번호</th><th>생일</th><th>성별</th><th>주소</th>
                <th>가입일</th><th>역할</th><th>최근로그인</th><th>MBTI</th><th>성향</th><th>주량</th>
              </tr>
            </thead>
            <tbody>
            	<td>\${data.user_Id}</td>
            	<td>\${data.password}</td>
            	<td>\${data.name}</td>
            	<td>\${data.email}</td>
            	<td>\${data.phone}</td>
            	<td>\${data.birthDate}</td>
            	<td>\${data.gender}</td>
            	<td>\${data.address}</td>
           		<td>\${data.regDate}</td>
            	<td>\${data.role}</td>
            	<td>\${data.lastLogin}</td>
            	<td>\${data.mbti}</td>
            	<td>\${data.personalities}</td>
            	<td>\${data.drinking_level}</td>
            </tbody>
	      </table>
	      `;
	    })
	    .catch(error => {
	      document.getElementById("result").innerHTML = "에러 발생: " + error;
	    });
	  });
	}
  
	//통계 차트
	function productStatistics() {
    const main = document.getElementById('main');
    main.innerHTML = `<div id="salesChart" style="width: 1000px; height: 800px;"></div>`; // 차트 전용 div

    var chartDom = document.getElementById('salesChart');
    var myChart = echarts.init(chartDom);

    fetch('/getSalse') 
    .then(response => response.json())
    .then(rawData => {
        const formattedData = rawData.map(item => ({
            name: item.title,
            value: item.total_sale
        }));

        var option = {
        		  title: {
        			    text: '매출 종합 집계',
        			    subtext: '여행 상품별',
        			    left: 'center'
        			  },
        			  tooltip: {
        			    trigger: 'item'
        			  },
        			  legend: {
        			    orient: 'vertical',
        			    left: 'left'
        			  },
        			  series: [
        			    {
        			      name: 'Access From',
        			      type: 'pie',
        			      radius: '50%',
        			      data: formattedData,
        			      emphasis: {
        			        itemStyle: {
        			          shadowBlur: 10,
        			          shadowOffsetX: 0,
        			          shadowColor: 'rgba(0, 0, 0, 0.5)'
        			        }
        			      }
        			    }
        			  ]
        			};
        myChart.setOption(option);
    })
    .catch(err => {
        console.error('매출 데이터 로딩 실패:', err);
        main.innerHTML = '<p>매출 데이터를 불러오는 데 실패했습니다.</p>';
    });

}
	function monthlySalse() {
	    const main = document.getElementById('main');
	    main.innerHTML = `<div id="salesChart" style="width: 1000px; height: 800px;"></div>`;
	    var chartDom = document.getElementById('salesChart');
	    var myChart = echarts.init(chartDom);

	    fetch('/getMonthlySalesDataset')
	        .then(response => response.json())
	        .then(sourceData => {
	            let option = {
	                legend: {},
	                tooltip: {
	                    trigger: 'axis',
	                    showContent: false
	                },
	                dataset: {
	                    source: sourceData
	                },
	                xAxis: { type: 'category' },
	                yAxis: { gridIndex: 0 },
	                grid: { top: '55%' },
	                series: [], // 아래에서 채움
	            };

	            // 상품 개수만큼 라인 시리즈 추가
	            for (let i = 1; i < sourceData.length; i++) {
	                option.series.push({
	                    type: 'line',
	                    smooth: true,
	                    seriesLayoutBy: 'row',
	                    emphasis: { focus: 'series' }
	                });
	            }

	            // pie 차트 추가 (기본은 첫 번째 월인 '1월')
	            option.series.push({
	                type: 'pie',
	                id: 'pie',
	                radius: '30%',
	                center: ['50%', '25%'],
	                emphasis: {
	                    focus: 'self'
	                },
	                label: {
	                    formatter: '{b}: {@[1]} ({d}%)'
	                },
	                encode: {
	                    itemName: 'product',
	                    value: 1,
	                    tooltip: 1
	                }
	            });

	            // pie 갱신
	            myChart.on('updateAxisPointer', function (event) {
	                const xAxisInfo = event.axesInfo[0];
	                if (xAxisInfo) {
	                    const dimension = xAxisInfo.value + 1;
	                    myChart.setOption({
	                        series: {
	                            id: 'pie',
	                            label: {
	                                formatter: `{b}: {@[${dimension}]} ({d}%)`
	                            },
	                            encode: {
	                                value: dimension,
	                                tooltip: dimension
	                            }
	                        }
	                    });
	                }
	            });

	            myChart.setOption(option);
	        })
	        .catch(err => {
	            console.error("월별 매출 데이터 로딩 실패:", err);
	            main.innerHTML = "<p>데이터를 불러오지 못했습니다.</p>";
	        });
	}


  
</script>

</body>
</html>