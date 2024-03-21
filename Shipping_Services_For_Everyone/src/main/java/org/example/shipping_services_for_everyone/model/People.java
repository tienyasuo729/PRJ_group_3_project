package org.example.shipping_services_for_everyone.model;

import javax.servlet.http.Part;
import java.time.LocalDate;
import java.util.Date;
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
    private Part fileImageSelfie;
    private Part fileCccdFront;
    private Part fileCccdBack;


    public People() {
    }
    public People(Address address) {
        this.address = address;
    }
    public People(List<Address> listOldAddress) {
        this.listOldAddress = listOldAddress;
    }

    public People(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
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

    public People(String cccd, String firstName, String middleName, String lastName, LocalDate dateOfBirth, char sex, String email, Address address, Part fileImageSelfie, Part fileCccdFront, Part fileCccdBack) {
        this.cccd = cccd;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        this.email = email;
        this.address = address;
        this.fileImageSelfie = fileImageSelfie;
        this.fileCccdFront = fileCccdFront;
        this.fileCccdBack = fileCccdBack;
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

    public Part getFileImageSelfie() {
        return fileImageSelfie;
    }

    public void setFileImageSelfie(Part fileImageSelfie) {
        this.fileImageSelfie = fileImageSelfie;
    }

    public Part getFileCccdFront() {
        return fileCccdFront;
    }

    public void setFileCccdFront(Part fileCccdFront) {
        this.fileCccdFront = fileCccdFront;
    }

    public Part getFileCccdBack() {
        return fileCccdBack;
    }

    public void setFileCccdBack(Part fileCccdBack) {
        this.fileCccdBack = fileCccdBack;
    }

    public String toStringListOld_address(){
        if (listOldAddress.isEmpty()){
            return null;
        }else {
            String listAddress = null;
            for (Address oldAddress: listOldAddress) {
                listAddress += oldAddress.toString() + "|";
            }
            listAddress = listAddress.substring(0,listAddress.length() - 1) + ".";
            return listAddress;
        }

    }
}
