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
          <div class="dropdown mx-2">
            <a class="btn btn-dark dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-bs-toggle="dropdown" aria-expanded="false">
              Dropdown link
            </a>
          
            <ul class="dropdown-menu" aria-labelledby="dropdownMenuLink">
              <li><a class="dropdown-item" href="#">Action</a></li>
              <li><a class="dropdown-item" href="#">Another action</a></li>
              <li><a class="dropdown-item" href="#">Something else here</a></li>
            </ul>
          </div>
          
         
            <a class="btn mx-2 btn-dark link-light" href="#">Brand</a>

        </div>
        <div class="navlink login logout">
          <a class="nav-link link-light " href="#">Login</a>
          <a class="nav-link link-light " href="#">Login</a>
          <a class="nav-link link-light " href="#">Sign up</a>
      </div>
      </div>
    </nav>
  </header>
