<%--
  Created by IntelliJ IDEA.
  User: ThuTruong
  Date: 7/17/2019
  Time: 2:00 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp"></jsp:include>
<div class="container below-banner">


<c:if test="${user_info != null}">
    <div class="container">
        <div id="productTitle"><h1>Checkout</h1></div>
        <div class="row shopping-cart">
            <form class="payment-form">
                <div class="form-group row">
                    <label for="fullName" class="col-sm-2 col-form-label">User Name</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="fullName" name="fullName" placeholder="Name" value="${user.username}" required>
                    </div>
                </div>
                <div class="form-group row">
                    <label for="address" class="col-sm-2 col-form-label">Shipping Address</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="address" name="address" placeholder="Address" value="" required>
                    </div>
                </div>
                <div class="form-group row">
                    <label for="address" class="col-sm-2 col-form-label">Payment</label>
                    <div class="col-sm-10">
                        <div class="form-check">
                            <label class="form-check-label" for="payInStore">
                                <input class="form-check-input" type="radio" id="payInStore" name="payment" value="Pay In Store" checked>
                                Pay In Store
                            </label>
                        </div>
                        <div class="form-check">
                            <label class="form-check-label" for="card">
                                <input class="form-check-input" type="radio" name="payment" id="card" value="Card">
                                Pay By Card
                            </label>
                        </div>
                    </div>
                </div>
                <div class="form-group row">
                    <label for="comment" class="col-sm-2 col-form-label">Comment</label>
                    <div class="col-sm-10">
                        <textarea cols="100" rows="10" class="form-control" id="comment" name="comment" placeholder="Comment"></textarea>
                    </div>
                </div>
                <div class="form-group row">
                    <div class="offset-sm-2 col-sm-10">
                        <button type="submit" class="btn btn-outline-primary">
                            <span class="fa fa-calendar"></span> Confirm
                        </button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</c:if>
</div>
<jsp:include page="footer.jsp"></jsp:include>
