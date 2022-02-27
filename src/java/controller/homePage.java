/*
 * Copyright(C) 2021, group 3 SE1511JS
 * T.NET:
 *  Vehicle Store
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2021-02-09      1.0                 ThaiNV           Add Field
 */
package controller;

import dao.BrandDAO;
import dao.ProductDAO;
import dao.ShoppingCartDAO;
import dao.VehicleTypeDAO;
import entity.Product;
import entity.VehicleType;
import entity.Brand;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.impl.IProductDAO;
import dao.impl.IShoppingCartDAO;
import entity.ShoppingCart;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *HomePage
 * take all car and moto from database
 * @author ThaiNV 
 */
public class homePage extends HttpServlet {

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
            IProductDAO productDao = new ProductDAO();
            VehicleTypeDAO vehicleTypeDao = new VehicleTypeDAO();
            BrandDAO brandDao = new BrandDAO();
            Vector<Product> allCar = (Vector) productDao.getAllProductsByVehicleTypeId(1);
            Vector<Product> allMoto = (Vector) productDao.getAllProductsByVehicleTypeId(2);
            Vector<VehicleType> allVehicleType = (Vector) vehicleTypeDao.getAllVehicleType();
            Vector<Brand> allBrand = brandDao.getAllBrand();
            if(ses.getAttribute("account") != null){
                IShoppingCartDAO shoppingCartDAO = new ShoppingCartDAO();
                Vector<ShoppingCart> allShoppingCart = shoppingCartDAO.getShoppingCart(1); // fix cunng
                ses.setAttribute("shoppingCart", allShoppingCart);
            }
            ses.setAttribute("allBrand", allBrand);
            ses.setAttribute("allVehicleType", allVehicleType);
            ses.setAttribute("allCar", allCar);
            ses.setAttribute("allMoto", allMoto);
            request.getRequestDispatcher("view/homePage.jsp").forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(homePage.class.getName()).log(Level.SEVERE, null, ex);
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
