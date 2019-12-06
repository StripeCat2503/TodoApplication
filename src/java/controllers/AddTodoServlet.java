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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import todo.Todo;
import todo.TodoDAO;
import user.User;

/**
 *
 * @author Admin
 */
@WebServlet(name = "AddTodoServlet", urlPatterns = {"/newTodo"})
public class AddTodoServlet extends HttpServlet {
    
    private final String ADD_TODO_PAGE = "addNewTodo.jsp";
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
        response.sendRedirect(ADD_TODO_PAGE);
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
        String todoDescription = request.getParameter("txtTodoDescription");
        String txtTodoStatus = request.getParameter("selectTodoStatus");
        HttpSession session = request.getSession(false);
        User user = null;
        
        String url = "";
        
        if(session != null){
            user = (User) session.getAttribute("user");
        }
        
        int todoStatus;
        
        if(txtTodoStatus.equals("Not yet")){
            todoStatus = 0;
        }
        else if(txtTodoStatus.equals("In Progress")){
            todoStatus = 1;
        }
        else{
            todoStatus = 2;
        }
        
        String txtTodoTargetDate = request.getParameter("txtTodoTargetDate");
        SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date sqlDate = null;
        try {
            Date date = fm.parse(txtTodoTargetDate);
            sqlDate = new java.sql.Date(date.getTime());          
           
        } catch (ParseException ex) {
            log("ERR AT AddTodoServlet: " + ex.getMessage());
        }
        
        Todo todo = new Todo(todoDescription, todoStatus, sqlDate, todoTitle, user.getUsername());
        
        TodoDAO dao = new TodoDAO();
        boolean success = dao.saveNewTodo(todo);
        
        if(success){
            url = TODO_PAGE;
        }
        else{
            url = ADD_TODO_PAGE;
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
