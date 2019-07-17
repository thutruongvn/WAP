<%--
  Created by IntelliJ IDEA.
  User: ThuTruong
  Date: 7/16/2019
  Time: 6:11 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp"></jsp:include>
<div class="container below-banner">
    <%--<h1>Login page</h1>--%>
    <%--&lt;%&ndash;<blockquote>hint: test1/123, test2/123, test3/123</blockquote>&ndash;%&gt;--%>
    <%--<%--%>
    <%--    String userName = "";--%>
    <%--    Cookie[] cookies = request.getCookies();--%>
    <%--    if(cookies !=null){--%>
    <%--        for(Cookie cookie : cookies){--%>
    <%--            if(cookie.getName().equals("username")) {--%>
    <%--                userName = cookie.getValue();--%>
    <%--            }--%>
    <%--        }--%>
    <%--    }--%>
    <%--%>--%>
    <%--<form action="/login" method="post">--%>
    <%--    <div class="row">--%>
    <%--        <div class="column"><span>Username:</span></div>--%>
    <%--        <div class="column">--%>
    <%--            <input type="text" name="txtUsername" value="<%= userName%>"/>--%>
    <%--        </div>--%>
    <%--    </div>--%>
    <%--    <div class="row">--%>
    <%--        <div class="column"><span>Password:</span></div>--%>
    <%--        <div class="column">--%>
    <%--            <input type="password" name="txtPassword" />--%>
    <%--        </div>--%>
    <%--    </div>--%>
    <%--    <div class="column fullWidth row">--%>
    <%--        <label><input type="checkbox" name="chkRemember" /> Remember me</label>--%>
    <%--        &lt;%&ndash;      value="<%= !userName.equals("") %>"&ndash;%&gt;--%>
    <%--    </div>--%>
    <%--    <div class="column fullWidth row">--%>
    <%--        <button id="btnCreateAcc">Login</button>--%>
    <%--    </div>--%>
    <%--</form>--%>
    <div class="row">
            <div class="col-md-6 ">
                <div class="">
                    <h4>Sign In</h4>
                    <p class="login-error"></p>
                    <form action="/login" method="post">
                        <div class="c-input">
                            <div class="input-title">Username:<i class="input-error-txt"
                                    style="display: none;">*</i></div> <input placeholder="" autocomplete=""
                                type="text" name="txtUsername" class="">
                        </div>
                        <div class="c-input">
                            <div class="input-title">Password:<i class="input-error-txt" style="display: none;">*</i>
                            </div> <input placeholder="" autocomplete="" type="password" name="txtPassword" class="">

                        </div>
                        <div class="c-input">
                            <label><input type="checkbox" name="chkRemember" /> Remember me</label>
                        </div>
                        <div class="c-input">
                            <button id="btnLogin">Login</button>
                        </div>
                    </form>
                    <!---->
                </div>
            </div>
            <div class="col-md-1 sign-in-rightborder"></div>
            <div class="col-md-5">
                <div >
                    <h4>Register new account</h4>
<%--                    <c:if test="${sessionScope['success_msg_register'] != null}">--%>
<%--                        <div class="alert alert-success" role="alert">--%>
<%--                            <c:out value="${sessionScope['success_msg_register']}"/>--%>
<%--                                &lt;%&ndash;        <span>If you do not have login access, <a href="/register">click here</a> to create your account.</span>&ndash;%&gt;--%>
<%--                        </div>--%>
<%--                    </c:if>--%>
<%--                    <div class="alert alert-success display-none" role="alert"><span id="registerSuccessMsg"></span></div>--%>
                    <div class="alert alert-danger display-none" role="alert"><span id="registerErrMsg"></span></div>
                    <form >
<%--                        <form action="/register" method="post">--%>
                        <div class="c-input">
                            <div class="input-title">Username:<i class="input-error-txt"
                                    style="display: none;">*</i></div> <input placeholder="" autocomplete=""
                                type="text" name="newUsername" class="">
                            <!---->
                            <!---->
                        </div>
                        <div class="c-input">
                            <div class="input-title">Password:<i class="input-error-txt" style="display: none;">*</i>
                            </div> <input placeholder="" autocomplete="" type="password" name="newPassword" class=""
                                          pattern=".{6,}" title="Six or more characters">

                        </div>
                        <div class="c-input">
                            <div class="input-title">Confirm Password:<i class="input-error-txt"
                                    style="display: none;">*</i></div> <input placeholder="" autocomplete=""
                                type="password" name="cfPassword" class="" pattern=".{6,}" title="Six or more characters">

                        </div>
                        <div class="c-input">
                            <button class="btn-dark btn-register" id="btnRegister">Register</button>
                        </div>
                    </form>

                </div>
            </div>
    </div>
</div>
<jsp:include page="footer.jsp"></jsp:include>