/*
 * Copyright(C) 2005, G3-VS.
 * Vehicle Store
 *  
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2022-02-14      1.0                 QuanTBA          Add Field
 */
package controller;

import dao.BrandDAO;
import dao.ManageProductDAO;
import dao.SellerDAO;
import dao.VehicleTypeDAO;
import dao.impl.ISellerDAO;
import entity.Account;
import entity.Brand;
import entity.Seller;
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
import javax.servlet.http.HttpSession;

/**
 *Thêm thông tin 1 sản phẩm mới vào trong database đồng thời hiển thị trong
 * danh sách sản phẩm của người bán
 * @author QuanTBA
 */
public class AddProduct extends HttpServlet {

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
            out.println("<title>Servlet AddProduct</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddProduct at " + request.getContextPath() + "</h1>");
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
     BrandDAO brandDao = new BrandDAO();
     VehicleTypeDAO vehicleTypeDao = new VehicleTypeDAO();
     
     List<VehicleType> listvehicleType = vehicleTypeDao.getAllVehicleType();
     List<Brand> listbrand = brandDao.getAllBrand();
     
      
     
     //Validate
     String name =request.getParameter("productname").trim().replaceAll("\\s\\s+"," ");
     if(name.isEmpty()){
         name = "";
         request.setAttribute("vehicleType", listvehicleType);
         request.setAttribute("brand", listbrand);
          request.setAttribute("image",request.getParameter("img").trim().replaceAll("\\s\\s+",""));
         request.setAttribute("descript",request.getParameter("description").trim().replaceAll("\\s\\s+"," "));
          request.setAttribute("quant",Integer.parseInt( request.getParameter("quantity").trim().replaceAll("\\s\\s+","")));
          request.setAttribute("myear",request.getParameter("Myear").trim().replaceAll("\\s\\s+",""));
         request.setAttribute("discount",Float.parseFloat( request.getParameter("discount").trim().replaceAll("\\s\\s+","")));
          request.setAttribute("price",Float.parseFloat( request.getParameter("price").trim()));
         request.setAttribute("madein", request.getParameter("madeIn").trim().replaceAll("\\s\\s+",""));
         request.setAttribute("alert1", "Product name not allow space or not null !");
         request.setAttribute("proname", request.getParameter("productname").trim().replaceAll("\\s\\s+"," "));
         request.getRequestDispatcher("view/AddProduct.jsp").forward(request, response);
     }
   
     String description =request.getParameter("description").trim().replaceAll("\\s\\s+"," ");
     if( description.isEmpty()){
         request.setAttribute("vehicleType", listvehicleType);
         request.setAttribute("brand", listbrand);
          request.setAttribute("image",request.getParameter("img").trim().replaceAll("\\s\\s+",""));
          request.setAttribute("descript",request.getParameter("description").trim().replaceAll("\\s\\s+"," "));
          request.setAttribute("quant",Integer.parseInt( request.getParameter("quantity").trim().replaceAll("\\s\\s+","")));
          request.setAttribute("myear",request.getParameter("Myear").trim().replaceAll("\\s\\s+",""));
          request.setAttribute("discount",Float.parseFloat( request.getParameter("discount").trim().replaceAll("\\s\\s+","")));
          request.setAttribute("price",Float.parseFloat( request.getParameter("price").trim()));
         request.setAttribute("proname", request.getParameter("productname").trim().replaceAll("\\s\\s+"," "));
          request.setAttribute("madein", request.getParameter("madeIn").trim().replaceAll("\\s\\s+",""));
         request.setAttribute("alert2", "Description not allow space or not null !");
        
         request.getRequestDispatcher("view/AddProduct.jsp").forward(request, response);
     }
      
     
     String MadeIn = request.getParameter("madeIn").trim().replaceAll("\\s\\s+","");
             if(MadeIn.isEmpty()){  
         request.setAttribute("vehicleType", listvehicleType);
         request.setAttribute("brand", listbrand);
          request.setAttribute("image",request.getParameter("img").trim().replaceAll("\\s\\s+",""));
         request.setAttribute("descript",request.getParameter("description").trim().replaceAll("\\s\\s+"," "));
          request.setAttribute("quant",Integer.parseInt( request.getParameter("quantity").trim().replaceAll("\\s\\s+","")));
          request.setAttribute("myear",request.getParameter("Myear").trim().replaceAll("\\s\\s+",""));
          request.setAttribute("discount",Float.parseFloat( request.getParameter("discount").trim().replaceAll("\\s\\s+","")));
         request.setAttribute("proname", request.getParameter("productname").trim().replaceAll("\\s\\s+"," "));
         request.setAttribute("price",Float.parseFloat( request.getParameter("price").trim()));
         request.setAttribute("alert3", "MadeIn not allow space or not null !");
         request.setAttribute("madein", request.getParameter("madeIn").trim().replaceAll("\\s\\s+",""));
         request.getRequestDispatcher("view/AddProduct.jsp").forward(request, response);
           
             }
             
             
        String  image =  request.getParameter("img").trim().replaceAll("\\s\\s+","");
          if(image.isEmpty()){  
         request.setAttribute("vehicleType", listvehicleType);
         request.setAttribute("brand", listbrand);
         request.setAttribute("image",request.getParameter("img").trim().replaceAll("\\s\\s+",""));
         request.setAttribute("descript",request.getParameter("description").trim().replaceAll("\\s\\s+"," "));
          request.setAttribute("quant",Integer.parseInt( request.getParameter("quantity").trim().replaceAll("\\s\\s+","")));
          request.setAttribute("myear",request.getParameter("Myear").trim().replaceAll("\\s\\s+",""));
          request.setAttribute("discount",Float.parseFloat( request.getParameter("discount").trim().replaceAll("\\s\\s+","")));
         request.setAttribute("proname", request.getParameter("productname").trim().replaceAll("\\s\\s+"," "));
         request.setAttribute("price",Float.parseFloat( request.getParameter("price").trim()));
         request.setAttribute("alert4", "Image not allow space or not null !");
         request.setAttribute("madein", request.getParameter("madeIn").trim().replaceAll("\\s\\s+",""));
         request.getRequestDispatcher("view/AddProduct.jsp").forward(request, response);
           
             }
     float price = Float.parseFloat( request.getParameter("price").trim());
     int brand =Integer.parseInt( request.getParameter("brand"));
     int vehicletype =Integer.parseInt( request.getParameter("type"));
     float discount = Float.parseFloat( request.getParameter("discount").trim().replaceAll("\\s\\s+",""));
     String ManufactureYear = request.getParameter("Myear").trim().replaceAll("\\s\\s+","");
     int quantity = Integer.parseInt( request.getParameter("quantity").trim().replaceAll("\\s\\s+",""));
       
      

     HttpSession sess = request.getSession();
     ManageProductDAO manageProductDao = new ManageProductDAO();
     Account a = (Account) sess.getAttribute("account");
      ISellerDAO isellerDAO = new SellerDAO();
     Seller seller = isellerDAO.getSeller(a.getUsername());

    if(name.length() != 0 && description.length() != 0 && MadeIn.length() != 0){
    manageProductDao.AddProduct(vehicletype, name,brand, MadeIn, ManufactureYear, description, image, quantity, price, discount, seller.getSellerId());
    } 
   
 
    request.setAttribute("vehicleType", listvehicleType);
    request.setAttribute("brand", listbrand);
    request.setAttribute("alert", "Add succefully !");
    request.getRequestDispatcher("view/AddProduct.jsp").forward(request, response);
 } catch(Exception ex) {
          Logger.getLogger(AddProduct.class.getName()).log(Level.SEVERE, null, ex);
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
