/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.demo112.Impl;


import org.example.demo112.QueryStatement.IRepository;
import org.example.demo112.context.DBcontext;
import org.example.demo112.model.Account;
import org.example.demo112.model.People;
import org.example.demo112.model.UserAccount;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author ASUS
 */
public class AccountUserImpl  implements IRepository<UserAccount> {
    private final String sqlQuerry_find ="select phone_number,password,first_name,middle_name,last_name from user_account where  phone_number=? and password =?";
    @Override
    public List<UserAccount> display(UserAccount object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void addNew(UserAccount object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
                Account c = new Account(password, phoneNumber);
                People p= new People(fistName, middleName, lastName);
                UserAccount usAccount=new  UserAccount(c, p);
                list.add(usAccount);
            }
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
