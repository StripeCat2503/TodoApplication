<%-- 
    Document   : register
    Created on : Dec 5, 2019, 12:38:12 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Todo Application</title>
    </head>
    <body>
        <jsp:include page="_navbar.jsp" />

        <div class="container">
            <h1 class="mt-5">Create new account</h1>
            <form action="register" method="POST" class="custom-form">
                <div class="form-group">
                    <label for="firstNameInput">First Name</label>
                    <input name="txtFirstName" type="text" class="form-control" id="firstNameInput" placeholder="First name">                  
                </div>
                
                <div class="form-group">
                    <label for="lastNameInput">Last Name</label>
                    <input name="txtLastName" type="text" class="form-control" id="lastNameInput" placeholder="Last name">                  
                </div>
                
                <div class="form-group">
                    <label for="usernameInput">Username</label>
                    <input name="txtUsername" type="text" class="form-control" id="usernameInput" placeholder="Username">                  
                </div>
                
                <div class="form-group">
                    <label for="passwordInput">Password</label>
                    <input name="txtPassword" type="password" class="form-control" id="passwordInput" placeholder="Password">                  
                </div>
               
                <button type="submit" class="btn btn-primary">Sign Up</button>
            </form>
        </div>
        <jsp:include page="footer.html" />
    </body>
</html>
