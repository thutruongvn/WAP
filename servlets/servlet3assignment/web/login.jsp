<%--
  Created by IntelliJ IDEA.
  User: ThuTruong
  Date: 7/16/2019
  Time: 6:11 PM
  To change this template use File | Settings | File Templates.
--%>
<jsp:include page="header.jsp"></jsp:include>
<div class="container">
<h1>Login page</h1>
<%--<blockquote>hint: test1/123, test2/123, test3/123</blockquote>--%>
<%
    String userName = "";
    Cookie[] cookies = request.getCookies();
    if(cookies !=null){
        for(Cookie cookie : cookies){
            if(cookie.getName().equals("username")) {
                userName = cookie.getValue();
            }
        }
    }
%>
<form action="/login" method="post">
    <div class="row">
        <div class="column"><span>Username:</span></div>
        <div class="column">
            <input type="text" name="txtUsername" value="<%= userName%>"/>
        </div>
    </div>
    <div class="row">
        <div class="column"><span>Password:</span></div>
        <div class="column">
            <input type="password" name="txtPassword" />
        </div>
    </div>
    <div class="column fullWidth row">
        <label><input type="checkbox" name="chkRemember" /> Remember me</label>
        <%--      value="<%= !userName.equals("") %>"--%>
    </div>
    <div class="column fullWidth row">
        <button id="btnCreateAcc">Login</button>
    </div>
</form>
</div>
<jsp:include page="footer.jsp"></jsp:include>
