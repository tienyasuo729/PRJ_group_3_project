package org.example.shipping_services_for_everyone.repository.queryStatement;

public class PackageQueryStatement {
    public final String addNewPackage = "INSERT INTO package (name_Item, length, width, height, weight, image_1, image_2, image_3, image_4, id_order) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
}
