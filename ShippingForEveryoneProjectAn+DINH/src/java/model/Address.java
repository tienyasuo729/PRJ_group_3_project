package model;

public class Address {
    private String nameAddress;
    private String apartmentNumber;
    private String streetName;
    private String district;
    private String ward;
    private String city;

    public Address() {
    }

    public Address(String apartmentNumber, String streetName, String district, String ward, String city) {
        this.apartmentNumber = apartmentNumber;
        this.streetName = streetName;
        this.district = district;
        this.ward = ward;
        this.city = city;
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
        return  "nameAddress=" + nameAddress + ", apartmentNumber:" + apartmentNumber + ", streetName:" + streetName + ", district:" + district + ", ward:" + ward + ", city:" + city ;
    }
    
}
