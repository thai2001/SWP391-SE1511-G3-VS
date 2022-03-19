<%-- 
    Document   : Register
    Created on : Feb 6, 2022, 10:02:00 PM
    Author     : levan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="<c:url value="https://cdnjs.cloudflare.com/ajax/libs/simple-line-icons/2.4.1/css/simple-line-icons.min.css" />" crossorigin="anonymous">
        <link href="<c:url value="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" />" rel="stylesheet">
        <link href="<c:url value="css/styleRegisterandLogin.css" />" rel="stylesheet">
    </head>
    <body>
        <!-- This snippet uses Font Awesome 5 Free as a dependency. You can download it at fontawesome.io! -->

        <div class="registration-form">
            <form method="post" action="register" onsubmit="return validateform()">
                <div class="form-icon">
                    <span><i class="icon icon-user"></i></span>
                </div>
                <div style="margin-bottom: 40px;">
                    <div style="float: left; margin-left: 40px; font-size: 20px">
                        <input type="radio" id="buyer" name="role" value="2" <c:if test = "${messradio == 2}">
                               checked="checked"
                            </c:if>>
                        <label style="color: #1e7e34">Buyer</label>
                    </div>
                    <div style="float: right; margin-right: 40px; font-size: 20px" >
                        <input type="radio" id="seller" name="role" value="3" <c:if test = "${messradio == 3}">
                               checked="checked"
                            </c:if>>
                        <label style="color: #1e7e34">Seller</label><br>
                    </div>
                </div>
                <p <c:if test = "${mess ne 'AccountExit'}">
                        style="display:none;"
                    </c:if>> Your account or password already exists! Please create another</p>
                <div class="form-group">
                    <p id="username" style="display: none;">Username must be no more than 20 characters long and not blank</p>
                    <input type="text" class="form-control item" name="user" placeholder="Username (Require)"
                           <c:choose>
                               <c:when test="${Account != null}">
                                   value="${Account.username}"
                               </c:when>
                           </c:choose>>
                </div>



                <div class="form-group">
                    <p id="password" style="display: none;">Password must be at least 6 characters long and not blank</p>
                    <input type="password" class="form-control item" name="password"  placeholder="Password (Require)"
                           <c:choose>
                               <c:when test="${Account != null}">
                                   value="${Account.password}"
                               </c:when>
                           </c:choose>>
                </div>

                <div class="form-group">
                    <p id="repass" style="display: none;">Repassword must be the same password! </p>
                    <input type="password" class="form-control item" name="repass" placeholder="RePassword (Require)"
                           <c:choose>
                               <c:when test="${Account != null}">
                                   value="${Account.password}"
                               </c:when>
                           </c:choose>>
                </div>

                <div class="form-group">
                    <p id="name" style="display: none;">Displayname not the blank </p>
                    <input type="text" class="form-control item" name="name" placeholder="DisplayName (Require)"
                           <c:choose>
                               <c:when test="${Account != null}">
                                   value="${Account.name}"
                               </c:when>
                           </c:choose>>
                </div>

                <div class="form-group">
                    <p id="gmail" style="display: none;">Email invalid!</p>
                    <p <c:if test = "${mess ne 'GmailExit'}">
                            style="display:none;"
                        </c:if>> Email already exists! Please create another</p>
                    <p <c:if test = "${mess ne 'EmailWrong'}">
                            style="display:none;"
                        </c:if>> Your Gmail is not correct! please check it again</p>
                    <input type="text" class="form-control item" name="gmail" placeholder="Gmail (Require)"
                           <c:choose>
                               <c:when test="${Account != null}">
                                   value="${Account.email}"
                               </c:when>
                           </c:choose>>
                </div>

                <div class="form-group">
                    <p id="phone" style="display: none;">PhoneNumber invalid! Must be 10 character </p>
                    <input type="text" class="form-control item" name="phone" placeholder="Phone number (Require)"
                           <c:choose>
                               <c:when test="${Account != null}">
                                   value="${Account.phone}"
                               </c:when>
                           </c:choose>>
                </div>

                <div class="form-group" id="resellerad" <c:if test = "${messradio == 1}">
                     style="display: none;"
                    </c:if>>
                    <p  id="address" style="display: none;">Address not be blank </p>
                    <input type="text" class="form-control item" name="address" placeholder="Address (Require)"
                           <c:choose>
                               <c:when test="${Account.address != null}">
                                   value="${Account.address}"
                               </c:when>
                           </c:choose>>
                </div>

                <div class="form-group" id="resellerde" <c:if test = "${messradio == 1}">
                     style="display: none;"
                    </c:if>>
                    <p id="description" style="display: none;">Description not be blank</p>
                    <input type="text" class="form-control item" name="description" placeholder="Description (Require)"
                           <c:choose>
                               <c:when test="${Account.description != null}">
                                   value="${Account.description}"
                               </c:when>
                           </c:choose>>
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-block create-account">Create Account</button>
                </div>
                <div class="form-group">
                    <button onclick="window.location.href = './login'" type="button" class="btn btn-block create-account">Login</button>
                </div>
            </form>
            <div class="social-media">
                <h5>Sign up with social media</h5>
                <div class="social-icons">
                    <a href="#"><i class="icon-social-facebook" title="Facebook"></i></a>
                    <a href="#"><i class="icon-social-google" title="Google"></i></a>
                    <a href="#"><i class="icon-social-twitter" title="Twitter"></i></a>
                </div>
            </div>
        </div>
        <script src="<c:url value="https://code.jquery.com/jquery-3.2.1.min.js" />"></script>
        <script src="<c:url value="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.15/jquery.mask.min.js" />"></script>
        <script>
                        function validateform() {
                            var user = document.getElementsByName("user")[0].value;
                            var pass = document.getElementsByName("password")[0].value;
                            var repass = document.getElementsByName("repass")[0].value;
                            var name = document.getElementsByName("name")[0].value;
                            var gmail = document.getElementsByName("gmail")[0].value;
                            var phone = document.getElementsByName("phone")[0].value;
                            var btn = document.getElementById("seller");

                            if (user.trim() == "" || user.trim().length > 20) {
                                document.getElementById('username').style.display = 'block';
                                return false;
                            } else
                            {
                                document.getElementById('username').style.display = 'none';
                            }

                            if (pass.trim().length < 6) {
                                document.getElementById('password').style.display = 'block';
                                return false;
                            } else
                            {
                                document.getElementById('password').style.display = 'none';
                            }

                            if (pass.trim() != repass.trim()) {
                                document.getElementById('repass').style.display = 'block';
                                return false;
                            } else
                            {
                                document.getElementById('repass').style.display = 'none';
                            }

                            if (name.trim() == "" || name.trim().length > 20) {
                                document.getElementById('name').style.display = 'block';
                                return false;
                            } else
                            {
                                document.getElementById('name').style.display = 'none';
                            }

                            let regexEmail = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
                            if (!gmail.trim().match(regexEmail)) {
                                document.getElementById('gmail').style.display = 'block';
                                return false;
                            } else
                            {
                                document.getElementById('gmail').style.display = 'none';
                            }

                            var regexphone = /^\d{0,10}$/;
                            if (!phone.trim().match(regexphone)) {
                                document.getElementById('phone').style.display = 'block';
                                return false;
                            } else
                            {
                                document.getElementById('phone').style.display = 'none';
                            }

                            if (btn.checked == true)
                            {
                                var add = document.getElementsByName("address")[0].value;
                                var des = document.getElementsByName("description")[0].value;

                                if (add.trim() == "") {
                                    document.getElementById('address').style.display = 'block';
                                    return false;
                                } else
                                {
                                    document.getElementById('address').style.display = 'none';
                                }

                                if (des.trim() == "") {
                                    document.getElementById('description').style.display = 'block';
                                    return false;
                                } else
                                {
                                    document.getElementById('description').style.display = 'none';
                                }
                            }
                        }

                        document.getElementById("buyer").onclick = function () {
                            document.getElementById("resellerad").style.display = 'none';
                            document.getElementById("resellerde").style.display = 'none';
                        };

                        document.getElementById("seller").onclick = function () {
                            document.getElementById("resellerad").style.display = 'block';
                            document.getElementById("resellerde").style.display = 'block';
                        };


        </script>
    </body>
</html>
