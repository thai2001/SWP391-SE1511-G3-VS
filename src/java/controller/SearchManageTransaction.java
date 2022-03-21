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
import entity.Account;
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
import javax.servlet.http.HttpSession;

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
        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("account");
        if (account.getRoleId().getRoleId() != 1) {
            response.sendRedirect("view/forbiddenPage.jsp");
        }
        String url = request.getParameter("url");
        if (url == null) {
            url = request.getRequestURL() + "?" + request.getQueryString() + "&";
        }
        int orderId = 0;
        int sellerId = 0;
        int buyerId = 0;
        Date dateFrom = Date.valueOf("2018-01-01");
        Date dateTo = new Date(System.currentTimeMillis());
        Date change = null;        
        String sortColumn = request.getParameter("sort").trim();
        if (request.getParameter("orderId").trim().length() > 9 || request.getParameter("sellerId").trim().length() > 9
                || request.getParameter("buyerId").trim().length() > 9) {
            request.setAttribute("alert", "warning");
            request.setAttribute("message", "number of characters not excess 9 !");
            request.setAttribute("orderId", request.getParameter("orderId").trim());
            request.setAttribute("sellerId", request.getParameter("sellerId").trim());
            request.setAttribute("buyerId", request.getParameter("buyerId").trim());
            request.setAttribute("dateFrom", dateFrom);
            request.setAttribute("dateTo", dateTo);
            request.setAttribute("sort", sortColumn);
            request.getRequestDispatcher("view/ManageTransaction.jsp").forward(request, response);
        }
        try {
            if (request.getParameter("orderId").trim().length() > 0) {
                orderId = Integer.parseInt(request.getParameter("orderId").trim());
                request.setAttribute("orderId", orderId);
            }
            if (request.getParameter("sellerId").trim().length() > 0) {
                sellerId = Integer.parseInt(request.getParameter("sellerId").trim());
                request.setAttribute("sellerId", sellerId);
            }
            if (request.getParameter("buyerId").trim().length() > 0) {
                buyerId = Integer.parseInt(request.getParameter("buyerId").trim());
                request.setAttribute("buyerId", buyerId);
            }
        } catch (NumberFormatException nfe) {
            request.setAttribute("alert", "warning");
            request.setAttribute("message", "Input number is required !");
            request.setAttribute("dateFrom", dateFrom);
            request.setAttribute("dateTo", dateTo);
            request.setAttribute("sort", sortColumn);
            request.getRequestDispatcher("view/ManageTransaction.jsp").forward(request, response);
        }
        if (orderId < 0 || sellerId < 0 || buyerId < 0) {
            request.setAttribute("alert", "warning");
            request.setAttribute("message", "Must input positive number !");
            request.setAttribute("orderId", request.getParameter("orderId").trim());
            request.setAttribute("sellerId", request.getParameter("sellerId").trim());
            request.setAttribute("buyerId", request.getParameter("buyerId").trim());
            request.setAttribute("dateFrom", dateFrom);
            request.setAttribute("dateTo", dateTo);
            request.setAttribute("sort", sortColumn);
            request.getRequestDispatcher("view/ManageTransaction.jsp").forward(request, response);
        }
        if (request.getParameter("dateFrom").trim().length() > 0) {
            Date dateFromfa = Date.valueOf(request.getParameter("dateFrom").trim());
            if (dateFrom.before(dateFromfa)) {
                dateFrom = dateFromfa;
            }
        }
        if (request.getParameter("dateTo").trim().length() > 0) {
            Date dateTofa = Date.valueOf(request.getParameter("dateTo").trim());
            if (dateTo.after(dateTofa)) {
                dateTo = dateTofa;
            }
        }
        if (dateFrom.after(dateTo)) {
            change = dateFrom;
            dateFrom = dateTo;
            dateTo = change;

        }

        IManageTransactionDAO iManageTransactionDAO = new ManageTransactionDAO();
        List<Order> list = null;
        try {
            list = iManageTransactionDAO.GetOrderByFilter(orderId, sellerId, buyerId, dateFrom, dateTo, sortColumn);
        } catch (Exception ex) {
            Logger.getLogger(SearchManageTransaction.class.getName()).log(Level.SEVERE, null, ex);
        }
        int size = list.size();
        String sNumPerPage = request.getParameter("numPerPage");
        int numPerPage;
        if (sNumPerPage == null || sNumPerPage.length() == 0) {
            numPerPage = 5;
        } else {
            numPerPage = Integer.parseInt(sNumPerPage);
        }

        int numPage = size / numPerPage + (size % numPerPage == 0 ? 0 : 1);
        String spage = request.getParameter("page");
        int page;
        if (spage == null) {
            page = 1;
        } else {
            page = Integer.parseInt(spage);
        }
        int start, end;
        start = (page - 1) * numPerPage;
        end = Math.min(size, page * numPerPage);
        List<Order> listOrder = iManageTransactionDAO.GetOrderByPage(list, start, end);
        request.setAttribute("listSize", size);
        request.setAttribute("numPerPage", numPerPage);
        request.setAttribute("num", numPage);
        request.setAttribute("page", page);
        request.setAttribute("url", "searchManageTransaction?orderId="+orderId+"&buyerId="+buyerId+"&"
                + "sellerId="+sellerId+"&dateFrom="+dateFrom+"&dateTo="+dateTo+"&sort="+sortColumn+"&");
        request.setAttribute("dateFrom", dateFrom);
        request.setAttribute("dateTo", dateTo);
        request.setAttribute("sort", sortColumn);
        request.setAttribute("order", listOrder);
        request.getRequestDispatcher("view/ManageTransaction.jsp").forward(request, response);
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
