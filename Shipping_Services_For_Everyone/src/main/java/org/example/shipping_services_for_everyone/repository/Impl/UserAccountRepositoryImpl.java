package org.example.shipping_services_for_everyone.repository.Impl;

import org.example.shipping_services_for_everyone.model.Account;
import org.example.shipping_services_for_everyone.model.Address;
import org.example.shipping_services_for_everyone.model.People;
import org.example.shipping_services_for_everyone.repository.IRepository;
import org.example.shipping_services_for_everyone.repository.queryStatement.ImageLocationStatement;
import org.example.shipping_services_for_everyone.repository.queryStatement.UserAccountQueryStatement;
import org.example.shipping_services_for_everyone.connection_config.BaseRepositoryJDBC;
import org.example.shipping_services_for_everyone.model.UserAccount;

import javax.servlet.ServletException;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserAccountRepositoryImpl implements IRepository<UserAccount> {
    private BaseRepositoryJDBC baseRepositoryJDBC = new BaseRepositoryJDBC();
    private UserAccountQueryStatement userAccountQueryStatement = new UserAccountQueryStatement();
    private ImageLocationStatement locationStatement = new ImageLocationStatement();
    private ImageRepositoryImpl imageRepository = new ImageRepositoryImpl();
    private final String folderImage = locationStatement.userAccountImage;

    @Override
    public List<UserAccount> display(UserAccount object) {
        return null;
    }

    @Override
    public void addNew(UserAccount userAccount) {
        try {
            PreparedStatement preparedStatement = this.baseRepositoryJDBC.getConnectionJavaToDB().prepareStatement(userAccountQueryStatement.addNewUserAccount);
            String imageSelfie = null;
            String imageCccdFront = null;
            String imageCccdBack = null;
            if (userAccount.getPeople().getFileImageSelfie() != null){
                imageRepository.saveImage(userAccount.getPeople().getFileImageSelfie(), folderImage, userAccount.getAccount().getPhoneNumber() + "ImageSelfie");
                imageSelfie = folderImage + File.separator + userAccount.getAccount().getPhoneNumber() + "ImageSelfie";
            }
            if (userAccount.getPeople().getFileCccdFront() != null){
                imageRepository.saveImage(userAccount.getPeople().getFileCccdFront(), folderImage, userAccount.getAccount().getPhoneNumber() + "ImageCccdFront");
                imageCccdFront = folderImage + File.separator + userAccount.getAccount().getPhoneNumber() + "ImageCccdFront";
            }
            if (userAccount.getPeople().getFileCccdBack() != null){
                imageRepository.saveImage(userAccount.getPeople().getFileCccdBack(), folderImage, userAccount.getAccount().getPhoneNumber() + "ImageCccdBack");
                imageCccdBack = folderImage + File.separator + userAccount.getAccount().getPhoneNumber() + "ImageCccdBack";
            }
            preparedStatement.setString(1, userAccount.getAccount().getPhoneNumber());
            preparedStatement.setString(2, userAccount.getAccount().getPassword());
            preparedStatement.setString(3, userAccount.getPeople().getCccd());
            preparedStatement.setString(4, userAccount.getPeople().getFirstName());
            preparedStatement.setString(5, userAccount.getPeople().getMiddleName());
            preparedStatement.setString(6, userAccount.getPeople().getLastName());
            preparedStatement.setDate(7, Date.valueOf(userAccount.getPeople().getDateOfBirth()));
            preparedStatement.setString(8, String.valueOf(userAccount.getPeople().getSex()));
            preparedStatement.setString(9, userAccount.getPeople().getEmail());
            preparedStatement.setString(10, userAccount.getPeople().getAddress().toString());
            preparedStatement.setString(11, userAccount.getPeople().getAddress().toString());
            preparedStatement.setString(12, imageSelfie);
            preparedStatement.setString(13, imageCccdFront);
            preparedStatement.setString(14, imageCccdBack);
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
    public void edit(UserAccount object) {

    }

    @Override
    public void delete(UserAccount object) {

    }

    @Override
    public List<UserAccount> find(UserAccount userAccount) {
        String sqlQuerry_find ="select id_account,phone_number,password,first_name,middle_name,last_name from user_account where  phone_number=? and password =?";
        List<UserAccount> list = new ArrayList<>();
        String Number = userAccount.getAccount().getPhoneNumber();
        String pass = userAccount.getAccount().getPassword();
        try {
            PreparedStatement ps = this.baseRepositoryJDBC.getConnectionJavaToDB().prepareStatement(sqlQuerry_find);
            ps.setString(1, Number);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idAccount = rs.getInt(1);
                String phoneNumber = rs.getString(2);
                String password = rs.getString(3);
                String fistName=rs.getString(4);
                String middleName=rs.getString(5);
                String lastName=rs.getString(6);
                Account c = new Account(idAccount, phoneNumber, password);

                People p= new People(fistName, middleName, lastName);
                UserAccount usAccount=new  UserAccount(c, p);
                list.add(usAccount);
            }
        } catch (Exception ex) {
            Logger.getLogger(UserAccountRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);

        }
        return list;    }

    @Override
    public Boolean checkIdIsExist(UserAccount object) {
        return null;
    }

    public void editDefaltAddress(UserAccount userAccount){
        try {
            PreparedStatement preparedStatement = this.baseRepositoryJDBC.getConnectionJavaToDB().prepareStatement(userAccountQueryStatement.editAddress);
            preparedStatement.setString(1, userAccount.getPeople().getAddress().toString());
            preparedStatement.setInt(2, userAccount.getAccount().getIdAccount());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void editOrDeleteAddressInTheListById(UserAccount userAccount){
        try {
            PreparedStatement preparedStatement = this.baseRepositoryJDBC.getConnectionJavaToDB().prepareStatement(userAccountQueryStatement.editListOldAddress);
            preparedStatement.setString(1, userAccount.getPeople().toStringListOld_address());
            preparedStatement.setInt(2, userAccount.getAccount().getIdAccount());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public List<Address> getAddressToTheListById(UserAccount userAccount){
        List<Address> addressList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseRepositoryJDBC.getConnectionJavaToDB().prepareStatement(userAccountQueryStatement.getListOldAddress);
            preparedStatement.setInt(1, userAccount.getAccount().getIdAccount());
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            String[] elements = resultSet.getString("list_old_address").split("\\|");
            elements[elements.length - 1] = elements[elements.length - 1].replace(".", "").trim();
            for (int i = 0; i < elements.length; i += 7) {
                addressList.add(new Address(
                        elements[i],
                        elements[i + 1],
                        elements[i + 2],
                        elements[i + 3],
                        elements[i + 4],
                        elements[i + 5],
                        elements[i + 6]
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return addressList;
    }

    public UserAccount findIdByPhoneNumber(String phoneNumberToFind) throws SQLException {
        PreparedStatement preparedStatement = this.baseRepositoryJDBC.getConnectionJavaToDB().prepareStatement(userAccountQueryStatement.findIdByPhoneNumber);
        preparedStatement.setString(1, phoneNumberToFind);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return new UserAccount(new Account(resultSet.getInt("id_account")));
    }

    public Address getAddressByIdUser(int idUser) throws SQLException {
        PreparedStatement preparedStatement = this.baseRepositoryJDBC.getConnectionJavaToDB().prepareStatement(userAccountQueryStatement.getAddresByIdUser);
        preparedStatement.setInt(1, idUser);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        String[] elements = resultSet.getString("address").split("\\|");
        Address address = null;
        for (int i = 0; i < elements.length; i += 7) {
            address =  new Address(
                    elements[i],
                    elements[i + 1],
                    elements[i + 2],
                    elements[i + 3],
                    elements[i + 4],
                    elements[i + 5],
                    elements[i + 6]
            );
        }
        return address;
    }
}
