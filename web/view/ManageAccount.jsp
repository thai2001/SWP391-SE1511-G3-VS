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
        <title>Manage Account</title>
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
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"/>
        <!-- custom CSS -->
        <style>
            .sidebar {
                position: inherit;
            }
            .title {
                margin-top: 30px;
                margin-bottom: 30px;
                padding-bottom: 30px;
            }
            .modal-notify .modal-header {
                border-radius: 3px 3px 0 0;
            }
            .modal-notify .modal-content {
                border-radius: 3px;
            }    

            body {

                * { box-sizing: border-box; }
            }

            .header {
                background-color: #398B93;
                color: black;
                font-size: 1.5em;
                padding: 1rem;
                text-align: center;
                text-transform: uppercase;
            }

            img {
                margin: 10px;
                height:auto;
                width:100px;
            }

            .table-users {
                background-color: lightblue;
                border: 1px solid darkgoldenrod;
                border-radius: 10px;
                box-shadow: 3px 3px 0 rgba(0,0,0,0.1);
                max-width: calc(100% - 2em);
                margin: 1em auto;
                overflow: hidden;
                width: 800px;
            }
            .mid{
                text-align: center;
            }
            th{
                text-align: center;
            }
            table {
                width: 100%;
                border-collapse:collapse;
                td, th { 
                    color: darken(#398B93, 10%);
                    padding: 10px; 
                    border: 1px solid black;
                }

                td {
                    font-size: 10px;
                    text-align: center;
                    vertical-align: middle;

                    &:last-child {
                        font-size: 0.95em;
                        line-height: 1.4;
                        text-align: left;
                    }
                }

                th { 
                    background-color: lighten(#398B93, 50%);
                    font-weight: 300;
                }

                tr {     
                    &:nth-child(2n) { background-color: white; }
                    &:nth-child(2n+1) { background-color: gainsboro; }
                }
            }


            .fade{
                padding-top: 80px;

            }
            .form-group input{
                width:100%;
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
            body {
                background-color: #eee
            }

            .nav-link {
                border-radius: 0px !important;
                transition: all 0.5s;
                width: 100px;
                display: flex;
                flex-direction: column
            }

            .nav-link small {
                font-size: 12px
            }

            .nav-link:hover {
                background-color: #52525240 !important
            }

            .nav-link .fa {
                transition: all 1s;
                font-size: 20px
            }

            .nav-link:hover .fa {
                transform: rotate(360deg)
            }
            .close {
                margin-right: 5%
            }
        </style>
    </head> 
    <body>
        <!-- navbar dung chung -->
        <jsp:include page="navbar.jsp"></jsp:include>
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-1">
                        <div class="sidebar d-flex flex-column flex-shrink-0 bg-light vh-100" style="width: 100%;">
                            <ul class="nav nav-pills nav-flush flex-column mb-auto text-center">
                                <li class="nav-item"> <a href="#" class="nav-link active py-3 border-bottom"> <i class="fa fa-home"></i> <small>Home</small> </a> </li>
                                <li> <a href="#" class="nav-link py-3 border-bottom"> <i class="fa fa-dashboard"></i> <small>Dashboard</small> </a> </li>
                                <li> <a href="#" class="nav-link py-3 border-bottom"> <i class="fa "></i> <small>Sign out</small> </a> </li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-md-11">
                        <div class="row title">
                            <div class="col-sm-3"><a class="link-dark" href="#">Manage <b>Transaction</b></a></div>
                            <div class="col-sm-3"><a class="link-dark" href="#">Manage <b>Report</b></a></div>
                            <div class="col-sm-3"><a class="link-dark" style="color: #007bff" href="manageAccount">Manage <b>Account</b></a></div>
                            <div class="col-sm-3"><a class="link-dark" href="authorize">Authorize <b>Seller</b></a></div>
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
                    <div class="table-users">
                        <div class="header">List Account</div>

                        <table border="1px"  >
                            <tr>
                                <th>Username</th>
                                <th>Role</th>
                                <th>Status</th>
                                <th width="120"></th>
                            </tr>
                            <c:forEach items="${requestScope.account}" var="a">
                                <tr>
                                    <td class="mid">${a.username}</td>
                                    <td class="mid">${a.roleId.roleName}</td>
                                    <td class="mid">${a.status}</td>
                                    <td class="mid"><button type="button" class="btn btn-secondary" data-toggle="modal" data-target="#exampleModal">Detail</button> </td>
                                </tr>     

                                <!-- Modal -->
                                <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalScrollableTitle" aria-hidden="true"> 
                                    <div class="modal-dialog modal-dialog-scrollable" role="document">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h5 class="modal-title" id="exampleModalScrollableTitle" style="font-size: 30px;margin: 0 auto">Account detail </h5>                                                                                                    
                                                <br/>
                                            </div>
                                            <div>
                                                <c:if test="${ a.roleId.roleId == 2 }">
                                                    <div class="modal-body">
                                                        <div class="form-group">
                                                            <label for="buyerId">Buyer ID</label>
                                                            <input type="text" class="form-control" id="buyerId" name="buyerId" value="${buyer.buyerId}" readonly >
                                                        </div>

                                                        <div class="form-group ">
                                                            <label for="buyerName">Name</label>
                                                            <input type="text" class="form-control" id="buyerName" name="buyerName" value="${buyer.buyerName}" readonly >
                                                        </div>
                                                        <div class="form-group ">
                                                            <label for="buyerAddress">Address</label>
                                                            <input type="text" class="form-control" id="buyerAddress" name="buyerAddress" value=" ${buyer.address}" readonly >
                                                        </div>

                                                        <div class="form-group">
                                                            <label for="buyerGmail">Gmail</label>
                                                            <input type="text" class="form-control" id="buyerGmail" name="buyerGmail" value="${buyer.gmail}" readonly>
                                                        </div>
                                                        <div class="form-group">
                                                            <label for="buyerPhone">Phone</label>
                                                            <input type="text" class="form-control" id="buyerPhone" name="buyerPhone" value="${buyer.phone}" readonly>
                                                        </div>
                                                        <div class="form-group">
                                                            <label for="buyerBirthday">Birthday</label>
                                                            <input type="text"  class="form-control" id="buyerBirthday" name="buyerBirthday" value="${buyer.birthday}" readonly>
                                                        </div>                                                 
                                                    </div>
                                                    <div class="modal-footer">
                                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                                        <button type="button" class="btn btn-secondary"><a href="changeAccountStatus?username=${a.username}&status=${a.status}" style="font-size: 15px;color: white">Change status</a></button>
                                                    </div>
                                                </c:if>
                                                <c:if test="${ a.roleId.roleId == 3 }">
                                                    <div class="modal-body">
                                                        <div class="form-group">
                                                            <label for="buyerId">Seller ID</label>
                                                            <input type="text" class="form-control" id="buyerId" name="buyerId" value="${seller.sellerId}" readonly >
                                                        </div>

                                                        <div class="form-group ">
                                                            <label for="sellerName">Name</label>
                                                            <input type="text" class="form-control" id="sellerName" name="sellerName" value="${seller.sellerName}" readonly >
                                                        </div>
                                                        <div class="form-group">
                                                            <label for="sellerDes">Description</label>
                                                            <input type="text"  class="form-control" id="sellerDes" name="sellerDes" value="${seller.description}" readonly>
                                                        </div>  
                                                        <div class="form-group ">
                                                            <label for="sellerAddress">Address</label>
                                                            <input type="text" class="form-control" id="sellerAddress" name="sellerAddress" value=" ${seller.address}" readonly >
                                                        </div>

                                                        <div class="form-group">
                                                            <label for="sellerGmail">Gmail</label>
                                                            <input type="text" class="form-control" id="buyerGmail" name="sellerGmail" value="${seller.gmail}" readonly>
                                                        </div>
                                                        <div class="form-group">
                                                            <label for="sellerPhone">Phone</label>
                                                            <input type="text" class="form-control" id="buyerPhone" name="sellerPhone" value="${seller.phone}" readonly>
                                                        </div>

                                                        <div class="form-group">
                                                            <label for="numProductsOnSale">Number of products on sale</label>
                                                            <input type="number"  class="form-control" id="numProductsOnSale" name="numProductsOnSale" value="${requestScope.numberProduct}" readonly>
                                                        </div>
                                                    </div>
                                                    <div class="modal-footer">
                                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                                        <button type="button" class="btn btn-secondary"><a href="changeAccountStatus?username=${a.username}&status=${a.status}" style="font-size: 15px;color: white">Change status</a></button>
                                                    </div>
                                                </c:if>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </table>
                    </div>
                    <h3> ${requestScope.note} </h3>
                </div>
            </div>
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
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <!-- Bootstrap core JavaScript --> 
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
