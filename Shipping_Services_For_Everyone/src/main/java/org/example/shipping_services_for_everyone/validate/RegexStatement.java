package org.example.shipping_services_for_everyone.validate;

public class RegexStatement {
    final String cccdForShipper = "^\\d{12}$";
    final String cccdForUser = "^(\\d{12})?$";
    final String firstName = "^([a-zA-ZÀ-ỹà-ỹ]+(?:\\s|$))+$";
    final String middleName = "^([a-zA-ZÀ-ỹà-ỹ]+(?:\\s|$))*$";
    final String lastName = "^([a-zA-ZÀ-ỹà-ỹ]+(?:\\s|$))+$";
    final String a = "";
}
