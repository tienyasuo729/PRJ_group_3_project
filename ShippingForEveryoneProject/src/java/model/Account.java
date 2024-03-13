/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author ASUS
 */
public class Account {
    
    private int idAccount;
    private String password;
    private int permission;
    private LocalDate joining_date;
    private String phoneNumber;
    
    public Account() {
    }

    public Account(String password, String phoneNumber) {
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    public Account(int idAccount, String password, int permission, LocalDate joining_date, String phoneNumber) {
        this.idAccount = idAccount;
        this.password = password;
        this.permission = permission;
        this.joining_date = joining_date;
        this.phoneNumber = phoneNumber;
    }
    
    
    
    public Account( String password, int permission, LocalDate joining_date) {
        
        this.password = password;
        this.permission = permission;
        this.joining_date = joining_date;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    

    public int getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(int idAccount) {
        this.idAccount = idAccount;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPermission() {
        return permission;
    }

    public void setPermission(int permission) {
        this.permission = permission;
    }

    public LocalDate getJoining_date() {
        return joining_date;
    }

    public void setJoining_date(LocalDate joining_date) {
        this.joining_date = joining_date;
    }
    
    
}
