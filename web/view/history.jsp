<%-- 
    Document   : history
    Created on : Mar 13, 2022, 9:23:49 PM
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
        <link rel="stylesheet" href="css/history.css" />
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous" />
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
        <!-- script link -->
        <script src="history.js" defer></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>


    </head>

    <body>
        <jsp:include page="navbar.jsp"></jsp:include>

            <div class="text-center p-3">
                <h2>History</h2>
            </div>
            <div class="container">
                <div class="row  text-center">
                    <h4 class="col">No</h4>
                    <h4 class="col">Order ID</h4>
                    <h4 class="col">Date</h4>
                    <h4 class="col">Total Price</h4>
                    <h4 class="col">Total product</h4>
                    <h4 class="col">Detail</h4>
                </div>
            <c:if test="${history == null}">
                <div class="nothing d-flex justify-content-center">
                    <a href="#" class="btn btn-danger ">Let Buy Something</a>
                </div> 
            </c:if>
            <c:if test="${createOrderSuccess != null}">
                <div class="text-success text-center">${createOrderSuccess}</div>
            </c:if>
            <c:forEach items="${history}" var="o" varStatus="loop">

                <!-- a history card -->
                <div class="mt-3">
                    <div class="row history-card-row border-top border-secondary rounded text-center">
                        <!-- new row -->
                        <div class="row mt-3">
                            <div class="col ">
                                <p>${loop.count}</p>
                            </div>
                            <div class="col ">
                                <p>${o.orderId}</p>
                            </div>
                            <div class="col">
                                <p class="date">${o.dateCreated}</p>
                            </div>
                            <div class="col">
                                <p class="text-danger">${o.totalPrice} $</p>
                            </div>
                            <div class="col">
                                <p class="">${o.totalProduct}</p>
                            </div>
                            <div class="col">
                                <a href="orderDetail?oid=${o.orderId}" class="btn btn-primary"> View</a>
                            </div>
                        </div>


                    </div>


                </div>
                <!-- end a  card -->
            </c:forEach>


 <c:if test="${numberOfOrderPage != 0}">
                    <div class="pt-3 d-flex justify-content-center">
                        <nav aria-label="Page navigation example">
                            <ul class="pagination">
                                <li class="page-item"><a class="page-link" href="#">Previous</a></li>
                                <c:forEach begin="1" end="${numberOfOrderPage}" var="index"><li class="page-item ${index==pi?"active":""} "><a class="page-link " href="history?pi=${index}">${index}</a></li></c:forEach>
                                    <li class="page-item"><a class="page-link" href="#">Next</a></li>
                                </ul>
                            </nav>

                        </div>
                </c:if>

        </div>








    </body>

</html>
