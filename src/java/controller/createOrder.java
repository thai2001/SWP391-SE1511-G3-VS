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

import dao.OrderDAO;
import dao.OrderDetailDAO;
import dao.ShoppingCartDAO;
import entity.Buyer;
import entity.Order;
import entity.Product;
import entity.ShoppingCart;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
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
 * @author taola
 */
@WebServlet(name = "createOrder", urlPatterns = {"/createOrder"})
public class createOrder extends HttpServlet {

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
        //processRequest(request, response);
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
        try {
            //processRequest(request, response);
            HttpSession ses = request.getSession();
            String today = request.getParameter("today");
            String from = request.getParameter("from");
            String to = request.getParameter("to");
            float total = Float.parseFloat(request.getParameter("total"));
            OrderDAO orderDAO = new OrderDAO();
            OrderDetailDAO orderDetailDAO = new OrderDetailDAO();
            ShoppingCartDAO shoppingCartDAO = new ShoppingCartDAO();

            Buyer buyer = (Buyer) ses.getAttribute("buyer");
            orderDAO.createOrder(today,total, buyer.getBuyerId());
            Order o = orderDAO.getTheLastOrder();
            int oid = o.getOrderId();
            HashMap<Product, Integer> list = (HashMap<Product, Integer>) ses.getAttribute("list");
            for (Map.Entry<Product, Integer> entry : list.entrySet()) {
                Product key = entry.getKey();
                Integer value = entry.getValue();
                orderDetailDAO.createOrderDetail(oid, key.getId(), value, from, to,false,false);
                shoppingCartDAO.deleteCart(buyer.getBuyerId(), key.getId());
            }
            Vector<Order> history = orderDAO.getOrderInPage(1,buyer.getBuyerId());
            int numberOfPage = orderDAO.getNumberOfPage(buyer.getBuyerId());
            ses.setAttribute("numberOfOrderPage", numberOfPage);
            ses.setAttribute("history", history);
            Vector<ShoppingCart> allShoppingCart = shoppingCartDAO.getShoppingCart(buyer.getBuyerId());
            String createOrderSuccess = "Create new Order succuess , new Order ID is " + oid;
            request.setAttribute("createOrderSuccess", createOrderSuccess);
            ses.setAttribute("shoppingCart", allShoppingCart);
            request.getRequestDispatcher("view/history.jsp").forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(createOrder.class.getName()).log(Level.SEVERE, null, ex);
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
