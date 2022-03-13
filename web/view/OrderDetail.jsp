

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
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">


<link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
      crossorigin="anonymous"
    />

    <!-- Additional CSS Files -->

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    
    <style>
.table-title {
    width: 1100px;
    margin: 30px auto;
    background: #fff;
    padding: 20px;	
    box-shadow: 0 1px 1px rgba(0,0,0,.05);
    padding-top: 150px;
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

.fade{
    padding-top: 80px;
}
.form-group input{
    width:180px;
    height: 30px
}
.btn-danger{
width: 140px;
border-radius: 20px;
}
#orderdetail{
    width: 750px;
}
.modal-content{
    width: 1000px;
}
img{
    width: 50%;
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
    margin-bottom: -100px;
}
.container h2{
    font-size: 40px;
}
</style>
  </head>

  <body>


    <!-- Header -->
      <jsp:include page="navbar.jsp"></jsp:include>

    <!-- Page Content -->
     
    <div class="container">

        <div class="table-wrapper">
                <div class="table-title">
                    <div class="row">
                        <div class="col-sm-6">
                            <h2>Order <b>Detail</b></h2>
                        </div>
                        <div class="col-sm-6">
                        </div>
                    </div>
                </div>
        </div>
           
<div id="orderdetail" >
            <div class="modal-dialog">
                <div class="modal-content">
                    
                        <div class="modal-header">						
                            <h4 class="modal-title">Order #${odt.orderId}</h4>
                            
                        </div>
                        <div class="modal-body">
                            <div class="row">
                                 <div class="col-md-6">
                               
                                <label>Product Name</label>
                                <input name="ProductName" class="form-control" value="${odt.product.name}" readonly></input>
                            
                            
                                <label>Customer Name</label>
                                <input name="CusName" type="text" class="form-control" value="${odt.buyer.buyerName}" readonly>
                            
                            
                                <label>Created Date</label>
                                <input name="CreateDate" type="text" class="form-control" value="${odt.order.dateCreated}" readonly>
                           
                            
                             
                                <label>Brand</label>
                                <input name="brand" class="form-control" value="${odt.brand.name}" readonly></input>
                            
                                
                                <label>Quantity</label>
                                <input name="quantity" class="form-control" value="${odt.quantity}" readonly></input>
                            
          
                          
                            </div>
                               
                            <div class="col-md-6">
                             <div class="form-group">
                                <label></label>
                               <img src="${odt.product.img}">
                                
                            </div>
                            </div>
                            
                             
                                <label>Total Price</label>
                                <h5 style="font-size: 36px; margin-left: 230px;"> ${odt.order.totalPrice} VNĐ</h5>
                           
                        </div>
                       
                </div>
            </div>
        </div>
       </div>
 
    
    </div>
    

    
   


    <!-- Bootstrap core JavaScript -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
 

    


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



