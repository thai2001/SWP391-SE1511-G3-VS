<%-- 
    Document   : authorizeSeller
    Created on : Feb 14, 2022, 12:41:57 AM
    Author     : nqt26
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <title>Home Page</title>
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <!--css link -->
        <link rel="stylesheet" href="css/style.css" />
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
              rel="stylesheet"
              integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
              crossorigin="anonymous"
              />
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">

    </head>
    <body>
        <!-- navbar dung chung -->
        <jsp:include page="navbar.jsp"></jsp:include>
            <div class="container-fluid">
                <div class="row">
                    <div class="col-sm-3"><a class="link-dark" href="#">Manage <b>Transaction</b></a></div>
                    <div class="col-sm-3"><a class="link-dark" href="#">Manage <b>Report</b></a></div>
                    <div class="col-sm-3"><a class="link-dark" href="#">Manage <b>Account</b></a></div>
                    <div class="col-sm-3"><a class="link-dark" href="#">Authorize <b>Seller</b></a></div>
                </div>
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th>Tên</th>
                            <th>Mô tả</th>
                            <th>Địa chỉ</th>
                            <th>Gmail</th>
                            <th>Số điện thoại </th>
                            <th>Mục điều chỉnh</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${requestScope.seller}" var="s">
                        <tr>
                            <td>${s.sellerName}</td>
                            <td>${s.description}</td>
                            <td>${s.address}</td>
                            <td>${s.gmail}</td>
                            <td>${s.phone}</td>
                            <td><button type="button" class="btn btn-secondary" ><a href="changeAccountStatus?status=${s.username.status}&username=${s.username.username}">Accept</a></button>&nbsp;&nbsp;&nbsp;
                                <button type="button" class="btn btn-secondary" ><a href="deleteSellerAccount?username=${s.username.getUsername()}">Deny</a></button></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
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
        <!-- script link -->
        <script src="main.js"></script>
        <script src="myjs.js"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    </body>
</html>