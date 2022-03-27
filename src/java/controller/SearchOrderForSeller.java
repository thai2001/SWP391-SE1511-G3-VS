/*
 * Copyright(C) 2005, G3-VS.
 * Vehicle Store
 *  
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2022-03-17      1.0                 QuanTBA          Add field
 */
package controller;

import dao.ManageOrderDAO;
import dao.SellerDAO;
import dao.impl.IManageOrderDAO;
import dao.impl.ISellerDAO;
import entity.Account;
import entity.Order;
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
 *This class contains method to search order information by date created from table Order in database 
 * In the search method,all data will be normalized(trim space) before getting data from database
 * The method will throw<code>Exception</code> if there is any error occurring when getting data from database
 * <p> Bugs: </p>
 * @author QuanTBA
 */
public class SearchOrderForSeller extends HttpServlet {

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
            out.println("<title>Servlet SearchOrderForSeller</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SearchOrderForSeller at " + request.getContextPath() + "</h1>");
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
     //  int sid = Integer.parseInt(request.getParameter("sid"));
        HttpSession sess = request.getSession();
        Account a = (Account) sess.getAttribute("account"); 
        IManageOrderDAO iManageOrderDAO = new ManageOrderDAO();
            ISellerDAO isellerDAO = new SellerDAO();
            IManageOrderDAO iOrderDetailDAO = new ManageOrderDAO();
         Seller seller = isellerDAO.getSeller(a.getUsername());
        String datecre = request.getParameter("datecreated").trim();
            
  List<Order> listorder = iOrderDetailDAO.searchOrderByDateForSeller(seller.getSellerId(),datecre);
         int size= listorder.size();
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
         List<Order> listord= iManageOrderDAO.getOrderByPage(listorder, start, end);
        
        request.setAttribute("num", numPage);
        request.setAttribute("page", page);
        request.setAttribute("url", "searchorderforseller?");
        request.setAttribute("datecreated", datecre);
        request.setAttribute("orderdt", listord);
        request.getRequestDispatcher("view/ManageOrder.jsp").forward(request, response);
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
