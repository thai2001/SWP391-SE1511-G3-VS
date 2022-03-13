/*
 * Copyright(C) 2005, G3-VS.
 * Vehicle Store
 *  
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2018-09-10      1.0                 MinhLH           First Implement
 */
package controller;

import dao.AccountDAO;
import entity.Account;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.SecureRandom;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Lớp này có các phương thức thực hiện truy vấn dữ liệu từ bảng Account.Thay
 * đổi mật khẩu người dùng
 *
 *
 * @author levan
 */
/**
 *
 * @author levan
 */
public class changePass extends BaseReqAuth {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
    protected void processGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //request.getRequestDispatcher("view/changePass.jsp").forward(request, response);
        response.sendRedirect(request.getContextPath()+"/profile");
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
    protected void processPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String user = request.getParameter("username").trim();
        String pass = request.getParameter("oldpassword").trim();
        String newpass = request.getParameter("newpassword").trim();
        Account ac = (Account) request.getSession().getAttribute("account");
        System.out.println(user);
        System.out.println(pass);
        System.out.println(newpass);

        System.out.println(ac.getUsername());
        System.out.println(ac.getPassword());
        AccountDAO adb = new AccountDAO();
        Account a = new Account();
        Account a1 = new Account();
     
        if (ac.getUsername().equals(user) && ac.getPassword().equals(pass)) {
            adb.changePass(ac, newpass);
            request.setAttribute("Account", adb.getProfile(ac));
            request.setAttribute("mess2", 1);
            request.setAttribute("role", ac.getRoleId().getRoleId());
            request.getRequestDispatcher("view/profile.jsp").forward(request, response);
            return;
        }
   
        a1.setUsername(user);
        a1.setPassword(pass);
        request.setAttribute("mess", "InvalidAC");
        request.setAttribute("Account", adb.getProfile(ac));
        request.setAttribute("Account1", a1);
        request.setAttribute("newpass", newpass);
        request.setAttribute("role", ac.getRoleId().getRoleId());
        request.getRequestDispatcher("view/profile.jsp").forward(request, response);
        //return;
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
