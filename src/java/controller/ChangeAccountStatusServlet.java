/*
 * Copyright(C) 2005, G3-VS.
 * Vehicle Store
 *  
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 16/02/2022      1.0                 TungNQ           First Implement
 */
package controller;

import dao.ManageAccountDAO;
import dao.impl.IManageAccountDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Thay đổi status của account
 *
 * @author nqt26
 */
public class ChangeAccountStatusServlet extends HttpServlet {

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
            out.println("<title>Servlet ChangeAccountStatusServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ChangeAccountStatusServlet at " + request.getContextPath() + "</h1>");
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
        String status = request.getParameter("status");// lấy thông tin trạng thái của tài khoản
        String username = request.getParameter("username"); // lấy username của tài khoản
        IManageAccountDAO manageAccountDAO = new ManageAccountDAO();
        if (status.equalsIgnoreCase("active")) {
            manageAccountDAO.deactiveAccount(username);
            request.setAttribute("note", "Hủy kích hoạt tài khoản thành công");
            request.getRequestDispatcher("manageAccount").forward(request, response);            
        } else if (status.equalsIgnoreCase("inactive")) {
            manageAccountDAO.activeAccount(username);
            request.setAttribute("note", "Kích hoạt tài khoản thành công");
            request.getRequestDispatcher("manageAccount").forward(request, response);
        }
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
