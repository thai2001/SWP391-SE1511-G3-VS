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
 *Chỉnh sửa thông tin sản phẩm được lấy từ database
 * Hiển thị thông tin mới của sản phẩm trong database và danh sách sản phẩm
 * của người bán
 * @author QuanTBA <your.name at your.org>
 */
public class EditProduct extends HttpServlet {

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
            out.println("<title>Servlet EditProduct</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EditProduct at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
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
        try{
         request.setCharacterEncoding("UTF-8"); // Hiển thị Tiêng Việt
        String name = request.getParameter("name"); 
        String image = request.getParameter("image");
        float price = Float.parseFloat(request.getParameter("price"));
        String description = request.getParameter("description");
        String category = request.getParameter("category");
        float discount =Float.parseFloat(request.getParameter("discount"));
        int brand =Integer.parseInt(request.getParameter("brand"));
        int type =Integer.parseInt(request.getParameter("type"));
        String manufactureyear = request.getParameter("Myear");
        String madein = request.getParameter("MadeIn");
         int pid = Integer.parseInt(request.getParameter("productid"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
         BrandDAO brandDao = new BrandDAO();
         VehicleTypeDAO vehicleTypeDao = new VehicleTypeDAO();
    
        ManageProductDAO manageProductDao = new ManageProductDAO();
        manageProductDao.EditProduct(type,brand,name, madein , manufactureyear, description, image, quantity, price, discount, pid);
        Product prod = manageProductDao.getProductByID(pid);
        List<Brand> listbrand = brandDao.getAllBrand();
        List<VehicleType> listvehicleType = vehicleTypeDao.getAllVehicleType();
   
         request.setAttribute("vehicleType", listvehicleType);
         request.setAttribute("brand", listbrand);
        request.setAttribute("product", prod);
        request.setAttribute("alert", "Edit successfully!");
         request.getRequestDispatcher("view/Edit.jsp").forward(request, response);
        }catch(Exception ex){
            Logger.getLogger(EditProduct.class.getName()).log(Level.SEVERE, null, ex);
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
