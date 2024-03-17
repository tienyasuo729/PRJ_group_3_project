/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Impl;

import QueryStatement.IRepository;
import context.DBcontext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;
import model.People;
import model.UserAccount;


/**
 *
 * @author ASUS
 */
public class AccountUserImpl  implements IRepository<UserAccount>{
    
    @Override
    public List<UserAccount> display(UserAccount object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void addNew(UserAccount object) {
        
    }

    @Override
    public void edit(UserAccount object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(UserAccount object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<UserAccount> find(UserAccount userAccount) {
        String sqlQuerry_find ="select phone_number,password,first_name,middle_name,last_name from user_account where  phone_number=? and password =?";
        List<UserAccount> list = new ArrayList<>();
        String Number = userAccount.getAccount().getPhoneNumber();
        String pass = userAccount.getAccount().getPassword();
       try {
            Connection conn = new DBcontext().getConnection();
            PreparedStatement ps = conn.prepareStatement(sqlQuerry_find);
            ps.setString(1, Number);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String phoneNumber = rs.getString(1);
                String password = rs.getString(2);
                String fistName=rs.getString(3);
                String middleName=rs.getString(4);
                String lastName=rs.getString(5);
                Account c = new Account(phoneNumber, password);
                People p= new People(fistName, middleName, lastName);
                UserAccount usAccount=new  UserAccount(c, p);
                list.add(usAccount);
            }
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(AccountUserImpl.class.getName()).log(Level.SEVERE, null, ex);
            
        }
       return list;
    }

    @Override
    public Boolean checkIdIsExist(UserAccount object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}

