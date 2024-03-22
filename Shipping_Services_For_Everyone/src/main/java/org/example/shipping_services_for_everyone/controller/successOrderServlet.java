package org.example.shipping_services_for_everyone.controller;

import org.example.shipping_services_for_everyone.model.OrderShipping;
import org.example.shipping_services_for_everyone.repository.Impl.OrderShippingDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "successOrderServlet", value = "/successOrderServlet")
public class successOrderServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String action =request.getParameter("action");
        OrderShippingDAO DAO = new OrderShippingDAO();
        OrderShipping orderShipping = new OrderShipping();
        orderShipping=DAO.get(Integer.parseInt(action));
        boolean order_status= DAO.updateOrderStatusSuccess(Integer.parseInt(action));
        if(order_status==true){
            orderShipping.setStatusOrder("Thanh_cong");
            request.setAttribute("orderShipping", orderShipping);
            request.getRequestDispatcher("orderDetail.jsp").forward(request, response);
        }

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);

    }
}