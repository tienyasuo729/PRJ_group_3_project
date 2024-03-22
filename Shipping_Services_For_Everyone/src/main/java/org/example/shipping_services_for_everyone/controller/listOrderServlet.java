package org.example.shipping_services_for_everyone.controller;

import org.example.shipping_services_for_everyone.model.Account;
import org.example.shipping_services_for_everyone.model.OrderShipping;
import org.example.shipping_services_for_everyone.repository.Impl.OrderShippingDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "listOrderServlet", value = "/listOrderServlet")
public class listOrderServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        OrderShippingDAO DAO = new OrderShippingDAO();
        List<OrderShipping> orderList = new ArrayList();
        String action = request.getParameter("action");
        Account account =(Account) session.getAttribute("loginSession");
        int id=account.getIdAccount();
        if (action.equals("yourlist")){
            orderList =DAO.viewAll(id);
            if(orderList.isEmpty()){
                request.getRequestDispatcher("showOrderOfShipper.jsp").forward(request, response);
            } else {

                request.setAttribute("OrderList", orderList);
                request.getRequestDispatcher("showOrderOfShipper.jsp").forward(request, response);
            }
        }else if (action.equals("update")){
            orderList =DAO.viewAll(id);
            if(orderList.isEmpty()){
                request.getRequestDispatcher("uploadProgress.jsp").forward(request, response);
            }else{

            }
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