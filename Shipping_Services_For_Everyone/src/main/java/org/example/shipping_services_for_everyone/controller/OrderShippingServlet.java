package org.example.shipping_services_for_everyone.controller;

import org.example.shipping_services_for_everyone.model.*;
import org.example.shipping_services_for_everyone.model.Package;
import org.example.shipping_services_for_everyone.repository.Impl.UserAccountRepositoryImpl;
import org.example.shipping_services_for_everyone.validate.ValidateByRegex;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

@WebServlet(name = "OrderShippingServlet", value = "/OrderShippingServlet")
public class OrderShippingServlet extends HttpServlet {
    private UserAccountRepositoryImpl userAccountRepository = new UserAccountRepositoryImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void registerUserAccount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int idSender = Integer.parseInt(request.getParameter("idSender"));
        String phoneNumberReceiver = ValidateByRegex.checkPhoneNumber(request.getParameter("phoneNumber"));
        String apartmentNumberReceiver = ValidateByRegex.checkPropertiesAddress(request.getParameter("apartmentNumber"));
        String streetNameReceiver = ValidateByRegex.checkPropertiesAddress(request.getParameter("streetName"));
        String districtReceiver = ValidateByRegex.checkPropertiesAddress(request.getParameter("district"));
        String wardReceiver = ValidateByRegex.checkPropertiesAddress(request.getParameter("ward"));
        String cityReceiver = ValidateByRegex.checkPropertiesAddress(request.getParameter("city"));
        int collectionMoney = Integer.parseInt(request.getParameter("collectionMoney"));
        Boolean checkPackage= Boolean.valueOf(request.getParameter("checkPackage"));
        Boolean senderWantShipperTakePackageOrNot= Boolean.valueOf(request.getParameter("senderWantShipperTakePackageOrNot"));
        String noteForShipper = request.getParameter("noteForShipper");
        String nameItem = request.getParameter("nameItem");
        int length = ValidateByRegex.checkLength(request.getParameter("length"));
        int width = ValidateByRegex.checkWidth(request.getParameter("width"));
        int height = ValidateByRegex.checkHeight(request.getParameter("height"));
        int weight = ValidateByRegex.checkWeight(request.getParameter("weight"));
        Part fileImage1 = request.getPart("fileImage1");
        Part fileImage2 = request.getPart("fileImage2");
        Part fileImage3 = request.getPart("fileImage3");
        Part fileImage4 = request.getPart("fileImage4");

        UserAccount idSenderObject = new UserAccount(new Account(idSender));
        UserAccount idReceiver = userAccountRepository.findIdByPhoneNumber(phoneNumberReceiver);
        Address address = new Address(apartmentNumberReceiver,streetNameReceiver,districtReceiver,wardReceiver,cityReceiver);
        Size size = new Size(length,width,height,weight);
        Image image = new Image(fileImage1,fileImage2,fileImage3,fileImage4);

        AccountShipping idpickup = null;
        AccountShipping idDelivery = null;
        if (senderWantShipperTakePackageOrNot){
             idpickup = null;
        }
        int transportationCost = 0;
//        idDelivery = ;

        LocalDate estimatedDeliveryTime = LocalDate.now().plusDays(2);
        Package pac = new Package(nameItem,size,image);
        OrderShipping orderShipping = new OrderShipping(idSenderObject,idReceiver,collectionMoney,transportationCost,checkPackage,address,noteForShipper,estimatedDeliveryTime,idpickup,idDelivery);

    }
}