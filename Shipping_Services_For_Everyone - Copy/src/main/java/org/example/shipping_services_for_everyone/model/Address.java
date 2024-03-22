package org.example.shipping_services_for_everyone.model;

public class Address {
    private String nameAddress;
    private String apartmentNumber;
    private String streetName;
    private String district;
    private String ward;
    private String city;
    private String phoneNumberForThisAddress;

    public Address() {
    }

    public Address(String nameAddress, String apartmentNumber, String streetName, String district, String ward, String city, String phoneNumberForThisAddress) {
        this.nameAddress = nameAddress;
        this.apartmentNumber = apartmentNumber;
        this.streetName = streetName;
        this.district = district;
        this.ward = ward;
        this.city = city;
        this.phoneNumberForThisAddress = phoneNumberForThisAddress;
    }

    public Address(String apartmentNumber, String streetName, String district, String ward, String city) {
        this.apartmentNumber = apartmentNumber;
        this.streetName = streetName;
        this.district = district;
        this.ward = ward;
        this.city = city;
    }

    public String getPhoneNumberForThisAddress() {
        return phoneNumberForThisAddress;
    }

    public void setPhoneNumberForThisAddress(String phoneNumberForThisAddress) {
        this.phoneNumberForThisAddress = phoneNumberForThisAddress;
    }

    public String getNameAddress() {
        return nameAddress;
    }

    public void setNameAddress(String nameAddress) {
        this.nameAddress = nameAddress;
    }

    public String getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(String apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        if (nameAddress == null && apartmentNumber == null && streetName == null && district == null && ward == null && city == null && phoneNumberForThisAddress == null){
            return null;
        }else {
            return nameAddress + "|" + apartmentNumber + "|" + streetName + "|" + district + "|" + ward + "|" + city + "|" + phoneNumberForThisAddress;
        }
    }
}
