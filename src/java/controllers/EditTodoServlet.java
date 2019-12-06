/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import todo.Todo;
import todo.TodoDAO;

/**
 *
 * @author Admin
 */
@WebServlet(name = "EditTodoServlet", urlPatterns = {"/editTodo"})
public class EditTodoServlet extends HttpServlet {
    
    private final String EDIT_TODO_PAGE = "editTodo.jsp";
    private final String TODO_PAGE = "listTodo.jsp";
    

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String todoId = request.getParameter("id");
        long id = Long.parseLong(todoId);
        TodoDAO dao = new TodoDAO();
        Todo todo = dao.getTodo(id);
        if(todo != null){
            request.setAttribute("todo", todo);
        }
        RequestDispatcher rd = request.getRequestDispatcher(EDIT_TODO_PAGE);
        rd.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String todoTitle = request.getParameter("txtTodoTitle");
        String todoDesciption = request.getParameter("txtTodoDescription");
        String txtTodoStatus = request.getParameter("selectTodoStatus");
        
        String username = request.getParameter("user");
        String todoId = request.getParameter("id");
        long id = Long.parseLong(todoId);
        
        String url = "";
        
        int status;
        if(txtTodoStatus.equals("Not yet")){
            status = 0;
        }
        else if(txtTodoStatus.equals("In Progress")){
            status = 1;
        }
        else{
            status = 2;
        }
        
        String txtTargetDate = request.getParameter("txtTodoTargetDate");
        SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date sqlDate = null;
        Date date = null;
        try {
            date = fm.parse(txtTargetDate);
            sqlDate = new java.sql.Date(date.getTime());
        } catch (ParseException ex) {
            log("ERR AT EditTodoServlet: " + ex.getMessage());
        }
        
        Todo newTodo = new Todo(todoDesciption, status, sqlDate, todoTitle, username);
        newTodo.setId(id);
        
        TodoDAO dao = new TodoDAO();
        boolean success = dao.updateTodo(newTodo);
       
        if(success){
            url = TODO_PAGE;
        }
        else{
            url = EDIT_TODO_PAGE;
        }
        
        response.sendRedirect(url);
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
