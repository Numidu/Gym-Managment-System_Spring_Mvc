<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8"
         language="java" %>

<!DOCTYPE html>
<html>

<head>

    <title>Payment Management</title>

    <link rel="preconnect" href="https://fonts.googleapis.com">

    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap"
          rel="stylesheet">

    <style>

        *{
            margin:0;
            padding:0;
            box-sizing:border-box;
            font-family:'Poppins',sans-serif;
        }

        body{
            background:#f1f5f9;
            padding:30px;
        }

        .container{
            width:100%;
        }

        /* HEADER */

        .header{
            margin-bottom:25px;
        }

        .header h1{
            font-size:32px;
            color:#0f172a;
            font-weight:700;
        }

        .header p{
            color:#64748b;
            margin-top:5px;
        }

        /* FORM CARD */

        .form-card{
            background:white;
            padding:30px;
            border-radius:22px;
            box-shadow:0 5px 20px rgba(0,0,0,0.08);
            margin-bottom:30px;
        }

        .form-grid{
            display:grid;
            grid-template-columns:repeat(auto-fit,minmax(250px,1fr));
            gap:20px;
        }

        .input-box{
            display:flex;
            flex-direction:column;
        }

        .input-box label{
            margin-bottom:8px;
            color:#334155;
            font-weight:500;
        }

        .input-box input,
        .input-box select{
            padding:14px;
            border-radius:12px;
            border:1px solid #cbd5e1;
            outline:none;
            transition:0.3s;
            font-size:14px;
        }

        .input-box input:focus,
        .input-box select:focus{
            border-color:#38bdf8;
            box-shadow:0 0 10px rgba(56,189,248,0.3);
        }

        /* BUTTON */

        .btn{
            margin-top:25px;
            padding:14px 28px;
            border:none;
            border-radius:14px;
            background:linear-gradient(135deg,#38bdf8,#2563eb);
            color:white;
            font-size:15px;
            font-weight:600;
            cursor:pointer;
            transition:0.3s;
        }

        .btn:hover{
            transform:translateY(-3px);
            box-shadow:0 8px 20px rgba(37,99,235,0.35);
        }

        /* TABLE */

        .table-card{
            background:white;
            padding:25px;
            border-radius:22px;
            box-shadow:0 5px 20px rgba(0,0,0,0.08);
            overflow-x:auto;
        }

        table{
            width:100%;
            border-collapse:collapse;
        }

        table thead{
            background:#0f172a;
            color:white;
        }

        table th{
            padding:16px;
            text-align:left;
            font-size:14px;
        }

        table td{
            padding:16px;
            border-bottom:1px solid #e2e8f0;
            color:#334155;
            font-size:14px;
        }

        table tr:hover{
            background:#f8fafc;
        }

        /* ACTION BUTTONS */

        .delete-btn{
            background:#ef4444;
            color:white;
            border:none;
            padding:10px 16px;
            border-radius:10px;
            cursor:pointer;
            transition:0.3s;
            font-weight:500;
        }

        .delete-btn:hover{
            background:#dc2626;
        }

        .edit-btn{
            text-decoration:none;
            background:#22c55e;
            color:white;
            padding:10px 18px;
            border-radius:10px;
            transition:0.3s;
            font-weight:500;
        }

        .edit-btn:hover{
            background:#16a34a;
        }

    </style>

</head>

<body>

<div class="container">

    <!-- HEADER -->

    <div class="header">

        <h1>Payment Management</h1>

        <p>Manage gym member payments</p>

    </div>

    <!-- FORM -->

    <div class="form-card">

        <form method="POST"
              action="${ep.id == 0
              ? 'savePayment'
              : 'updatePayment'}">

            <input type="hidden"
                   name="id"
                   value="${ep.id != null ? ep.id : 0}"/>

            <div class="form-grid">

                <!-- MEMBER -->

                <div class="input-box">

                    <label>Member</label>

                    <select name="memberId">

                        <c:forEach var="m" items="${memberList}">

                            <option value="${m.id}"

                                ${ep.memberId == m.id
                                        ? 'selected' : ''}>

                                    ${m.memberName}

                            </option>

                        </c:forEach>

                    </select>

                </div>

                <!-- AMOUNT -->

                <div class="input-box">

                    <label>Amount</label>

                    <input type="number"
                           step="0.01"
                           name="amount"
                           value="${ep.amount}"
                           placeholder="Enter payment amount"/>

                </div>

                <!-- PAYMENT DATE -->

                <div class="input-box">

                    <label>Payment Date</label>

                    <input type="date"
                           name="paymentDate"
                           value="${ep.paymentDate}"/>

                </div>

            </div>

            <input type="submit"

                   class="btn"

                   value="${ep.id == 0
                   ? 'Save Payment'
                   : 'Update Payment'}"/>

        </form>

    </div>

    <!-- TABLE -->

    <div class="table-card">

        <table>

            <thead>

            <tr>
                <th>Member Name</th>
                <th>Amount</th>
                <th>Payment Date</th>
                <th>Delete</th>
                <th>Edit</th>
            </tr>

            </thead>

            <tbody>

            <c:forEach var="p" items="${paymentList}">

                <tr>

                    <td>${p.memberName}</td>

                    <td>Rs. ${p.amount}</td>

                    <td>${p.paymentDate}</td>

                    <td>

                        <form action="deletePayment"
                              method="post">

                            <input type="hidden"
                                   name="paymentId"
                                   value="${p.id}">

                            <input type="submit"

                                   value="Delete"

                                   class="delete-btn"

                                   onclick="return confirm('Are you sure?')">

                        </form>

                    </td>

                    <td>

                        <a href="editPayment?id=${p.id}"
                           class="edit-btn">

                            Edit

                        </a>

                    </td>

                </tr>

            </c:forEach>

            </tbody>

        </table>

    </div>

</div>

</body>

</html>