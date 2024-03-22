package org.example.shipping_services_for_everyone.controller;

import org.example.shipping_services_for_everyone.model.Account;
import org.example.shipping_services_for_everyone.model.Address;
import org.example.shipping_services_for_everyone.model.OrderShipping;
import org.example.shipping_services_for_everyone.repository.Impl.OrderShippingDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "addOrderShipping", value = "/addOrderShipping")
public class addOrderShipping extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("createorder.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
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
}