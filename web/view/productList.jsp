<%-- 
    Document   : motoList
    Created on : Feb 7, 2022, 12:28:15 PM
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
        <jsp:include page="navbar.jsp"></jsp:include>

            <!-- search sort filter -->
            <div class="row w-100">
                <div class="col search sort filter  ">
                    <form action="search" method="post">
                        <div class="d-flex flex-row">
                            <input type="radio" class="btn-check" name="vtid" id="vtid1" value="1" ${vtid==1?"checked":""}>
                        <label class="btn btn-outline-secondary w-100" for="vtid1">Car</label>
                        <input type="radio" class="btn-check" name="vtid" id="vtid2" value="2" ${vtid==2?"checked":""}>
                        <label class="btn btn-outline-secondary w-100" for="vtid2">Moto</label>
                    </div>



                    <p class="m-2 border-bottom text-center">Search and filter </p>

                    <div class="input-group mb-3 ">
                        <input type="text" class="form-control" name="keyWord" placeholder="Key word"  value="${keyWord}" pattern=".{0,50}" title="can not over 50 char" >
                    </div>

                    <select class="form-select" name="sort" aria-label="Default select example">
                        <option ${sortOp=="ManufactureYear desc"?"selected":""} value="ManufactureYear desc">Newest</option>
                        <option ${sortOp=="ManufactureYear"?"selected":""} value="ManufactureYear">Oldest</option>
                        <option ${sortOp=="UnitPrice desc"?"selected":""} value="UnitPrice desc">Highest Price</option>
                        <option ${sortOp=="UnitPrice"?"selected":""} value="UnitPrice">Lowest Price</option>
                    </select>
                    <div class="brand-category border border-dark m-2 rounded">
                        <ul >
                            <li ><h6 class="dropdown-header border-bottom">Brand</h6></li>
                            <li class=""> <input type="radio" class="btn-check" name="brand" id="0" value="0" ${selectedBrand==0?"checked":""}>
                                <label class="btn btn-outline-secondary w-100" for="0">All Brand</label></li>
                            <c:forEach items="${allBrand}" var="b"><li class=""> <input type="radio" class="btn-check" name="brand" id="${b.id}" value="${b.id}" ${selectedBrand==b.id?"checked":""}>
                                    <label class="btn btn-outline-secondary w-100" for="${b.id}">${b.name}</label></li></c:forEach>
                            </ul>
                        </div>
                        <button class="btn btn-outline-secondary w-100" type="submit" >GO!!!!</button>
                    </form>
                </div>


                <!-- start list -->

                <div class="col-10 newest-moto-product bg-dark text-light">
                <c:if test="${messError != null}">
                    <div class="text-danger text-center">${messError}</div>
                </c:if>
                <c:if test="${messSuccess != null}">
                    <div class="text-success text-center">${messSuccess}</div>

                </c:if>

                <h3 class=" text-center text-light pt-5 border-bottom"> ${vtName} Product</h3>
                <br>
                <div class="p-5">
                    <c:if test="${empty availableProduct}">
                        <div class="row gy-5 nothing">
                            <h2>No result</h2>
                        </div>
                    </c:if>
                    <div class="row gy-5">
                        <c:forEach items="${availableProduct}" var="p">
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
                                        <p class=""> ${p.manufactureYear}</p>

                                    </section>
                                    <div class="mt-auto">
                                        <button type="button" class="btn" > <a class="btn btn-outline-secondary " href="productDetail?pid=${p.id}">Detail</a></button>
                                        <button type="button" class="btn" > <a class="btn btn-outline-secondary  " href="addShoppingCart?pid=${p.id}" ><i class="bi bi-cart-plus-fill"></i></a></button>
                                    </div>

                                </div>
                                123</div>
                            </c:forEach>



                    </div>
                </div>

                <!-- paging -->
                <c:if test="${numberOfPage != 0}">
                    <div class="pt-3 d-flex justify-content-center">
                        <nav aria-label="Page navigation example">
                            <ul class="pagination">
                                <li class="page-item"><a class="page-link" href="#">Previous</a></li>
                                <c:forEach begin="1" end="${numberOfPage}" var="index"><li class="page-item ${index==pi?"active":""} "><a class="page-link " href="productList?pi=${index}">${index}</a></li></c:forEach>
                                    <li class="page-item"><a class="page-link" href="#">Next</a></li>
                                </ul>
                            </nav>

                        </div>
                </c:if>
            </div>
        </div>
    </div>
</div>
<!-- end newest moto -->
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
<script src="myjs.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>

