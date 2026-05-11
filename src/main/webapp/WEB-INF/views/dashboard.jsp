<%--
  Created by IntelliJ IDEA.
  User: numidu_d
  Date: 5/10/2026
  Time: 12:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"
         language="java" %>

<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>

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
         width:260px;
         height:100vh;
         background:#0f172a;
         position:fixed;
         left:0;
         top:0;
         padding:20px;
     }

     .sidebar h1{
         color:white;
         margin-bottom:30px;
         text-align:center;
     }

     .sidebar a{
         display:block;
         color:#e2e8f0;
         text-decoration:none;
         padding:15px;
         margin-bottom:10px;
         border-radius:12px;
         transition:0.3s;
         font-size:17px;
     }

     .sidebar a:hover{
         background:#1e293b;
         padding-left:20px;
     }

     /* MAIN CONTENT */

     .main-content{
         margin-left:260px;
         width:calc(100% - 260px);
         min-height:100vh;
         padding:30px;
     }
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

    .profile h3{
    color:#0f172a;
    }

    .profile p{
    font-size:14px;
    color:gray;
    }

    /* CARDS */

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
    transition:0.3s;
    }

    .card:hover{
    transform:translateY(-5px);
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

    /* BOTTOM */

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

    .empty-box{
    height:250px;
    border:2px dashed #cbd5e1;
    border-radius:15px;
    display:flex;
    align-items:center;
    justify-content:center;
    color:gray;
    font-size:18px;
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

    <h1>GYM SYS</h1>
    <a href="dashboard">Dashboard</a>

    <a href="#" onclick="loadPage('m_view')">Members</a>

    <a href="#" onclick="loadPage('t_view')">Trainers</a>

    <a href="#" onclick="loadPage('p_view')">Payments</a>

    <a href="#" onclick="loadPage('at_view')">Attendance</a>

    <a href="#" onclick="loadPage('a_view')">Admins</a>

    <a href="logout">Logout</a>

</div>

<!-- CONTENT -->

<div class="main-content" id="content">

    <!-- TOP BAR -->

    <div class="top-bar">

        <div>
            <h1>Welcome Back 👋</h1>
            <p class="sub-text">Gym Management Dashboard</p>
        </div>

        <div class="profile">

            <img src="${pageContext.request.contextPath}/uploads/${loggedUser.image}">

            <div>
                <h3>Admin</h3>
                <p>System Administrator</p>
            </div>

        </div>

    </div>


    <!-- CARDS -->

    <div class="cards">

        <div class="card">
            <h2>Admins</h2>
            <p>${adminCount}</p>
        </div>

        <div class="card">
            <h2>Trainers</h2>
            <p>${trainerCount}</p>
        </div>

        <div class="card">
            <h2>Members</h2>
            <p>${memberCount}</p>
        </div>

        <div class="card">
            <h2>Total Payment</h2>
            <p>Rs. ${payment}</p>
        </div>

    </div>


    <!-- EMPTY SECTIONS -->

    <div class="bottom-section">

        <div class="box">

            <h2>Recent Members</h2>

            <table class="table">

                <tr>
                    <th>Name</th>
                    <th>Package</th>
                </tr>

                <c:forEach var="m" items="${payments}">
                    <tr>
                        <td>${m.memberName}</td>
                        <td>${m.paymentDate}</td>
                    </tr>
                </c:forEach>

            </table>

        </div>


        <div class="box">

            <h2>Payment Status</h2>

            <div class="status">

                <div class="status-card paid">
                    Paid Members : ${paidmember}
                </div>

                <div class="status-card pending">
                    Pending Payments : 5
                </div>

            </div>

        </div>

    </div>

</div>

<script>

    function loadPage(page){

        fetch(page)

            .then(response => response.text())

            .then(data => {

                document.getElementById("content").innerHTML = data;

            });

    }

</script>



</body>
</html>