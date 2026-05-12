<%--
  Created by IntelliJ IDEA.
  User: numidu_d
  Date: 5/11/2026
  Time: 10:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- TOP BAR -->

<div class="top-bar">

    <div>
        <h1>Welcome Back 👋</h1>
        <p class="sub-text">Gym Management Dashboard</p>
    </div>

    <div class="profile">

        <img src="${pageContext.request.contextPath}/uploads/${loggedUser.image}">

        <div>
            <h3>${loggedUser.username}</h3>
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

<!-- BOTTOM SECTION -->

<div class="bottom-section">

    <!-- RECENT MEMBERS -->

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

    <!-- PAYMENT STATUS -->

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
