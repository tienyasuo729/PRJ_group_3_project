package org.example.shipping_services_for_everyone.repository.Impl;

import org.example.shipping_services_for_everyone.model.Account;
import org.example.shipping_services_for_everyone.model.UserAccount;
import org.example.shipping_services_for_everyone.repository.IRepository;
import org.example.shipping_services_for_everyone.repository.queryStatement.AccountShippingQueryStatement;
import org.example.shipping_services_for_everyone.connection_config.BaseRepositoryJDBC;
import org.example.shipping_services_for_everyone.model.AccountShipping;
import org.example.shipping_services_for_everyone.repository.queryStatement.ImageLocationStatement;

import javax.servlet.ServletException;
import java.io.File;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AccountShippingRepositoryImpl implements IRepository<AccountShipping> {
    private BaseRepositoryJDBC baseRepositoryJDBC = new BaseRepositoryJDBC();
    private AccountShippingQueryStatement accountShippingQueryStatement = new AccountShippingQueryStatement();
    private ImageLocationStatement locationStatement = new ImageLocationStatement();
    private ImageRepositoryImpl imageRepository = new ImageRepositoryImpl();
    private final String folderImage = locationStatement.vehicleImage;
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
            preparedStatement.setString(15, folderImage + File.separator + accountShipping.getAccount().getPhoneNumber() + "ImageVehicleFront");
            preparedStatement.setString(16, folderImage + File.separator + accountShipping.getAccount().getPhoneNumber() + "ImageVehicleLeft");
            preparedStatement.setString(17, folderImage + File.separator + accountShipping.getAccount().getPhoneNumber() + "ImageVehicleRight");
            preparedStatement.setString(18, folderImage + File.separator + accountShipping.getAccount().getPhoneNumber() + "ImageVehicleBehind");
            imageRepository.saveImage(accountShipping.getTransportImage().getFileImageVehicleFront(), folderImage, accountShipping.getAccount().getPhoneNumber() + "ImageVehicleFront");
            imageRepository.saveImage(accountShipping.getTransportImage().getFileImageVehicleLeft(), folderImage, accountShipping.getAccount().getPhoneNumber() + "ImageVehicleLeft");
            imageRepository.saveImage(accountShipping.getTransportImage().getFileImageVehicleRight(), folderImage, accountShipping.getAccount().getPhoneNumber() + "ImageVehicleRight");
            imageRepository.saveImage(accountShipping.getTransportImage().getFileImageVehicleBehind(), folderImage, accountShipping.getAccount().getPhoneNumber() + "ImageVehicleBehind");
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
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
    public List<AccountShipping> find(AccountShipping shippingAccount) {
        String sqlQuerry_find ="select id_account_shipping,name_account,phone_number,password,active_status from account_shipping where phone_number=? and password=?";
        List<AccountShipping> list = new ArrayList<>();
        String Number = shippingAccount.getAccount().getPhoneNumber();
        String pass = shippingAccount.getAccount().getPassword();
        try {
            PreparedStatement ps = this.baseRepositoryJDBC.getConnectionJavaToDB().prepareStatement(sqlQuerry_find);
            ps.setString(1, Number);
            ps.setString(2, pass);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id_account =rs.getInt(1);
                String name =rs.getString(2);
                String phoneNumber = rs.getString(3);
                String password = rs.getString(4);
                boolean active_status=rs.getBoolean(5);
                Account c = new Account(id_account, phoneNumber, password);
                AccountShipping accShipping = new AccountShipping(name, c,active_status);
                list.add(accShipping);

            }
        } catch (Exception ex) {
            Logger.getLogger(UserAccountRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);

        }
        return list;
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

    public AccountShipping findShipperToPickupOrder(UserAccount receiver, char status){
        List<AccountShipping> accountShippingList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseRepositoryJDBC.getConnectionJavaToDB().prepareStatement(accountShippingQueryStatement.findShipperToPickupOrDeliveryOrder);
            preparedStatement.setString(1, String.valueOf(status));
            preparedStatement.setString(2, receiver.getPeople().getAddress().getDistrict());
            preparedStatement.setString(3, receiver.getPeople().getAddress().getDistrict());
            preparedStatement.setString(4, receiver.getPeople().getAddress().getCity());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id_account_shipping = resultSet.getInt("id_account_shipping");
                int total_orders_with_status_a = resultSet.getInt("total_orders_with_status_a");
                int total_rating_points = resultSet.getInt("total_rating_points");
                accountShippingList.add(new AccountShipping(new Account(id_account_shipping)));
            }
            Random random = new Random();
            return accountShippingList.get(random.nextInt(accountShippingList.size()-1)+1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateActiveStatusOn(int id){
        String SQLquery="UPDATE account_shipping  Set active_status=1 where id_account_shipping =?";
        try {
            String id_Shiper = Integer.toString(id);
            PreparedStatement ps = this.baseRepositoryJDBC.getConnectionJavaToDB().prepareStatement(SQLquery);
            ps.setString(1, id_Shiper);
            int rowsAffected=ps.executeUpdate();
            if(rowsAffected!=0) {
                return true;
            }
        } catch (Exception ex) {
            Logger.getLogger(AccountShippingRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean updateActiveStatusOff(int id){
        String SQLquery="UPDATE account_shipping  Set active_status=0 where id_account_shipping =?";
        try {
            String id_Shiper = Integer.toString(id);
            PreparedStatement ps = this.baseRepositoryJDBC.getConnectionJavaToDB().prepareStatement(SQLquery);
            ps.setString(1, id_Shiper);
            int rowsAffected=ps.executeUpdate();
            if(rowsAffected!=0) {
                return false;
            }
        } catch (Exception ex) {
            Logger.getLogger(AccountShippingRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
}
