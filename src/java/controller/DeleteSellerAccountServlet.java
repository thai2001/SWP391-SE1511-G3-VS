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

import dao.AuthorizeSellerDAO;
import dao.ManageAccountDAO;
import dao.impl.IAuthorizeSellerDAO;
import dao.impl.IManageAccountDAO;
import entity.Account;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author nqt26
 */
public class DeleteSellerAccountServlet extends HttpServlet {

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
            out.println("<title>Servlet DeleteSellerAccountServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DeleteSellerAccountServlet at " + request.getContextPath() + "</h1>");
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
        HttpSession session = request.getSession();
            Account account = (Account)session.getAttribute("account");
            if ( account.getRoleId().getRoleId() != 1 ){
                response.sendRedirect("view/forbiddenPage.jsp");
            }
        int roleId = Integer.parseInt(request.getParameter("roleId")); // vai tr?? kh??ch h??ng
        int cusId = Integer.parseInt(request.getParameter("id"));// Id kh??ch h??ng
        IManageAccountDAO iManageAccountDao = new ManageAccountDAO();
        Account delAccount = null;
        try {
            delAccount = iManageAccountDao.searchAccount(roleId, cusId);
        } catch (Exception ex) {
            Logger.getLogger(DeleteSellerAccountServlet.class.getName()).log(Level.SEVERE, null, ex);
        }        
        IAuthorizeSellerDAO iAuthorizeSellerDAO = new AuthorizeSellerDAO();
        iAuthorizeSellerDAO.denySellerAccount(account.getUsername());
        response.sendRedirect("authorize");
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
        processRequest(request, response);
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
