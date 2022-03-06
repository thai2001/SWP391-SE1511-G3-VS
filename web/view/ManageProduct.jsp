
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link href="https://fonts.googleapis.com/css?family=Poppins:100,200,300,400,500,600,700,800,900&display=swap" rel="stylesheet">

    <title>Vehicle Shopping</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <style>
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
    width: 180px;
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
.row0 select{
    width: 100px;
    height: 30px;
    margin-bottom: -10px;
    margin-top: 10px;
}

 .pagination {
                 display: inline-block;
              }
             .pagination a {
                color: black;
                font-size: 15px;
                float: left;
                padding: 8px 16px;
                text-decoration: none;
              }
            .pagination a.active {
                background-color: red;
                color: white;
              }
            .pagination a:hover:not(.active) {
                background-color: red;
            }
    </style>
<!--

-->

    <!-- Additional CSS Files -->

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    
   
<link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
      crossorigin="anonymous"
    />
  </head>

  <body>


    <!-- Header -->
     <header>
      <nav class="navbar bg-dark navbar-dark text-light">
        <a href="#"> <img src="img/logo/onlinelogomaker-011922-2055-7830.png" alt="" /></a>
        <div class="navlink">
          <a class="nav-link link-light " href="#">Login</a>
          <a class="nav-link link-light " href="#">Login</a>
          <a class="nav-link link-light " href="#">Sign up</a>
              
 
      </div>
      </div>
    </nav>
  </header>

    <!-- Page Content -->
    <div class="container-lg">
    <div class="table-responsive">
        <div class="table-wrapper">
            <div class="table-title">
                <div class="row">
                    <div class="col-sm-4"><a class="link-dark" href="manageproduct">Manage <b>Products</b></a></div>
                    <div class="col-sm-4"><a class="link-dark" href="#">Report <b>List</b></a></div>
                    <div class="col-sm-4"><a class="link-dark" href="#">Pre-order <b>Customers</b></a></div>
                </div>
                <div class = "row0">
                 <select name="brandid" onchange="location = this.value;">
                <option value="0">Brand</option>
                <c:forEach items="${requestScope.brand}" var="o">
                    <option  value="searchbrandforseller?brandid=${o.id}"> ${o.name} </option>
                </c:forEach> </select>
                </div>
                <div class="row1">
                    <form class="navbar-form navbar-right" action="searchproductforseller" method="get" >
                        
                    
                        
                <input value="${prodname}" name="productname" type="text" class="SearchBox" placeholder="Product Name"></li>
          
               <input type="submit" class="SearchButton" value="Search"\>  <i class="fa fa-search"></i></li>
          
       
    </form>
            <a href="loadaddproduct" type="button" class="btn btn-info add-new"><i class="fa fa-plus"></i> Add New</a>
                    </div>
            </div>
            
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>User ID</th>
                        <th>Product Name</th>
                        <th>Image</th>
                        <th>MadeIn</th>
                        <th>Price</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${requestScope.product}" var="o">
                    <tr>
                        <td>
                            ${o.sellerId}
                        </td>
                        <td>
                            ${o.name}
                        </td>
                        <td>
                            <img src="${o.img}">
                        </td>
                        <td>${o.madeIn}</td>
                        <td>${o.price}Đ</td>
                        <td>
                        
                            <a href="loadeditproduct?pid=${o.id}" class="edit" title="Edit" data-toggle="tooltip"><i class="fa fa-pencil" aria-hidden="true"></i></a>
                            <a href="deleteproduct?pid=${o.id}" class="delete" title="Delete" data-toggle="tooltip"><i class="fa fa-trash" aria-hidden="true"></i></a>
                        </td>
                    </tr>
                    </c:forEach>
                </tbody>
            </table>
                <c:if test="${num != 0}">
                        <div class="pagination">
        <c:forEach begin="1" end="${num}" var="i">
            <a class="${requestScope.page==i?"active":""}"
               href="manageproduct?page=${i}"> ${i} <a/>
            </c:forEach>
                    
        </div>
      </c:if>
        </div>
    </div>
</div>  
            
    
                

    
 


    <!-- Bootstrap core JavaScript -->
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.bundle.min.js"></script>


    <!-- Additional Scripts -->
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
      crossorigin="anonymous"
    ></script>
    <script
      src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
      integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
      crossorigin="anonymous"
    ></script>
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
      integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
      crossorigin="anonymous"
    ></script>


    <script language = "text/Javascript"> 
      cleared[0] = cleared[1] = cleared[2] = 0; 
      function clearField(t){                   
      if(! cleared[t.id]){                    
          cleared[t.id] = 1;  
          t.value='';         
          t.style.color='#fff';
          }
      }
    </script>


  </body>

</html>
