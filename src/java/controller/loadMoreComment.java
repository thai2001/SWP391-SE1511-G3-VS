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

import dao.CommentDAO;
import entity.Comment;
import entity.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
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
 * @author taola
 */
@WebServlet(name = "loadMoreComment", urlPatterns = {"/loadMoreComment"})
public class loadMoreComment extends HttpServlet {

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
            throws ServletException, IOException, Exception {

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
            //processRequest(request, response);
            request.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=UTF-8");
            HttpSession ses = request.getSession();
            Product p = (Product) ses.getAttribute("product");
            int pid = p.getId();
            int index = Integer.parseInt(request.getParameter("total"));
            PrintWriter out = response.getWriter();
            CommentDAO commentDAO = new CommentDAO();
            Vector<Comment> list = commentDAO.getNext2CommnetByPid(pid, index);
            for (Comment comment : list) {
                out.println(" <div class=\"media\">\n"
                        + "                            <div class=\"media-body\">\n"
                        + "                                <h4 class=\"media-heading\">" + comment.getBuyer().getBuyerName() + "</h4>\n"
                        + "                                <p>" + comment.getContent() + "</p>\n"
                        + "                                <ul class=\"list-unstyled list-inline media-detail pull-left\">\n"
                        + "                                    <li><i class=\"fa fa-calendar\"></i>" + comment.getDate() + "</li>\n"
                        + "                                </ul>\n"
                        + "                                <ul class=\"list-unstyled list-inline media-detail pull-right\">\n"
                        + "                                </ul>\n"
                        + "                            </div>\n"
                        + "                        </div>    ");
            }
        } catch (Exception ex) {
            Logger.getLogger(loadMoreComment.class.getName()).log(Level.SEVERE, null, ex);
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(loadMoreComment.class.getName()).log(Level.SEVERE, null, ex);
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
