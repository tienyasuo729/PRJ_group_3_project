/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;

/**
 *
 * @author ASUS
 */
public class People {
    private String cccd;
    private String firstName;
    private String middleName;
    private String lastName;

    private LocalDate dateOfBirth;
    private char sex;
    private String email;
    private String address;
    private String listOldAddress;
    private String imageSelfie;
    private String imageCccdFront ;
    private String imageCccdBack;

    public People(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    public People(String cccd, String firstName, String middleName, String lastName, LocalDate dateOfBirth, char sex, String email, String address, String listOldAddress, String imageSelfie, String imageCccdFront, String imageCccdBack) {
        this.cccd = cccd;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        this.email = email;
        this.address = address;
        this.listOldAddress = listOldAddress;
        this.imageSelfie = imageSelfie;
        this.imageCccdFront = imageCccdFront;
        this.imageCccdBack = imageCccdBack;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    
}
