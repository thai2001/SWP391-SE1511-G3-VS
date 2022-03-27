<%-- 
    Document   : QandA
    Created on : Mar 20, 2022, 5:31:47 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="main.js"></script>
        <script src="js/QandA.js"></script>
        <link rel="stylesheet" href="css/style.css" />
        <link rel="stylesheet" href="css/styleQandA.css" />
        <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
            crossorigin="anonymous"
            />
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

    </head>

    <body>
        <jsp:include page="navbar.jsp"></jsp:include>
            <!--===================================================-->
            <div class="container bootdey">
                <div class="col-md-12 bootstrap snippets">
                    <div class="panel">
                        <div class="panel-body">
                            <textarea class="form-control" rows="3" placeholder="Ask questions and we will answer as soon as possible!" id="commentcontent"></textarea>
                            <div class="mar-top clearfix">
                                <button class="btn btn-sm btn-primary pull-right" type="submit" name="contentcomment" id="buttoncomment"  onclick="PostComment('${sessionScope.account.username}')"><i class="fa fa-pencil fa-fw"></i> Commnet</button>
                            <span><button class="btn btn-sm btn-primary pull-right" type="submit" name="contentcomment" id="buttoncommentdes" style="display: none; margin-right: 10px;"  onclick="Destroy('buttoncomment', '', 'commentcontent')"><i class="fa fa-pencil fa-fw"></i> Destroy</button></span>
                            <span><button class="btn btn-sm btn-primary pull-right" type="submit" name="contentcomment" id="buttoncommentent" style="display: none; margin-right: 10px;"  onclick=""><i class="fa fa-pencil fa-fw"></i> EnterEdit</button></span>
                        </div>
                    </div>
                </div>
                <div class="panel">
                    <div class="panel-body" id="contentcomment">
                        <!-- Newsfeed Content -->
                        <!--===================================================-->
                        <c:forEach var="c" items="${requestScope.comments}">
                            <div class="media-block blockcomment" id="childcom${c.id}">
                                <c:choose>
                                    <c:when test="${c.roleid == 2}">
                                        <a class="media-left" href="#"><img class="img-circle img-sm" alt="Profile Picture" src="https://upload.wikimedia.org/wikipedia/commons/thumb/5/59/User-avatar.svg/1024px-User-avatar.svg.png"></a>
                                        </c:when>    
                                        <c:otherwise>
                                        <a class="media-left" href="#"><img class="img-circle img-sm" alt="Profile Picture" src="https://bootdey.com/img/Content/avatar/avatar1.png"></a>
                                        </c:otherwise>
                                    </c:choose>

                                <div class="media-body">

                                    <div class="mar-btm">
                                        <a href="#" class="btn-link text-semibold media-heading box-inline">${c.name}</a>
                                        <p class="text-muted text-sm"><i class="fa fa-mobile fa-lg"></i> ${c.timeago} ${c.dvtime} ago</p>
                                    </div>
                                    <p id='pcomment${c.id}'>${c.content}</p>
                                    <div class="pad-ver">
                                        <button type="button" class="btn btn-outline-primary btn-sm rely" onclick="setFocus('t${c.id}')">Rely</button>
                                        <c:if test = "${sessionScope.account.username == c.username}">
                                            <span><button type="button" class="btn btn-outline-primary btn-sm rely" onclick="confirmdelete('com.${c.id}')">Delete</button></span>
                                            <span><button type="button" class="btn btn-outline-primary btn-sm rely" onclick="edit('buttoncomment', '', 'commentcontent', 'com.${c.id}', '${c.content}')">Edit</button></span>
                                        </c:if>
                                    </div>
                                    <hr>

                                    <!-- Comments -->
                                    <div class="relycomment" id="r${c.id}">
                                        <c:forEach var="rely" items="${c.rely}">
                                            <div class="media-block blockrely${c.id}" id="childrel${rely.id}">
                                                <c:choose>
                                                    <c:when test="${rely.roleid == 2}">
                                                        <a class="media-left" href="#"><img class="img-circle img-sm" alt="Profile Picture" src="https://upload.wikimedia.org/wikipedia/commons/thumb/5/59/User-avatar.svg/1024px-User-avatar.svg.png"></a>
                                                        </c:when>    
                                                        <c:otherwise>
                                                        <a class="media-left" href="#"><img class="img-circle img-sm" alt="Profile Picture" src="https://bootdey.com/img/Content/avatar/avatar1.png"></a>
                                                        </c:otherwise>
                                                    </c:choose>
                                                <div class="media-body">
                                                    <div class="mar-btm">
                                                        <a href="#" class="btn-link text-semibold media-heading box-inline">${rely.name}</a>
                                                        <p class="text-muted text-sm"><i class="fa fa-mobile fa-lg"></i> ${rely.timeago} ${rely.dvtime} ago</p>
                                                    </div>
                                                    <p id='prely${rely.id}'>${rely.content}</p>
                                                    <div class="pad-ver">
                                                        <button type="button" class="btn btn-outline-primary btn-sm rely" onclick="setFocus('t${c.id}')">Rely</button>
                                                        <c:if test = "${sessionScope.account.username == rely.username}">
                                                            <span><button type="button" class="btn btn-outline-primary btn-sm rely" onclick="confirmdelete('rel.${rely.id}.${c.id}')">Delete</button></span>
                                                            <span><button type="button" class="btn btn-outline-primary btn-sm rely" onclick="edit('buttonrely', '${c.id}', 't${c.id}', 'rel.${rely.id}.${c.id}', '${rely.content}')">Edit</button></span>
                                                        </c:if>
                                                    </div>
                                                    <hr>
                                                </div>
                                            </div>
                                        </c:forEach>
                                    </div>
                                    <c:if test = "${c.countrely > 3}">
                                        <div style="text-align: center;" id="blockloadrely${c.id}">
                                            <a style="text-decoration: none;" onclick="LoadMoreRely('${c.id}', '${c.countrely}')"> Load More Rely</a> 
                                        </div>
                                    </c:if>

                                    <!-- Comments -->
                                    <textarea class="form-control" rows="2" placeholder="What are you thinking?" id="t${c.id}" minlength="1"></textarea>
                                    <button class="btn btn-sm btn-primary pull-right" type="submit" style="margin-top: 10px;" id ="buttonrely${c.id}" onclick="Rely('${c.id}', '${sessionScope.account.username}', '${c.countrely}')"><i class="fa fa-pencil fa-fw"></i> Rely</button>
                                    <span><button class="btn btn-sm btn-primary pull-right" type="submit" style="margin-right: 10px; margin-top: 10px; display: none;" id ="buttonrelydes${c.id}" onclick="Destroy('buttonrely', '${c.id}', 't${c.id}')"><i class="fa fa-pencil fa-fw"></i> Destroy</button></span>
                                    <span><button class="btn btn-sm btn-primary pull-right" type="submit" style="margin-right: 10px; margin-top: 10px; display: none;" id ="buttonrelyent${c.id}" onclick=""><i class="fa fa-pencil fa-fw"></i> EnterEdit</button></span>
                                </div>
                            </div>
                        </c:forEach>
                        <!--===================================================-->
                        <!-- End Newsfeed Content -->
                    </div>
                </div>
                <c:if test = "${requestScope.countcomment > 3}">
                    <div style="text-align: center;" id="LoadmoreCommentdiv"> 
                        <a class="loadmore" onclick="LoadMoreComment('${requestScope.countcomment}')"> Load More Comment</a> 
                    </div>
                </c:if>
            </div>
        </div>
        <!--===================================================-->
        <!--===================================================-->
        <script src="js/slideJs.js"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    </body>
</html>
