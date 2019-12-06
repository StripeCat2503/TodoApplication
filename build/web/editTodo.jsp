<%-- 
    Document   : addNewTodo
    Created on : Dec 5, 2019, 11:34:28 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Todo Application</title>
        <link rel="stylesheet" type="text/css" href="custom.css">

    </head>
    <body>
        <jsp:include page="_navbar.jsp" />
        <div class="container">
            <form action="" method="POST" class="custom-form">
                <h1>Edit Todo</h1>
                <div class="form-group">
                    <label for="todoTitle">Todo Title</label>
                    <input value="${todo.title}" name="txtTodoTitle" type="text" class="form-control" id="todoTitle">              
                </div>
                <div class="form-group">
                    <label for="todoDescription">Todo Description</label>
                    <input value="${todo.description}" name="txtTodoDescription" type="text" class="form-control" id="todoDescription">
                </div>

                <div class="form-group">
                    <label for="todoStatus">Todo Status</label>
                    <select class="form-control" id="todoStatus" name="selectTodoStatus">
                        <option <c:if test="${todo.status == 0}">selected</c:if>>Not yet</option>
                        <option <c:if test="${todo.status == 1}">selected</c:if>>In Progress</option>                      
                        <option <c:if test="${todo.status == 2}">selected</c:if>>Done</option>                       
                    </select>
                </div>

                <div class="form-group">
                    <label for="todoTargetDate">Todo Target Date</label>
                    <input value="${todo.target_date}" name="txtTodoTargetDate" type="date" class="form-control" id="todoTargetDate">
                </div>
                <button type="submit" class="btn btn-success">Save</button>
            </form>
            
        </div>
        <jsp:include page="footer.html" />

    </body>
</html>
