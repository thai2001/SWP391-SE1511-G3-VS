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

import dao.ManageReportDAO;
import dao.impl.IManageReportDAO;
import entity.Report;
import entity.ReportType;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nqt26
 */
@WebServlet(name = "SearchManageReport", urlPatterns = {"/searchManageReport"})
public class SearchManageReport extends HttpServlet {

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
            out.println("<title>Servlet SearchManageReport</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SearchManageReport at " + request.getContextPath() + "</h1>");
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
            int buyerId = 0;
            int productId = 0;
            String sort = request.getParameter("sort").trim();
            int reportTypeId = Integer.parseInt(request.getParameter("reportTypeId").trim());
            IManageReportDAO iManageReportDAO = new ManageReportDAO();
            List<ReportType> listReporttype = iManageReportDAO.getAllReportType();
            if (request.getParameter("buyerId").trim().length() > 9 || request.getParameter("productId").trim().length() > 9 ){
            request.setAttribute("alert", "warning");
            request.setAttribute("message", "Not excess 9 character!");
            request.setAttribute("buyerId", request.getParameter("buyerId").trim());
            request.setAttribute("productId", request.getParameter("productId").trim());
            request.setAttribute("sort", sort);
            request.setAttribute("reportTypeId", reportTypeId);
            request.setAttribute("reportType", listReporttype);
            request.getRequestDispatcher("view/ManageReport.jsp").forward(request, response);
            }
            try{
            if (request.getParameter("buyerId").trim().length() > 0 ) {               
                buyerId = Integer.parseInt(request.getParameter("buyerId").trim()); 
                request.setAttribute("buyerId", request.getParameter("buyerId").trim());
            }
            if (request.getParameter("productId").trim().length() > 0) {
                productId = Integer.parseInt(request.getParameter("productId").trim());
                request.setAttribute("productId", request.getParameter("productId").trim());
            }
              } catch (NumberFormatException nfe){
            request.setAttribute("alert", "danger");
            request.setAttribute("message", "Number is required !");            
            request.setAttribute("sort", sort);
            request.setAttribute("reportTypeId", reportTypeId);
            request.setAttribute("reportType", listReporttype);
            request.getRequestDispatcher("view/ManageReport.jsp").forward(request, response);
            }
            if ( buyerId < 0 || productId < 0) {
            request.setAttribute("alert", "danger");
            request.setAttribute("message", "Number must be positive !");
            request.setAttribute("buyerId", request.getParameter("buyerId").trim());
            request.setAttribute("productId", request.getParameter("productId").trim());
            request.setAttribute("sort", sort);
            request.setAttribute("reportTypeId", reportTypeId);
            request.setAttribute("reportType", listReporttype);
            request.getRequestDispatcher("view/ManageReport.jsp").forward(request, response);
            }
            
            List<Report> listReport = iManageReportDAO.getReportByFilter(buyerId, productId, reportTypeId, sort);
            
            request.setAttribute("buyerId", buyerId);
            request.setAttribute("productId", productId);
            request.setAttribute("sort", sort);
            request.setAttribute("reportTypeId", reportTypeId);
            request.setAttribute("reportType", listReporttype);
            request.setAttribute("report", listReport);
            request.getRequestDispatcher("view/ManageReport.jsp").forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(SearchManageReport.class.getName()).log(Level.SEVERE, null, ex);
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
