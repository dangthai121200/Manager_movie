/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Admin;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ModelAdmin;

/**
 *
 * @author gaone
 */
public class ControllerRegister extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControllerRegister</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControllerRegister at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        processRequest(request, response);
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
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String returnPassword = request.getParameter("returnpassword");
        boolean checkName = new ModelAdmin().checkName(username);
        if (checkName) {
            if (password.equals(returnPassword)) {
                   saveAdmin(request,response,username,password);
            } else {
                checkPassword(request, response, username);
            }
        } else {
            checkUserName(request, response);
        }
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

    private void checkUserName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //error=2 username đã tồn tại
        request.setAttribute("error", "2");
        request.getRequestDispatcher("createaccount.jsp").forward(request, response);
    }

    private void checkPassword(HttpServletRequest request, HttpServletResponse response, String username) throws ServletException, IOException {
        //error=1 password không giống nhau
        request.setAttribute("error", "1");
        request.setAttribute("username", username);
        request.getRequestDispatcher("createaccount.jsp").forward(request, response);
    }

    private void saveAdmin(HttpServletRequest request, HttpServletResponse response, String username, String password) throws ServletException, IOException {
        new ModelAdmin().add(new Admin(username, password));
        request.setAttribute("username", username);
        request.setAttribute("password", password);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
