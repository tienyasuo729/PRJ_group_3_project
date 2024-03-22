package org.example.shipping_services_for_everyone.repository.queryStatement;

public class OrderShippingQueryStatement {
    public final String addNewOrder = "INSERT INTO Order_Shipping (id_sender, id_receiver, collection_money, transportation_cost, status_order, "
            + "apartment_number_sender, street_name_sender, District_sender, Ward_sender, city_sender, "
            + "apartment_number_receiver, street_name_receiver, District_receiver, Ward_receiver, city_receiver, "
            + "note_for_shipper, estimated_delivery_time, check_package, id_pickup, id_delivery) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    public final String selectID = "SELECT MAX(id_order) AS max_id FROM Order_Shipping;";

}
