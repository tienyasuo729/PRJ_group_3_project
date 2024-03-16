package org.example.shipping_services_for_everyone.controller;

import org.example.shipping_services_for_everyone.Repository.IRepository;
import org.example.shipping_services_for_everyone.model.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "ShippingServicesForEveryOneServlet", value = "/shipping")
public class ShippingServicesForEveryOneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        addNewShipper(request,response);
    }

    private void addNewShipper(HttpServletRequest request, HttpServletResponse response) {
        String cccd = request.getParameter("cccd");
        String firstName = request.getParameter("firstName");
        String middleName = request.getParameter("middleName");
        String lastName = request.getParameter("lastName");
        String nameAccount;
        LocalDate dateOfBirth = LocalDate.parse(request.getParameter("dateOfBirth"));
        char sex = request.getParameter("sex").charAt(0);
        String email = request.getParameter("email");
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
        int idTypeVehicle = Integer.parseInt(request.getParameter("idTypeVehicle"));
        String length = request.getParameter("length");
        String width = request.getParameter("width");
        String height = request.getParameter("height");
        String weight = request.getParameter("weight");
        String maximumStorageVolume = request.getParameter("maximumStorageVolume");
        String licensePlate = request.getParameter("licensePlate");
        String apartmentNumber = request.getParameter("apartmentNumber");
        String streetName = request.getParameter("streetName");
        String district = request.getParameter("district");
        String ward = request.getParameter("ward");
        String city = request.getParameter("city");
        String imageVehicleFront = request.getParameter("imageVehicleFront");
        String imageVehicleLeft = request.getParameter("imageVehicleLeft");
        String imageVehicleRight = request.getParameter("imageVehicleRight");
        String imageVehicleBehind = request.getParameter("imageVehicleBehind");

        Address address = new Address(apartmentNumber,streetName,district,ward,city);
        TypeVehicle typeVehicle = new TypeVehicle(idTypeVehicle);
        People people = new People(cccd,firstName,middleName,lastName,dateOfBirth,sex,email,address,imageSelfie,imageCccdFront,imageCccdBack);
        Account account = new Account();
        AccountShipping accountShipping = new AccountShipping(nameAccount);
        Size size = new Size();

    }
}