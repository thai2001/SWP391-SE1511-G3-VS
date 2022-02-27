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
            <form action="changePass" method="post" onsubmit="return validateform()"> 
                <div class="form-icon">
                    <span><i class="icon icon-user"></i></span>
                </div>
                <p <c:if test = "${mess != 'InvalidAC'}">
                        style="display:none;"
                    </c:if>> Your account or password wrong! please reenter</p>

                <div class="form-group">
                    <p id="username" style="display: none;">Username must be no more than 20 characters long and not blank</p>
                    <input type="text" class="form-control item" name="username" placeholder="Username"
                           <c:choose>
                               <c:when test="${Account != null}">
                                   value="${Account.username}"
                               </c:when>
                           </c:choose>>
                </div>
                
                <div class="form-group">
                    <p id="oldpassword" style="display: none;">Old Password must be at least 6 characters long and not blank and no more than 20 characters</p>
                    <input type="password" class="form-control item" name="oldpassword" placeholder="Old Password"
                           <c:choose>
                               <c:when test="${Account != null}">
                                   value="${Account.password}"
                               </c:when>
                           </c:choose>>
                </div>
                
                <div class="form-group">
                    <p id="newpassword" style="display: none;">New Password must be at least 6 characters long and not blank and no more than 20 characters</p>
                    <input type="password" class="form-control item" name="newpassword" placeholder="New Password"
                           <c:choose>
                               <c:when test="${Account != null}">
                                   value="${newpass}"
                               </c:when>
                           </c:choose>>
                </div>

                <div class="form-group">
                    <p id="repassword" style="display: none;">Confirm password must be the same pass</p>
                    <input type="password" class="form-control item" name="repassword" placeholder="Confirm Password"
                           <c:choose>
                               <c:when test="${Account != null}">
                                   value="${newpass}"
                               </c:when>
                           </c:choose>>
                </div>

                <div class="form-group">
                    <button type="submit" class="btn btn-block create-account">Change Password</button>
                </div>
                <div class="form-group">
                    <button onclick="window.location.href = './login'" type="button" class="btn btn-block create-account">Login</button>
                </div>
                <div class="form-group">
                    <button onclick="window.location.href = './register'" type="button" class="btn btn-block create-account">Register</button>
                </div>
            </form>
            <div class="social-media">
                <h5>Sign in with social media</h5>
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
        </script>
    </body>
</html>
