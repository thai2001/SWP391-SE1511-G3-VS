

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
#editProduct{
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

  <body style="background-color: #fffdf9;  background-image: url('https://carconfigurator.ferrari.com/assets/cars/portofinom/packages/default/car-ferrari-portofino-m_splash.jpg')">


    <!-- Header -->
      <jsp:include page="navbar.jsp"></jsp:include>

    <!-- Page Content -->
     
    <div class="container">

        <div class="table-wrapper" style="border-radius: 15px;">
                <div class="table-title" style="border-radius: 15px; width: 1000px;margin-left: 120px;">
                    <div class="row">
                        <div class="col-sm-6">
                            <h2>Edit <b>Product</b></h2>
                        </div>
                    </div>
                </div>
        </div>
           
<div id="editProduct">
            <div class="modal-dialog">
                <div class="modal-content" style="border-radius: 15px;">
                    <form action="editproduct" method="post">
                        <div class="modal-header">						
                            <h4 class="modal-title" style='font-size: 35px;'>Product's<b> Info</b></h4>
                            <p style="color:green;font-size: 25px;">${alert}</p>
                        </div>
                        <div class="modal-body">
                            <div class="row">
                             
                            <div class ="col-md-4">
                                <div class="form-group">
                                <label>ProductID</label>
                                <input value="${product.id}" name="productid" class="form-control" readonly="" required></input>
                            </div>
                            <div class="form-group">
                                <label>Product Name</label><p style="color:red">${alert1}</p>
                                <input minlength="5" maxlength="100" value="${product.name}" name="proname" class="form-control" required></input>
                            </div>
                            
                            <div class="form-group">
                                <label>Price</label>
                                <input min="100000" max="9000000" value="${product.price}" name="price" type="number" class="form-control" required placeholder="VN??">
                            </div>
                            <div class="form-group">
                                <label>Discount</label>
                                <input  min="0" max="90" value="${product.discount}" name="discount" type="number" class="form-control" required placeholder="%">
                            </div>
                           
                                <div class="form-group">
                                <label>Brand</label>
                                <select name="brand" class="form-select" aria-label="Default select example">
                                    <c:forEach items="${requestScope.brand}" var="o">
                                        <option value="${o.id}">${o.name}</option>
                                    </c:forEach>
                                </select>
                             </div>
                             <div class="form-group">
                                <label>VehicleType</label>
                                <select name="type" class="form-select" aria-label="Default select example">
                                    <c:forEach items="${requestScope.vehicleType}" var="o">
                                        <option value="${o.vehicleTypeId}">${o.vehicleTypeName}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            </div>
       
                            
                                <div class="col-md-4">
                                
                            
                            <div class="form-group right" >
                                <label>Manufacture Year</label>
                                <input min="1990" max="2022" value="${product.manufactureYear}" name="Myear"  type="number" class="form-control" required></input>
                            </div>
                            <div class="form-group right">
                                <label>Made In</label><p style="color:red">${alert3}</p>
                                <input minlength="3" maxlength="20" value="${product.madeIn}"name="MadeIn" pattern="^[a-zA-Z]*$" title="Number not allowed" type="text" class="form-control" required></input>
                            </div>
                            <div class="form-group right">
                                <label>Quantity</label>
                                <input value="${product.quantity}" min="1" max="200" name="quantity" type="number" class="form-control" required></input>
                            </div>
                            </div>
                            
                            <div class="col-md-4">
                                <div class="form-group">
                                <label>Image</label><p style="color:red">${alert5}</p>
                                <input minlength="10" maxlength="1000"  type="text" value="${product.img}" name="image" class="form-control" required></input>
                            </div>
                            </div>
                            </div>
                                
                            
                            
                            
                            <div class="form-group">
                                <label>Description</label><p style="color:red">${alert2}</p>
                                <textarea  minlength="10" maxlength="3000" name="description" class="form-control" required>${product.descript}</textarea>
                            </div>
                            

                        </div>
                        
                       
                        
                        <div class="modal-footer">
                            <a href="manageproduct" type="button" class="btn btn-default" data-dismiss="modal" >Cancel </a>
                            <input type="submit" class="btn btn-danger" value="Edit">
                        </div>
                    </form>
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


