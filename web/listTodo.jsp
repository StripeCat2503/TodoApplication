<%-- 
    Document   : listTodo
    Created on : Dec 5, 2019, 12:16:58 PM
    Author     : Admin
--%>

<%@page import="todo.Todo"%>
<%@page import="user.User"%>
<%@page import="java.util.List"%>
<%@page import="todo.TodoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Todo Application</title>
    </head>
    <body>
        <jsp:include page="_navbar.jsp" />
        <div class="container">
            <h2 class="mt-5">List of Todos</h2>
            <hr>
            <a href="newTodo" class="btn btn-success">Add Todo</a>

            <%
                TodoDAO dao = new TodoDAO();
                User user = (User) session.getAttribute("user");
                if (user != null) {
                    List<Todo> listOfTodo = dao.getAllTodos(user.getUsername());
                    if (listOfTodo != null && !listOfTodo.isEmpty()) {
            %>
            <table class="table mt-5">
                <thead>
                    <tr>
                        <th scope="col">Title</th>
                        <th scope="col">Target Date</th>
                        <th scope="col">Todo Status</th>
                        <th scope="col">Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        for (Todo todo : listOfTodo) {
                            int status = todo.getStatus();
                            String txtStatus = "";
                            String style = "";
                            if (status == 0) {
                                txtStatus = "Not yet";
                                style = "text-danger";
                            } else if (status == 1) {
                                txtStatus = "In Progress";
                                style = "text-primary";
                            } else {
                                txtStatus = "Done";
                                style = "text-success";
                            }

                    %>

                    <tr>
                        <th scope="row"><%= todo.getTitle()%></th>
                        <td><%= todo.getTarget_date().toString()%></td>
                        <td class="<%= style%>"><%= txtStatus%></td>
                        <td>
                            <a href="editTodo?id=<%= todo.getId()%>&user=<%= user.getUsername()%>" class="mr-3">Edit</a>
                            <a href="deleteTodo?id=<%= todo.getId()%>">Delete</a>
                        </td>
                    </tr>
                    <%
                        }
                    } else {
                    %>
                <div class="card mt-5">
                    <div class="card-body text-danger font-weight-bold">
                        There's no todo, add more...
                    </div>
                </div>
                <%
                        }
                    }
                %>



                </tbody>
            </table>
        </div>

        <jsp:include page="footer.html" />
    </body>
</html>
