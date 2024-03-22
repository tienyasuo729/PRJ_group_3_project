package org.example.shipping_services_for_everyone.controller;

import org.example.shipping_services_for_everyone.model.Address;
import org.example.shipping_services_for_everyone.model.OrderShipping;
import org.example.shipping_services_for_everyone.repository.Impl.OrderShippingDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "updateOrderServlet", value = "/updateOrderServlet")
public class updateOrderServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UpdateOrder</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateOrder at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        OrderShippingDAO orderDAO = new OrderShippingDAO();
        OrderShipping order= orderDAO.getIdOrder(id);
        request.setAttribute("orderShipping",order );
        request.getRequestDispatcher("update.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String receiverName = request.getParameter("receiverName");
        String receiverPhoneNum = request.getParameter("receiverPhoneNum");
        int collectionMoney =Integer.parseInt( request.getParameter("collectionMoney"));
        String city = request.getParameter("city");
        String district = request.getParameter("district");
        String ward = request.getParameter("ward");
        String streetName = request.getParameter("streetName");
        String apartmentNumber = request.getParameter("apartmentNumber");
        String noteForShipper = request.getParameter("noteForShipper");
        Address address = new Address(apartmentNumber, streetName, district, ward, city);
        OrderShipping orderShipping = new OrderShipping(collectionMoney, address, noteForShipper, receiverName, receiverPhoneNum);
        OrderShippingDAO orderDAO = new OrderShippingDAO();
        orderDAO.update(orderShipping);
        response.sendRedirect("MyOrderServlet");
    }
}