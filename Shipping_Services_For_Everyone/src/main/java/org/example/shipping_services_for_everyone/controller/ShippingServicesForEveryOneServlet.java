package org.example.shipping_services_for_everyone.controller;

import org.example.shipping_services_for_everyone.repository.Impl.AccountShippingRepositoryImpl;
import org.example.shipping_services_for_everyone.repository.Impl.ShipperRepositoryImpl;
import org.example.shipping_services_for_everyone.repository.Impl.TransitVehicleRepositoryImpl;
import org.example.shipping_services_for_everyone.repository.Impl.UserAccountRepositoryImpl;
import org.example.shipping_services_for_everyone.model.*;
import org.example.shipping_services_for_everyone.validate.ValidateByRegex;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "ShippingServicesForEveryOneServlet", value = "/shipping")
public class ShippingServicesForEveryOneServlet extends HttpServlet {
    private AccountShippingRepositoryImpl accountShippingRepository = new AccountShippingRepositoryImpl();
    private ShipperRepositoryImpl shipperRepository = new ShipperRepositoryImpl();
    private UserAccountRepositoryImpl userAccountRepository = new UserAccountRepositoryImpl();
    private TransitVehicleRepositoryImpl transitVehicleRepository = new TransitVehicleRepositoryImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        request.getRequestDispatcher("view/RegisterUserAccount.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        registerUserAccount(request,response);
    }

    private void registerUserAccount(HttpServletRequest request, HttpServletResponse response) {
        String phoneNumber = request.getParameter("phoneNumber").replace(" ","");
        String password = request.getParameter("password");
        String cccd = request.getParameter("cccd").replace(" ","");
        String firstName = request.getParameter("firstName").trim().replace("  "," ");
        String middleName = request.getParameter("middleName").trim().replace("  "," ");
        String lastName = request.getParameter("lastName").trim().replace("  "," ");
        LocalDate dateOfBirth = LocalDate.parse(request.getParameter("dateOfBirth").replace(" ",""));
        char sex = request.getParameter("sex").replace(" ","").charAt(0);
        String email = request.getParameter("email").trim();
        String imageSelfie = request.getParameter("imageSelfie");
        String imageCccdFront = request.getParameter("imageCccdFront");
        String imageCccdBack = request.getParameter("imageCccdBack");
        String nameAddress = request.getParameter("nameAddress").trim();
        String apartmentNumber = request.getParameter("apartmentNumber").trim();
        String streetName = request.getParameter("streetName").trim();
        String district = request.getParameter("district").trim();
        String ward = request.getParameter("ward").trim();
        String city = request.getParameter("city").trim();

        Account account = new Account(phoneNumber,password);
        Address address = new Address(nameAddress,apartmentNumber,streetName,district,ward,city,phoneNumber);
        People people = new People(cccd,firstName,middleName,lastName,dateOfBirth,sex,email,address,imageSelfie,imageCccdFront,imageCccdBack);
        UserAccount userAccount = new UserAccount(account,people);
        userAccountRepository.addNew(userAccount);
    }

    private void registerShipper(HttpServletRequest request, HttpServletResponse response) {
        String cccd = ValidateByRegex.checkCccdAccountShipping(request.getParameter("cccd").replace(" ",""));
        String firstName = request.getParameter("firstName").trim().replace("  "," ");
        String middleName = request.getParameter("middleName").trim().replace("  "," ");
        String lastName = request.getParameter("lastName").trim().replace("  "," ");
        String phoneNumber = request.getParameter("phoneNumber").replace(" ","");
        String password = request.getParameter("password");
        String nameAccount = firstName + " " + middleName + " " + lastName;
        LocalDate dateOfBirth = LocalDate.parse(request.getParameter("dateOfBirth").replace(" ",""));
        char sex = request.getParameter("sex").replace(" ","").charAt(0);
        String email = request.getParameter("email").trim();
        String imageSelfie = request.getParameter("imageSelfie");
        String imageCccdFront = request.getParameter("imageCccdFront");
        String imageCccdBack = request.getParameter("imageCccdBack");
        String imageDriverLicense = request.getParameter("imageDriverLicense");
        String imageVehicleRegistration = request.getParameter("imageVehicleRegistration");
        String imageCurriculumVitae = request.getParameter("imageCurriculumVitae");
        String imageCivilGuaranteeLetter = request.getParameter("imageCivilGuaranteeLetter");
        String imageCertificateOfNoCriminalRecord = request.getParameter("imageCertificateOfNoCriminalRecord");
        String imageBirthCertificate = request.getParameter("imageBirthCertificate");
        String imageHouseholdRegistration = request.getParameter("imageHouseholdRegistration");
        String imageHealthExaminationCertificate = request.getParameter("imageHealthExaminationCertificate");
        int idTypeVehicle = Integer.parseInt(request.getParameter("idTypeVehicle").replace(" ",""));
        int length = Integer.parseInt(request.getParameter("length").replace(" ",""));
        int width = Integer.parseInt(request.getParameter("width").replace(" ",""));
        int height = Integer.parseInt(request.getParameter("height").replace(" ",""));
        int weight = Integer.parseInt(request.getParameter("weight").replace(" ",""));
        String licensePlate = request.getParameter("licensePlate");
        String apartmentNumber = request.getParameter("apartmentNumber").replace(" ","");
        String streetName = request.getParameter("streetName").trim().replace("  "," ");
        String district = request.getParameter("district").trim().replace("  "," ");
        String ward = request.getParameter("ward").trim().replace("  "," ");
        String city = request.getParameter("city").trim().replace("  "," ");
        String imageVehicleFront = request.getParameter("imageVehicleFront");
        String imageVehicleLeft = request.getParameter("imageVehicleLeft");
        String imageVehicleRight = request.getParameter("imageVehicleRight");
        String imageVehicleBehind = request.getParameter("imageVehicleBehind");

        Address currentPosition = new Address(apartmentNumber,streetName,district,ward,city);
        TypeVehicle typeVehicle = new TypeVehicle(idTypeVehicle);
        ImageIdentification imageIdentification = new ImageIdentification(imageDriverLicense,imageVehicleRegistration,imageCurriculumVitae,imageCivilGuaranteeLetter,imageCertificateOfNoCriminalRecord,imageBirthCertificate,imageHouseholdRegistration,imageHealthExaminationCertificate);
        People people = new People(cccd,firstName,middleName,lastName,dateOfBirth,sex,email,currentPosition,imageSelfie,imageCccdFront,imageCccdBack);
        TransportImage transportImage = new TransportImage(imageVehicleFront,imageVehicleLeft,imageVehicleRight,imageVehicleBehind);
        Account account = new Account(phoneNumber,password);
        Size size = new Size(length,width,height,weight);
        Shipper shipper = new Shipper(people,imageIdentification);
        AccountShipping accountShipping = new AccountShipping(nameAccount,account,typeVehicle,size,licensePlate,currentPosition,transportImage);
        accountShippingRepository.addNew(accountShipping);
        shipperRepository.addNew(shipper);
    }

    private void registerTransitVehicle(HttpServletRequest request, HttpServletResponse response) {
        String cccd = request.getParameter("cccd").replace(" ","");
        String firstName = request.getParameter("firstName").trim().replace("  "," ");
        String middleName = request.getParameter("middleName").trim().replace("  "," ");
        String lastName = request.getParameter("lastName").trim().replace("  "," ");
        String phoneNumber = request.getParameter("phoneNumber").replace(" ","");
        String password = request.getParameter("password");
        String nameAccount = firstName + " " + middleName + " " + lastName;
        LocalDate dateOfBirth = LocalDate.parse(request.getParameter("dateOfBirth").replace(" ",""));
        char sex = request.getParameter("sex").replace(" ","").charAt(0);
        String email = request.getParameter("email").trim();
        String imageSelfie = request.getParameter("imageSelfie");
        String imageCccdFront = request.getParameter("imageCccdFront");
        String imageCccdBack = request.getParameter("imageCccdBack");
        String imageDriverLicense = request.getParameter("imageDriverLicense");
        String imageVehicleRegistration = request.getParameter("imageVehicleRegistration");
        String imageCurriculumVitae = request.getParameter("imageCurriculumVitae");
        String imageCivilGuaranteeLetter = request.getParameter("imageCivilGuaranteeLetter");
        String imageCertificateOfNoCriminalRecord = request.getParameter("imageCertificateOfNoCriminalRecord");
        String imageBirthCertificate = request.getParameter("imageBirthCertificate");
        String imageHouseholdRegistration = request.getParameter("imageHouseholdRegistration");
        String imageHealthExaminationCertificate = request.getParameter("imageHealthExaminationCertificate");
        int idTypeVehicle = Integer.parseInt(request.getParameter("idTypeVehicle").replace(" ",""));
        int length = Integer.parseInt(request.getParameter("length").replace(" ",""));
        int width = Integer.parseInt(request.getParameter("width").replace(" ",""));
        int height = Integer.parseInt(request.getParameter("height").replace(" ",""));
        int weight = Integer.parseInt(request.getParameter("weight").replace(" ",""));
        String licensePlate = request.getParameter("licensePlate");
        String apartmentNumber = request.getParameter("apartmentNumber").replace(" ","");
        String streetName = request.getParameter("streetName").trim().replace("  "," ");
        String district = request.getParameter("district").trim().replace("  "," ");
        String ward = request.getParameter("ward").trim().replace("  "," ");
        String city = request.getParameter("city").trim().replace("  "," ");
        String imageVehicleFront = request.getParameter("imageVehicleFront");
        String imageVehicleLeft = request.getParameter("imageVehicleLeft");
        String imageVehicleRight = request.getParameter("imageVehicleRight");
        String imageVehicleBehind = request.getParameter("imageVehicleBehind");


        Address currentPosition = new Address(apartmentNumber,streetName,district,ward,city);
        TypeVehicle typeVehicle = new TypeVehicle(idTypeVehicle);
        ImageIdentification imageIdentification = new ImageIdentification(imageDriverLicense,imageVehicleRegistration,imageCurriculumVitae,imageCivilGuaranteeLetter,imageCertificateOfNoCriminalRecord,imageBirthCertificate,imageHouseholdRegistration,imageHealthExaminationCertificate);
        People people = new People(cccd,firstName,middleName,lastName,dateOfBirth,sex,email,currentPosition,imageSelfie,imageCccdFront,imageCccdBack);
        TransportImage transportImage = new TransportImage(imageVehicleFront,imageVehicleLeft,imageVehicleRight,imageVehicleBehind);
        Account account = new Account(phoneNumber,password);
        Size size = new Size(length,width,height,weight);
        TransitVehicle transitVehicle = new TransitVehicle(people,imageIdentification);
        AccountShipping accountShipping = new AccountShipping(nameAccount,account,typeVehicle,size,licensePlate,currentPosition,transportImage);
        accountShippingRepository.addNew(accountShipping);
        transitVehicleRepository.addNew(transitVehicle);
    }
}
