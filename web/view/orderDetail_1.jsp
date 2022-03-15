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
    <link rel="stylesheet" href="css/orderDetail.css" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous" />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
    <!-- script link -->
    <script src="js/orderDetail.js" defer></script>
     <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>


</head>

<body>
        <jsp:include page="navbar.jsp"></jsp:include>

    <div class="text-center p-3">
        <h2>Order Detail</h2>
    </div>
    <div class="container">
        <div class="row  text-center">
            <p class="col-4">Product</p>
            <p class="col">Price</p>
            <p class="col">Quantity</p>
            <p class="col">Total</p>
            <p class="col">Activity</p>

        </div>
        <c:if test="${mess != null}">
                <div class="text-success text-center">${mess}</div>
            </c:if>
        <c:if test="${empty orderDetails }">
        <div class="nothing d-flex justify-content-center">
            <a href="#" class="btn btn-danger ">Let Buy Something</a>
        </div> 
    </c:if>
    <c:forEach items="${orderDetails}" var="o">
         <!-- new order detail card -->
            <div class="mt-3">
                <div class="row detail-card-row border-top border-secondary rounded text-center">
                    <div class="row mt-3">
                    <div class="col-4 d-flex">

                        <img class="add-img" src="${o.product.img}" alt="">
                        <p class="add-name ms-2">${o.product.name}</p>
                    </div>
                    <p class="col">${o.product.price}</p>
                    <input type="number" name="price" class="price" value="${o.product.price}" hidden>
                    <div class="col">

                        <p class=" quantity">${o.quantity}</p>
                        <input type="number" value="" name="quantity" hidden>
                    </div>
                    <p class="col cardPrice">${o.product.price * o.quantity} $</p>
                    <div class="col">
                        <a href="deleteOrderDetail?oid=${o.orderId}&&pid=${o.product.id}" class="btn btn-danger delete" > Delete</a>
                    </div>
                </div>


                    <div class="row mt-3">
                        <div class="col text-start">
                            <textarea type="text" placeholder="message for seller" class="message" readonly></textarea>
                        </div>
                        <div class="col">
                            <p>Date Take : </p>
                        </div>
                        <div class="col">
                            from : <span class="from">  </span> <br> to : <span class="to"></span>
                            <input type="date" name="from" value="${o.start}" hidden >
                            <input type="date" name="to" value="${o.end}" hidden >


                        </div>
                        <div class="col">
                            <p class="text-center">Deliver Price </p>

                        </div>
                        <div class="col">
                            <p class="deliver-price text-center">500 $ </p>
                        </div>
                        <div class="col">

                        </div>

                    </div>
                    <div class="row mt-3">
                        <div class="col text-start">
                        </div>
                        <div class="col">

                        </div>
                        <div class="col">
                        </div>
                        <div class="col">
                            <h3 class="text-center "> </h3>

                        </div>
                        <div class="col">
                            <p class=" text-center text-danger card-total">${o.product.price * o.quantity + 500} $ </p>
                        </div>
                        <div class="col">
                            <button  class="btn btn-primary period-btn" onclick="showPeriod(this)"> Period</button>
                        </div>
                    </div>
                    <div class="row mt-3 period ">
                        <div class="col">
                            <div class="period-indicator active">
                                <span class="blink active"></span>
                                <h4>Ordered</h4>
                            </div>

                        </div>
                        <div class="col">
                            <div class="period-indicator">
                                <span class="blink"></span>
                                <h4>Shipping</h4>
                            </div>
                        </div>
                        <div class="col">
                            <div class="period-indicator">
                                <span class="blink"></span>
                                <h4>Finished</h4>
                            </div>
                        </div>
                        
                    </div>
                </div>
                </div>
                <!-- end a history card -->
    </c:forEach>
       

       


    </div>





</body>

</html>