package org.example.shipping_services_for_everyone.Repository.Impl;

import org.example.shipping_services_for_everyone.Repository.IRepository;
import org.example.shipping_services_for_everyone.Repository.QueryStatement.ShipperQueryStatement;
import org.example.shipping_services_for_everyone.connection_config.BaseRepositoryJDBC;
import org.example.shipping_services_for_everyone.model.AccountShipping;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class AccountShippingRepositoryImpl implements IRepository<AccountShipping> {
    private BaseRepositoryJDBC baseRepositoryJDBC = new BaseRepositoryJDBC();
    @Override
    public List<AccountShipping> display(AccountShipping object) {
        return null;
    }

    @Override
    public void addNew(AccountShipping object) {
        try {
            PreparedStatement preparedStatement = this.baseRepositoryJDBC.getConnectionJavaToDB().prepareStatement(ShipperQueryStatement.addNewShipper);
            preparedStatement.setString(1, );
            preparedStatement.setString(2, );
            preparedStatement.setString(3, );
            preparedStatement.setInt(4,);
            preparedStatement.setInt(5,);
            preparedStatement.setInt(6,);
            preparedStatement.setInt(7,);
            preparedStatement.setInt(8,);
            preparedStatement.setString(9,);
            preparedStatement.setString(10,);
            preparedStatement.setString(11,);
            preparedStatement.setString(12,);
            preparedStatement.setString(13, );
            preparedStatement.setString(14, );
            preparedStatement.setString(15,);
            preparedStatement.setString(16,);
            preparedStatement.setString(17,);
            preparedStatement.setString(18,);

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
}
