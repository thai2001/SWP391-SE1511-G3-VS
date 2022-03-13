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

import dao.BuyerDAO;
import dao.ManageAccountDAO;
import dao.RoleDAO;
import dao.SellerDAO;
import dao.impl.IBuyerDAO;
import dao.impl.IManageAccountDAO;
import dao.impl.IRoleDAO;
import dao.impl.ISellerDAO;
import entity.Account;
import entity.Buyer;
import entity.Role;
import entity.Seller;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * tìm kiếm tài khoản
 *
 * @author nqt26
 */
public class SearchAccountServlet extends HttpServlet {

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
            out.println("<title>Servlet SearchAccountServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SearchAccountServlet at " + request.getContextPath() + "</h1>");
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
//        try {
        int roleId = Integer.parseInt(request.getParameter("roleId").trim());
        int id = 0;
        try {
        id = Integer.parseInt(request.getParameter("uid").trim()); }
        catch (NumberFormatException nfe){
            request.setAttribute("notice", "Number required !");
            request.getRequestDispatcher("manageAccount").forward(request, response);
        }
        IManageAccountDAO manageaccountdao = new ManageAccountDAO();
        IBuyerDAO iBuyerDAO = new BuyerDAO();
        ISellerDAO iSellerDAO = new SellerDAO();
        List<Account> account = null;
        Buyer buyer = null;
        Seller seller = null;
        try {
            account = manageaccountdao.searchAccount(roleId, id);
            if (roleId == 2) {
                buyer = iBuyerDAO.getBuyer(account.get(0).getUsername());
            }
            if (roleId == 3) {
                seller = iSellerDAO.getSeller(account.get(0).getUsername());
                int numberProductSale = iSellerDAO.getNumberOfProductOnSale(seller.getSellerId());
                request.setAttribute("numberProduct", numberProductSale);
            }
        } catch (Exception ex) {
            Logger.getLogger(SearchAccountServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("roleId", roleId);
        request.setAttribute("id", id);
        request.setAttribute("account", account);
        request.setAttribute("seller", seller);
        request.setAttribute("buyer", buyer);
        request.getRequestDispatcher("manageAccount").forward(request, response);
//        } catch (NullPointerException npt) {
//            response.sendRedirect("login");
//        }
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
