/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Admin;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ModelAdmin;
import org.apache.commons.lang3.text.WordUtils;
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
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        //Lấy value từ form
        String fullName=request.getParameter("fullname").toLowerCase();
        String userName = request.getParameter("username");
        String passWord = request.getParameter("password");  
        String returnPassword = request.getParameter("returnpassword");
        String checkPolicy=request.getParameter("checkbox");
          
   
        
        //kiểm tra có lỗi hay không có thì chuyển hướng về lại trang register cùng các tham số fullName,userName,passWord và các lỗi
        boolean checkErr=checkError(request,response,userName,passWord,returnPassword,checkPolicy);
        if(checkErr){
            request.setAttribute("fullName", fullName);
            request.setAttribute("userName", userName);
            request.getRequestDispatcher("createaccount.jsp").forward(request, response);
        }else{
            fullName=WordUtils.capitalizeFully(fullName);
            saveAdmin(request,response,new Admin(fullName,userName,passWord));
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

    //Kiểm tra tất cả các lỗi nếu có lỗi trả true,không có lỗi trả về false
    private boolean checkError(HttpServletRequest request,HttpServletResponse response, String userName,String passWord,String returnPassword,String checkPolicy) throws ServletException, IOException{
        checkUserName(request,response,userName);
        checkPassword(request,response,passWord,returnPassword);
        checkPolicy(request,response,checkPolicy);
         if(request.getAttribute("errorUserName")!=null||request.getAttribute("errorPassword")!=null||request.getAttribute("errorPolicy")!=null){
          return true;
        }
         return false;
    }
    
    //set lỗi username có đã có tồn tại
    private void checkUserName(HttpServletRequest request, HttpServletResponse response,String userName) throws ServletException, IOException {
         boolean checkUserName = new ModelAdmin().checkName(userName);
         if(checkUserName){
             //error=errorusername username đã tồn tại   
             request.setAttribute("errorUserName", "errorusername");
         }                  
       
    }
    
    //set lỗi password không giống nhau
    private void checkPassword(HttpServletRequest request, HttpServletResponse response,String passWord,String returnPassword) throws ServletException, IOException {
       
        if(passWord.equals(returnPassword)==false){
             //error=errorpassword password không giống nhau
              request.setAttribute("errorPassword", "errorpassword");
        }      
    }
    
    //set lỗi chưa check vào đồng ý với chính sách bảo mật
    private void checkPolicy(HttpServletRequest request, HttpServletResponse response,String checkPolicy) throws ServletException, IOException {
         if(checkPolicy==null){
             //error=errorPolicy chưa check chính sách bảo mật  
             request.setAttribute("errorPolicy", "errorpolicy");
         }                  
    }
    
    //Lưu thông tin admin và chuyển hướng về trang login
    private void saveAdmin(HttpServletRequest request, HttpServletResponse response,Admin admin) throws ServletException, IOException {
        new ModelAdmin().add(admin);
        request.setAttribute("username", admin.getUsername());
        request.setAttribute("password", admin.getPassword());
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
