<%--
  Created by IntelliJ IDEA.
  User: ThuTruong
  Date: 7/15/2019
  Time: 7:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- The Modal -->
<%--<div id="shoppingCartModal" class="modal">--%>

<%--    <!-- Modal content -->--%>
<%--    <div class="modal-content">--%>
<%--        <span class="close">&times;</span>--%>
<jsp:include page="header.jsp"></jsp:include>
<div class="container below-banner">
        <div id="productTitle" ><h1>Your Cart</h1></div>

        <div class="row shopping-cart">

            <table class="table table-bordered table-striped">
                <thead>
                <tr>
                    <th>Select</th>
                    <th>Image</th>
                    <th>Product Name</th>
                    <th>Quantity</th>
                    <th>Unit Price</th>
                    <th>Total</th>
                </tr>
                </thead>
                <tbody id="tblMyCart">
                <c:forEach items="${cartItems}" var="item">
                    <tr class="item" id="item_${item.item.id}">
                        <td><input class="check" type="checkbox" value="${item.item.id}"></td>
                        <td class="muted center_text"><a href="/">
                            <img src="<c:url value="/resources/img/${item.item.img}" />" class="img-thumbnail width100"
                                 alt="${item.item.name}"></a>
                        </td>
                        <td>${item.item.name}</td>
                        <td>
<%--                            <span class="display-none">&minus;</span>--%>
                            <input class="qty" type="number" placeholder="1" class="input-mini" value="${item.quantity}"
                                   min="1" id="quantity_${item.item.id}" >
<%--                            <span class="icon-add">&plus;</span>--%>
                        </td>
                        <td ><span class="price format-money">${item.item.price}</span> </td>
                        <td ><span class="total format-money" id="sum_${item.item.id}">${item.item.price * item.quantity}</span> </td>
                    </tr>
                </c:forEach>
                <tr>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                    <td><strong>Total</strong></td>
                    <td><strong >$<span id="sum">${totalPrice}</span></strong></td>
                </tr>
                </tbody>
            </table>
        </div>
        <div class="row shopping-cart">
            <div class="col-sm-2 left">
                <button type="button" class="btn btn-danger" id="btnRemove" value="remove">
                    <span class="fa fa-check-circle"></span> Remove
                </button>
            </div>
            <div class="col-sm-2 left">
                <button type="button" class="btn btn-outline-primary" id="btnUpdate" value="update">
                    <span class="fa fa-check-circle"></span> Update
                </button>
            </div>
            <div class="col-sm-5 right">
                <a href="/" class="btn btn-info" id="btnContinueShopping">
                    <span class="fa fa-forward"></span> Continue shopping
                </a>
            </div>
            <div class="col-sm-2 right">
                <button type="button" class="btn btn-primary" id="btnCheckout">
                    <span class="fa fa-calendar"></span> Checkout
                </button>
            </div>
        </div>
    </div>

<%--</div>--%>
<%--<script>--%>

<%--    var modal = document.getElementById("myModal");--%>

<%--    // Get the <span> element that closes the modal--%>
<%--    var span = document.getElementsByClassName("close")[0];--%>

<%--    // When the user clicks the button, open the modal--%>
<%--    window.onload = function() {--%>
<%--        modal.style.display = "block";--%>
<%--    }--%>

<%--    // When the user clicks on <span> (x), close the modal--%>
<%--    span.onclick = function() {--%>
<%--        modal.style.display = "none";--%>
<%--    }--%>
<%--</script>--%>
<jsp:include page="footer.jsp"></jsp:include>