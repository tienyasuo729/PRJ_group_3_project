package org.example.shipping_services_for_everyone.repository.Impl;

import org.example.shipping_services_for_everyone.repository.IRepository;
import org.example.shipping_services_for_everyone.repository.queryStatement.AccountShippingQueryStatement;
import org.example.shipping_services_for_everyone.connection_config.BaseRepositoryJDBC;
import org.example.shipping_services_for_everyone.model.AccountShipping;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AccountShippingRepositoryImpl implements IRepository<AccountShipping> {
    private BaseRepositoryJDBC baseRepositoryJDBC = new BaseRepositoryJDBC();
    private AccountShippingQueryStatement accountShippingQueryStatement = new AccountShippingQueryStatement();
    @Override
    public List<AccountShipping> display(AccountShipping object) {
        return null;
    }

    @Override
    public void addNew(AccountShipping accountShipping) {
        try {
            PreparedStatement preparedStatement = this.baseRepositoryJDBC.getConnectionJavaToDB().prepareStatement(accountShippingQueryStatement.addNewAccountShipping);
            preparedStatement.setString(1, accountShipping.getNameAccount());
            preparedStatement.setString(2, accountShipping.getAccount().getPhoneNumber());
            preparedStatement.setString(3, accountShipping.getAccount().getPassword());
            preparedStatement.setInt(4, accountShipping.getTypeVehicle().getIdTypeVehicle());
            preparedStatement.setInt(5, accountShipping.getSize().getLength());
            preparedStatement.setInt(6, accountShipping.getSize().getWidth());
            preparedStatement.setInt(7, accountShipping.getSize().getHeight());
            preparedStatement.setInt(8, accountShipping.getSize().getWeight());
            preparedStatement.setString(9, accountShipping.getLicensePlate());
            preparedStatement.setString(10, accountShipping.getCurrentPosition().getApartmentNumber());
            preparedStatement.setString(11, accountShipping.getCurrentPosition().getStreetName());
            preparedStatement.setString(12, accountShipping.getCurrentPosition().getDistrict());
            preparedStatement.setString(13, accountShipping.getCurrentPosition().getWard());
            preparedStatement.setString(14, accountShipping.getCurrentPosition().getCity());
            preparedStatement.setString(15, accountShipping.getTransportImage().getImageVehicleFront());
            preparedStatement.setString(16, accountShipping.getTransportImage().getImageVehicleLeft());
            preparedStatement.setString(17, accountShipping.getTransportImage().getImageVehicleRight());
            preparedStatement.setString(18, accountShipping.getTransportImage().getImageVehicleBehind());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void edit(AccountShipping object) {

    }

    @Override
    public void delete(AccountShipping object) {

    }

    @Override
    public List<AccountShipping> find(AccountShipping object) {
        return null;
    }

    @Override
    public Boolean checkIdIsExist(AccountShipping object) {
        return null;
    }

    public int selectIdForAddNewAccountShipping(){
        try {
            PreparedStatement preparedStatement = this.baseRepositoryJDBC.getConnectionJavaToDB().prepareStatement(accountShippingQueryStatement.selectID);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return resultSet.getInt("max_id");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
