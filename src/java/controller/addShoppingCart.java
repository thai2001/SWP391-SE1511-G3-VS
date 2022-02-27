/*
 * Copyright(C) 2005, G3-VS.
 * Vehicle Store
 *  
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2018-09-10      1.0                 Thainv           First Implement
 */
package controller;

import dao.ShoppingCartDAO;
import dao.impl.IShoppingCartDAO;
import entity.Buyer;
import entity.ShoppingCart;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "addShoppingCart", urlPatterns = {"/addShoppingCart"})
public class addShoppingCart extends HttpServlet {

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
        try {
            //processRequest(request, response);
            HttpSession ses = request.getSession();
            Buyer buyer = (Buyer) ses.getAttribute("buyer");
            IShoppingCartDAO shoppingCartDAO = new ShoppingCartDAO();
            Vector<ShoppingCart> allShoppingCart = shoppingCartDAO.getShoppingCart(buyer.getBuyerId());
            String mess = "";
            int pid = Integer.parseInt(request.getParameter("pid"));
            for (ShoppingCart shoppingCart : allShoppingCart) {
                if (shoppingCart.getProduct().getId() == pid) {
                    mess = "Product already added to Shopping Cart";
                    request.setAttribute("messError", mess);
                    break;

                } else {
                    shoppingCartDAO.addToShoppingCart(buyer.getBuyerId(), pid);
                    mess = "Add to Shopping Cart succusfull";
                    request.setAttribute("messSuccess", mess);
                }
            }
            allShoppingCart = shoppingCartDAO.getShoppingCart(buyer.getBuyerId());
            ses.setAttribute("shoppingCart",allShoppingCart);
            request.getRequestDispatcher("view/productList.jsp").forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(addShoppingCart.class.getName()).log(Level.SEVERE, null, ex);
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
