<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<style>
    body {
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        background: #f5f7fa;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
    }
    .login-container {
        background: #fff;
        padding: 40px 30px;
        border-radius: 12px;
        box-shadow: 0 4px 20px rgba(0,0,0,0.1);
        width: 300px;
        text-align: center;
    }
    h1 {
        margin-bottom: 20px;
        font-size: 24px;
        color: #333;
    }
    input[type="text"], input[type="password"] {
        width: 100%;
        padding: 10px 12px;
        margin: 10px 0;
        border: 1px solid #ccc;
        border-radius: 6px;
        box-sizing: border-box;
    }
    input[type="submit"], button {
        width: 100%;
        padding: 10px 12px;
        margin-top: 10px;
        border: none;
        border-radius: 6px;
        background-color: #4CAF50;
        color: white;
        font-size: 16px;
        cursor: pointer;
        transition: background-color 0.3s ease;
    }
    button {
        background-color: #2196F3;
    }
    input[type="submit"]:hover {
        background-color: #45a049;
    }
    button:hover {
        background-color: #1e87db;
    }
</style>
</head>
<body>
    <div class="login-container">
        <h1>로그인</h1>
        <form action="login" method="POST">
            <input type="text" name="id" placeholder="아이디" required><br>
            <input type="password" name="pw" placeholder="비밀번호" required><br>
            <input type="submit" value="로그인">
            <button type="button" onclick="reg()">회원가입</button>
        </form>
    </div>

    <script>
        function reg() {
            location.href = "regMember";
        }
    </script>
</body>
</html>
