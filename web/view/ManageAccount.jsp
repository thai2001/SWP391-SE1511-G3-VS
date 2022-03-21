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
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Manage Account</title>
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
                        <a href="#" class="article">Logout</a>
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
                    <h1 style="text-align: center">Manage Account</h1>
                    <c:if test="${ message != null }">
                        <div class="alert alert-${alert}">
                            ${message} 
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">x</button>
                        </div>
                    </c:if>

                    <div class="row">

                        <form class="navbar-form navbar-right" action="searchAccount" method="get" >
                            <label id="roleId">Role</label>
                            <select name="roleId" id="roleId">                                       
                                <c:forEach items="${requestScope.role}" var="r">
                                    <option  value="${r.roleId}" ${r.roleId == roleId?"selected":""} > ${r.roleName} </option>
                                </c:forEach> 
                            </select> 
                            <label id="id">User ID</label>
                            <input value="${id}" id="id" name="id" type="text" class="SearchBox" placeholder="Id" pattern="\s*[0-9]\s*{1,1000}" title="Number is required" required>

                            <input type="submit" class="SearchButton" />  <i class="fa fa-search"></i>
                        </form>

                    </div>
                    <c:if test="${ searchAccount == null}"> 
                        <div class="alert alert-info">
                            Have not entered search data yet or no search result found !
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">x</button>
                        </div> 
                    </c:if>       
                    <c:if test="${ searchAccount != null}">
                        <div class="table-users">
                            <div class="header"> Account detail</div>

                            <table border="1px"  >
                                <tr>
                                    <th>Username</th>
                                    <th>Role</th>
                                    <th>Status</th>
                                    <th width="120"></th>
                                </tr>                                  
                                <tr>
                                    <td class="mid">${searchAccount.username}</td>
                                    <td class="mid">${searchAccount.roleId.roleName}</td>
                                    <td class="mid" style="color:${searchAccount.status == "active" ?"green":"red"};">${searchAccount.status}</td>
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
                                                <c:if test="${ searchAccount.roleId.roleId == 2 }">
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
                                                        <button type="button" class="btn btn-secondary"><a href="changeAccountStatus?id=${buyer.buyerId}&roleId=2&status=${a.status}" style="font-size: 15px;color: white">Change status</a></button>
                                                    </div>
                                                </c:if>
                                                <c:if test="${ searchAccount.roleId.roleId == 3 }">
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
                                                        <button type="button" class="btn btn-secondary"><a href="changeAccountStatus?id=${seller.sellerId}&roleId=3&status=${searchAccount.status}" style="font-size: 15px;color: white">Change status</a></button>
                                                    </div>
                                                </c:if>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </table>
                        </div> 
                    </c:if>
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
