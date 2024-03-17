package org.example.shipping_services_for_everyone.Repository.QueryStatement;

public class ShipperQueryStatement {
    public final static String addNewShipper = "INSERT INTO account_shipping (name_account, phone_number, password, type, length, width, height, maximum_storage_volume, license_plate, apartment_number, street_name, District, Ward, city, image_vehicle_front, image_vehicle_left, image_vehicle_right, image_vehicle_behind) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
}
