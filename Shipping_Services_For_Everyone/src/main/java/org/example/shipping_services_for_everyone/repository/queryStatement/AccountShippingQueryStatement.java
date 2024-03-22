package org.example.shipping_services_for_everyone.repository.queryStatement;

public class AccountShippingQueryStatement {
    public final String addNewAccountShipping = "INSERT INTO account_shipping (name_account, phone_number, password, type, length, width, height, maximum_storage_volume, license_plate, apartment_number, street_name, District, Ward, city, image_vehicle_front, image_vehicle_left, image_vehicle_right, image_vehicle_behind) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    public final String selectID = "SELECT MAX(id_account_shipping) AS max_id FROM account_shipping;";
    public final String findShipperToPickupOrDeliveryOrder = "SELECT " +
            "a.id_account_shipping, " +
            "COUNT(CASE WHEN o.status_order = ? THEN o.id_order ELSE NULL END) AS total_orders_with_status_a, " +
            "SUM(e.Rating) AS total_rating_points " +
            "FROM " +
            "account_shipping AS a " +
            "LEFT JOIN " +
            "Order_Shipping AS o ON a.id_account_shipping = o.id_sender " +
            "LEFT JOIN " +
            "evaluate AS e ON a.id_account_shipping = e.id_account_shipping " +
            "WHERE " +
            "a.District = ? AND a.Ward = ? AND a.city = ? " +
            "AND a.active_status = 1 " +
            "AND a.type = 1 " +
            "GROUP BY " +
            "a.id_account_shipping " +
            "ORDER BY " +
            "total_rating_points DESC, " +
            "total_orders_with_status_a DESC";

}
