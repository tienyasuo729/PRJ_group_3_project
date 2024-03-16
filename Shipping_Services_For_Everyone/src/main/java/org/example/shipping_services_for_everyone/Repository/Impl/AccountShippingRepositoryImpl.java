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
