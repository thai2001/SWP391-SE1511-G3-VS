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

import dao.CommentandRelyDAO;
import entity.Account;
import entity.CommentQandA;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
public class LoadMoreRely extends BaseReqAuth {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
    protected void processGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
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
    protected void processPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int exist = Integer.parseInt(request.getParameter("exist"));
        CommentandRelyDAO cdao = new CommentandRelyDAO();
        ArrayList<CommentQandA> listrely = new ArrayList<CommentQandA>();
        Account ac = (Account) request.getSession().getAttribute("account");
        listrely = cdao.LoadMoreRely(id, exist);
        PrintWriter out = response.getWriter();
        for (CommentQandA c : listrely) {
            out.print("<div class=\"media-block blockrely" + id + "\" id=\"childrel" + c.getId() + "\">");
            if (c.getRoleid() == 2) {
                out.print("<a class=\"media-left\" href=\"#\"><img class=\"img-circle img-sm\" alt=\"Profile Picture\" src=\"https://upload.wikimedia.org/wikipedia/commons/thumb/5/59/User-avatar.svg/1024px-User-avatar.svg.png\"></a>");
            } else {
                out.print("<a class=\"media-left\" href=\"#\"><img class=\"img-circle img-sm\" alt=\"Profile Picture\" src=\"https://bootdey.com/img/Content/avatar/avatar1.png\"></a>");
            }
            out.print("<div class=\"media-body\">\n"
                    + "                                                    <div class=\"mar-btm\">\n"
                    + "                                                        <a href=\"#\" class=\"btn-link text-semibold media-heading box-inline\">" + c.getName() + "</a>\n"
                    + "                                                        <p class=\"text-muted text-sm\"><i class=\"fa fa-mobile fa-lg\"></i> " + c.getTimeago() + " " + c.getDvtime() + " ago</p>\n"
                    + "                                                    </div>\n"
                    + "                                                    <p id='prely" + c.getId() + "'>" + c.getContent() + "</p>\n"
                    + "                                                    <div class=\"pad-ver\">\n"
                    + "                                                        <button type=\"button\" class=\"btn btn-outline-primary btn-sm rely\" onclick=\"setFocus('t" + id + "')\">Rely</button>");
            if (ac.getUsername().equals(c.getUsername())) {
                out.print("<span><button type=\"button\" class=\"btn btn-outline-primary btn-sm rely\" onclick=\"confirmdelete('rel." + c.getId() + "." + id + "')\">Delete</button></span>\n"
                        + "                                                            <span><button type=\"button\" class=\"btn btn-outline-primary btn-sm rely\" onclick=\"edit('buttonrely', '" + id + "', 't" + id + "', 'rel." + c.getId() + "." + id + "', '" + c.getContent() + "')\">Edit</button></span>");
            }
            out.print("</div>\n"
                    + "                                                    <hr>\n"
                    + "                                                </div>\n"
                    + "                                            </div>");
            System.out.println(c.getId());
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
