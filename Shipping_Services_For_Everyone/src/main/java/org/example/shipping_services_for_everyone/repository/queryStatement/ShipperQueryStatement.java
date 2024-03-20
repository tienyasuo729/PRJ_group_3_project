package org.example.shipping_services_for_everyone.repository.queryStatement;

public class ShipperQueryStatement {
    public final String addNewShipper = "INSERT INTO Shipper (cccd, first_name, middle_name, last_name, DateOfBirth, sex, email, image_selfie, image_cccd_front, image_cccd_back, image_driver_license, image_vehicle_registration, image_Curriculum_Vitae, image_Civil_Guarantee_Letter, image_Certificate_of_No_Criminal_Record, image_Birth_Certificate, image_Household_Registration, image_Health_Examination_Certificate, id_account_shipping) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
}
