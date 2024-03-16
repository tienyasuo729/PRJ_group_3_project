package org.example.demo112.model;

import java.time.LocalDate;
import java.util.List;

public class People {
    private String cccd;
    private String firstName;
    private String middleName;
    private String lastName;
    private LocalDate dateOfBirth;
    private char sex;
    private String email;
    private Address address;
    private List<Address> listOldAddress;
    private String imageSelfie;
    private String imageCccdFront ;
    private String imageCccdBack;

    public People() {
    }

    public People(String cccd, String firstName, String middleName, String lastName, LocalDate dateOfBirth, char sex, String email, Address address, String imageSelfie, String imageCccdFront, String imageCccdBack) {
        this.cccd = cccd;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        this.email = email;
        this.address = address;
        this.imageSelfie = imageSelfie;
        this.imageCccdFront = imageCccdFront;
        this.imageCccdBack = imageCccdBack;
    }

    public People(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    
    
    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Address> getListOldAddress() {
        return listOldAddress;
    }

    public void setListOldAddress(List<Address> listOldAddress) {
        this.listOldAddress = listOldAddress;
    }

    public String getImageSelfie() {
        return imageSelfie;
    }

    public void setImageSelfie(String imageSelfie) {
        this.imageSelfie = imageSelfie;
    }

    public String getImageCccdFront() {
        return imageCccdFront;
    }

    public void setImageCccdFront(String imageCccdFront) {
        this.imageCccdFront = imageCccdFront;
    }

    public String getImageCccdBack() {
        return imageCccdBack;
    }

    public void setImageCccdBack(String imageCccdBack) {
        this.imageCccdBack = imageCccdBack;
    }
}
