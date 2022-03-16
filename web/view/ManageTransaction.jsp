<%-- 
    Document   : ManageTransaction
    Created on : Feb 7, 2022, 12:10:19 AM
    Author     : nqt26
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
    <!DOCTYPE html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Manage Transaction</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <!-- Bootstrap core CSS -->
        <link href="../css/sidebar.css" rel="stylesheet" type="text/css"/>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
              crossorigin="anonymous">
        <link href="https://use.fontawesome.com/releases/v5.0.6/css/all.css" rel="stylesheet">
        <!-- CSS outsource -->

        <!-- Bootstrap core JavaScript -->      

        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
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

            body {
                font-family: 'Poppins', sans-serif;
                background: #fafafa;
            }

            p {
                font-family: 'Poppins', sans-serif;
                font-size: 1.1em;
                font-weight: 300;
                line-height: 1.7em;
                color: #999;
            }

            a,
            a:hover,
            a:focus {
                color: inherit;
                text-decoration: none;
                transition: all 0.3s;
            }

            .navbar {
                padding: 15px 10px;
                background: #fff;
                border: none;
                border-radius: 0;
                margin-bottom: 40px;
                box-shadow: 1px 1px 3px rgba(0, 0, 0, 0.1);
            }

            .navbar-btn {
                box-shadow: none;
                outline: none !important;
                border: none;
            }

            .line {
                width: 100%;
                height: 1px;
                border-bottom: 1px dashed #ddd;
                margin: 40px 0;
            }

            /* ---------------------------------------------------
                SIDEBAR STYLE
            ----------------------------------------------------- */

            .wrapper {
                display: flex;
                width: 100%;
                align-items: stretch;
            }

            #sidebar {
                min-width: 250px;
                max-width: 250px;
                background: #7386D5;
                color: #fff;
                transition: all 0.3s;
            }

            #sidebar.active {
                margin-left: -250px;
            }

            #sidebar .sidebar-header {
                padding: 20px;
                background: #bee5eb;
            }

            #sidebar ul.components {
                padding: 20px 0;
                border-bottom: 1px solid #47748b;
            }

            #sidebar ul p {
                color: #fff;
                padding: 10px;
            }

            #sidebar ul li a {
                padding: 10px;
                font-size: 1.1em;
                display: block;
            }

            #sidebar ul li a:hover {
                color: #7386D5;
                background: #fff;
            }

            #sidebar ul li.active>a,
            a[aria-expanded="true"] {
                color: #fff;
                background: #6d7fcc;
            }

            a[data-toggle="collapse"] {
                position: relative;
            }

            .dropdown-toggle::after {
                display: block;
                position: absolute;
                top: 50%;
                right: 20px;
                transform: translateY(-50%);
            }

            ul ul a {
                font-size: 0.9em !important;
                padding-left: 30px !important;
                background: #6d7fcc;
            }

            ul.CTAs {
                padding: 20px;
            }

            ul.CTAs a {
                text-align: center;
                font-size: 0.9em !important;
                display: block;
                border-radius: 5px;
                margin-bottom: 5px;
            }

            a.download {
                background: #fff;
                color: #7386D5;
            }

            a.article,
            a.article:hover {
                background: #6d7fcc !important;
                color: #fff !important;
            }

            /* ---------------------------------------------------
                CONTENT STYLE
            ----------------------------------------------------- */

            #content {
                width: 100%;
                padding: 20px;
                min-height: 100vh;
                transition: all 0.3s;
            }

            /* ---------------------------------------------------
                MEDIAQUERIES
            ----------------------------------------------------- */

            @media (max-width: 768px) {
                #sidebar {
                    margin-left: -250px;
                }
                #sidebar.active {
                    margin-left: 0;
                }
                #sidebarCollapse span {
                    display: none;
                }
            }
        </style>
    </head> 
    <body>
        <!-- navbar dung chung -->
        <div class="wrapper">
            <!-- Sidebar  -->
            <nav id="sidebar">
                <div class="sidebar-header">
                    <h3><a href="homePage"> <img class="logo" src="img/onlinelogomaker-011922-2055-7830.png" alt="" style="width: 210px" /></a> </h3> 
                </div>

                <ul class="list-unstyled components">
                    <p style="font-size: 30px; font-family: serif">Admin system</p>
                    <li class="active">
                        <a href="#homeSubmenu" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">Manage</a>
                        <ul class="collapse list-unstyled" id="homeSubmenu">
                            <li>
                                <a href="authorize">Authorise Seller</a>
                            </li>
                            <li>
                                <a href="manageAccount">Manage Account</a>
                            </li>
                            <li>
                                <a href="manageTransaction">Manage Transaction</a>
                            </li>
                            <li>
                                <a href="manageReport">Manage Report</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="#">Dashboard</a>
                    </li>
                </ul>

                <ul class="list-unstyled CTAs">
                    <li>
                        <a href="homepage" class="download">Go to homepage</a>
                    </li>
                    <li>
                        <a href="logout" class="article">Logout</a>
                    </li>
                </ul>
            </nav>

            <!-- Page Content  -->
            <div id="content">

                <nav class="navbar navbar-expand-lg navbar-light bg-light">
                    <div class="container-fluid">

                        <button type="button" id="sidebarCollapse" class="btn btn-info">
                            <i class="fas fa-align-left"></i>

                        </button>
                        <button class="btn btn-dark d-inline-block d-lg-none ml-auto" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                            <i class="fas fa-align-justify"></i>
                        </button>

                        <div class="collapse navbar-collapse" id="navbarSupportedContent">
                            <ul class="nav navbar-nav ml-auto">                 

                                <li class="nav-item">
                                    <h2>Welcome <b>admin</b></h2>
                                </li>
                            </ul>
                        </div>
                    </div>
                </nav>
                <div class="container-fluid">
                    <div class="row">
                        <div class="alert alert-${alert}">
                            ${message} 
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">x</button>
                        </div>
                        <form class="navbar-form navbar-right" action="searchManageTransaction" method="get" >  
                            <label for="orderId">OrderId:</label>
                            <input value="${orderId}" name="orderId" id="orderId" type="text" class="SearchBox" placeholder="Input orderId" pattern="\s*[0-9]\s*{1,1000}" title="Please input number">
                            <label for="buyerId">BuyerId:</label>
                            <input value="${buyerId}" name="buyerId" id="buyerId" type="text" class="SearchBox" placeholder="Input buyerId" pattern="\s*[0-9]\s*{1,1000}" title="Please input number">
                            <label for="sellerId">SellerId:</label>
                            <input value="${sellerId}" name="sellerId" id="sellerId" type="text" class="SearchBox" placeholder="Input sellerId" pattern="\s*[0-9]\s*{1,1000}" title="Please input number">
                            <br>
                            <label for="start">Start date:</label>
                            <input type="date" id="start" name="dateFrom"value="${dateFrom}">
                            <label for="end">End date:</label>
                            <input type="date" id="end" name="dateTo"value="${dateTo}">
                            <select name="sort" id="sort" onchange="this.form.submit()">  
                                <option  value="OrderId ASC" ${ sort == "OrderId ASC"?"selected":""} > Order Id ascending </option>
                                <option  value="OrderId DESC" ${ sort == "OrderId DESC"?"selected":""} > Order Id descending </option>
                                <option  value="BuyerId ASC" ${ sort == "BuyerId ASC"?"selected":""} > Buyer oldest </option>
                                <option  value="BuyerId DESC" ${ sort == "BuyerId DESC"?"selected":""} > Buyer newest </option>
                                <option  value="DateCreated ASC" ${ sort == "DateCreated ASC"?"selected":""} > Oldest </option>
                                <option  value="DateCreated DESC" ${ sort == "DateCreated DESC"?"selected":""} > Newest </option>
                                <option  value="TotalPrice ASC" ${ sort == "TotalPrice ASC"?"selected":""} > Lowest value </option>
                                <option  value="TotalPrice DESC" ${ sort == "TotalPrice DESC"?"selected":""} > Highest value </option>

                            </select> 
                            <input type="submit" class="SearchButton" />  <i class="fa fa-search"></i>
                        </form>

                    </div>
                    <div class="table-users">
                        <div class="header">List Order</div>

                        <table border="1px"  >
                            <tr>
                                <th>Order ID</th>
                                <th>Buyer Name</th>
                                <th>Date Created</th>
                                <th>Total Price</th>

                                <th width="120"></th>
                            </tr>
                            <c:forEach items="${requestScope.order}" var="o">
                                <tr>
                                    <td class="mid">${o.orderId}</td>
                                    <td class="mid">${o.buyer.buyerName}</td>
                                    <td class="mid">${o.dateCreated}</td>
                                    <td class="mid">$${o.totalPrice}</td>                                 
                                    <td class="mid"><button type="button" class="btn btn-secondary" data-toggle="modal" data-target="#exampleModal${o.orderId}">Detail</button> </td>
                                </tr>     

                                <!-- Modal -->
                                <div class="modal fade" id="exampleModal${o.orderId}">
                                    <div class="modal-dialog modal-dialog-centered">
                                        <div class="modal-content">
                                            <!-- Modal Header -->
                                            <div class="modal-header">
                                                <h4 class="modal-title">Order Detail</h4> <button type="button" class="close" data-dismiss="modal">&times;</button>
                                            </div> <!-- Modal body -->
                                            <div class="modal-body">
                                                <div class="container">
                                                    <h5>Item Details</h5>                                                   
                                                    <c:forEach items="${o.getListOrderdetail()}" var = "l">
                                                        <div class="row">
                                                            <div class="col-md-4"> <img class="img-fluid" src="${l.product.img}"> </div>
                                                            <div class="mid col-md-4" style="padding-top: 2vh;"> <a href="productDetail?pid=${l.product.id}" style="color: #007bff;text-decoration: underline;font-size: 15px">${l.product.name}</a></div>
                                                            <div class="mid col-md-1" style="padding-top: 2vh;"> <p>x${l.quantity}</p></div>
                                                            <div class="mid col-md-3" style="padding-top: 2vh;"> <p>$${l.product.price}</p></div>                                                            
                                                        </div>
                                                    </c:forEach>
                                                    <h5>Order Details</h5>
                                                    <div class="row">
                                                        <div class="col-md-6">
                                                            <ul type="none">
                                                                <li class="left">Order ID:</li>
                                                                <li class="left">Date Created:</li>
                                                                <li class="left">Buyer ID:</li>
                                                                <li class="left">Buyer Name:</li>
                                                                <li class="left">Seller ID:</li>
                                                                <li class="left">Seller Name:</li>
                                                                <li class="left" style="color: red;">Total Price:</li>
                                                            </ul>
                                                        </div>
                                                        <div class="col-md-6">
                                                            <ul class="right" type="none">
                                                                <li class="right">${o.orderId}</li>
                                                                <li class="right">${o.dateCreated}</li>
                                                                <li class="right">${o.buyer.buyerId}</li>
                                                                <li class="right">${o.buyer.buyerName}</li>
                                                                <li class="right">${o.getListOrderdetail().get(0).product.seller.sellerId}
                                                                <li class="right">${o.getListOrderdetail().get(0).product.seller.sellerName}</li>
                                                                <li class="right" style="color: red;">$${o.totalPrice}</li>
                                                            </ul>
                                                        </div>
                                                    </div>                        
                                                </div>
                                            </div> <!-- Modal footer -->
                                            <div class="modal-footer"> <button type="button" class="btn" data-dismiss="modal" >Close</button> </div>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </table>
                    </div> 
                </div>
            </div>
        </div>        
        <!-- page-wrapper -->

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
        <script>
            $(document).ready(function () {
                $('#sidebarCollapse').on('click', function () {
                    $('#sidebar').toggleClass('active');
                });
            });
        </script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
    </body>
</html>
