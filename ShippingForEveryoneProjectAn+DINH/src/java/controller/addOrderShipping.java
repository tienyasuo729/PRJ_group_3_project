/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import context.OrderShippingDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;
import model.Address;
import model.OrderShipping;

/**
 *
 * @author DINH
 */
public class addOrderShipping extends HttpServlet {

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
            out.println("<title>Servlet OrderShippingServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet OrderShippingServlet at " + request.getContextPath() + "</h1>");
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
        request.getRequestDispatcher("createorder.jsp").forward(request, response);
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
            HttpSession session = request.getSession();
            Account account = (Account) session.getAttribute("loginSession");
            
            
        try {
            
            int senderId= Integer.parseInt(request.getParameter("sender"));
            String receiverName = request.getParameter("receiverName");
            String receiverPhoneNum = request.getParameter("receiverPhoneNum");
            int collectionMoney =Integer.parseInt( request.getParameter("collectionMoney"));           
            String city = request.getParameter("city");
            String district = request.getParameter("district");
            String ward = request.getParameter("ward");
            String streetName = request.getParameter("streetName");
            String apartmentNumber = request.getParameter("apartmentNumber");
            String noteForShipper = request.getParameter("noteForShipper");
            // String imagePackage = request.getParameter("imagePackage");
            char statusOrder = 'C';
            boolean checkPackage =Boolean.parseBoolean(request.getParameter("checkPackage"));
            int idDelivery = Integer.parseInt(request.getParameter("idDelivery"));
            
            if ( apartmentNumber.equals("")
                    || streetName.equals("")
                    || district.equals("")
                    || ward.equals("")
                    || city.equals("")) {
                request.setAttribute("msg", "Enter name again!!");
                request.getRequestDispatcher("createorder.jsp").forward(request, response);
                return;
            }
            OrderShippingDAO orderDAO = new OrderShippingDAO();
            Address address = new Address(apartmentNumber, streetName, district, ward, city);
            OrderShipping ordershipping = new OrderShipping(senderId, collectionMoney, checkPackage, statusOrder, address, noteForShipper, receiverName, receiverPhoneNum, idDelivery);
            orderDAO.addorder(ordershipping);
            response.sendRedirect("MyOrderServlet");
        } catch (Exception ex) {
            Logger.getLogger(addOrderShipping.class.getName()).log(Level.SEVERE, null, ex);
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