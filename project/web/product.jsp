<%--
  Created by IntelliJ IDEA.
  User: ThuTruong
  Date: 7/14/2019
  Time: 9:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--<!DOCTYPE HTML>--%>
<%--<html>--%>
<%--<head>--%>
<%--  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">--%>
<%--    <title>Product shopping</title>--%>
<%--    <script type="text/javascript"--%>
<%--            src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>--%>
<%--    <script type="text/javascript" src="/resources/js/script.js"></script>--%>
<%--  <link href="/resources/css/custom.css" rel="stylesheet" type="text/css" />--%>
<%--  </head>--%>
<%--  <body>--%>
<%--<jsp:include page="header.jsp"></jsp:include>--%>
<%@ include file="header.jsp"%>
<div class="container below-banner">
  <c:forEach items="${products}" var="product">
    <%--      <c:url value='shopping-cart' var="linkAddToCart">--%>
    <%--        <c:param name="productId" value="${product.productId}"/>--%>
    <%--      </c:url>--%>
    <div class="card bottom-space">
      <div class="row no-gutters">
        <div class="col-auto">
          <img src="<c:url value="/resources/img/${product.img}" />" class="img-fluid" alt="">
        </div>
        <div class="col">
          <div class="card-block px-2">
            <h4 class="card-title">${product.name}</h4>
            <p class="card-text">
              <c:if test="${(product.price) < 15}">
                <h5>Price: <span class="sale-price">$${product.price}</span> </h5>
              </c:if>
              <c:if test="${(product.price) >= 15}">
                <h5>Price: <span class="">$${product.price}</span> </h5>
              </c:if>
              Qty: <span class="icon-reduce">&minus;</span><input type="number" class="qty-input" value="${qty=0}" /><span class="icon-add">&plus;</span>
            </p>
            <button type="button" id="${product.id}" class="btn btn-primary addToCart">Add to cart</button>
          </div>
        </div>
      </div>
      <div class="card-footer w-100 text-muted">
        In Stock
      </div>
    </div>

<%--    <div class="col-lg-3 col-md-4 col-xs-6 item">--%>
<%--      <div class="card h-100">--%>
<%--        <a href=""><img class="card-img-top" src="<c:url value="/resources/img/${product.img}" />" alt=${product.name}></a>--%>
<%--        <div class="card-body">--%>
<%--          <h4 class="card-title">--%>
<%--            <a href=""><span id="item_${product.id}">${product.name}</span></a>--%>
<%--          </h4>--%>
<%--          <h5>$${product.price}</h5>--%>
<%--          <p class="card-text">${product.name}</p>--%>
<%--        </div>--%>
<%--        <div class="card-footer text-center">--%>
<%--          <a href="" class="btn btn-primary btn-lg active addToCart" role="button" aria-pressed="true">Add to cart</a>--%>
<%--        </div>--%>
<%--      </div>--%>
<%--    </div>--%>
  </c:forEach>
</div>
<%--  --%>
<%--<table id="tbl_products">--%>
<%--    <thead>--%>
<%--    <tr>--%>
<%--      <th>Id</th>--%>
<%--      <th>Name</th>--%>
<%--      <th>Price</th>--%>
<%--    </tr>--%>
<%--    </thead>--%>
<%--    <tbody>--%>
<%--    <c:forEach items="${products}" var="product">--%>
<%--      <tr>--%>
<%--        <td><c:out value="${product.id}" /></td>--%>
<%--        <td><c:out value="${product.name}" /></td>--%>
<%--        <td><c:out value="${product.price}" /></td>--%>
<%--      </tr>--%>
<%--    </c:forEach>--%>
<%--    </tbody>--%>
<%--  </table>--%>


<%--  <fieldset>--%>
<%--    <div>--%>
<%--      <label for="product_id">Id</label> <input type="text" id="product_id"--%>
<%--                                        readonly="readonly" placeholder="Id" />--%>
<%--    </div>--%>
<%--    <div>--%>
<%--      <label for="product_name">Name</label> <input type="text" id="product_name"--%>
<%--                                            placeholder="Name" />--%>
<%--    </div>--%>
<%--    <div>--%>
<%--      <label for="product_price">Price</label> <input type="text" id="product_price"--%>
<%--                                              placeholder="Price" />--%>
<%--    </div>--%>

<%--    <div>--%>
<%--      <input id="btn_add" type="submit" value="Submit" />--%>
<%--    </div>--%>
<%--  </fieldset>--%>
<%--  </body>--%>
<%--</html>--%>
<%--<jsp:include page="shoppingCart.jsp"></jsp:include>--%>
<jsp:include page="footer.jsp"></jsp:include>
