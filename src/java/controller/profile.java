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
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entity.Account;
import entity.Role;

/**
 *
 * @author Admin
 */
public class profile extends BaseReqAuth {

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
        String servletPath = request.getContextPath();
        Account ac = (Account) request.getSession().getAttribute("account");
        Account a = new Account();
        AccountDAO adb = new AccountDAO();
        a = adb.getProfile(ac);
        int role;
        if (ac.getRoleId().getRoleId() == 1) {
            role = 1;
        } else {
            role = 2;
        }
        request.setAttribute("role", role);
        request.setAttribute("Account", a);
        request.getRequestDispatcher("view/profile.jsp").forward(request, response);
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
        //processRequest(request, response);
        String name = request.getParameter("fullname").trim();
        String gmail = request.getParameter("gmail").trim();
        String phone = request.getParameter("phone").trim();
        String address = request.getParameter("address").trim();
        String contextPath = request.getContextPath();
        Account ac = (Account) request.getSession().getAttribute("account");
        String description = null;
        if (ac.getRoleId().getRoleId() == 2) {
            description = request.getParameter("description").trim();
        }
        AccountDAO adb = new AccountDAO();
        Account a = new Account();
        a.setName(name);
        a.setEmail(gmail);
        a.setPhone(phone);
        a.setAddress(address);
        a.setDescription(description);
        a.setUsername(ac.getUsername());
        a.setRoleId(new Role(ac.getRoleId().getRoleId()));
        adb.updateProfile(a);
        //response.sendRedirect(contextPath + "/profile");
        int role;
        if (ac.getRoleId().getRoleId() == 1) {
            role = 1;
        } else {
            role = 2;
        }
        request.setAttribute("mess1", 1);
        request.setAttribute("role", role);
        request.setAttribute("Account", a);
        request.getRequestDispatcher("view/profile.jsp").forward(request, response);
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
