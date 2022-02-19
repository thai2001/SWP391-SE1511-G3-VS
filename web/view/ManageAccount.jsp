<%-- 
    Document   : ManageAccount
    Created on : Feb 6, 2022, 10:18:59 PM
    Author     : nqt26
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="en">
    <!DOCTYPE html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <!-- Bootstrap core CSS -->
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
        <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
            rel="stylesheet"/>
        <link href="vendor/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <!-- CSS outsource -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"/>
        <!-- custom CSS -->
        <style>
            .title {
                margin-top: 30px;
                margin-bottom: 30 px;
                padding-bottom: 30px;
            }
            .table-wrapper {
                width: 1100px;
                margin: 30px auto;
                background: #fff;
                padding: 20px;	
                box-shadow: 0 1px 1px rgba(0,0,0,.05);
                padding-top: 150px;
            }
            .table-title {
                padding-bottom: 10px;
                margin: 0 0 10px;
            }
            .table-title h2 {
                margin: 6px 0 0;
                font-size: 22px;
            }
            .table-title .add-new {
                float: right;
                height: 30px;
                font-weight: bold;
                font-size: 12px;
                text-shadow: none;
                min-width: 100px;
                border-radius: 50px;
                line-height: 13px;
            }
            .table-title .add-new i {
                margin-right: 4px;

            }
            table.table {
                table-layout: fixed;

            }
            table.table tr th, table.table tr td {
                border-color: #e9e9e9;

            }
            table.table th i {
                font-size: 13px;
                margin: 0 5px;
                cursor: pointer;

            }
            table.table th:last-child {
                width: 100px;

            }
            table.table td a {
                cursor: pointer;
                display: inline-block;
                margin: 0 5px;
                min-width: 24px;

            }    
            table.table td a.add {
                color: #27C46B;
            }
            table.table td a.edit {
                color: #FFC107;
            }
            table.table td a.delete {
                color: #E34724;
            }
            table.table td i {
                font-size: 19px;

            }
            table.table td a.add i {
                font-size: 24px;
                margin-right: -1px;
                position: relative;
                top: 3px;

            }    
            table.table .form-control {
                height: 32px;
                line-height: 32px;
                box-shadow: none;
                border-radius: 2px;
            }
            table.table .form-control.error {
                border-color: #f50000;

            }
            table.table td .add {
                display: none;
            }

            img{
                width: 190px;
            }

            .fade{
                padding-top: 80px;

            }
            .form-group input{
                width:180px;
                height: 30px
            }

            .modal-content{
                border-radius: 15px;
            }

            .btn-danger{
                width: 140px;
                border-radius: 20px;
            }
            .navlink{
                display: flex;
                flex-direction: row;
            }
            header{
                position:sticky;
                top: 0px;
                width: 100%;
                height: auto;
            }
            header img{
                width: 50%;
            }
            .row1{
                margin-bottom: 30px;
                margin-top: 20px;
            }
            .row h2{
                font-size: 30px;

            }
            .row a{
                font-size: 30px;
            }
            .row1 select{
                width: 100px;
                height: 30px;
            }
            body {

                * { box-sizing: border-box; }
            }
        </style>
    </head> 
    <body>
        <!-- navbar dung chung -->
        <jsp:include page="navbar.jsp"></jsp:include>

            <div class="container-fluid">
                <div class="row title">
                    <div class="col-sm-3"><a class="link-dark" href="#">Manage <b>Transaction</b></a></div>
                    <div class="col-sm-3"><a class="link-dark" href="#">Manage <b>Report</b></a></div>
                    <div class="col-sm-3"><a class="link-dark" href="manageAccount">Manage <b>Account</b></a></div>
                    <div class="col-sm-3"><a class="link-dark" href="authorizeSeller">Authorize <b>Seller</b></a></div>
                </div>
                <div class="row">
                    <form class="navbar-form navbar-right" action="searchAccount" method="get" >
                        <select name="roleId">
                            <c:forEach items="${requestScope.role}" var="r">
                            <option  value="${r.roleId}" > ${r.roleName} </option>
                        </c:forEach> 
                    </select>    
                    <input value="" name="uid" type="text" class="SearchBox" placeholder="Id">

                    <input type="submit" class="SearchButton" />  <i class="fa fa-search"></i>
                </form>

            </div>
            <div class="row">

                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th>Tài khoản</th>
                            <th>Vai trò</th>
                            <th>Trạng thái</th>
                            <th>Mục điều chỉnh</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach  items="${requestScope.account}" var="a">
                        <tr>
                            <td>${a.getUsername()}</td>
                            <td>${a.getRoleId().getRoleName()}</td>
                            <td>${a.getStatus()}  </td>
                            <td><button type="button" class="btn btn-secondary" ><a href="changeAccountStatus?status=${a.getStatus()}&username=${a.username}">change</a></button></td>

                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
                <h3> ${requestScope.note} </h3>
        </div>
        <!-- end container part -->
        <!-- footer  -->
        <footer class="bg-dark text-light">
            <div class="tiltle information">
                <h3  >More information</h3>
                <button type="button" class="btn btn-outline-secondary"> <a href="#"></a> <i class="bi bi-instagram"></i></button>
                <button type="button" class="btn btn-outline-success"> <a href="#"></a> <i class="bi bi-instagram"></i></button>
                <button type="button" class="btn btn-outline-success"> <a href="#"></a> <i class="bi bi-instagram"></i></button>
                <br>
            </div>
            <div class="tiltle address">
                <h3  >Address</h3>
                <p>SWP301-SE1511-JS</p>

            </div>
        </footer>
        <!-- end footer -->

        <!-- Bootstrap core JavaScript -->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    </body>
</html>
