package org.example.shipping_services_for_everyone.repository.queryStatement;

public class UserAccountQueryStatement {
    public final String addNewUserAccount = "INSERT INTO user_account (phone_number, password, cccd, first_name, middle_name, last_name, DateOfBirth, sex, email, address, image_selfie, image_cccd_front, image_cccd_back) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    public final String getListOldAddress = "SELECT list_old_address FROM user_account WHERE id_account = ?";
    public final String editListOldAddress = "UPDATE user_account SET list_old_address = ? WHERE id_account = ?";

}
