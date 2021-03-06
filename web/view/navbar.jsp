<%-- 
    Document   : navbar
    Created on : Jan 21, 2022, 11:38:46 AM
    Author     : taola
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
  <header>
      <nav class="navbar bg-dark navbar-dark text-light">
        <a href="homePage"> <img class="logo" src="img/onlinelogomaker-011922-2055-7830.png" alt="" /></a>
        <a class="navbar-brand" href=""><h2>Hello <em style="font-style: normal;color: #6dcf7f;">${sessionScope.account.username}</em></h2></a>
        <div class="option-link d-flex">
          <div class="dropdown mx-2">
            <a class="btn btn-dark dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-bs-toggle="dropdown" aria-expanded="false">
              Vehicle
            </a>
            <ul class="dropdown-menu " aria-labelledby="dropdownMenuLink">
                <c:forEach items="${allVehicleType}" var="vt" >
                    <li><a class="dropdown-item " href="productList?vtid=${vt.vehicleTypeId}&&vtname=${vt.vehicleTypeName}">${vt.vehicleTypeName}</a></li>
                </c:forEach>
            
            </ul>
          </div>        
          
         
            <a class="btn mx-2 btn-dark link-light" href="brandList">Brand</a>

        </div>
        
        <c:if test="${shoppingCart != null && sessionScope.account.roleId.roleId != 3 }" >
        <button type="button" class="btn btn-dark m-2"> <a href="shoppingCart"><i class="bi bi-cart3 text-white"></i></a>  ${shoppingCart.size()} </button>
        </c:if>
        <c:if test="${not empty history && sessionScope.account.roleId.roleId != 3 }" >
            <button type="button" class="btn btn-dark m-2"> <a href="history"><i class="bi bi-journal-check text-white"></i></a> ${history.size()}
            </button>
        </c:if>
        

        <div class="navlink login logout">
            <c:if test="${sessionScope.account.roleId.roleId == 3}">
                
                <a class="nav-link link-light " href="manageproduct">Manage Product</a>
             
              </c:if>
            <c:if test="${sessionScope.account == null}">
          <a class="nav-link link-light " href="login">Login</a>
            </c:if>
           <c:if test="${sessionScope.account == null}">
          <a class="nav-link link-light " href="register">Sign Up</a>
           </c:if>
           <c:if test="${sessionScope.account != null}">
          <a class="nav-link link-light " href="profile">Profile</a>
          </c:if>
          <c:if test="${sessionScope.account != null}">
          <a class="nav-link link-light " href="QandA">Q&A</a>
          </c:if>
          <c:if test="${sessionScope.account != null}">
          <a class="nav-link link-light " href="logout">Sign Out</a>
          </c:if>
         
      </div>
      </div>
    </nav>
  </header>
