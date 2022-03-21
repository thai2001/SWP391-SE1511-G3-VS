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
    margin-bottom: -10px;
    margin-top: 20px;
    margin-left: 900px;
}
.row h2{
    font-size: 30px;

}
.row a{
    font-size: 35px;
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
 #orderdetail{
    width: 750px;
}

.table-wrapper{
      width: 1200px;
      
  }
  .table-title{
      margin-top: -80px;
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
       <jsp:include page="navbar.jsp"></jsp:include>

    <!-- Page Content -->
    <div class="container-lg">
    <div class="table-responsive">
        <div class="table-wrapper">
            <div class="table-title">
                <div class="row">
                    <div class="col-sm-4"><a class="link-dark" href="manageproduct">Manage <b>Products</b></a></div>
                    <div class="col-sm-4"><a class="link-dark" href="manageorder">Orders <b>History</b></a></div>
                    <div class="col-sm-4"><a class="link-dark" href="managecustomer">Customer <b>Notification</b></a></div>
                </div>
                 <div class="row1">
                    <form class="navbar-form navbar-right" action="searchorderforseller" method="get" >
                        
                    
                        
                <input value="${datecreated}" type="date" id="date" name="datecreated"
                              
                               min="2018-01-01" max="2022-12-31" style="border-radius: 5px;"></li>
          
               <input type="submit" class="SearchButton" value="Search" style="border-radius: 5px;">  <i class="fa fa-search"></i></li>
          
       
    </form>
                    </div>
                
            </div>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>OrderID</th>
                        <th>Buyer Name</th>
                        <th>Date Created</th>
                        <th>TotalPrice</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${requestScope.orderdt}" var="odt">
                    <tr>
                        <td>                          
                            ${odt.orderId}
                        </td>
                        <td>${odt.buyer.buyerName}</td>
                           <td>                          
                            ${odt.dateCreated}
                        </td>
                            
                       
                        <td>$${odt.totalPrice}</td>
                        <td><a href="#orderdetail${odt.orderId}" type="button" class="btn btn-info" data-toggle="modal" style="background-color: #ff6666"> Detail</a></td>
                    </tr>
                      <div id="orderdetail${odt.orderId}" class="modal fade">
            <div class="modal-dialog">
                 <div class="modal-content">                   
                        <div class="modal-header">						
                            <h4 class="modal-title" style="font-size:35px; ">Order #${odt.orderId}</h4>
                            
                        </div>
                        <div class="modal-body">
                             <c:forEach items="${odt.getListOrderdetail()}" var="ordt">
                                 <div class="row">
                                     
                                      <div class="col-md-4"> <img class="img-fluid" src="${ordt.product.img}">  </div>
                                      <div class="mid col-md-4" style="padding-top: 2vh;"> <input type="text" class="form-control"  value="${ordt.product.name}" style="color:#333333; width:100px;" readonly> </div>
                                      <div class="mid col-md-1" style="padding-top: 2vh;"> <p>x${ordt.quantity}</p></div>
                                      <div class="mid col-md-3" style="padding-top: 2vh;"> <p>$${ordt.product.price}</p></div>                                                            
                                                          
                                 </div>
                             </c:forEach>
                            
                            <div class="row">
                                       <div class="col-md-6">
                                     <div class="form-group-7">
                                <label>Customer ID</label>
                                <input name="CusID" type="text" class="form-control" value="${odt.buyer.buyerId}" readonly>
                                     </div>
                                     <div class="form-group-7">
                                <label>Customer Name</label>
                                <input name="CusName" type="text" class="form-control" value="${odt.buyer.buyerName}" readonly>
                                     </div>
                                      <div class="form-group-7">
                                <label>Created Date</label>
                                <input name="CreateDate" type="text" class="form-control" value="${odt.dateCreated}" readonly>
                                      </div>
                            
                              <div class="form-group-7">
                                <label>Brand</label>
                                <input name="brand" class="form-control" value="${odt.getListOrderdetail().get(0).product.brand.name}" readonly></input>
                              </div>
                                
          </div>
     
                                 <div class="form-group-7">
                               <label>Total Price</label>
                                <h5 style="font-size: 36px;"> $${odt.totalPrice} </h5>
                                 </div>
                                  
                        </div>
                       
                </div>
            </div>
            </div>
        </div>
                    </c:forEach>
                </tbody>
            </table>
           <c:if test="${num != 0}">
                        <div class="pagination">
        <c:forEach begin="1" end="${num}" var="i">
            <a class="${requestScope.page==i?"active":""}"
               href="searchorderforseller?page=${i}&datecreated=${datecreat}"> ${i} <a/>
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
