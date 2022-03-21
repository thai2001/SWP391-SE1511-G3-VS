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
import entity.Account;
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author nqt26
 */
@WebServlet(name = "ManageReportServlet", urlPatterns = {"/manageReport"})
public class ManageReportServlet extends HttpServlet {

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
            out.println("<title>Servlet ManageReportServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ManageReportServlet at " + request.getContextPath() + "</h1>");
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
        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("account");
        if (account.getRoleId().getRoleId() != 1) {
            response.sendRedirect("view/forbiddenPage.jsp");
        }
        IManageReportDAO iManageReportDAO = new ManageReportDAO();
        List<Report> list = null;
        try {
            list = iManageReportDAO.getAllReport();
        } catch (Exception ex) {
            Logger.getLogger(ManageReportServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        List<ReportType> listReportType = null;
        try {
            listReportType = iManageReportDAO.getAllReportType();
        } catch (Exception ex) {
            Logger.getLogger(ManageReportServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        int size = list.size();
        String sNumPerPage = request.getParameter("numPerPage");
        int numPerPage;
        if (sNumPerPage == null) {
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
        List<Report> listReport = iManageReportDAO.GetreportByPage(list, start, end);
        request.setAttribute("listSize", size);
        request.setAttribute("url", "manageReport?");
        request.setAttribute("numPerPage", numPerPage);
        request.setAttribute("num", numPage);
        request.setAttribute("page", page);
        request.setAttribute("report", listReport);
        request.setAttribute("reportType", listReportType);
        request.getRequestDispatcher("view/ManageReport.jsp").forward(request, response);
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
