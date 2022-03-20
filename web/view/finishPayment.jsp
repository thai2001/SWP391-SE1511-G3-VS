<%-- 
    Document   : finishPaymnet
    Created on : Mar 20, 2022, 10:32:15 AM
    Author     : taola
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/finishPayment.css" />
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
                <h2>Verify Your Payment</h2>
                <p>We emailed you the six digit code to fantacydesignss@gmail.com <br/> Enter the code below to confirm your email address.</p>
                <div class="status-img">
                    <img src="img/—Pngtree—error application denied server alert_4481725.png" alt=""/>
                </div>
                <small class="info">
                    <a type="submit" class="btn btn-outline-success" >back to history</a>
                </small>      

            </div>
        </form>

    </body>
</html>
