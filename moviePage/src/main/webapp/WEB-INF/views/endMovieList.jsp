<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>종료된 영화 목록</title>
<style>
    body {
        font-family: 'Noto Sans KR', sans-serif;
        background-color: #f8f9fa;
        margin: 0;
        padding: 20px;
        color: #343a40;
    }

    h1 {
        text-align: center;
        color: #2c3e50;
        margin-bottom: 30px;
    }

    table {
        width: 100%;
        border-collapse: collapse;
        background-color: #fff;
        box-shadow: 0 2px 8px rgba(0, 0, 0, 0.05);
        border-radius: 8px;
        overflow: hidden;
    }

    thead {
        background-color: #6c757d;
        color: white;
    }

    th, td {
        padding: 14px 16px;
        text-align: center;
        border-bottom: 1px solid #dee2e6;
    }

    td img {
        width: 80px;
        height: 120px;
        object-fit: cover;
        border-radius: 6px;
        box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
    }

    a {
        color: #007bff;
        text-decoration: none;
        font-weight: bold;
    }

    a:hover {
        text-decoration: underline;
    }

    @media (max-width: 768px) {
        table, thead, tbody, th, td, tr {
            display: block;
        }

        thead {
            display: none;
        }

        tr {
            margin-bottom: 20px;
            background: #fff;
            border-radius: 8px;
            padding: 12px;
            box-shadow: 0 2px 6px rgba(0, 0, 0, 0.05);
        }

        td {
            text-align: left;
            padding-left: 50%;
            position: relative;
            border: none;
        }

        td::before {
            content: attr(data-label);
            position: absolute;
            left: 16px;
            top: 12px;
            font-weight: bold;
            color: #555;
        }

        td img {
            width: 100%;
            height: auto;
        }
    }
</style>
</head>
<body>
    <h1>🎬 종료된 영화 목록</h1>
    <jsp:include page="./layout/header.jsp"/>
    <table>
        <thead>
            <tr>
                <th>포스터</th>
                <th>제목</th>
                <th>개봉일</th>
                <th>종료일</th>
                <th>연령제한</th>
                <th>제작사</th>
                <th>줄거리</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="item" items="${list}" varStatus="status">
                <tr>
                    <td data-label="포스터">
                        <img alt="영화포스터" src="./images/posterSample.jpeg">
                    </td>
                    <td data-label="제목">
                        <a href="/detail?movie_code=${item.movie_code}">${item.title}</a>
                    </td>
                    <td data-label="개봉일">${item.season_start}</td>
                    <td data-label="종료일">${item.season_end}</td>
                    <td data-label="연령제한">${item.age_limit}</td>
                    <td data-label="제작사">${item.adment}</td>
                    <td data-label="줄거리">${item.plot}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
