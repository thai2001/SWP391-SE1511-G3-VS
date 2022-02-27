<%-- 
    Document   : shoppingCard
    Created on : Feb 27, 2022, 8:02:13 AM
    Author     : taola
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
     <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <title>Vehicle Store</title>
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <script src="main.js"></script>
        <link rel="stylesheet" href="css/shoppingCard.css" />
        <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
            crossorigin="anonymous"
            />
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">

    </head>
    <body>
               <jsp:include page="navbar.jsp"></jsp:include>

               
               <div class="text-center p-3">
   <h2>Gio hang</h2>
 </div>
  <div class="container">
  <div class="row  text-center">
    <p class="col-4">San pham</p>
     <p class="col">Don gia</p>
     <p class="col">So luong</p>
     <p class="col">So tien</p>
     <p class="col">thao tac</p>
  </div>
  <form action="">
   
    <div class="mt-3">
       <div class="row shopping-card-row border-top border-secondary rounded text-center">
        <div class="col-4 d-flex">
          <input class="selectedProduct" type="checkbox" name="selectedProduct"  value="123" onclick="checkedCard(this)"> 
          <img class="add-img" src="sieu-xe-la-gi-muaxegiatot-vn.jpg" alt="">
          <p class="add-name ms-2">Lorem ipsum dolor sit amet consectetur adipisicing elit.</p>
        </div>
         <p class="col" >10000</p>
         <input type="number" name="price" class="price" value="10000" hidden>
         <div class="col">
           
           <i class="bi bi-dash-circle" onclick="plusMinus(this,-1)"></i><input class="w-25 quantity" type="number" max="10" min="1"   value="1" onchange="quantityChanged(this)"> <i class="bi bi-plus-circle" onclick="plusMinus(this,1)"></i>
         </div>
         <p class="col cardPrice" >0 $</p>
         <p class="col"><a href="#" class="btn btn-danger delete"> xoa</a></p>
      </div>   
    </div>


    
    <div class="mt-3">
       <div class="row shopping-card-row border-secondary border-top rounded text-center ">
        <div class="col-4 d-flex">
          <input class="selectedProduct" type="checkbox" name="selectedProduct"  value="123" onclick="checkedCard(this)"> 
          <img class="add-img" src="sieu-xe-la-gi-muaxegiatot-vn.jpg" alt="">
          <p class="add-name ms-2">Lorem ipsum dolor sit amet consectetur adipisicing elit.</p>
        </div>
         <p class="col" >10000</p>
         <input type="number" name="price" class="price" value="10000" hidden>
         <div class="col">
           
           <i class="bi bi-dash-circle" onclick="plusMinus(this,-1)"></i><input  class="w-25 quantity" type="number" max="10" min="1"  value="1" onchange="quantityChanged(this)"> <i class="bi bi-plus-circle" onclick="plusMinus(this,1)" ></i>
         </div>
         <p class="col cardPrice" >0 $</p>
         <p class="col"><a href="#" class="btn btn-danger delete"> xoa</a></p>
      </div>
    </div>

    <div class="pay bg-dark p-4 rounded d-flex">
      <div class="text-light">
        Da chon <span class="nop"> 0 </span> san pham 
      </div>
      <div class="totalPrice text-light">
        tong tien : 1000$
      </div>
      <input  class="btn btn-danger pay-button" type="submit" value="Pay" ></input>
    </div>
  </form>
  
  
  
</div>
               <!-- script link -->
        <script src="js/shoppingCard.js"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    </body>
</html>
