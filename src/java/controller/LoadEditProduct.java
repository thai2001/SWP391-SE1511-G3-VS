/*
 * Copyright(C) 2005, G3-VS.
 * Vehicle Store
 *  
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2022-02-15      1.0                 QuanTBA          Add Field
 */
package controller;

import dao.BrandDAO;
import dao.ManageProductDAO;
import dao.VehicleTypeDAO;
import entity.Brand;
import entity.Product;
import entity.VehicleType;
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
 *This class contains method to get product,brand,vehicleType information from table Product,Brand,vehicleType in database 
 * The method will throw<code>Exception</code> if there is any error occurring when getting data from database
 * <p> Bugs: </p>
 * @author QuanTBA
 */
public class LoadEditProduct extends HttpServlet {

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
            out.println("<title>Servlet LoadEditProduct</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoadEditProduct at " + request.getContextPath() + "</h1>");
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
         int pid = Integer.parseInt(request.getParameter("pid")); //Lấy id của sản phẩm
        ManageProductDAO manageproductdao = new ManageProductDAO();
        BrandDAO brandDao = new BrandDAO();
        VehicleTypeDAO vehicleTypeDao = new VehicleTypeDAO();
        Product prod = manageproductdao.getProductByID(pid);
        List<Brand> listbrand = brandDao.getAllBrand();
        List<VehicleType> listvehicleType = vehicleTypeDao.getAllVehicleType();
   
         request.setAttribute("vehicleType", listvehicleType);
         request.setAttribute("brand", listbrand);
        request.setAttribute("product", prod);
        request.getRequestDispatcher("view/Edit.jsp").forward(request, response);
    
    }catch(Exception ex){
    Logger.getLogger(LoadEditProduct.class.getName()).log(Level.SEVERE, null, ex);
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
