<%-- 
    Document   : homePage
    Created on : Jan 20, 2022, 8:08:29 AM
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
                <!-- silde show container -->
                <div class="slideshow-container">
                    <div class="mySlides fade">
                        <div class="numbertext">1 / 3</div>
                        <img class="slideImg" src="img/sieu-xe-la-gi-muaxegiatot-vn.jpg" alt="" />
                        <div class="text">Caption Text</div>
                    </div>

                    <div class="mySlides fade">
                        <div class="numbertext">2 / 3</div>
                        <img class="slideImg" src="img/sieu-xe-la-gi-muaxegiatot-vn.jpg" alt="" />
                        <div class="text">Caption Two</div>
                    </div>

                    <div class="mySlides fade">
                        <div class="numbertext">3 / 3</div>
                        <img class="slideImg" src="img/sieu-xe-la-gi-muaxegiatot-vn.jpg" alt="" />
                        <div class="text">Caption Three</div>
                    </div>

                    <a class="prev" onclick="plusSlides(-1)">&#10094;</a>
                    <a class="next" onclick="plusSlides(1)">&#10095;</a>

                </div>
                <br>

                <div style="text-align:center">
                    <span class="dot" onclick="currentSlide(1)"></span> 
                    <span class="dot" onclick="currentSlide(2)"></span> 
                    <span class="dot" onclick="currentSlide(3)"></span> 
                </div>

                <!-- end slide show container -->
                <!-- brand --> 
                <!-- dang can sua them -->
                <div class=" bg-light text-dark">
                    <h3 class="text-center pt-4">Brand</h3>
                    <br>
                    <div class="p-5">
                        <div class="row">
                        <c:forEach items="${allBrand}" var="b" begin="0" end="3">
                            <div class="col-sm-6 col-md-3 ">

                                <div class="box rounded brand bg-dark d-flex flex-column text-light p-4 h-100">
                                    <div class="card-img">
                                        <img class="rounded product-img" src="${b.img}" alt="">
                                    </div>
                                    <h2 class="text-center mt-auto">${b.name}</h2>             
                                    <div class="mt-auto text-end">
                                        <button type="button" class="btn" > <a class="btn btn-outline-secondary " href="brandList?bid=${b.id}">See more >></a></button>

                                    </div>

                                </div>
                                123</div>
                            </c:forEach>



                    </div>
                </div>
                <div class="text-end">
                    <button type="button" class="btn btn-outline-secondary m-3"> <a href="#"></a>See more >></i></button>

                </div>
            </div>
            <!-- start newest oto product -->
            <div class="newest-car-product bg-dark text-light">
                <h3 class="bg-secondery text-center pt-4">Newest Car Product</h3>
                <br>
                <div class="p-5">
                    <div class="row gy-5">
                        <c:forEach items="${allCar}" var="p" begin="0" end="8" >
                            <div class="col-sm-12 col-md-6 col-lg-4">
                                <div class="box rounded product bg-dark d-flex flex-column text-light p-4 h-100">
                                    <section class="card-img">
                                        <section class="text-end"><span class="vehicle__badge vehicle__badge--special">Special Value</span></section>

                                        <img class="product-img" src="${p.img}" alt="">
                                    </section>             
                                    <section class="vehicle-header">
                                        <h2 class="product-tiltle">${p.name}</h2>
                                        <h2 class="product-price"> ${p.price}$</h3>

                                    </section>
                                    <section>
                                        <p class=""><i class="bi bi-geo-alt-fill"></i> ${p.madeIn}</p>
                                        <p class=""><i class="bi bi-calendar"></i> ${p.manufactureYear}</p>

                                    </section>

                                    <div class="mt-auto">
                                        <button type="button" class="btn" > <a class="btn btn-outline-secondary " href="productDetail?pid=${p.id}">Detail</a></button>
                                        <button type="button" class="btn" > <a class="btn btn-outline-secondary " ><i class="bi bi-cart-plus-fill"></i></a></button>
                                    </div>

                                </div>
                                123</div>
                            </c:forEach>




                    </div>
                </div>
                <div class="text-end">
                    <button type="button" class="btn" > <a class="btn btn-outline-secondary  m-3" href="productList?vtid=1&&vtname=Car">See more >></a></button>

                </div>
            </div>
            <!-- end newest Car product -->
            <div class="newest-car-product bg-dark text-light">
                <h3 class="bg-secondery text-center pt-4">Newest Moto Product</h3>
                <br>
                <div class="p-5">
                    <div class="row gy-5">
                        <c:forEach items="${allMoto}" var="p" begin="0" end="8" >
                            <div class="col-sm-12 col-md-6 col-lg-4">
                                <div class="box rounded product bg-dark d-flex flex-column text-light p-4 h-100">
                                    <section class="card-img">
                                        <section class="text-end"><span class="vehicle__badge vehicle__badge--special">Special Value</span></section>

                                        <img class="product-img" src="${p.img}" alt="">
                                    </section>             
                                    <section class="vehicle-header">
                                        <h2 class="product-tiltle">${p.name}</h2>
                                        <h2 class="product-price"> ${p.price}$</h3>

                                    </section>
                                    <section>
                                        <p class=""><i class="bi bi-geo-alt-fill"></i> ${p.madeIn}</p>
                                        <p class=""><i class="bi bi-calendar"></i> ${p.manufactureYear}</p>

                                    </section>
                                    <div class="mt-auto">
                                        <button type="button" class="btn" > <a class="btn btn-outline-secondary " href="productDetail?pid=${p.id}">Detail</a></button>
                                        <button type="button" class="btn" > <a class="btn btn-outline-secondary  " ><i class="bi bi-cart-plus-fill"></i></a></button>
                                    </div>

                                </div>
                                123</div>
                            </c:forEach>




                    </div>
                </div>
                <div class="text-end">
                    <button type="button" class="btn" > <a class="btn btn-outline-secondary  m-3" href="productList?vtid=2&&vtname=Moto">See more >></a></button>

                </div>
            </div>
            <!-- end newest Moto product -->

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
