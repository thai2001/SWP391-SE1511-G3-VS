/*
 * Copyright(C) 2021, group 3 SE1511JS
 * T.NET:
 *  Vehicle Store
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2021-02-09      1.0                 levan           Add Field
 */
package controller;

import dao.AccountDAO;
import entity.Account;
import entity.Buyer;
import entity.JavaMail;
import entity.Role;
import entity.Seller;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Lớp này có các phương thức thực hiện truy vấn dữ liệu từ bảng Account.
 *
 *
 * @author levan
 */
/**
 *
 * @author levan
 */
public class register extends HttpServlet {

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
        int messradio = 1;
        request.setAttribute("messradio", messradio);
        request.getRequestDispatcher("view/register.jsp").forward(request, response);
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
        String user = request.getParameter("user").trim();
        String pass = request.getParameter("password").trim();
        String name = request.getParameter("name").trim();
        String gmail = request.getParameter("gmail").trim();
        String phone = request.getParameter("phone").trim();
        int rol = Integer.parseInt(request.getParameter("role"));
        Account a = new Account();
        a.setUsername(user);
        a.setPassword(pass);
        a.setRoleId(new Role(rol));
        a.setName(name);
        a.setEmail(gmail);
        a.setPhone(phone);
        if (rol == 1) {
            a.setStatus("active");
        } else {
            a.setStatus("inactive");
            String add = request.getParameter("address").trim();
            String des = request.getParameter("description").trim();
            a.setAddress(add);
            a.setDescription(des);
        }

        Random rnd = new Random();
        int number = rnd.nextInt(999999);
        a.setCode(number);

        AccountDAO adb = new AccountDAO();
        String mess = adb.Insert(a);

        if (mess.equalsIgnoreCase("oke")) {
            String subject = "This is your authentication code";
            String message = "<!DOCTYPE html>\n"
                    + "<html lang=\"en\">\n"
                    + "\n"
                    + "<head>\n"
                    + "</head>\n"
                    + "\n"
                    + "<body>\n"
                    + "    <h3 style=\"color: blue;\">You have successfully registered.Here is your code to verify your account</h3>\n"
                    + "    <div>Your code :" + a.getCode() + "</div>\n"
                    + "    <h3 style=\"color: blue;\">Thank you very much!</h3>\n"
                    + "\n"
                    + "</body>\n"
                    + "\n"
                    + "</html>";
            try {
                JavaMail.send(a.getEmail(), subject, message, "projectgroup3se1511@gmail.com", "Projectse1511");
            } catch (Exception e) {
                System.out.println(e);
            }
            int messcode = 1;
            mess = "ValidCode";
            request.setAttribute("Account", a);
            request.getRequestDispatcher("view/login.jsp").forward(request, response);
        } else {
            int messradio;
            if (rol == 1) {
                messradio = 1;
                
            } else {
                messradio = 2;
            }
            request.setAttribute("messradio", messradio);
            request.setAttribute("mess", mess);
            request.setAttribute("Account", a);
            request.getRequestDispatcher("view/register.jsp").forward(request, response);
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
