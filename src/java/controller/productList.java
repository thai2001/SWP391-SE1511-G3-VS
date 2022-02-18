/*
 * Copyright(C) 2021, group 3 SE1511JS
 * T.NET:
 *  Vehicle Store
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2021-02-09      1.0                 ThaiNV           Add Field
 */
package controller;

import dao.ProductDAO;
import entity.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Lớp này có các phương thức thực hiện truy vấn hoặc cập nhật dữ liệu từ bảng
 * Product. Đông thời hiện thị các danh mục và các hãng xe cho chức năng search
 *
 * @Brand : brandName ,BrandId
 *
 *
 * @author Nguyen Viet Thai
 */
/**
 * The class contains method find, update, delete, insert Product information
 * from Product table in database.
 *
 * <p>
 * Bugs:
 *
 * @author Nguyen Viet Thai
 */
public class productList extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            ProductDAO productDAO = new ProductDAO();
            HttpSession ses = request.getSession();

            int vtid = 0;
            int brandId = 0;
            String vtName = "";
            String keyWord = "";
            String sort = "";
            if (request.getParameter("vtid") != null) {
                vtid = Integer.parseInt(request.getParameter("vtid"));
            } else {
                vtid = (int) ses.getAttribute("vtid");
            }
            if (vtid == 1) {
                vtName = "Car";
            } else {
                vtName = "Moto";
            }

            int pi = 1;
            if (request.getParameter("pi") != null) {
                pi = Integer.parseInt(request.getParameter("pi"));
            }
            if (ses.getAttribute("selectedBrand") == null) {
                brandId = 0;
            } else {
                brandId = (int) ses.getAttribute("selectedBrand");
            }
            if (request.getParameter("bid") != null) {
                brandId = Integer.parseInt(request.getParameter("bid"));
            }
            if (ses.getAttribute("sortOp") == null) {
                sort = "ManufactureYear desc";
            } else {
                sort = (String) ses.getAttribute("sortOp");
            }
            if (ses.getAttribute("keyWord") == null) {
                keyWord = "";
            } else {
                keyWord = (String) ses.getAttribute("keyWord");
            }

            Vector<Product> allProduct = productDAO.getProductInPage(pi, vtid, brandId, keyWord, sort);
            int numberOfPage = productDAO.getNumberOfPage(vtid, brandId, keyWord);
            ses.setAttribute("numberOfPage", numberOfPage);
            ses.setAttribute("availableProduct", allProduct);
            ses.setAttribute("selectedBrand", brandId);
            ses.setAttribute("vtid", vtid);
            ses.setAttribute("vtName", vtName);
            ses.setAttribute("pi", pi);
            request.getRequestDispatcher("view/productList.jsp").forward(request, response);
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
