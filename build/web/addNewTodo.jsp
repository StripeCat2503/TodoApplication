<%-- 
    Document   : addNewTodo
    Created on : Dec 5, 2019, 11:34:28 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            <form action="newTodo" method="POST" class="custom-form">
                <h1>Add New Todo</h1>
                <div class="form-group">
                    <label for="todoTitle">Todo Title</label>
                    <input name="txtTodoTitle" type="text" class="form-control" id="todoTitle">              
                </div>
                <div class="form-group">
                    <label for="todoDescription">Todo Description</label>
                    <input name="txtTodoDescription" type="text" class="form-control" id="todoDescription">
                </div>

                <div class="form-group">
                    <label for="todoStatus">Todo Status</label>
                    <select class="form-control" id="todoStatus" name="selectTodoStatus">
                        <option>Not yet</option>
                        <option>In Progress</option>                      
                        <option>Done</option>                       
                    </select>
                </div>

                <div class="form-group">
                    <label for="todoTargetDate">Todo Target Date</label>
                    <input name="txtTodoTargetDate" type="date" class="form-control" id="todoTargetDate">
                </div>
                <button type="submit" class="btn btn-success">Save</button>
            </form>
            
        </div>
        <jsp:include page="footer.html" />

    </body>
</html>
