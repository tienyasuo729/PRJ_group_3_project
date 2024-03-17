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
import model.AccountShipping;

/**
 *
 * @author ASUS
 */
public class AccountShippingImpl implements IRepository<AccountShipping>{
    @Override
    public void addNew(AccountShipping shipper) {

    }

    @Override
    public List<AccountShipping> display(AccountShipping object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void edit(AccountShipping object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(AccountShipping object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<AccountShipping> find(AccountShipping shippingAccount) {
        String sqlQuerry_find ="select name_account,phone_number,password from account_shipping where phone_number=? and password=?";
        List<AccountShipping> list = new ArrayList<>();
        String Number = shippingAccount.getAccount().getPhoneNumber();
        String pass = shippingAccount.getAccount().getPassword();
       try {
            Connection conn = new DBcontext().getConnection();
            PreparedStatement ps = conn.prepareStatement(sqlQuerry_find);
            ps.setString(1, Number);
            ps.setString(2, pass);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String name =rs.getString(1);
                String phoneNumber = rs.getString(2);
                String password = rs.getString(3);
                Account c = new Account(phoneNumber, password);
                AccountShipping accShipping = new AccountShipping(name, c);
                list.add(accShipping);
                
            }
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(AccountUserImpl.class.getName()).log(Level.SEVERE, null, ex);
            
        }
       return list;
    }

    @Override
    public Boolean checkIdIsExist(AccountShipping object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
