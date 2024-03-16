/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.demo112.model;


import org.example.demo112.context.DBcontext;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author ASUS
 */
public class AccountDB {
    private final String sqlQuerry_login ="select phone_number,password,first_name,middle_name,last_name from user_account where  phone_number=? and password =?";
    
    public AccountDB() {
    }
    
    public static Account getByID(int sID){
        
        return null;
    }
    public UserAccount login(String Number, String pass){      
        try {
            Connection conn = new DBcontext().getConnection();
            PreparedStatement ps = conn.prepareStatement(sqlQuerry_login);
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
                return new UserAccount(c, p);
                  
            }
        } catch (Exception ex) {
            Logger.getLogger(AccountDB.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return null;      
    }
    
    public static void main(String[] args) {
         try {
            Connection conn = new DBcontext().getConnection();
            PreparedStatement ps = conn.prepareStatement("select phone_number,password,first_name,middle_name,last_name from user_account where  phone_number=? and password =?");
            ps.setString(1, "0774443467");
            ps.setString(2, "tien220403");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String phoneNumber = rs.getString(1);
                String password = rs.getString(2);
                String fistName=rs.getString(3);
                String middleName=rs.getString(4);
                String lastName=rs.getString(5);
                Account c = new Account(password, phoneNumber);
                People p= new People(fistName, middleName, lastName);
                UserAccount ac=new UserAccount(c, p);
                System.out.println(ac);
                  
            }
        } catch (Exception ex) {
           
             System.out.println("fall");
            
        }
          
    }
}
