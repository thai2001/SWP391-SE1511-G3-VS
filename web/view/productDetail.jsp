<%-- 
    Document   : productDetail
    Created on : Feb 15, 2022, 1:56:33 PM
    Author     : ThaiNV
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <title>Home page</title>
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <link rel="stylesheet" href="css/style.css" />
        <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
            crossorigin="anonymous"
            />
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
         <!-- script link -->
        <script src="js/productDetail.js"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>



    </head>
    <body>
        <jsp:include page="navbar.jsp"></jsp:include>

            <div class="container">
                <!--                product detail tiltle-->
                <div class="row">
                    <div class="col-10">
                        <section class="vehicle-detail-header">
                            <section class="w-100">
                                <p ><i class="bi bi-geo-alt-fill"></i>   ${product.madeIn} </p>
                            <p><i class="bi bi-calendar"></i>    ${product.manufactureYear}</p>

                        </section>
                        <h2 class="">${product.name}</h2>
                        <h2 class="">${product.price} $ </h2>
                        <button type="button" class="btn" > <a class="btn btn-outline-secondary  " href="addShoppingCart?pid=${product.id}" ><i class="bi bi-cart-plus-fill"></i></a></button>

                    </section>


                </div>

            </div>
            <!--                    product detail information-->
            <div class="row mt-3">
                <div class="col-10">
                    <section>
                        <img class="w-100" src="${product.img}" alt="">    
                    </section>
                </div>
            </div>
            <div class="row mt-3">
                <div class=" col"></div>
                <h2>Characters</h2>
                <p class=" w-75">Vehicle name : ${product.name}</p>
                <c:forEach items="${allBrand}" var="b">
                    <c:if test="${b.id==product.brandId}">
                        <p class=" w-75">Brand : ${b.name}</p>
                    </c:if>
                </c:forEach>
                <p class=" w-75">Made in : ${product.madeIn}</p>
                <p class=" w-75">Manufacture year : ${product.manufactureYear}</p>

            </div>
            <div class="row mt-3">
                <div class="col"></div>
                <h2>Description</h2>
                <p class="descript w-75">${product.descript}</p>
            </div>
        </div>


        <section class="content-item" id="comments">
            <div class="container">   
                <div class="row">
                    <div class="col-sm-8" id="comments-body">   
                            <h3 class="pull-left">New Comment</h3>
                            <fieldset>
                                <div class="row">
                                    <div class="col-sm-3 col-lg-2 hidden-xs">
                                    </div>
                                    <div class="form-group col-xs-12 col-sm-9 col-lg-10">
                                        <textarea class="form-control" id="message" placeholder="Your message" maxlength="1000" title="Not over 1000 word" ${account == null?"disabled":""}  required ></textarea>
                                    </div>
                                </div>  	
                                  
                            </fieldset>
                                    <button onclick="insertNewComment()" class="btn btn-normal btn-outline-success pull-right">Comment</button>

                        <h3> Comments</h3>
                        <div id="mediaes">
                            <!-- COMMENT 1 - START -->
                        <c:forEach items="${comments}" var="c" >
                        <div class="media">
                            <div class="media-body">
                                <h4 class="media-heading">${c.buyer.buyerName}</h4>
                                <p>${c.content}</p>
                                <ul class="list-unstyled list-inline media-detail pull-left">
                                    <li><i class="fa fa-calendar"></i>${c.date}</li>
                                </ul>
                                <ul class="list-unstyled list-inline media-detail pull-right">
                                </ul>
                            </div>
                        </div>    
                        </c:forEach>
                        
                        <!-- COMMENT 1 - END -->
                        </div>

                        

                       

                    </div>
                </div>
                        <button onclick="loadMore()" class="btn btn-normal btn-outline-primary pull-right">More</button>

            </div>
        </section>
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

       
    </body>
</html>

