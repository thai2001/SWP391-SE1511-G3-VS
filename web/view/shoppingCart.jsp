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
                <h2>Shopping Carts</h2>
            </div>
        <c:if test="${empty shoppingCart}">
            <div class="nothing d-flex justify-content-center">
                <a href="productList" class="btn btn-danger ">Let Buy Something</a>
            </div>     
        </c:if>

        <div class="container">
            <div class="row  text-center">
                <p class="col-4">Product</p>
                <p class="col">Price</p>
                <p class="col">Quantity</p>
                <p class="col">Total</p>
                <p class="col">Activity</p>
            </div>
            <form action="">
                <c:forEach items="${shoppingCart}" var="cart">
                    <div class="mt-3">
                        <div class="row shopping-card-row border-top border-secondary rounded text-center">
                            <div class="col-4 d-flex">
                                <input class="selectedProduct" type="checkbox" name="selectedProduct"  value="${cart.product.id}" onclick="checkedCard(this)"> 
                                <img class="add-img" src="${cart.product.img}" alt="">
                                <p class="add-name ms-2">${cart.product.name}</p>
                            </div>
                            <p class="col" >${cart.product.price} $ </p>
                            <input type="number" name="price" class="price" value="${cart.product.price}" hidden>
                            <div class="col">

                                <i class="bi bi-dash-circle" onclick="plusMinus(this, -1)"></i><input class="w-25 quantity" type="number" max="${cart.product.quantity}" min="1"   value="1" onchange="quantityChanged(this)"> <i class="bi bi-plus-circle" onclick="plusMinus(this, 1)"></i>
                            </div>
                            <p class="col cardPrice" >${cart.product.price} $</p>
                            <p class="col"><a href="deleteCart?pid=${cart.product.id}" class="btn btn-danger delete"> Delete</a></p>
                        </div>   
                    </div> 
                </c:forEach>




                <div class="pay bg-dark p-4 rounded d-flex">
                    <div class="text-light">
                        Selected <span class="nop"> 0 </span> product 
                    </div>
                    <div class="text-light">
                        Total Price :<span class="totalPrice"> 0 $ </span> 
                    </div>
                    <input  class="btn btn-danger pay-button" type="submit" value="Pay" disabled="true"></input>
                </div>
            </form>



        </div>
        <!-- script link -->
        <script src="js/shoppingCard.js"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    </body>
</html>
