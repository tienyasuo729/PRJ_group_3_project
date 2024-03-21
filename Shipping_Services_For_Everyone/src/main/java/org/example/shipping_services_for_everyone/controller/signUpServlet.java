package org.example.shipping_services_for_everyone.controller;

import org.example.shipping_services_for_everyone.repository.Impl.*;
import org.example.shipping_services_for_everyone.model.*;
import org.example.shipping_services_for_everyone.validate.ValidateByRegex;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet(name = "signUpServlet", value = "/signUpServlet")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1,  // 2MB
        maxFileSize = 1024 * 1024 * 10,       // 10MB
        maxRequestSize = 1024 * 1024 * 100      // 50MB
)
public class signUpServlet extends HttpServlet {
    private AccountShippingRepositoryImpl accountShippingRepository = new AccountShippingRepositoryImpl();
    private ShipperRepositoryImpl shipperRepository = new ShipperRepositoryImpl();
    private UserAccountRepositoryImpl userAccountRepository = new UserAccountRepositoryImpl();
    private TransitVehicleRepositoryImpl transitVehicleRepository = new TransitVehicleRepositoryImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        request.setAttribute("listType", HtmlSupport.listType());
        request.setAttribute("listSex", HtmlSupport.listSex());
        if (request.getParameter("action1").equals("signUpUser")){
            request.getRequestDispatcher("signUpForUser.jsp").forward(request, response);
        }else {
            request.getRequestDispatcher("signUpForShipperAndTransitVehicle.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        if (request.getParameter("action2").equals("userRegister")){
            registerUserAccount(request,response);
        }else {

            int type = Integer.parseInt(request.getParameter("idTypeVehicle"));
            switch (type){
                case 1:
                    registerShipper(request,response);
                    break;
                case 2:
                case 3:
                case 4:
                    registerTransitVehicle(request,response);
                    break;
            }
        }
        response.sendRedirect("index.jsp");

    }

    private void registerUserAccount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String phoneNumber = ValidateByRegex.checkPhoneNumber(request.getParameter("phoneNumber"));
        String password = ValidateByRegex.checkPasswordForUser(request.getParameter("password"));
        String cccd = ValidateByRegex.checkCccdUser(request.getParameter("cccd"));
        String firstName = ValidateByRegex.checkFirstName(request.getParameter("firstName"));
        String middleName = ValidateByRegex.checkMiddleName(request.getParameter("middleName"));
        String lastName = ValidateByRegex.checkLastName(request.getParameter("lastName"));
        LocalDate dateOfBirth = LocalDate.parse(ValidateByRegex.checkDateOfBirth(request.getParameter("dateOfBirth")));
        char sex = ValidateByRegex.checkSex(request.getParameter("sex")).charAt(0);
        String email = ValidateByRegex.checkEmail(request.getParameter("email"));

        Part imageSelfie = ValidateByRegex.checkImage(request.getPart("imageSelfie"));
        System.out.println(imageSelfie == null);
        Part imageCccdFront = ValidateByRegex.checkImage(request.getPart("imageCccdFront"));
        Part imageCccdBack = ValidateByRegex.checkImage(request.getPart("imageCccdBack"));

//        String nameAddress = ValidateByRegex.checkPropertiesAddress(request.getParameter("nameAddress"));
        String nameAddress = "Địa chỉ nhà";
        String apartmentNumber = ValidateByRegex.checkPropertiesAddress(request.getParameter("apartmentNumber"));
        String streetName = ValidateByRegex.checkPropertiesAddress(request.getParameter("streetName"));
        String district = ValidateByRegex.checkPropertiesAddress(request.getParameter("district"));
        String ward = ValidateByRegex.checkPropertiesAddress(request.getParameter("ward"));
        String city = ValidateByRegex.checkPropertiesAddress(request.getParameter("city"));

        Account account = new Account(phoneNumber,password);
        Address address = new Address(nameAddress,apartmentNumber,streetName,district,ward,city,phoneNumber);
        People people = new People(cccd,firstName,middleName,lastName,dateOfBirth,sex,email,address,imageSelfie,imageCccdFront,imageCccdBack);
        UserAccount userAccount = new UserAccount(account,people);
        userAccountRepository.addNew(userAccount);
    }
    private void registerShipper(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cccd = ValidateByRegex.checkCccdAccountShipping(request.getParameter("cccd"));
        String firstName = ValidateByRegex.checkFirstName(request.getParameter("firstName"));
        String middleName = ValidateByRegex.checkMiddleName(request.getParameter("middleName"));
        String lastName = ValidateByRegex.checkLastName(request.getParameter("lastName"));
        String phoneNumber = ValidateByRegex.checkPhoneNumber(request.getParameter("phoneNumber"));
        String password = ValidateByRegex.checkPasswordForAccountShipping(request.getParameter("password"));
        String nameAccount = firstName + " " + middleName + " " + lastName;
        LocalDate dateOfBirth = LocalDate.parse(ValidateByRegex.checkDateOfBirth(request.getParameter("dateOfBirth")));
        char sex = ValidateByRegex.checkSex(request.getParameter("sex")).charAt(0);
        String email = ValidateByRegex.checkEmail(request.getParameter("email"));
        Part imageSelfie = request.getPart("imageSelfie");
        Part imageCccdFront = request.getPart("imageCccdFront");
        Part imageCccdBack = request.getPart("imageCccdBack");
        Part imageDriverLicense = request.getPart("imageDriverLicense");
        Part imageVehicleRegistration = request.getPart("imageVehicleRegistration");
        Part imageCurriculumVitae = request.getPart("imageCurriculumVitae");
        Part imageCivilGuaranteeLetter = request.getPart("imageCivilGuaranteeLetter");
        Part imageCertificateOfNoCriminalRecord = request.getPart("imageCertificateOfNoCriminalRecord");
        Part imageBirthCertificate = request.getPart("imageBirthCertificate");
        Part imageHouseholdRegistration = request.getPart("imageHouseholdRegistration");
        Part imageHealthExaminationCertificate = request.getPart("imageHealthExaminationCertificate");
        int idTypeVehicle = ValidateByRegex.checkIdTypeVehicle(request.getParameter("idTypeVehicle"));
        int length = ValidateByRegex.checkLength(request.getParameter("length"));
        int width = ValidateByRegex.checkWidth(request.getParameter("width"));
        int height = ValidateByRegex.checkHeight(request.getParameter("height"));
        int weight = ValidateByRegex.checkWeight(request.getParameter("weight"));
        String licensePlate = request.getParameter("licensePlate").replace(" ","");
        String apartmentNumber = ValidateByRegex.checkPropertiesAddress(request.getParameter("apartmentNumber"));
        String streetName = ValidateByRegex.checkPropertiesAddress(request.getParameter("streetName"));
        String district = ValidateByRegex.checkPropertiesAddress(request.getParameter("district"));
        String ward = ValidateByRegex.checkPropertiesAddress(request.getParameter("ward"));
        String city = ValidateByRegex.checkPropertiesAddress(request.getParameter("city"));
        Part imageVehicleFront = request.getPart("imageVehicleFront");
        Part imageVehicleLeft = request.getPart("imageVehicleLeft");
        Part imageVehicleRight = request.getPart("imageVehicleRight");
        Part imageVehicleBehind = request.getPart("imageVehicleBehind");

        Address currentPosition = new Address(apartmentNumber,streetName,district,ward,city);
        TypeVehicle typeVehicle = new TypeVehicle(idTypeVehicle);
        ImageIdentification imageIdentification = new ImageIdentification(imageDriverLicense,imageVehicleRegistration,imageCurriculumVitae,imageCivilGuaranteeLetter,imageCertificateOfNoCriminalRecord,imageBirthCertificate,imageHouseholdRegistration,imageHealthExaminationCertificate);
        People people = new People(cccd,firstName,middleName,lastName,dateOfBirth,sex,email,currentPosition,imageSelfie,imageCccdFront,imageCccdBack);
        TransportImage transportImage = new TransportImage(imageVehicleFront,imageVehicleLeft,imageVehicleRight,imageVehicleBehind);
        Account account = new Account(phoneNumber,password);
        Size size = new Size(length,width,height,weight);
        AccountShipping accountShipping = new AccountShipping(nameAccount,account,typeVehicle,size,licensePlate,currentPosition,transportImage);
        Shipper shipper = new Shipper(people,imageIdentification,account);
        accountShippingRepository.addNew(accountShipping);
        shipperRepository.addNew(shipper);
    }
    private void registerTransitVehicle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cccd = ValidateByRegex.checkCccdAccountShipping(request.getParameter("cccd"));
        String firstName = ValidateByRegex.checkFirstName(request.getParameter("firstName"));
        String middleName = ValidateByRegex.checkMiddleName(request.getParameter("middleName"));
        String lastName = ValidateByRegex.checkLastName(request.getParameter("lastName"));
        String phoneNumber = ValidateByRegex.checkPhoneNumber(request.getParameter("phoneNumber"));
        String password = ValidateByRegex.checkPasswordForAccountShipping(request.getParameter("password"));
        String nameAccount = firstName + " " + middleName + " " + lastName;
        LocalDate dateOfBirth = LocalDate.parse(ValidateByRegex.checkDateOfBirth(request.getParameter("dateOfBirth")));
        char sex = ValidateByRegex.checkSex(request.getParameter("sex")).charAt(0);
        String email = ValidateByRegex.checkEmail(request.getParameter("email"));
        Part imageSelfie = request.getPart("imageSelfie");
        Part imageCccdFront = request.getPart("imageCccdFront");
        Part imageCccdBack = request.getPart("imageCccdBack");
        Part imageDriverLicense = request.getPart("imageDriverLicense");
        Part imageVehicleRegistration = request.getPart("imageVehicleRegistration");
        Part imageCurriculumVitae = request.getPart("imageCurriculumVitae");
        Part imageCivilGuaranteeLetter = request.getPart("imageCivilGuaranteeLetter");
        Part imageCertificateOfNoCriminalRecord = request.getPart("imageCertificateOfNoCriminalRecord");
        Part imageBirthCertificate = request.getPart("imageBirthCertificate");
        Part imageHouseholdRegistration = request.getPart("imageHouseholdRegistration");
        Part imageHealthExaminationCertificate = request.getPart("imageHealthExaminationCertificate");
        int idTypeVehicle = ValidateByRegex.checkIdTypeVehicle(request.getParameter("idTypeVehicle"));
        int length = ValidateByRegex.checkLength(request.getParameter("length"));
        int width = ValidateByRegex.checkWidth(request.getParameter("width"));
        int height = ValidateByRegex.checkHeight(request.getParameter("height"));
        int weight = ValidateByRegex.checkWeight(request.getParameter("weight"));
        String licensePlate = request.getParameter("licensePlate").replace(" ","");
        String apartmentNumber = ValidateByRegex.checkPropertiesAddress(request.getParameter("apartmentNumber"));
        String streetName = ValidateByRegex.checkPropertiesAddress(request.getParameter("streetName"));
        String district = ValidateByRegex.checkPropertiesAddress(request.getParameter("district"));
        String ward = ValidateByRegex.checkPropertiesAddress(request.getParameter("ward"));
        String city = ValidateByRegex.checkPropertiesAddress(request.getParameter("city"));
        Part imageVehicleFront = request.getPart("imageVehicleFront");
        Part imageVehicleLeft = request.getPart("imageVehicleLeft");
        Part imageVehicleRight = request.getPart("imageVehicleRight");
        Part imageVehicleBehind = request.getPart("imageVehicleBehind");


        Address currentPosition = new Address(apartmentNumber,streetName,district,ward,city);
        TypeVehicle typeVehicle = new TypeVehicle(idTypeVehicle);
        ImageIdentification imageIdentification = new ImageIdentification(imageDriverLicense,imageVehicleRegistration,imageCurriculumVitae,imageCivilGuaranteeLetter,imageCertificateOfNoCriminalRecord,imageBirthCertificate,imageHouseholdRegistration,imageHealthExaminationCertificate);
        People people = new People(cccd,firstName,middleName,lastName,dateOfBirth,sex,email,currentPosition,imageSelfie,imageCccdFront,imageCccdBack);
        TransportImage transportImage = new TransportImage(imageVehicleFront,imageVehicleLeft,imageVehicleRight,imageVehicleBehind);
        Account account = new Account(phoneNumber,password);
        Size size = new Size(length,width,height,weight);
        TransitVehicle transitVehicle = new TransitVehicle(people,imageIdentification,account);
        AccountShipping accountShipping = new AccountShipping(nameAccount,account,typeVehicle,size,licensePlate,currentPosition,transportImage);
        accountShippingRepository.addNew(accountShipping);
        transitVehicleRepository.addNew(transitVehicle);
    }
    private void formEditAddressDefault(HttpServletRequest request, HttpServletResponse response){
        int idUserWamtToEditDefaultAddress = ValidateByRegex.checkLength(request.getParameter("idUserAccount"));
        String phoneNumber = ValidateByRegex.checkPhoneNumber(request.getParameter("phoneNumber"));
        String nameAddress = ValidateByRegex.checkPropertiesAddress(request.getParameter("nameAddress"));
        String apartmentNumber = ValidateByRegex.checkPropertiesAddress(request.getParameter("apartmentNumber"));
        String streetName = ValidateByRegex.checkPropertiesAddress(request.getParameter("streetName"));
        String district = ValidateByRegex.checkPropertiesAddress(request.getParameter("district"));
        String ward = ValidateByRegex.checkPropertiesAddress(request.getParameter("ward"));
        String city = ValidateByRegex.checkPropertiesAddress(request.getParameter("city"));
        Account account = new Account(idUserWamtToEditDefaultAddress);
        Address address = new Address(nameAddress,apartmentNumber,streetName,district,ward,city,phoneNumber);
        UserAccount userAccount = new UserAccount(account,new People(address));
        userAccountRepository.editDefaltAddress(userAccount);
    }
    private void formDeleteElementAddressInlist(HttpServletRequest request, HttpServletResponse response){
        int idUserWamtToDeleteAddress = ValidateByRegex.checkLength(request.getParameter("idUserAccount"));
        int indexElementDelete = ValidateByRegex.checkLength(request.getParameter("indexElementDelete"));
        Account account = new Account(idUserWamtToDeleteAddress);
        List<Address> addressList = userAccountRepository.getAddressToTheListById(new UserAccount(account));
        addressList.remove(indexElementDelete);
        People people = new People(addressList);
        userAccountRepository.editOrDeleteAddressInTheListById(new UserAccount(account,people));
    }
    private void formEditElementAddressInlist(HttpServletRequest request, HttpServletResponse response){
        int idUserWamtToDeleteAddress = ValidateByRegex.checkLength(request.getParameter("idUserAccount"));
        int indexElementEdit = ValidateByRegex.checkLength(request.getParameter("indexElementDelete"));
        String phoneNumber = ValidateByRegex.checkPhoneNumber(request.getParameter("phoneNumber"));
        String nameAddress = ValidateByRegex.checkPropertiesAddress(request.getParameter("nameAddress"));
        String apartmentNumber = ValidateByRegex.checkPropertiesAddress(request.getParameter("apartmentNumber"));
        String streetName = ValidateByRegex.checkPropertiesAddress(request.getParameter("streetName"));
        String district = ValidateByRegex.checkPropertiesAddress(request.getParameter("district"));
        String ward = ValidateByRegex.checkPropertiesAddress(request.getParameter("ward"));
        String city = ValidateByRegex.checkPropertiesAddress(request.getParameter("city"));
        Account account = new Account(idUserWamtToDeleteAddress);
        Address address = new Address(nameAddress,apartmentNumber,streetName,district,ward,city,phoneNumber);
        List<Address> addressList = userAccountRepository.getAddressToTheListById(new UserAccount(account));
        addressList.set(indexElementEdit, address);
        People people = new People(addressList);
        userAccountRepository.editOrDeleteAddressInTheListById(new UserAccount(account,people));
    }
    private void formAddNewAddressToListOldAddress(HttpServletRequest request, HttpServletResponse response){
        int idUserWantToAddNewAddress = ValidateByRegex.checkLength(request.getParameter("idUserAccount"));
        String phoneNumber = ValidateByRegex.checkPhoneNumber(request.getParameter("phoneNumber"));
        String nameAddress = ValidateByRegex.checkPropertiesAddress(request.getParameter("nameAddress"));
        String apartmentNumber = ValidateByRegex.checkPropertiesAddress(request.getParameter("apartmentNumber"));
        String streetName = ValidateByRegex.checkPropertiesAddress(request.getParameter("streetName"));
        String district = ValidateByRegex.checkPropertiesAddress(request.getParameter("district"));
        String ward = ValidateByRegex.checkPropertiesAddress(request.getParameter("ward"));
        String city = ValidateByRegex.checkPropertiesAddress(request.getParameter("city"));
        Address newAddress = new Address(nameAddress,apartmentNumber,streetName,district,ward,city,phoneNumber);
        Account account = new Account(idUserWantToAddNewAddress);
        List<Address> addressList = userAccountRepository.getAddressToTheListById(new UserAccount(account));
        addressList.add(newAddress);
        People people = new People(addressList);
        userAccountRepository.editOrDeleteAddressInTheListById(new UserAccount(account,people));
    }
    private void formGetListOldAddress(HttpServletRequest request, HttpServletResponse response){

    }
}
