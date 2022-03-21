package controller;

/*
 * Copyright(C) 2005, G3-VS.
 * Vehicle Store
 *  
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2018-09-10      1.0                 MinhLH           First Implement
 */
import dao.ManageTransactionDAO;
import dao.impl.IManageTransactionDAO;
import entity.Account;
import entity.Order;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;
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
 * @author nqt26
 */
@WebServlet(name = "ManageTransactionServlet", urlPatterns = {"/manageTransaction"})
public class ManageTransactionServlet extends HttpServlet {

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
            out.println("<title>Servlet ManageTransactionServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ManageTransactionServlet at " + request.getContextPath() + "</h1>");
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
        try {
            HttpSession session = request.getSession();
            Account account = (Account)session.getAttribute("account");
            if ( account.getRoleId().getRoleId() != 1 ){
                response.sendRedirect("view/forbiddenPage.jsp");
            }
            Date dateFrom = Date.valueOf("2018-01-01");
            Date dateTo = new Date(System.currentTimeMillis());
            IManageTransactionDAO iManageTransactionDAO = new ManageTransactionDAO();
            List<Order> list = iManageTransactionDAO.GetAllOrder();
            int size = list.size();
            String sNumPerPage = request.getParameter("numPerPage");
            int numPerPage;
            if ( sNumPerPage == null ){
                numPerPage = 5;
            } else {
                numPerPage = Integer.parseInt(sNumPerPage);
            }
            
            int numPage = size / numPerPage + (size % numPerPage == 0 ? 0 : 1);
            String spage = request.getParameter("page");
            int page;
            if (spage == null) {
                page = 1;
            } else {
                page = Integer.parseInt(spage);
            }
            int start, end;
            start = (page - 1) * numPerPage;
            end = Math.min(size, page * numPerPage);
            List<Order> listOrder = iManageTransactionDAO.GetOrderByPage(list, start, end);
            request.setAttribute("listSize", size);
            request.setAttribute("url", "manageTransaction?");
            request.setAttribute("numPerPage", numPerPage);
            request.setAttribute("num", numPage);
            request.setAttribute("page", page);
            request.setAttribute("dateTo", dateTo);
            request.setAttribute("dateFrom", dateFrom);
            request.setAttribute("order", listOrder);
            request.getRequestDispatcher("view/ManageTransaction.jsp").forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ManageTransactionServlet.class.getName()).log(Level.SEVERE, null, ex);
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
