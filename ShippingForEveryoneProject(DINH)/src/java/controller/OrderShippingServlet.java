/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import context.ReviewDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Address;
import model.OrderShipping;

/**
 *
 * @author DINH
 */
public class OrderShippingServlet extends HttpServlet {

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
        try {
            String sender = request.getParameter("sender");
            int receiver = Integer.parseInt(request.getParameter("receiver"));
            int collectionMoney = Integer.parseInt(request.getParameter("collectionMoney"));
            int transportationCost = Integer.parseInt(request.getParameter("transportationCost"));
            String apartmentNumber = request.getParameter("apartmentNumber");
            String streetName = request.getParameter("streetName");
            String district = request.getParameter("district");
            String ward = request.getParameter("ward");
            String city = request.getParameter("city");
            String noteForShipper = request.getParameter("noteForShipper");
            String estimatedDeliveryTime = request.getParameter("estimatedDeliveryTime");
            boolean checkPackage = Boolean.parseBoolean(request.getParameter("checkPackage"));
            int idPickup = Integer.parseInt(request.getParameter("idPickup"));
            int idDelivery = Integer.parseInt(request.getParameter("idDelivery"));
            if (sender.equals("")
                    || apartmentNumber.equals("")
                    || streetName.equals("")
                    || district.equals("")
                    || ward.equals("")
                    || city.equals("")) {
                 request.setAttribute("msg", "Enter name again!!");
                  request.getRequestDispatcher("createorder.jsp").forward(request, response);    
                  return;
            }            
            ReviewDAO reviewDAO = new ReviewDAO();
            OrderShipping ordershipping = new OrderShipping(collectionMoney, transportationCost, checkPackage, noteForShipper);
            Address address = new Address(apartmentNumber, streetName, district, ward, city);
            reviewDAO.addorder(ordershipping, address);
             response.sendRedirect("listOrder.jsp");
        } catch (Exception ex) {
            Logger.getLogger(OrderShippingServlet.class.getName()).log(Level.SEVERE, null, ex);
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
