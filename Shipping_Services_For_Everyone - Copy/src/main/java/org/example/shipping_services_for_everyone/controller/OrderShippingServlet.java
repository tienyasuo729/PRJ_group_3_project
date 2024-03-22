package org.example.shipping_services_for_everyone.controller;

import org.example.shipping_services_for_everyone.model.*;
import org.example.shipping_services_for_everyone.model.Package;
import org.example.shipping_services_for_everyone.repository.Impl.AccountShippingRepositoryImpl;
import org.example.shipping_services_for_everyone.repository.Impl.OrdersShippingRepositoryImpl;
import org.example.shipping_services_for_everyone.repository.Impl.PackageRepositoryImpl;
import org.example.shipping_services_for_everyone.repository.Impl.UserAccountRepositoryImpl;
import org.example.shipping_services_for_everyone.validate.ValidateByRegex;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Random;

@WebServlet(name = "OrderShippingServlet", value = "/OrderShippingServlet")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1,  // 2MB
        maxFileSize = 1024 * 1024 * 10,       // 10MB
        maxRequestSize = 1024 * 1024 * 100      // 50MB
)
public class OrderShippingServlet extends HttpServlet {
    private UserAccountRepositoryImpl userAccountRepository = new UserAccountRepositoryImpl();
    private AccountShippingRepositoryImpl accountShippingRepository = new AccountShippingRepositoryImpl();
    private OrdersShippingRepositoryImpl ordersShippingRepository = new OrdersShippingRepositoryImpl();

    private PackageRepositoryImpl packageRepository = new PackageRepositoryImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        request.getRequestDispatcher("createorder.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        try {
            registeOrder(request,response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void registeOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int idSender = Integer.parseInt(request.getParameter("idSender"));
        String phoneNumberReceiver = ValidateByRegex.checkPhoneNumber(request.getParameter("receiverPhoneNumber"));
        String firstName = ValidateByRegex.checkFirstName(request.getParameter("receiverFirstName"));
        String middleName = ValidateByRegex.checkMiddleName(request.getParameter("receiverMiddleName"));
        String lastName = ValidateByRegex.checkLastName(request.getParameter("receiverLastName"));
        String apartmentNumberSender = request.getParameter("apartmentNumberSender");
        String streetNameSender = ValidateByRegex.checkPropertiesAddress(request.getParameter("streetNameSender"));
        String districtSender = ValidateByRegex.checkPropertiesAddress(request.getParameter("districtSender"));
        String wardSender = ValidateByRegex.checkPropertiesAddress(request.getParameter("wardSender"));
        String citySender = ValidateByRegex.checkPropertiesAddress(request.getParameter("citySender"));
        String apartmentNumberReceiver = ValidateByRegex.checkPropertiesAddress(request.getParameter("apartmentNumberReceiver"));
        String streetNameReceiver = ValidateByRegex.checkPropertiesAddress(request.getParameter("streetNameReceiver"));
        String districtReceiver = ValidateByRegex.checkPropertiesAddress(request.getParameter("districtReceiver"));
        String wardReceiver = ValidateByRegex.checkPropertiesAddress(request.getParameter("wardReceiver"));
        String cityReceiver = ValidateByRegex.checkPropertiesAddress(request.getParameter("cityReceiver"));
        int collectionMoney = Integer.parseInt(request.getParameter("collectionMoney"));
        Boolean checkPackage = false;
        if (request.getParameter("checkPackage").equals("on")){
            checkPackage = true;
        }
        Boolean senderWantShipperTakePackageOrNot = false;
        if (request.getParameter("senderWantShipperTakePackageOrNot").equals("on")){
            senderWantShipperTakePackageOrNot = true;
        }
        String noteForShipper = request.getParameter("noteForShipper");
        String nameItem = request.getParameter("nameItem");
        int length = ValidateByRegex.checkLength(request.getParameter("length"));
        int width = ValidateByRegex.checkWidth(request.getParameter("width"));
        int height = ValidateByRegex.checkHeight(request.getParameter("height"));
        int weight = ValidateByRegex.checkWeight(request.getParameter("weight"));
        Part fileImage1 = ValidateByRegex.checkImage(request.getPart("fileImage1"));
        Part fileImage2 = ValidateByRegex.checkImage(request.getPart("fileImage2"));
        Part fileImage3 = ValidateByRegex.checkImage(request.getPart("fileImage3"));
        Part fileImage4 = ValidateByRegex.checkImage(request.getPart("fileImage4"));
        Address addressSender = new Address(apartmentNumberSender,streetNameSender,districtSender,wardSender,citySender);
        Address addressReceiver = new Address(apartmentNumberReceiver,streetNameReceiver,districtReceiver,wardReceiver,cityReceiver);
        Random calculator = new Random();
        UserAccount receiver = new UserAccount(new Account(phoneNumberReceiver), new People(firstName,middleName,lastName,new Address(apartmentNumberReceiver,streetNameReceiver,districtReceiver,wardReceiver,cityReceiver)));
        UserAccount idSenderObject = new UserAccount(new Account(idSender),new People(addressSender));
        UserAccount idReceiver = userAccountRepository.findIdByPhoneNumber(receiver);
        int transportationCost = calculator.nextInt(190001)+10000;
        AccountShipping idpickup = accountShippingRepository.findShipperToPickupOrder(idSenderObject,'a');
        AccountShipping idDelivery = accountShippingRepository.findShipperToPickupOrder(receiver,'b');
        char statusOrder = 'f';
        if (senderWantShipperTakePackageOrNot){
            statusOrder = 'a';
        }
        LocalDate estimatedDeliveryTime = LocalDate.now().plusDays(2);
        Size size = new Size(length,width,height,weight);
        Image image = new Image(fileImage1,fileImage2,fileImage3,fileImage4);
        Package pac = new Package(nameItem,size,image);
        OrderShipping orderShipping = new OrderShipping(idSenderObject,idReceiver,collectionMoney,transportationCost,statusOrder,addressSender,addressReceiver,noteForShipper,estimatedDeliveryTime,checkPackage,idpickup,idDelivery);
        ordersShippingRepository.addNew(orderShipping);
        packageRepository.addNew(pac);
    }
}