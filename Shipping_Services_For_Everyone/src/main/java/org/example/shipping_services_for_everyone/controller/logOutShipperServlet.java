package org.example.shipping_services_for_everyone.controller;

import org.example.shipping_services_for_everyone.model.Account;
import org.example.shipping_services_for_everyone.repository.Impl.AccountShippingRepositoryImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "logOutShipperServlet", value = "/logOutShipperServlet")
public class logOutShipperServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        HttpSession session =request.getSession();
        AccountShippingRepositoryImpl impl = new AccountShippingRepositoryImpl();
        Account account =(Account) session.getAttribute("loginSession");
        int id=account.getIdAccount();
        impl.updateActiveStatusOff(id); // trong AccountShippingImpl
        session.removeAttribute("loginSession");
        request.getRequestDispatcher("index.jsp").forward(request, response);
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