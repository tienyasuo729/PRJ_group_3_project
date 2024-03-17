package org.example.shipping_services_for_everyone.repository.Impl;

import org.example.shipping_services_for_everyone.repository.IRepository;
import org.example.shipping_services_for_everyone.repository.queryStatement.UserAccountQueryStatement;
import org.example.shipping_services_for_everyone.connection_config.BaseRepositoryJDBC;
import org.example.shipping_services_for_everyone.model.UserAccount;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class UserAccountRepositoryImpl implements IRepository<UserAccount> {
    private BaseRepositoryJDBC baseRepositoryJDBC = new BaseRepositoryJDBC();
    private UserAccountQueryStatement userAccountQueryStatement = new UserAccountQueryStatement();

    @Override
    public List<UserAccount> display(UserAccount object) {
        return null;
    }

    @Override
    public void addNew(UserAccount userAccount) {
        try {
            PreparedStatement preparedStatement = this.baseRepositoryJDBC.getConnectionJavaToDB().prepareStatement(userAccountQueryStatement.addNewUserAccount);
            preparedStatement.setString(1, userAccount.getAccount().getPhoneNumber());
            preparedStatement.setString(2, userAccount.getAccount().getPassword());
            preparedStatement.setString(3, userAccount.getPeople().getCccd());
            preparedStatement.setString(4, userAccount.getPeople().getFirstName());
            preparedStatement.setString(5, userAccount.getPeople().getMiddleName());
            preparedStatement.setString(6, userAccount.getPeople().getLastName());
            preparedStatement.setDate(7, Date.valueOf(userAccount.getPeople().getDateOfBirth()));
            preparedStatement.setString(8, String.valueOf(userAccount.getPeople().getSex()));
            preparedStatement.setString(9, userAccount.getPeople().getEmail());
            preparedStatement.setString(10, userAccount.getPeople().getAddress().getNameAddress() + " | " + userAccount.getPeople().getAddress().getApartmentNumber() + " | " + userAccount.getPeople().getAddress().getStreetName() + " | " + userAccount.getPeople().getAddress().getDistrict() + " | " + userAccount.getPeople().getAddress().getWard() + " | " + userAccount.getPeople().getAddress().getCity()+ " | " + userAccount.getPeople().getAddress().getPhoneNumberForThisAddress());
            preparedStatement.setString(11, userAccount.getPeople().getImageSelfie());
            preparedStatement.setString(12, userAccount.getPeople().getImageCccdFront());
            preparedStatement.setString(13, userAccount.getPeople().getImageCccdBack());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void edit(UserAccount object) {

    }

    @Override
    public void delete(UserAccount object) {

    }

    @Override
    public List<UserAccount> find(UserAccount object) {
        return null;
    }

    @Override
    public Boolean checkIdIsExist(UserAccount object) {
        return null;
    }
}
