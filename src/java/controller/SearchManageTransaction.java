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

import dao.ManageTransactionDAO;
import dao.impl.IManageTransactionDAO;
import entity.Order;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nqt26
 */
@WebServlet(name = "SearchManageTransaction", urlPatterns = {"/searchManageTransaction"})
public class SearchManageTransaction extends HttpServlet {

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
            out.println("<title>Servlet SearchManageTransaction</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SearchManageTransaction at " + request.getContextPath() + "</h1>");
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
        try{
        int orderId = Integer.parseInt(request.getParameter("orderId"));
        int sellerId = Integer.parseInt(request.getParameter("sellerId"));
        int buyerId = Integer.parseInt(request.getParameter("buyerId"));
        Date dateFrom = Date.valueOf(request.getParameter("dateFrom"));
        Date dateTo = Date.valueOf(request.getParameter("dateTo"));
        String sortColumn = request.getParameter("sort");
        IManageTransactionDAO iManageTransactionDAO = new ManageTransactionDAO();
        List<Order> listOrder = iManageTransactionDAO.GetOrderByFilter(orderId, sellerId, buyerId, dateFrom, dateTo, sortColumn);
        request.setAttribute("order", listOrder);
        request.getRequestDispatcher("view/ManageTransaction.jsp").forward(request, response);
        } catch (Exception ex) {
             Logger.getLogger(SearchManageTransaction.class.getName()).log(Level.SEVERE, null, ex);
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