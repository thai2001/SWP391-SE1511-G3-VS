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
import dao.VehicleTypeDAO;
import entity.Account;
import entity.Brand;
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
        String name = request.getParameter("productname").trim();
        String image = request.getParameter("img").trim();
       
        float price = Float.parseFloat( request.getParameter("price"));
        String description = request.getParameter("description").trim();
        int brand =Integer.parseInt( request.getParameter("brand"));
        int vehicletype =Integer.parseInt( request.getParameter("type"));
        float discount = Float.parseFloat( request.getParameter("discount"));
        String ManufactureYear = request.getParameter("Myear").trim();
        String MadeIn = request.getParameter("madeIn").trim();
        int quantity = Integer.parseInt( request.getParameter("quantity"));
//        HttpSession sess = request.getSession();
  //     Account a = (Account) sess.getAttribute("acc");
 //      int sid = a.getRoleId().getRoleId();
  ManageProductDAO manageProductDao = new ManageProductDAO();
       
       manageProductDao.AddProduct(vehicletype, name,brand, MadeIn, ManufactureYear, description, image, quantity, price, discount, 2);
       request.setAttribute("alert", "Add succefully");
       request.getRequestDispatcher("view/AddProduct.jsp").forward(request, response);
       response.sendRedirect("manageproduct");
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
