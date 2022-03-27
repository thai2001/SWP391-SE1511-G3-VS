<%-- 
    Document   : Profile_Edit
    Created on : Oct 23, 2021, 10:58:23 AM
    Author     : levan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styleProfile_Edit.css" />    
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <style>
            p{
                color:red;
                font-size: 15px;
            }
        </style>
    </head>
    <body>

        <div class="container">
            <div class="row gutters">
                <div class="col-xl-3 col-lg-3 col-md-12 col-sm-12 col-12">
                    <div class="card h-100">
                        <div class="card-body">
                            <div class="account-settings">
                                <div class="user-profile">
                                    <div class="user-avatar">
                                        <img src="https://bootdey.com/img/Content/avatar/avatar7.png" alt="Maxwell Admin">
                                    </div>
                                    <h5 class="user-name">${Account.name}</h5>
                                    <h6 class="user-email">${Account.email}</h6>
                                </div>
                                <div class="about"
                                     <c:if test = "${role != 3}">
                                         style="display: none;"
                                     </c:if>>
                                    <h5>Description</h5>
                                    <p>${Account.description}</p>
                                </div>
                                <div style="text-align: center;">
                                    <button type="button" id="submit" name="home" class="btn btn-primary" onclick="window.location.href = './homePage'" >Home</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-xl-9 col-lg-9 col-md-12 col-sm-12 col-12">
                    <div class="card h-100">
                        <div class="card-body">
                            <form action="profile" method="post" onsubmit="return validateform1()">
                                <div class="row gutters">
                                    <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                                        <h6 class="mb-2 text-primary">Personal Details
                                            <span <c:if test = "${mess1 != 1}">
                                                    style="display:none;"
                                                </c:if> style = "color: green;" id ="updateSuccess" > (Update Successfully)
                                            </span>
                                        </h6>
                                    </div>
                                    <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                                        <div class="form-group">
                                            <label for="fullName">Full Name
                                                <span style="color: red; font-size: 12px;"> 
                                                    *
                                                </span>
                                            </label>
                                            <p id="name" style="display: none;">Name not be blank</p>
                                            <input type="text" class="form-control" id="ifullName" name="fullname" placeholder="Enter full name" value="${Account.name}">
                                        </div>
                                    </div>
                                    <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                                        <div class="form-group">
                                            <label for="eMail">Email
                                                <span style="color: red; font-size: 12px;"> 
                                                    *
                                                </span>
                                            </label>
                                            <p id="gmail" style="display: none;">Gmail not be blank or invalid</p>
                                            <input type="email" class="form-control" id="ieMail" name="gmail" placeholder="Enter email ID" value="${Account.email}" readonly>
                                        </div>
                                    </div>
                                    <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                                        <div class="form-group">
                                            <label for="phone">Phone
                                                <span style="color: red; font-size: 12px;"> 
                                                    *
                                                </span>
                                            </label>
                                            <p id="phone" style="display: none;">Phone not be blank or invalid</p>
                                            <input type="text" class="form-control" id="iphone" name="phone" placeholder="Enter phone number" value="${Account.phone}">
                                        </div>
                                    </div>
                                    <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                                        <div class="form-group">
                                            <label for="website">Address 
                                                <span style="color: red; font-size: 12px;"> 
                                                    *
                                                </span>
                                            </label>
                                            <p id="address" style="display: none;">Address not be blank </p>
                                            <input type="text" class="form-control" id="iaddress" name="address" placeholder="Address" value="${Account.address}">
                                        </div>
                                    </div>
                                    <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12"
                                         <c:if test = "${role != 3}">
                                             style="display: none;"
                                         </c:if>>
                                        <div class="form-group">

                                            <label for="website">Description 
                                                <span style="color: red; font-size: 12px;"> 
                                                    *
                                                </span>
                                            </label>
                                            <textarea type="text" class="form-control" id="idescription" name="description" placeholder="Description" value="${Account.description}">${Account.description}</textarea>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                                    <div class="text-right">
                                        <button type="submit" id="submit" name="submit" class="btn btn-primary">Update</button>
                                    </div>
                                </div>
                            </form>

                            <form action="changePass" method="post" onsubmit="return validateform()">
                                <div class="row gutters">
                                    <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                                        <h6 class="mt-3 mb-2 text-primary">Change pass 
                                            <span <c:if test = "${mess != 'InvalidAC'}">
                                                    style="display:none;"
                                                </c:if> style = "color: red;" > (Your account or password wrong! please reenter)
                                            </span>

                                            <span <c:if test = "${mess2 != 1}">
                                                    style="display:none;"
                                                </c:if> style = "color: green;" id ="resetSuccess"> Reset pass word Successfully
                                            </span>
                                        </h6>
                                    </div>
                                    <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                                        <div class="form-group">
                                            <p id="username" style="display: none;">Username must be no more than 20 characters long and not blank</p>
                                            <label for="Street">Account<span style="color: red; font-size: 12px;"> 
                                                    *
                                                </span></label>
                                            <input type="name" class="form-control" name="username" placeholder="Account" value="${Account1.username}">
                                        </div>
                                    </div>
                                    <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                                        <div class="form-group">
                                            <p id="newpassword" style="display: none;">New Password must be at least 6 characters long and not blank and no more than 20 characters</p>
                                            <label for="ciTy">New PassWord <span style="color: red; font-size: 12px;"> 
                                                    *
                                                </span></label>
                                            <input type="password" class="form-control" name="newpassword" placeholder="New PassWord" >
                                        </div>
                                    </div>
                                    <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                                        <div class="form-group">
                                            <p id="oldpassword" style="display: none;">Old Password must be at least 6 characters long and not blank and no more than 20 characters</p>
                                            <label for="sTate">Old PassWord <span style="color: red; font-size: 12px;"> 
                                                    *
                                                </span></label>
                                            <input type="password" class="form-control" name="oldpassword" placeholder="Old PassWord" value="${Account1.password}">
                                        </div>
                                    </div>
                                    <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                                        <div class="form-group">
                                            <p id="repassword" style="display: none;">Confirm password must be the same pass</p>
                                            <label for="zIp">Confirm PassWord <span style="color: red; font-size: 12px;"> 
                                                    *
                                                </span></label>
                                            <input type="password" class="form-control" name="repassword" placeholder="Confirm PassWord">
                                        </div>
                                    </div>
                                </div>
                                <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                                    <div class="text-right">
                                        <button type="submit" id="submit" name="submit" class="btn btn-primary">Change pass</button>
                                    </div>
                                </div>
                            </form>

                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script>
            setTimeout(function () {
                document.getElementById('updateSuccess').style.display = 'none';
            }, 4000);

            setTimeout(function () {
                document.getElementById('resetSuccess').style.display = 'none';
            }, 4000);
            function validateform() {
                var user = document.getElementsByName("username")[0].value;
                var oldpass = document.getElementsByName("oldpassword")[0].value;
                var newpass = document.getElementsByName("newpassword")[0].value;
                var repass = document.getElementsByName("repassword")[0].value;

                if (user.trim() == "" || user.trim().length > 20) {
                    document.getElementById('username').style.display = 'block';
                    return false;
                } else
                {
                    document.getElementById('username').style.display = 'none';
                }

                if (oldpass.trim().length < 6 || oldpass.trim().length > 20) {
                    document.getElementById('oldpassword').style.display = 'block';
                    return false;
                } else
                {
                    document.getElementById('oldpassword').style.display = 'none';
                }

                if (newpass.trim().length < 6 || newpass.trim().length > 20) {
                    document.getElementById('newpassword').style.display = 'block';
                    return false;
                } else
                {
                    document.getElementById('newpassword').style.display = 'none';
                }

                if (newpass.trim() != repass.trim()) {
                    document.getElementById('repassword').style.display = 'block';
                    return false;
                } else
                {
                    document.getElementById('repassword').style.display = 'none';
                }
            }

            function validateform1() {
                var name = document.getElementsByName("fullname")[0].value;
                var gmail = document.getElementsByName("gmail")[0].value;
                var phone = document.getElementsByName("phone")[0].value;
                var add = document.getElementsByName("address")[0].value;
                
                if (name.trim() == "" || name.trim().length > 20) {
                    document.getElementById('name').style.display = 'block';
                    return false;
                } else
                {
                    document.getElementById('name').style.display = 'none';
                }

                if (add.trim() == "" || add.trim().length > 30) {
                    document.getElementById('address').style.display = 'block';
                    return false;
                } else
                {
                    document.getElementById('address').style.display = 'none';
                }

                let regexEmail = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
                if (!gmail.trim().match(regexEmail)) {
                    document.getElementById('gmail').style.display = 'block';
                    return false;
                } else
                {
                    document.getElementById('gmail').style.display = 'none';
                }

                var regexphone = /^\d{8,10}$/;
                if (!phone.trim().match(regexphone)) {
                    document.getElementById('phone').style.display = 'block';
                    return false;
                } else
                {
                    document.getElementById('phone').style.display = 'none';
                }
            }
        </script>
    </body>                             
</html>