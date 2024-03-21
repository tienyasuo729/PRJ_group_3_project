package org.example.shipping_services_for_everyone.validate;

import javax.servlet.http.Part;

public class ValidateByRegex {
    private static RegexStatement regexStatement = new RegexStatement();

    public static String checkPhoneNumber(String phoneNumber) {
        if (phoneNumber.trim().isEmpty()){
            return "error";
        }else if (phoneNumber.replace(" ","").matches(regexStatement.phoneNumber)){
            return phoneNumber.replace(" ","");
        }else {
            return "error";
        }
    }

    public static String checkCccdUser(String cccd) {
        if (cccd.trim().isEmpty()){
            return null;
        }else if (cccd.replace(" ","").matches(regexStatement.cccdForUser)){
            return cccd.replace(" ","");
        }else {
            return "error";
        }
    }
    public static String checkCccdAccountShipping(String cccd) {
        if (cccd.trim().isEmpty()){
            return "error";
        }else if (cccd.replace(" ","").matches(regexStatement.cccdForShipper)){
            return cccd.replace(" ","");
        }else {
            return "error";
        }
    }

    public static String checkPasswordForUser(String password) {
        if (password.trim().isEmpty()){
            return null;
        }else if (password.matches(regexStatement.password)){
            return password;
        }else {
            return "error";
        }
    }

    public static String checkPasswordForAccountShipping(String password) {
        if (password.trim().isEmpty()){
            return "error";
        }else if (password.matches(regexStatement.password)){
            return password;
        }else {
            return "error";
        }
    }

    public static String checkNameAccount(String nameAccount) {
        if (nameAccount.trim().isEmpty()){
            return "error";
        }else if (nameAccount.trim().replace("  "," ").matches(regexStatement.nameAccount)){
            return nameAccount.trim().replace("  "," ");
        }else {
            return "error";
        }
    }

    public static String checkFirstName(String firstName) {
        if (firstName.trim().isEmpty()){
            return "error";
        }else if (firstName.trim().replace("  "," ").matches(regexStatement.firstName)){
            return firstName.trim().replace("  "," ");
        }else {
            return "error";
        }
    }

    public static String checkMiddleName(String middleName) {
        if (middleName.trim().isEmpty()){
            return null;
        }else if (middleName.trim().replace("  "," ").matches(regexStatement.middleName)){
            return middleName.trim().replace("  "," ");
        }else {
            return "error";
        }
    }

    public static String checkLastName(String lastName) {
        if (lastName.trim().isEmpty()){
            return "error";
        }else if (lastName.trim().replace("  "," ").matches(regexStatement.lastName)){
            return lastName.trim().replace("  "," ");
        }else {
            return "error";
        }
    }

    public static String checkDateOfBirth(String dateOfBirth) {
        if (dateOfBirth.replace(" ","").isEmpty()){
            return "error";
        }else if (dateOfBirth.replace(" ","").matches(regexStatement.dateOfBirth)){
            return dateOfBirth.replace(" ","");
        }else {
            return "error";
        }
    }

    public static String checkSex(String sex) {
        if (sex.replace(" ","").isEmpty()){
            return "error";
        }else if (sex.replace(" ","").matches(regexStatement.sex)){
            return sex.replace(" ","");
        }else {
            return "error";
        }
    }
    public static String checkPropertiesAddress(String propertiesAddress) {
        if (propertiesAddress.replace(" ","").isEmpty()){
            return null;
        }else if (propertiesAddress.trim().replace("  ", " ").matches(regexStatement.propertiesAddress)){
            return propertiesAddress.trim().replace("  ", " ");
        }else {
            return "error";
        }
    }

    public static String checkEmail(String email) {
        if (email.replace(" ","").isEmpty()){
            return null;
        }else if (email.matches(regexStatement.email)){
            return email;
        }else {
            return "error";
        }
    }

    public static String checkAddressForUserAccount(String addressForUserAccount) {
        if (addressForUserAccount.replace(" ","").isEmpty()){
            return "error";
        }else if (addressForUserAccount.matches(regexStatement.addressForUserAccount)){
            return addressForUserAccount;
        }else {
            return "error";
        }
    }

    public static String checkListAddressForUserAccount(String listAddressForUserAccount) {
        if (listAddressForUserAccount.replace(" ","").isEmpty()){
            return null;
        }else if (listAddressForUserAccount.matches(regexStatement.listAddressForUserAccount)){
            return listAddressForUserAccount;
        }else {
            return "error";
        }
    }

    public static int checkLength(String length) {
        if (length.replace(" ","").isEmpty()){
            return 0;
        }else if (length.matches(regexStatement.length)){
            return Integer.parseInt(length);
        }else {
            return 0;
        }

    }

    public static int checkWidth(String width) {
        if (width.replace(" ","").isEmpty()){
            return 0;
        }else if (width.matches(regexStatement.width)){
            return Integer.parseInt(width);
        }else {
            return 0;
        }

    }
    public static int checkHeight(String height) {
        if (height.replace(" ","").isEmpty()){
            return 0;
        }else if (height.matches(regexStatement.height)){
            return Integer.parseInt(height);
        }else {
            return 0;
        }

    }
    public static int checkWeight(String weight) {
        if (weight.replace(" ","").isEmpty()){
            return 0;
        }else if (weight.matches(regexStatement.weight)){
            return Integer.parseInt(weight);
        }else {
            return 0;
        }

    }
    public static int checkIdTypeVehicle(String idTypeVehicle) {
        if (idTypeVehicle.replace(" ","").isEmpty()){
            return 0;
        }else if (idTypeVehicle.matches(regexStatement.idTypeVehicle)){
            return Integer.parseInt(idTypeVehicle);
        }else {
            return 0;
        }

    }

    public static Part checkImage(Part image){
        if (image.getSize() == 0){
            return null;
        }else {
            return image;
        }

    };

    public static String checkImageSelfie(String imageSelfie) { return imageSelfie; }
    public static String checkImageCccdFront(String imageCccdFront) { return imageCccdFront; }
    public static String checkImageCccdBack(String imageCccdBack) { return imageCccdBack; }

//    public int checkIdSender(String idSender) {
//        if (idSender.replace(" ","").isEmpty()){
//            return null;
//        }else if (idSender.matches(regexStatement.weight)){
//            return Integer.parseInt(idSender);
//        }else {
//            return 0;
//        }
//    }

//    public String check(String firstName) {
//        if (firstName.trim().isEmpty()){
//            return "error";
//        }else if (firstName.trim().matches(regexStatement.middleName)){
//            return firstName.trim();
//        }else {
//            return "error";
//        }
//    }
}
