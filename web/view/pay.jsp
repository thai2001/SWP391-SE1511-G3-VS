<%-- 
    Document   : pay
    Created on : Mar 13, 2022, 2:39:20 PM
    Author     : taola
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <title>Vehicle Store</title>
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link rel="stylesheet" href="css/pay.css" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous" />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
    <!-- script link -->
    <script src="js/pay.js" defer></script>
    <!-- script link -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

</head>

<body>
     <jsp:include page="navbar.jsp"></jsp:include>
    <div class="text-center p-3">
        <h2>Payment</h2>
    </div>
    <div class="container">
        <div class="row  text-center">
            <p class="col-4">Product</p>
            <p class="col">Price</p>
            <p class="col">Quantity</p>
            <p class="col">Total</p>
        </div>
        <form method="post" action="createOrder">
            <input type="date" name="today"  value="" hidden>
        <c:forEach items="${list}" var="p">
            <div class="mt-3">
<!--                <h3>seller name</h3>-->
                <!-- a shopping cart -->
                <div class="row shopping-card-row border-top border-secondary rounded text-center">
                    <!-- new row -->
                    <div class="row mt-3">
                    <div class="col-4 d-flex">
                        <input type="checkbox" name="pid" value="${p.key.id}" hidden checked>
                        <img class="add-img" src="${p.key.img}" alt="">
                        <p class="add-name ms-2">${p.key.name}</p>
                    </div>
                    <p class="col">${p.key.price} $ </p>
                    <input type="number" name="price" class="price" value="${p.key.price}" hidden>
                    <div class="col">

                        <p class=" quantity">${p.value}</p>
                        <input type="number" value="${p.value}" name="quantity" hidden>
                    </div>
                    <p class="col cardPrice">${p.key.price*p.value} $</p>
                    </div>
<!-- new row -->
                    <div class="row mt-3">
                        <div class="col text-start">
                            <textarea type="text" placeholder="message for seller" class="message"></textarea>
                        </div>
                        <div class="col">
                            <p>Date Take : </p>
                        </div>
                        <div class="col">
                            from : <span class="from">  </span> <br> to : <span class="to"></span>
                            <input type="date" name="from" value="" hidden >
                            <input type="date" name="to" value="" hidden>


                        </div>
                        <div class="col">
                            <p class="text-center">Deliver price</p>

                        </div>
                        <div class="col">
                            <p class="deliver-price text-center">500 $ </p>
                        </div>

                    </div>
                    <!-- new row -->
                    <div class="row mt-3">
                        <div class="col text-start">
                        </div>
                        <div class="col">

                        </div>
                        <div class="col">
                        </div>
                        <div class="col">

                        </div>
                        <div class="col">
                            <p class=" text-center text-danger card-total">${p.key.price*p.value + 500} $ </p>
                        </div>

                    </div>
                </div>
                <!-- end a shopping cart -->

               
                    </div>
</c:forEach>




                    <div class="pay bg-dark p-4 rounded d-flex">
                        <div class="text-light">
                            Selected <span class="nop"> </span> Product
                        </div>
                        <div class="totalPrice text-light">
                        </div>
                                                    <input type="number" value="" name="total"  hidden>

                        <input class="btn btn-danger pay-button" type="submit" value="Pay"></input>
                    </div>
        </form>



    </div>





</body>

</html>