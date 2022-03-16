/*
 * Copyright(C) 2021, group 3 SE1511JS
 * T.NET:
 *  Vehicle Store
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2021-02-09      1.0                 levan           Add Field
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.AccountDAO;
import entity.Account;

/**
 * Lớp này có các phương thức thực hiện truy vấn dữ liệu từ bảng Account.
 *
 *
 * @author levan
 */
/**
 *
 * @author levan
 */
public class login extends HttpServlet {

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
        int messcode = 0;
        request.setAttribute("messcode", messcode);
        request.getRequestDispatcher("view/login.jsp").forward(request, response);
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
        String contextPath = request.getContextPath();
        String user = request.getParameter("username").trim();
        String pass = request.getParameter("password").trim();
        int code = Integer.parseInt(request.getParameter("code").trim());
        AccountDAO adb = new AccountDAO();
        Account ac = new Account();
        Account acdb = new Account();
        ac.setUsername(user);
        ac.setPassword(pass);
        acdb = adb.getAccount(ac);
        if (acdb == null) {
            String mess = "InvalidAC";
            int messcode = 0;
            request.setAttribute("messcode", messcode);
            request.setAttribute("mess", mess);
            request.setAttribute("Account", ac);
            request.getRequestDispatcher("view/login.jsp").forward(request, response);
            return;
        }

        if (acdb.getCode() == 0) {
            request.getSession().setAttribute("account", acdb);
            response.sendRedirect(contextPath + pathConnect(acdb));
            return;
        }

        if (acdb.getCode() == code && acdb.getCode() != 0) {
            adb.updateCode(ac);
            request.getSession().setAttribute("account", acdb);
            response.sendRedirect(contextPath + pathConnect(acdb));   
            return;
        }
        
        if (acdb.getCode() != code && acdb.getCode() != 0) {
            int messcode = 1;
            String mess = "InValidCode";
            request.setAttribute("messcode", messcode);
            request.setAttribute("mess", mess);
            request.setAttribute("Account", acdb);
            request.getRequestDispatcher("view/login.jsp").forward(request, response);
            return;
        }
        

    }

    String pathConnect(Account ac) {
        String s = "";   
        if( ac.getRoleId().getRoleId() == 1 ){ s = "/authorize"; } 
        if( ac.getRoleId().getRoleId() == 2 ){ s = "/homePage"; } 
        if( ac.getRoleId().getRoleId() == 3 ){ s = "/homePage"; } 
        return s;
    }

}
