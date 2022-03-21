<%-- 
    Document   : payment
    Created on : Mar 19, 2022, 10:30:57 AM
    Author     : taola
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/payment.css" />
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous" />
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
        <!-- script link -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

        <title>Vehicle Store</title>
    </head>
    <body>
        <jsp:include page="navbar.jsp"></jsp:include>

            <div class="container">
                <div class="row">
                    <div class="col-lg-4 mb-lg-0 mb-3">
                        <div class="card p-3">
                            <div class="img-box"> <img src="https://www.freepnglogos.com/uploads/visa-logo-download-png-21.png" alt=""> </div>
                            <div class="number"> <label class="fw-bold" for="">**** **** **** 1060</label> </div>
                            <div class="d-flex align-items-center justify-content-between"> <small><span class="fw-bold">Expiry date:</span><span>10/16</span></small> <small><span class="fw-bold">Name:</span><span>Kumar</span></small> </div>
                        </div>
                    </div>
                    <div class="col-lg-4 mb-lg-0 mb-3">
                        <div class="card p-3">
                            <div class="img-box"> <img src="https://www.freepnglogos.com/uploads/mastercard-png/file-mastercard-logo-svg-wikimedia-commons-4.png" alt=""> </div>
                            <div class="number"> <label class="fw-bold">**** **** **** 1060</label> </div>
                            <div class="d-flex align-items-center justify-content-between"> <small><span class="fw-bold">Expiry date:</span><span>10/16</span></small> <small><span class="fw-bold">Name:</span><span>Kumar</span></small> </div>
                        </div>
                    </div>
                    <div class="col-lg-4 mb-lg-0 mb-3">
                        <div class="card p-3">
                            <div class="img-box"> <img src="https://www.freepnglogos.com/uploads/discover-png-logo/credit-cards-discover-png-logo-4.png" alt=""> </div>
                            <div class="number"> <label class="fw-bold">**** **** **** 1060</label> </div>
                            <div class="d-flex align-items-center justify-content-between"> <small><span class="fw-bold">Expiry date:</span><span>10/16</span></small> <small><span class="fw-bold">Name:</span><span>Kumar</span></small> </div>
                        </div>
                    </div>
                    <div class="col-12 mt-4">
                        <div class="card p-3">
                            <p class="mb-0 fw-bold h4">Payment Methods</p>
                        </div>
                    </div>
                    <div class="col-12">
                        <div class="card p-3">
                            <div class="card-body border p-0">
                                <p> <a class="btn btn-primary w-100 h-100 d-flex align-items-center justify-content-between" data-bs-toggle="collapse" href="#collapseExample" role="button" aria-expanded="true" aria-controls="collapseExample"> <span class="fw-bold">PayPal</span> <span class="fab fa-cc-paypal"> </span> </a> </p>
                                <div class="collapse p-3 pt-0" id="collapseExample">
                                    <div class="row">
                                        <div class="col-8">
                                            <p class="h4 mb-0">Summary</p>
                                            <p class="mb-0"><span class="fw-bold">Product:</span><span class="c-green">: Name of product</span></p>
                                            <p class="mb-0"><span class="fw-bold">Price:</span><span class="c-green">:$452.90</span></p>
                                            <p class="mb-0">Lorem ipsum, dolor sit amet consectetur adipisicing elit. Atque nihil neque quisquam aut repellendus, dicta vero? Animi dicta cupiditate, facilis provident quibusdam ab quis, iste harum ipsum hic, nemo qui!</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="card-body border p-0">
                                <p> <a class="btn btn-primary p-2 w-100 h-100 d-flex align-items-center justify-content-between" data-bs-toggle="collapse" href="#collapseExample" role="button" aria-expanded="true" aria-controls="collapseExample"> <span class="fw-bold">Credit Card</span> <span class=""> <span class="fab fa-cc-amex"></span> <span class="fab fa-cc-mastercard"></span> <span class="fab fa-cc-discover"></span> </span> </a> </p>
                                <div class="collapse show p-3 pt-0" id="collapseExample">
                                    <div class="row">
                                        <div class="col-lg-5 mb-lg-0 mb-3">
                                            <p class="h4 mb-0">Summary</p>
                                            <p class="mb-0"><span class="fw-bold">Product:</span><span class="c-green"> ${o.product.name}</span> </p>
                                        <p class="mb-0"> <span class="fw-bold">Price:</span> <span class="c-green">${o.product.price *o.quantity + 500} $ </span> </p>
                                        <p class="mb-0">${o.product.descript}</p>
                                    </div>
                                    <div class="col-lg-7">
                                        <form action="sendVetifyCode" class="form">
                                            <div class="row">
                                                <div class="col-12">
                                                    <div class="form__div"> <input type="text" class="form-control" placeholder=" " pattern="[0-9]{10}" title="only 10 number" required> <label for="" class="form__label">Card Number</label> </div>
                                                </div>
                                                <div class="col-6">
                                                    <div class="form__div"> <input type="text" class="form-control" placeholder=" " pattern="^(0[1-9]|1[012])/((19|2[0-9])[0-9]{2})$" title="MM/YY" required > <label for="" class="form__label">MM / yy</label> </div>
                                                </div>
                                                <div class="col-6">
                                                    <div class="form__div"> <input type="password" class="form-control" placeholder=" " pattern="\d{3}" title="3 number" required> <label for="" class="form__label">cvv code</label> </div>
                                                </div>
                                                <div class="col-12">
                                                    <div class="form__div"> <input type="text" class="form-control" placeholder=" " pattern="[a-zA-Z]+" title="Full Name" required> <label for="" class="form__label">name on the card</label> </div>
                                                </div>
                                                <div class="col-12">
                                                    <input type="submit" value="Pay" class="btn btn-primary w-100"></div>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-12">
                <div class="btn btn-primary payment"> Make Payment </div>
            </div>
        </div>
    </div>
</body>
</html>
