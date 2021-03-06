<%-- 
    Document   : ManageReport
    Created on : Feb 7, 2022, 12:20:46 AM
    Author     : nqt26
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
    <!DOCTYPE html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Manage Report</title>
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
             .pagination {
                display: inline-block;
                margin: 0 auto;
            }
            .pagination a {
                color: black;
                font-size: 22px;
                float: left;
                padding: 8px 16px;
                text-decoration: none;
            }
            .pagination a.active {
                background-color: #4CAF50;
                color: white;
            }
            .pagination a:hover:not(.active) {
                background-color: chocolate;
            }
            /* Paging */
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
                    <h1 style="text-align: center">Manage Report</h1>
                    <div class="row">
                        <c:if test="${ message != null }">
                            <div class="alert alert-${alert}">
                                ${message} 
                                <button type="button" class="close" data-dismiss="alert" aria-label="Close">x</button>
                            </div>
                        </c:if>
                        <form class="navbar-form navbar-right" action="searchManageReport" method="get" >
                            <label id="reportTypeId"> Report type </label>
                            <select name="reportTypeId" id="reportTypeId" onchange = "this.form.submit()">
                                <option value="0" > All report type </option>
                                <c:forEach items="${requestScope.reportType}" var="r">
                                    <option  value="${r.reportTypeId}" ${ r.reportTypeId == reportTypeId?"selected":""}> ${r.reportTypeName} </option>
                                </c:forEach> 
                            </select> 
                            <label id="buyerId"> Buyer ID </label>
                            <input value="<c:if test="${buyerId > 0}" >${ buyerId }</c:if>" name="buyerId" id="buyerId" type="text" class="SearchBox" placeholder="Nh???p buyerId" pattern="\s*[0-9]\s*{1,1000}" title="Please input number">
                                <label id="productId"> Product ID </label>
                                <input value="<c:if test="${productId > 0}" >${ productId }</c:if>" name="productId" id="productId" type="text" class="SearchBox" placeholder="Nh???p productId" pattern="\s*[0-9]\s*{1,1000}" title="Please input number">
                                <input type="submit" class="SearchButton" />  <i class="fa fa-search"></i>
                                <br>
                                <br>
                                <label id="sort"> Sort </label>
                                <select name="sort" id="sort" onchange="this.form.submit()">                                                
                                    <option  value="reportId ASC" ${ sort == "reportId ASC"?"selected":""} > Report Id t??ng d???n </option>
                                <option  value="reportId DESC" ${ sort == "reportId DESC"?"selected":""} > Report Id gi???m d???n </option>
                            </select> 
                            <br>
                            <p> Show 
                            <select name="numPerPage" id="numPerPage" onchange="this.form.submit()">
                                <option  value="2" ${ numPerPage == 2?"selected":""} >2</option>
                                <option  value="3" ${ numPerPage == 3?"selected":""} >3</option>
                                <option  value="5" ${ numPerPage == 5?"selected":""} >5</option>
                            </select>
                             of  ${listSize} entries 
                            </p>

                        </form>

                    </div>
                    <c:if test="${report.isEmpty()}">
                        <div class="alert alert-info">
                            Kh??ng c?? k???t qu??? t??m ki???m
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">x</button>
                        </div>

                    </c:if>
                    <c:if test="${report.size() > 0}">
                        <div class="table-users">
                            <div class="header">List Report</div>

                            <table border="1px"  >
                                <tr>
                                    <th>ReportId</th>
                                    <th>Reporter</th>
                                    <th>ProductName</th>
                                    <th>Report Type</th>
                                    <th width="120"></th>
                                </tr>
                                <c:forEach items="${requestScope.report}" var="r">
                                    <tr>
                                        <td class="mid">${r.reportId}</td>
                                        <td class="mid">${r.buyerId.buyerName}</td>
                                        <td class="mid"><a href="productDetail?pid=${r.productId.id}" style="color: #007bff;text-decoration: underline">${r.productId.name}</a></td>
                                        <td class="mid">${r.reportTypeId.reportTypeName}</td>
                                        <td class="mid"><button type="button" class="btn btn-secondary" data-toggle="modal" data-target="#reportModal${r.reportId}" style="font-size: 10px;height: 75%">Detail</button> </td>
                                    </tr>     

                                    <!-- Modal -->
                                    <div class="modal fade" id="reportModal${r.reportId}" tabindex="-1" role="dialog" aria-labelledby="exampleModalScrollableTitle" aria-hidden="true"> 
                                        <div class="modal-dialog modal-dialog-scrollable" role="document">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <h5 class="modal-title" id="exampleModalScrollableTitle" style="font-size: 30px;margin: 0 auto">Report detail </h5>                                                                                                    
                                                    <br/>
                                                </div>
                                                <div>
                                                    <div class="modal-body">
                                                        <div class="form-group">
                                                            <label for="buyerId">ReportId</label>
                                                            <input type="text" class="form-control" id="buyerId" name="buyerId" value="${r.reportId}" readonly >
                                                        </div>
                                                        <div class="row">
                                                            <div class="form-group col-md-3">
                                                                <label for="sellerName">Reporter ID</label>
                                                                <input type="text" class="form-control" id="sellerName" name="sellerName" value="${r.buyerId.buyerId}" readonly >
                                                            </div>
                                                            <div class="form-group col-md-9">
                                                                <label for="sellerDes">Reporter Name</label>
                                                                <input type="text"  class="form-control" id="sellerDes" name="sellerDes" value="${r.buyerId.buyerName}" readonly>
                                                            </div>  
                                                        </div>
                                                        <div class="row">
                                                            <div class="form-group col-md-3 ">
                                                                <label for="sellerAddress">Product ID</label>
                                                                <input type="text" class="form-control" id="sellerAddress" name="sellerAddress" value=" ${r.productId.id}" readonly >
                                                            </div>
                                                            <div class="form-group col-md-9">
                                                                <label for="sellerGmail">Product Name</label>
                                                                <input type="text" class="form-control" id="sellerGmail" name="sellerGmail" value="${r.productId.name}" readonly>
                                                            </div>
                                                        </div>
                                                        <div class="row" >
                                                            <div class="form-group col-md-3">
                                                                <label for="sellerPhone">Seller ID</label>
                                                                <input type="text" class="form-control" id="sellerPhone" name="sellerPhone" value="${r.seller.sellerId}" readonly>
                                                            </div>
                                                            <div class="form-group col-md-9">
                                                                <label for="sellern">Seller Name</label>
                                                                <input type="text" class="form-control" id="sellern" name="sellern" value="${r.seller.sellerName}" readonly>
                                                            </div>
                                                        </div>
                                                        <div class="form-group">
                                                            <label for="sellerGmail">Report type</label>
                                                            <input type="text" class="form-control" id="sellerGmail" name="sellerGmail" value="${r.reportTypeId.reportTypeName}" readonly>
                                                        </div>
                                                        <div class="form-group">
                                                            <label for="numProductsOnSale">Content</label>
                                                            <textarea  class="form-control" id="numProductsOnSale" name="numProductsOnSale"  readonly>${r.content}</textarea>
                                                        </div>
                                                    </div>
                                                    <div class="modal-footer">
                                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>                                                            
                                                    </div>          
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
                            </table>
                        </div> 
                        <div class="pagination ">
                            <c:forEach begin="1" end="${requestScope.num}" var="i">
                                <a class="${requestScope.page==i?"active":""}" href="${url}page=${i}&numPerPage=${numPerPage}"> 
                                    ${i}</a>
                                </c:forEach>
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

