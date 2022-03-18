<%-- 
    Document   : brandList
    Created on : Feb 18, 2022, 12:06:04 PM
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
        <link rel="stylesheet" href="css/style.css" />
        <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
            crossorigin="anonymous"
            />
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">

    </head>
    <body>
        <!-- navbar dung chung -->
        <jsp:include page="navbar.jsp"></jsp:include>
            <!-- class container chua tat ca cac phan chinh -->
            <div class="container">

                <!-- brand --> 
                <!-- dang can sua them -->
                <div class=" bg-light text-dark">
                    <h3 class="text-center pt-4">Brand</h3>
                    <br>
                    <div class="p-5">
                        <div class="row">
                            <c:forEach items="${allBrand}" var="b" >
                            <div class="col-sm-6 col-md-3 mt-3">

                                <div class="box rounded brand bg-dark d-flex flex-column text-light p-4 h-100">
                                    <div class="card-img">
                                        <img class="rounded product-img" src="${b.img}" alt="">
                                    </div>
                                    <h2 class="text-center mt-auto">${b.name}</h2>             
                                    <div class="mt-auto text-end">
                                        <button type="button" class="btn" > <a class="btn btn-outline-secondary " href="productList?bid=${b.id}&&vtid=1">See more >></a></button>
                                    </div>

                                </div>
                                </div>
                        </c:forEach>



                    </div>
                </div>
               
            </div>

        </div>
        <!-- end container part -->
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

        <!-- script link -->
        <script src="js/slideJs.js"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    </body>
</html>
