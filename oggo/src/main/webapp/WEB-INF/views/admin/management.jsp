<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ManageMentPage</title>
<script
	src="https://cdn.jsdelivr.net/npm/echarts@5.6.0/dist/echarts.min.js"></script>
<style>
* {
	box-sizing: border-box;
	font-family: 'Segoe UI', sans-serif;
}

body {
	margin: 0;
	display: flex;
	height: 100vh;
}

header {
	width: 220px;
	background-color: #2c3e50;
	color: white;
	padding: 20px 0;
}

nav ul {
	list-style: none;
	padding: 0;
}

nav ul li {
	padding: 15px 20px;
	cursor: pointer;
	transition: background-color 0.3s;
}

nav ul li:hover {
	background-color: #34495e;
}

nav li.no-hover:hover {
	background-color: inherit;
	cursor: default;
	font-weight: bold;
}

nav ul li div {
	color: white;
	text-decoration: none;
}

#main {
	flex: 1;
	padding: 20px;
	overflow-y: auto;
	background-color: #f4f6f9;
}

h1 {
	background-color: #1abc9c;
	color: white;
	padding: 20px;
	margin: 0;
	text-align: center;
}

table {
	width: 100%;
	border-collapse: collapse;
	margin: 20px 0;
	background: white;
	box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
}

th, td {
	border: 1px solid #ddd;
	padding: 10px;
	text-align: center;
}

th {
	background-color: #ecf0f1;
	font-weight: bold;
}

input[type="text"], input[type="date"], input[type="submit"] {
	padding: 6px 10px;
	margin: 5px;
	border: 1px solid #ccc;
	border-radius: 4px;
}

input[type="submit"] {
	background-color: #3498db;
	color: white;
	cursor: pointer;
}

input[type="submit"]:hover {
	background-color: #2980b9;
}

#salesChart {
	background-color: white;
	border-radius: 10px;
	padding: 20px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}
</style>
</head>
<!-- 구현하고 싶은 기능 -->
<!-- QnA를 작성하면 비속어 필터링을 통해 비속어가 감지되면 관리자에게 알려지도록 알람이 오고 삭제를 관리자가 진행하면 작성 내역과 로그를 DB에 기록 -->
<!-- 각 예약현황 및 월별매출, 매출보고 PDF파일로 변환하기 기능 -->
<!--  -->
<body>
	<header>
		<nav>
			<ul>
				<li class="no-hover">OGGO</li>
				<li><div onclick="getQnAList()">❌미응답QnAList</div></li>
				<li><div onclick="forbiddenWords()">👮🏼‍♂️필터링된 QnAList</div></li>
				<li><div onclick="getUserList()">👥 회원 현황</div></li>
				<li><div onclick="getUser()">🔍 개별 회원 조회</div></li>
				<li><div onclick="getReservationList()">📝 예약 현황</div></li>
				<li><div onclick="productStatistics()">📊 매출 보고</div></li>
				<li><div onclick="monthlySalse()">📈 월별 매출</div></li>
				<li><div onclick="loadMonthlySalesTable()">🧾 보고서 생성</div></li>
			</ul>
		</nav>
	</header>

	<div id="main">
		<h2>관리자용 페이지</h2>
		<p>Version 1.0</p>
		<p>All Copyrights from OGGO</p>
	</div>
	<script>
		
  function getQnAList() {
	  const main = document.getElementById("main");

	  fetch('/getQnAList')
	    .then(response => {
	      if (!response.ok) {
	        throw new Error('응답 없음');
	      }
	      return response.json();
	    })
	    .then(data => {
	      let html = `
	        <h3>QnA 목록</h3>
	        <table border="1">
	          <thead>
	            <tr>
	              <th>식별번호</th>
	              <th>유저 ID</th>
	              <th>제목</th>
	              <th>내용</th>
	              <th>조회수</th>
	              <th>작성일자</th>
	            </tr>
	          </thead>
	          <tbody>
	      `;

	      data.forEach(qna => {
	        html += `
	          <tr>
	            <td>\${qna.qna_id}</td>
	            <td>\${qna.user_id}</td>
	            <td>\${qna.title}</td>
	            <td>\${qna.content}</td>
	            <td>\${qna.views}</td>
	            <td>\${qna.created_at}</td>
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
	      console.error("QnA 데이터를 불러오는 데 실패했습니다:", error);
	      main.innerHTML = "<p>QnA 데이터를 불러오지 못했습니다.</p>";
	    });
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
		          <th>결제확인</th>
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
		        <td>\${reservation.total_price.toLocaleString()}원</td>
		        <td>\${reservation.status}</td>
		        <td><button onclick="checkPayment(\${reservation.reservation_id})">예약확정</button>
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
            	<td>\${data.user_id}</td>
            	<td>\${data.password}</td>
            	<td>\${data.name}</td>
            	<td>\${data.email}</td>
            	<td>\${data.phone}</td>
            	<td>\${data.birth_date}</td>
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
	      document.getElementById("result").innerHTML = "입력하신 사용자가 존재하지 않습니다!";
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
	function forbiddenWords(){
		const main = document.getElementById("main");
		
		fetch("/forbiddenWords") // 컨트롤러 또는 JSP 매핑 경로
			.then(response => {
				if (!response.ok) throw new Error("응답 실패");
				return response.json();
			})
			.then(data => {
				console.log(data);
	      let html = `
	        <h3>필터링된 QnA리스트</h3>
	        <table border="1">
	          <thead>
	            <tr>
	              <th>식별번호</th>
	              <th>유저 ID</th>
	              <th>제목</th>
	              <th>내용</th>
	              <th>조회수</th>
	              <th>작성일자</th>
	              <th>처리</th>
	            </tr>
	          </thead>
	          <tbody>
	      `;

	      data.forEach(qna => {
	        html += `
	          <tr>
	            <td>\${qna.qna_id}</td>
	            <td>\${qna.user_id}</td>
	            <td>\${qna.title}</td>
	            <td>\${qna.content}</td>
	            <td>\${qna.views}</td>
	            <td>\${qna.created_at}</td>
	            <td><button onclick="deleteForbiddenWord(\${qna.qna_id})">삭제하기</button></td>
	          </tr>
	        `;
	      });

	      html += `
	          </tbody>
	        </table>
	      `;

	      main.innerHTML = html;
	    })
			.catch(err => {
				console.error("비속어 목록 로딩 실패:", err);
				main.innerHTML = "<p>비속어 데이터를 불러오지 못했습니다.</p>";
			});
	}
	//비속어가 포함된걸로 감지되어 
	function deleteForbiddenWord(qna_id){
		alert("qna 삭제 기능에 포함 예정");
	}
	//결제를 확인하면 상태를 변경
	function checkPayment(res_id) {
  	const main = document.getElementById("main");
	console.log(res_id);
 	 fetch("/updateResStatus", {
	 method: "POST",
	  headers: {
	    "Content-Type": "application/x-www-form-urlencoded"
	  },
	  body: "res_id=" + encodeURIComponent(res_id)
	})
    .then(result => {
      console.log("처리 결과:", result);
      alert("결제 상태가 성공적으로 변경되었습니다.");
      // 예: 상태 갱신을 위해 페이지 새로고침 또는 목록 다시 불러오기
      location.reload();
    })
    .catch(err => {
      console.error("에러:", err);
      main.innerHTML = '<p>처리 실패</p>';
    });
}

function loadMonthlySalesTable() {
  fetch("/getMonthlySalesDataset")
    .then(response => response.json())
    .then(data => {
      const main = document.getElementById("main");

      let html = "<h3>월별 상품 매출</h3><table border='1'><thead><tr>";

      // 첫 행은 헤더
      data[0].forEach(header => {
        html += `<th>\${header}</th>`;
      });
      html += "</tr></thead><tbody>";

      // 나머지 행은 데이터
      for (let i = 1; i < data.length; i++) {
        html += "<tr>";
        data[i].forEach(cell => {
          html += `<td>\${cell}</td>`;
        });
        html += "</tr>";
      }
      html += "<button onclick='monthlySalesPdf()'>보고서 PDF로 출력하기</button>";	
      html += "</tbody></table>";
      main.innerHTML = html;
    })
    .catch(err => {
      console.error("데이터 로딩 실패:", err);
      document.getElementById("main").innerHTML = "<p>매출 데이터를 불러오는 데 실패했습니다.</p>";
    });
}
	function monthlySalesPdf(){
		location.href='/monthlySalesPdf';
	}





	</script>
</body>
</html>