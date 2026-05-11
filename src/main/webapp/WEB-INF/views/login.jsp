<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>Admin Login</title>

    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap" rel="stylesheet">

    <style>

        *{
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: 'Poppins', sans-serif;
        }

        body{
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            background: linear-gradient(135deg,#0f172a,#1e293b,#334155);
            overflow: hidden;
        }

        /* BACKGROUND CIRCLES */

        .circle1{
            position: absolute;
            width: 300px;
            height: 300px;
            background: rgba(56,189,248,0.15);
            border-radius: 50%;
            top: -100px;
            left: -100px;
            filter: blur(10px);
        }

        .circle2{
            position: absolute;
            width: 350px;
            height: 350px;
            background: rgba(59,130,246,0.15);
            border-radius: 50%;
            bottom: -120px;
            right: -120px;
            filter: blur(10px);
        }

        /* LOGIN CARD */

        .login-box{
            width: 400px;
            background: rgba(255,255,255,0.08);
            backdrop-filter: blur(15px);
            border: 1px solid rgba(255,255,255,0.1);
            border-radius: 25px;
            padding: 40px;
            box-shadow: 0 10px 40px rgba(0,0,0,0.3);
            position: relative;
            z-index: 10;
        }

        .login-box h2{
            color: white;
            text-align: center;
            margin-bottom: 10px;
            font-size: 32px;
        }

        .login-box p{
            color: #cbd5e1;
            text-align: center;
            margin-bottom: 35px;
            font-size: 14px;
        }

        .input-box{
            margin-bottom: 22px;
        }

        .input-box label{
            display: block;
            margin-bottom: 8px;
            color: #e2e8f0;
            font-size: 14px;
        }

        .input-box input{
            width: 100%;
            padding: 14px;
            border: none;
            outline: none;
            border-radius: 12px;
            background: rgba(255,255,255,0.12);
            color: white;
            font-size: 15px;
            transition: 0.3s;
        }

        .input-box input::placeholder{
            color: #cbd5e1;
        }

        .input-box input:focus{
            background: rgba(255,255,255,0.18);
            border: 1px solid #38bdf8;
            box-shadow: 0 0 10px rgba(56,189,248,0.4);
        }

        /* BUTTON */

        .btn{
            width: 100%;
            padding: 14px;
            border: none;
            border-radius: 14px;
            background: linear-gradient(135deg,#38bdf8,#2563eb);
            color: white;
            font-size: 16px;
            font-weight: 600;
            cursor: pointer;
            transition: 0.3s;
            margin-top: 10px;
        }

        .btn:hover{
            transform: translateY(-3px);
            box-shadow: 0 8px 20px rgba(37,99,235,0.4);
        }

        /* ERROR */

        .error{
            margin-top: 18px;
            background: rgba(239,68,68,0.15);
            color: #fecaca;
            padding: 12px;
            border-radius: 12px;
            text-align: center;
            border: 1px solid rgba(239,68,68,0.3);
            font-size: 14px;
        }

    </style>

</head>

<body>

<div class="circle1"></div>
<div class="circle2"></div>

<div class="login-box">

    <h2>Admin Login</h2>

    <p>Welcome back! Please login to continue.</p>

    <form action="login" method="post">

        <div class="input-box">

            <label>Email</label>

            <input type="email" name="email" placeholder="Enter your email" required>

        </div>

        <div class="input-box">

            <label>Password</label>

            <input type="password" name="password" placeholder="Enter your password" required>

        </div>

        <input type="submit" value="Login" class="btn">

    </form>

    <c:if test="${error != null}">

        <div class="error">
                ${error}
        </div>

    </c:if>

</div>

</body>
</html>