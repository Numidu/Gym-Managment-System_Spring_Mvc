<%--
  Created by IntelliJ IDEA.
  User: numidu_d
  Date: 5/10/2026
  Time: 12:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>

<head>

    <title>Dashboard</title>

    <style>

        *{
            margin:0;
            padding:0;
            box-sizing:border-box;
            font-family:Arial;
        }

        body{
            display:flex;
            background:#f1f5f9;
        }

        /* SIDEBAR */

        .sidebar{
            width:270px;
            height:100vh;
            background:linear-gradient(180deg,#0f172a,#1e293b);
            position:fixed;
            left:0;
            top:0;
            padding:25px 18px;
            display:flex;
            flex-direction:column;
            justify-content:space-between;
            box-shadow:4px 0 15px rgba(0,0,0,0.15);
        }

        .logo-section{
            text-align:center;
            margin-bottom:30px;
        }

        .logo-section h1{
            color:white;
            font-size:30px;
            margin-bottom:5px;
            letter-spacing:1px;
        }

        .logo-section p{
            color:#94a3b8;
            font-size:14px;
        }

        .menu{
            display:flex;
            flex-direction:column;
            gap:12px;
        }

        .menu a{
            display:flex;
            align-items:center;
            gap:14px;
            color:#e2e8f0;
            text-decoration:none;
            padding:15px 18px;
            border-radius:14px;
            transition:0.3s;
            font-size:17px;
            font-weight:500;
        }

        .menu a:hover{
            background:#2563eb;
            transform:translateX(5px);
        }

        .logout-section{
            margin-top:20px;
        }

        .logout-btn{
            display:flex;
            align-items:center;
            justify-content:center;
            gap:12px;
            background:#ef4444;
            color:white;
            text-decoration:none;
            padding:15px;
            border-radius:14px;
            font-size:17px;
            font-weight:bold;
            transition:0.3s;
        }

        .logout-btn:hover{
            background:#dc2626;
        }

        /* MAIN CONTENT */

        .main-content{
            margin-left:270px;
            width:calc(100% - 270px);
            min-height:100vh;
            padding:30px;
        }

        /* HOME PAGE STYLES */

        .top-bar{
            display:flex;
            justify-content:space-between;
            align-items:center;
            margin-bottom:30px;
        }

        .sub-text{
            color:gray;
            margin-top:5px;
        }

        .profile{
            display:flex;
            align-items:center;
            gap:15px;
            background:white;
            padding:10px 20px;
            border-radius:15px;
            box-shadow:0 2px 10px rgba(0,0,0,0.08);
        }

        .profile img{
            width:55px;
            height:55px;
            border-radius:50%;
            object-fit:cover;
        }

        .cards{
            display:grid;
            grid-template-columns:repeat(auto-fit,minmax(220px,1fr));
            gap:20px;
            margin-bottom:30px;
        }

        .card{
            background:white;
            padding:25px;
            border-radius:20px;
            box-shadow:0 3px 10px rgba(0,0,0,0.08);
        }

        .card h2{
            color:#334155;
            margin-bottom:15px;
        }

        .card p{
            font-size:35px;
            font-weight:bold;
            color:#2563eb;
        }

        .bottom-section{
            display:grid;
            grid-template-columns:1fr 1fr;
            gap:20px;
        }

        .box{
            background:white;
            padding:20px;
            border-radius:20px;
            box-shadow:0 3px 10px rgba(0,0,0,0.08);
        }

        .box h2{
            margin-bottom:20px;
            color:#0f172a;
        }

        .table{
            width:100%;
            border-collapse:collapse;
        }

        .table th,
        .table td{
            padding:15px;
            border-bottom:1px solid #e2e8f0;
            text-align:left;
        }

        .status{
            display:flex;
            flex-direction:column;
            gap:20px;
            margin-top:20px;
        }

        .status-card{
            padding:20px;
            border-radius:15px;
            color:white;
            font-size:18px;
            font-weight:bold;
        }

        .paid{
            background:#22c55e;
        }

        .pending{
            background:#ef4444;
        }

    </style>

</head>

<body>

<!-- SIDEBAR -->

<div class="sidebar">

    <div>

        <div class="logo-section">

            <h1>GYM SYS</h1>

            <p>Management Panel</p>

        </div>

        <div class="menu">

            <a href="dashboard">
                🏠 Dashboard
            </a>

            <a href="m_view">
                💪 Members
            </a>

            <a href="t_view">
                🏋️ Trainers
            </a>

            <a href="p_view">
                💳 Payments
            </a>

            <a href="at_view">
                📅 Attendance
            </a>

            <a href="a_view">
                👨‍💼 Admins
            </a>

        </div>

    </div>

    <div class="logout-section">

        <a href="logout"
           class="logout-btn">

            🚪 Logout

        </a>

    </div>

</div>

<!-- PAGE CONTENT -->

<div class="main-content">

    <jsp:include page="${page}" />

</div>

</body>
</html>