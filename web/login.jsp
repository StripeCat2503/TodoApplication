<%-- 
    Document   : login
    Created on : Dec 5, 2019, 10:09:14 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Todo Application</title>
        <link rel="stylesheet" href="custom.css" type="text/css">
    </head>
    <body>
        <jsp:include page="_navbar.jsp" />

        <div class="container">
            <form action="login" method="POST" class="custom-form">
                <h1>Login Form</h1>
                <div class="form-group">
                    <label for="usernameInput">Username</label>
                    <input name="txtUsername" type="text" class="form-control" id="usernameInput" placeholder="Username">                    
                </div>
                <div class="form-group">
                    <label for="passwordInput">Password</label>
                    <input name="txtPassword" type="password" class="form-control" id="passwordInput" placeholder="Password">                   
                </div>
                <c:if test="${not empty loginErr}">
                    <p style="color: red">${loginErr}</p>
                </c:if>
                <button type="submit" class="btn btn-primary">Login</button>
            </form>
        </div>
        <jsp:include page="footer.html" />
    </body>
</html>
