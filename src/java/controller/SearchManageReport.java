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
            if (request.getParameter("buyerId") != null) {
                buyerId = Integer.parseInt(request.getParameter("buyerId"));
            }
            if (request.getParameter("productId") != null) {
                productId = Integer.parseInt(request.getParameter("productId"));
            }
            int reportTypeId = Integer.parseInt(request.getParameter("reportTypeId"));
            String Sort = request.getParameter("sort");
            IManageReportDAO iManageReportDAO = new ManageReportDAO();
            List<Report> listReport = iManageReportDAO.getReportByFilter(buyerId, productId, reportTypeId, Sort);
            List<ReportType> listReporttype = iManageReportDAO.getAllReportType();
            request.setAttribute("reportType", listReporttype);
            request.setAttribute("report", listReport);
            request.getRequestDispatcher("view/ManageReport.jsp").forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ManageReportServlet.class.getName()).log(Level.SEVERE, null, ex);
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
