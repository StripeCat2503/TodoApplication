<%-- 
    Document   : _navbar
    Created on : Dec 5, 2019, 10:07:19 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" 
              integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <link rel="stylesheet" href="custom.css" type="text/css">

    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light custom-nav">
            <a class="navbar-brand text-light" href="login">Todo App</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav ml-auto">

                    <c:if test="${not empty sessionScope.user}">
                        <li class="nav-item">
                            <a class="nav-link text-light" href="listTodo.jsp">Hello, ${sessionScope.user.lastName}!</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link text-light" href="logout">Logout</a>
                        </li>
                    </c:if>
                    <c:if test="${empty sessionScope.user}">
                        <li class="nav-item">
                            <a class="nav-link text-light" href="login">Login</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link text-light" href="register.jsp">Sign Up</a>
                        </li>
                    </c:if>
                </ul>

            </div>
        </nav>

        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    </body>
</html>
