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
public class LoadMoreCommentQandA extends BaseReqAuth {

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
        int exist = Integer.parseInt(request.getParameter("exist"));
        CommentandRelyDAO cdao = new CommentandRelyDAO();
        ArrayList<CommentQandA> listcomment = new ArrayList<CommentQandA>();
        listcomment = cdao.LoadMoreComment(exist);
        Account ac = (Account) request.getSession().getAttribute("account");
        PrintWriter out = response.getWriter();
        for (CommentQandA c : listcomment) {
            out.print("<div class=\"media-block blockcomment\" id=\"childcom" + c.getId() + "\">");
            if (c.getRoleid() == 2) {
                out.print("<a class=\"media-left\" href=\"#\"><img class=\"img-circle img-sm\" alt=\"Profile Picture\" src=\"https://upload.wikimedia.org/wikipedia/commons/thumb/5/59/User-avatar.svg/1024px-User-avatar.svg.png\"></a>");
            } else {
                out.print("<a class=\"media-left\" href=\"#\"><img class=\"img-circle img-sm\" alt=\"Profile Picture\" src=\"https://bootdey.com/img/Content/avatar/avatar1.png\"></a>");
            }
            out.print("<div class=\"media-body\">\n"
                    + "\n"
                    + "                                    <div class=\"mar-btm\">\n"
                    + "                                        <a href=\"#\" class=\"btn-link text-semibold media-heading box-inline\">" + c.getName() + "</a>\n"
                    + "                                        <p class=\"text-muted text-sm\"><i class=\"fa fa-mobile fa-lg\"></i> " + c.getTimeago() + " " + c.getDvtime() + " ago</p>\n"
                    + "                                    </div>\n"
                    + "                                    <p id='pcomment" + c.getId() + "'>" + c.getContent() + "</p>\n"
                    + "                                    <div class=\"pad-ver\">\n"
                    + "                                        <button type=\"button\" class=\"btn btn-outline-primary btn-sm rely\" onclick=\"setFocus('t" + c.getId() + "')\">Rely</button>");
            if (c.getUsername().equals(ac.getUsername())) {
                out.print("<span><button type=\"button\" class=\"btn btn-outline-primary btn-sm rely\" onclick=\"confirmdelete('com." + c.getId() + "')\">Delete</button></span>\n"
                        + "                                            <span><button type=\"button\" class=\"btn btn-outline-primary btn-sm rely\" onclick=\"edit('buttoncomment', '', 'commentcontent', 'com." + c.getId() + "', '" + c.getContent() + "')\">Edit</button></span>");
            }
            out.print("</div>\n"
                    + "                                    <hr>\n"
                    + "\n"
                    + "                                    <!-- Comments -->\n"
                    + "                                    <div class=\"relycomment\" id=\"r" + c.getId() + "\">");
            for (CommentQandA rely : c.getRely()) {
                out.print("<div class=\"media-block blockrely" + c.getId() + "\" id=\"childrel" + rely.getId() + "\">");
                if (rely.getRoleid() == 2) {
                    out.print("<a class=\"media-left\" href=\"#\"><img class=\"img-circle img-sm\" alt=\"Profile Picture\" src=\"https://upload.wikimedia.org/wikipedia/commons/thumb/5/59/User-avatar.svg/1024px-User-avatar.svg.png\"></a>");
                } else {
                    out.print("<a class=\"media-left\" href=\"#\"><img class=\"img-circle img-sm\" alt=\"Profile Picture\" src=\"https://bootdey.com/img/Content/avatar/avatar1.png\"></a>");
                }
                out.print("<div class=\"media-body\">\n"
                        + "                                                    <div class=\"mar-btm\">\n"
                        + "                                                        <a href=\"#\" class=\"btn-link text-semibold media-heading box-inline\">" + rely.getName() + "</a>\n"
                        + "                                                        <p class=\"text-muted text-sm\"><i class=\"fa fa-mobile fa-lg\"></i> " + rely.getTimeago() + " " + rely.getDvtime() + " ago</p>\n"
                        + "                                                    </div>\n"
                        + "                                                    <p id='prely" + rely.getId() + "'>" + rely.getContent() + "</p>\n"
                        + "                                                    <div class=\"pad-ver\">\n"
                        + "                                                        <button type=\"button\" class=\"btn btn-outline-primary btn-sm rely\" onclick=\"setFocus('t" + c.getId() + "')\">Rely</button>");
                if (ac.getUsername().equals(rely.getUsername())) {
                    out.print("<span><button type=\"button\" class=\"btn btn-outline-primary btn-sm rely\" onclick=\"confirmdelete('rel." + rely.getId() + "." + c.getId() + "')\">Delete</button></span>\n"
                            + "                                                            <span><button type=\"button\" class=\"btn btn-outline-primary btn-sm rely\" onclick=\"edit('buttonrely', '" + c.getId() + "', 't" + c.getId() + "', 'rel." + rely.getId() + "." + c.getId() + "', '" + rely.getContent() + "')\">Edit</button></span>");
                }
                out.print("</div>\n"
                        + "                                                    <hr>\n"
                        + "                                                </div>\n"
                        + "                                            </div>");
                
            }
            out.print("</div>");
            if (c.getCountrely() > 3) {
                out.print("<div style=\"text-align: center;\" id=\"blockloadrely" + c.getId() + "\">\n"
                        + "                                            <a style=\"text-decoration: none;\" onclick=\"LoadMoreRely('" + c.getId() + "','" + c.getCountrely() + "')\"> Load More Rely</a> \n"
                        + "                                        </div>");
            }
            out.print("<textarea class=\"form-control\" rows=\"2\" placeholder=\"What are you thinking?\" id=\"t"+c.getId()+"\" minlength=\"1\"></textarea>\n"
                    + "                                    <button class=\"btn btn-sm btn-primary pull-right\" type=\"submit\" style=\"margin-top: 10px;\" id =\"buttonrely"+c.getId()+"\" onclick=\"Rely('"+c.getId()+"', '"+ac.getUsername()+"')\"><i class=\"fa fa-pencil fa-fw\"></i> Rely</button>\n"
                    + "                                    <span><button class=\"btn btn-sm btn-primary pull-right\" type=\"submit\" style=\"margin-right: 10px; margin-top: 10px; display: none;\" id =\"buttonrelydes"+c.getId()+"\" onclick=\"Destroy('buttonrely', '"+c.getId()+"', 't"+c.getId()+"')\"><i class=\"fa fa-pencil fa-fw\"></i> Destroy</button></span>\n"
                    + "                                    <span><button class=\"btn btn-sm btn-primary pull-right\" type=\"submit\" style=\"margin-right: 10px; margin-top: 10px; display: none;\" id =\"buttonrelyent"+c.getId()+"\" onclick=\"\"><i class=\"fa fa-pencil fa-fw\"></i> EnterEdit</button></span>\n"
                    + "                                </div>\n"
                    + "                            </div>");
            System.out.println("132");
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
