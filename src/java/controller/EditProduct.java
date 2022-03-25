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
          ManageProductDAO manageProductDao = new ManageProductDAO();
         BrandDAO brandDao = new BrandDAO();
         VehicleTypeDAO vehicleTypeDao = new VehicleTypeDAO();
         List<Brand> listbrand = brandDao.getAllBrand();
        List<VehicleType> listvehicleType = vehicleTypeDao.getAllVehicleType();
         
        String image = request.getParameter("image").trim().replaceAll("\\s\\s+"," ");
        float price = Float.parseFloat(request.getParameter("price").trim().replaceAll("\\s\\s+"," "));
        float discount =Float.parseFloat(request.getParameter("discount").trim().replaceAll("\\s\\s+"," "));
        int brand =Integer.parseInt(request.getParameter("brand"));
        int type =Integer.parseInt(request.getParameter("type"));
        String manufactureyear = request.getParameter("Myear").trim().replaceAll("\\s\\s+"," ");
         int pid = Integer.parseInt(request.getParameter("productid"));
        int quantity = Integer.parseInt(request.getParameter("quantity").trim().replaceAll("\\s\\s+"," "));
        
        
        //Validate
        String name = request.getParameter("proname").trim().replaceAll("\\s\\s+"," "); 
         if(name.isEmpty()){
         name = "";
          Product prod = manageProductDao.getProductByID(pid);
    request.setAttribute("product", prod);
         request.setAttribute("vehicleType", listvehicleType);
         request.setAttribute("brand", listbrand);
         request.setAttribute("alert1", "Product name not allow space or not null !");    
         request.getRequestDispatcher("view/Edit.jsp").forward(request, response);
     }
         
       
        String description = request.getParameter("description").trim().replaceAll("\\s\\s+"," ");
         if( description.isEmpty()){
             Product prod = manageProductDao.getProductByID(pid);
    request.setAttribute("product", prod);
         request.setAttribute("vehicleType", listvehicleType);
         request.setAttribute("brand", listbrand);
         request.setAttribute("alert2", "Description not allow space or not null !");
         request.getRequestDispatcher("view/Edit.jsp").forward(request, response);
     }
         
           String madein = request.getParameter("MadeIn").trim().replaceAll("\\s\\s+"," ");
             if(madein.isEmpty()){  
                 Product prod = manageProductDao.getProductByID(pid);
    request.setAttribute("product", prod);
         request.setAttribute("vehicleType", listvehicleType);
         request.setAttribute("brand", listbrand);
         request.setAttribute("alert3", "MadeIn not allow space or not null !");
         request.getRequestDispatcher("view/view/Edit.jsp").forward(request, response);
           
             }
          
         
    
       
        if(name.length() != 0 && description.length() != 0 && madein.length() != 0){
        manageProductDao.EditProduct(type,brand,name, madein , manufactureyear, description, image, quantity, price, discount, pid);
        }
    Product prod = manageProductDao.getProductByID(pid);
    request.setAttribute("product", prod);
         request.setAttribute("vehicleType", listvehicleType);
         request.setAttribute("brand", listbrand);
        
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
