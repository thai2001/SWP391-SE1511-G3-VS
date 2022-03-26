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

import dao.ManageProductDAO;
import dao.SellerDAO;
import dao.impl.ISellerDAO;
import entity.Account;
import entity.Product;
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author QuanTBA <your.name at your.org>
 */
public class SearchProductforSeller extends HttpServlet {

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
            out.println("<title>Servlet SearchProductforSeller</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SearchProductforSeller at " + request.getContextPath() + "</h1>");
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
       request.setCharacterEncoding("UTF-8");
     
        HttpSession sess = request.getSession();
        Account a = (Account) sess.getAttribute("account"); 
        ManageProductDAO  manageproductdao= new ManageProductDAO();
            ISellerDAO isellerDAO = new SellerDAO();
         Seller seller =isellerDAO.getSeller(a.getUsername());
        String name= request.getParameter("productname").trim().replaceAll("\\s\\s+"," ");
        if(name == null){
            name = "";
        }
        List<Product> listproduct = manageproductdao.SearchProductByNameForSeller(seller.getSellerId(), name);
         int size= listproduct.size();
        int numperPage=5;
        int numPage=size/numperPage+(size%numperPage== 0?0:1);
        String spage= request.getParameter("page");
        int page;
        if(spage == null){ 
            page= 1;
        }else{
            page = Integer.parseInt(spage); 
        }
        int start, end;
        start=(page-1)*numperPage;
        end=Math.min(size, page*numperPage);
          List<Product> listprod= manageproductdao.getProductByPage(listproduct, start, end);
        request.setAttribute("product", listprod);
        request.setAttribute("num", numPage);
        request.setAttribute("url", "searchproductforseller?");
          request.setAttribute("page", page);
        request.setAttribute("prodname", name);
        request.getRequestDispatcher("view/ManageProduct.jsp").forward(request, response);
        }catch(Exception ex){
            Logger.getLogger(SearchProductforSeller.class.getName()).log(Level.SEVERE, null, ex);
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
