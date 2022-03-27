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

import dao.ManageCustomerDAO;
import dao.ManageProductDAO;
import dao.SellerDAO;
import dao.impl.IManageCustomerDAO;
import dao.impl.IManageProductDao;
import dao.impl.ISellerDAO;
import entity.Account;
import entity.Buyer;
import entity.JavaMail;
import entity.Role;
import entity.Seller;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *This class contains method to send email to buyer
 * In the send method,all data will be normalized(trim space) before sending to buyer
 * The method will throw<code>Exception</code> if there is any error occurring when getting data from database
 * <p> Bugs:Still have some issues related to validate mess variable </p>
 * @author QuanTBA
 */
public class SendMail extends HttpServlet {

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
            out.println("<title>Servlet SendMail</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SendMail at " + request.getContextPath() + "</h1>");
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
        String resultMessage = "";
        try {
        String to = request.getParameter("to").trim().replaceAll("\\s\\s+"," ");
        String sub = request.getParameter("subject2").trim().replaceAll("\\s\\s+"," ");
        String mess =request.getParameter("message2").trim().replaceAll("\\s\\s+"," ");
       HttpSession sess = request.getSession();
            IManageCustomerDAO iManageCustomer = new ManageCustomerDAO();
            ISellerDAO isellerDAO = new SellerDAO();
          Account a = (Account) sess.getAttribute("account"); 
          Seller seller = isellerDAO.getSeller(a.getUsername());
         
       
       List<Buyer> listbuyer = iManageCustomer.getBuyerBySellerId(seller.getSellerId());
        int size= listbuyer.size();
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
          List<Buyer> listbuy= iManageCustomer.getCusByPage(listbuyer, start, end);
          
       
       request.setAttribute("num", numPage); 
       request.setAttribute("buyer", listbuy);
       request.setAttribute("buyerall", listbuy);
        request.setAttribute("page", page);
            
                JavaMail.send(to,sub, mess, "projectgroup3se1511@gmail.com", "Projectse1511");
            }catch (Exception ex) {
            ex.printStackTrace();
            resultMessage = "There were an error: " + ex.getMessage();
        } finally {
            request.setAttribute("Message", resultMessage);
             request.setAttribute("alert","Email sent successfully !");
           request.getRequestDispatcher("view/customerNotification.jsp").forward(
                    request, response);
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
