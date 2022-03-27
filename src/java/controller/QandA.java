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

import com.sun.javafx.css.Combinator;
import dao.AccountDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entity.CommentQandA;
import dao.CommentandRelyDAO;
import entity.Account;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class QandA extends BaseReqAuth {

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
            out.println("<title>Servlet QandA</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet QandA at " + request.getContextPath() + "</h1>");
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
    protected void processGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<CommentQandA> comments = new ArrayList<CommentQandA>();
        CommentandRelyDAO cdao = new CommentandRelyDAO();
        comments = cdao.get3Comment();
        int k = cdao.CountComment();
        request.setAttribute("countcomment", k);
        request.setAttribute("comments", comments);
        request.setAttribute("commentsize", comments.size());
        request.getRequestDispatcher("view/QandA.jsp").forward(request, response);
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
        String username = request.getParameter("account");
        String content = request.getParameter("contents");
        CommentQandA c = new CommentQandA();
        c.setUsername(username);
        c.setContent(content);
        Timestamp added_date = new Timestamp(System.currentTimeMillis());
        c.setTimecreate(added_date);
        CommentandRelyDAO cdao = new CommentandRelyDAO();
        c = cdao.InsertComment(c);
        
        Account ac = (Account) request.getSession().getAttribute("account");
        AccountDAO acdao = new AccountDAO();
        ac = acdao.getProfile(ac);
        c.setName(ac.getName());
        
        PrintWriter out = response.getWriter();
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
                + "                                        <p class=\"text-muted text-sm\"><i class=\"fa fa-mobile fa-lg\"></i> vua xong </p>\n"
                + "                                    </div>\n"
                + "                                    <p id='pcomment" + c.getId() + "'>" + c.getContent() + "</p>\n"
                + "                                    <div class=\"pad-ver\">\n"
                + "                                        <button type=\"button\" class=\"btn btn-outline-primary btn-sm rely\" onclick=\"setFocus('t" + c.getId() + "')\">Rely</button>");
        out.print("<span><button type=\"button\" class=\"btn btn-outline-primary btn-sm rely\" onclick=\"confirmdelete('com."+c.getId()+"')\">Delete</button></span>\n"
                + "                                            <span><button type=\"button\" class=\"btn btn-outline-primary btn-sm rely\" onclick=\"edit('buttoncomment', '', 'commentcontent', 'com."+c.getId()+"', '"+c.getContent()+"')\">Edit</button></span>");
        out.print("</div>\n" +
"                                    <hr>\n" +
"\n" +
"                                    <!-- Comments -->\n" +
"                                    <div class=\"relycomment\" id=\"r"+c.getId()+"\">");
        out.print("</div>");
        out.print("<!-- Comments -->\n" +
"                                    <textarea class=\"form-control\" rows=\"2\" placeholder=\"What are you thinking?\" id=\"t"+c.getId()+"\" minlength=\"1\"></textarea>\n" +
"                                    <button class=\"btn btn-sm btn-primary pull-right\" type=\"submit\" style=\"margin-top: 10px;\" id =\"buttonrely"+c.getId()+"\" onclick=\"Rely('"+c.getId()+"', '"+ac.getUsername()+"')\"><i class=\"fa fa-pencil fa-fw\"></i> Rely</button>\n" +
"                                    <span><button class=\"btn btn-sm btn-primary pull-right\" type=\"submit\" style=\"margin-right: 10px; margin-top: 10px; display: none;\" id =\"buttonrelydes"+c.getId()+"\" onclick=\"Destroy('buttonrely', '"+c.getId()+"', 't"+c.getId()+"')\"><i class=\"fa fa-pencil fa-fw\"></i> Destroy</button></span>\n" +
"                                    <span><button class=\"btn btn-sm btn-primary pull-right\" type=\"submit\" style=\"margin-right: 10px; margin-top: 10px; display: none;\" id =\"buttonrelyent"+c.getId()+"\" onclick=\"\"><i class=\"fa fa-pencil fa-fw\"></i> EnterEdit</button></span>\n" +
"                                </div>\n" +
"                            </div>");
        
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
