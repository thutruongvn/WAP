<%--
  Created by IntelliJ IDEA.
  User: ThuTruong
  Date: 7/15/2019
  Time: 11:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>Fashion shop</title>
    <!-- Bootstrap core JavaScript -->
    <script src="<c:url value="/resources/js/jquery-3.4.1.min.js" />"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
    <script type="text/javascript" src="/resources/js/script.js"></script>
    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css" />">
    <link href="<c:url value="/resources/css/custom.css" />" rel="stylesheet">

</head>

<body>

<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-light bg-light border-bottom fixed-top shadow-sm mb-5">
    <div class="container">
<%--        <a href="/" class="logo">Home</a>--%>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive"
                aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="/">Home     </a>
                </li>
                <li class="nav-item active">
                    <!--<a href="shopping-cart" class="list-group-item d-flex justify-content-between align-items-center">-->
                    <a class="nav-link" href="shopping-cart" >
                        <span>
                        <i class="fa fa-shopping-cart" id="icon-basket"></i>
                        <span id="num-of-items" class="badge badge-primary badge-pill">${numItems}</span>
                    </span>
                    </a>
                </li>
                <c:if test="${user_info == null}">
                    <li class="nav-item active">
                        <a class="nav-link" href="login">Login</a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link" href="register">Register</a>
                    </li>
                </c:if>
                <c:if test="${user_info != null}">
                    <li class="nav-item active">
                        <a class="nav-link" href="profile">${user_info}</a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link" href="logout">Logout</a>
                    </li>
                </c:if>
            </ul>
        </div>
    </div>
</nav>

<c:if test="${sessionScope['err_msg_checkout'] != null}">
    <div class="alert alert-danger" role="alert">
        <c:out value="${sessionScope['err_msg_checkout']}"/>
    </div>
</c:if>