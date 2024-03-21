package org.example.shipping_services_for_everyone.repository.queryStatement;

public class AccountShippingQueryStatement {
    public final String addNewAccountShipping = "INSERT INTO account_shipping (name_account, phone_number, password, type, length, width, height, maximum_storage_volume, license_plate, apartment_number, street_name, District, Ward, city, image_vehicle_front, image_vehicle_left, image_vehicle_right, image_vehicle_behind) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    public final String selectID = "SELECT MAX(id_account_shipping) AS max_id FROM account_shipping;";

}
