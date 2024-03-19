package org.example.shipping_services_for_everyone.validate;

public class RegexStatement {
    final String cccdForShipper = "^\\d{12}$";
    final String phoneNumber = "^0\\d{9,10}$";
    final String cccdForUser = "^(?:\\d{12})?$";
    final String password = "^(?=.*[A-Z])[A-Za-z\\d\\W_]{8,99}$";
    final String nameAccount = "^[a-zA-ZÀ-ỹ]+(?: [a-zA-ZÀ-ỹ]+)*$";
    final String firstName = "^[a-zA-ZÀ-ỹ]+(?: [a-zA-ZÀ-ỹ]+)*$";
    final String middleName = "^(?:[a-zA-ZÀ-ỹ]+(?: [a-zA-ZÀ-ỹ]+)*)?$";
    final String lastName = "^[a-zA-ZÀ-ỹ]+(?: [a-zA-ZÀ-ỹ]+)*$";
    final String dateOfBirth = "^(?:19|20|21)\\d{2}-(?:0[1-9]|1[0-2])-(?:0[1-9]|[12]\\d|3[01])$";
    final String sex = "^[a-zA-Z]$";
    final String email = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    final String addressForUserAccount = "^[^\\|\\n]+(?:\\s*\\|\\s*[^\\|\\n]+){6}\\s*\\.$";
    final String listAddressForUserAccount = "^(\\s*|[^\\|\\n]+(?:\\s*\\|\\s*[^\\|\\n]+){6}(?:\\s*\\|\\s*[^\\|\\n]+)*\\s*\\.)$";
    final String length = "^[1-9]\\d*$";
    final String width = "^[1-9]\\d*$";
    final String height = "^[1-9]\\d*$";
    final String weight = "^[1-9]\\d*$";
    final String propertiesAddress = "^[^.|]*$";
    final String idSender = "^[1-9]\\d*$";
    final String idTypeVehicle = "^[1-9]\\d*$";
    final String idEeceiver = "^[1-9]\\d*$";
    final String collectionMoney = "^\\d+$";
    final String transportationCost = "^\\d+$";
    final String rating = "^(1(\\.5)?|2(\\.5)?|3(\\.5)?|4(\\.5)?|5)$";
    final String a = "";
}
