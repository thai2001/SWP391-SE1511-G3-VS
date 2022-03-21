/*
 * Copyright(C) 2021, group 3 SE1511JS
 * T.NET:
 *  Vehicle Store
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2021-02-13      1.0                 TungNQ           Add Field
 */
package controller;

import dao.AuthorizeSellerDAO;
import dao.ManageAccountDAO;
import entity.Seller;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.impl.IAuthorizeSellerDAO;
import dao.impl.IManageAccountDAO;
import entity.Account;
import entity.Order;
import javax.servlet.http.HttpSession;

/**
 * cập nhật dữ liệu từ trong database đến bảng seller chưa được đăng kí Trong
 * Các phương thức sẽ trả về một đối tượng của lớp
 * <code>javax.servlet.ServletException</code> khi có bất cứ lỗi nào xảy ra trong quá trình
 * truy vấn, cập nhật dữ liệu
 * <p>Bug: 404</p>
 *
 * @author nqt26
 */
public class AuthorizeSellerServlet extends HttpServlet {

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
            out.println("<title>Servlet AuthorizeSeller</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AuthorizeSeller at " + request.getContextPath() + "</h1>");
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
        //processRequest(request, response);
        
            HttpSession session = request.getSession();
            Account account = (Account)session.getAttribute("account");
            if ( account.getRoleId().getRoleId() != 1 ){
                response.sendRedirect("view/forbiddenPage.jsp");
            }
            request.setCharacterEncoding("UTF-8"); // hiển thị tiếng việt
            IAuthorizeSellerDAO iauthorizeSellerdao = new AuthorizeSellerDAO();
            List<Seller> list = iauthorizeSellerdao.getInactiveSellerAccount();
            int size = list.size();
            String sNumPerPage = request.getParameter("numPerPage");
            int numPerPage;
            if ( sNumPerPage == null ){
                numPerPage = 2;
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
            List<Seller> listSeller = iauthorizeSellerdao.GetSellerAccountByPage(list, start, end);
            request.setAttribute("url", "authorize?");
            request.setAttribute("numPerPage", numPerPage);
            request.setAttribute("num", numPage);
            request.setAttribute("page", page);
            request.setAttribute("seller", listSeller);
            request.getRequestDispatcher("view/authorizeSeller.jsp").forward(request, response);
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
