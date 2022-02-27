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
 *
 * @author Admin
 */
public class changePass extends HttpServlet {

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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("view/changePass.jsp").forward(request, response);
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
        String user = request.getParameter("username").trim();
        String pass = request.getParameter("oldpassword").trim();
        String newpass = request.getParameter("newpassword").trim();

        AccountDAO adb = new AccountDAO();
        Account a = new Account();
        a.setUsername(user);
        a.setPassword(pass);

        Account ac = adb.getAccount(a);

        if (ac == null) {
            String mess = "InvalidAC";
            request.setAttribute("mess", mess);
            request.setAttribute("Account", a);
            request.setAttribute("newpass", newpass);
            request.getRequestDispatcher("view/changePass.jsp").forward(request, response);
            return;
        }

        if (ac != null) {
            if (ac.getCode() != 0) {
                int messcode = 1;
                String mess = "InValidCode";
                request.setAttribute("messcode", messcode);
                request.setAttribute("mess", mess);
                request.setAttribute("Account", ac);
                request.getRequestDispatcher("view/login.jsp").forward(request, response);
                return;
            }
            if (ac.getCode() == 0) {
                adb.changePass(a, newpass);
                response.sendRedirect("login");
                return;
            }
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

}
