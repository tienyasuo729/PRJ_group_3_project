package org.example.shipping_services_for_everyone.model;

public class Shipper {
    private int idShipper;
    private People people;
    private ImageIdentification imageIdentification;
    private Account idAccountShipping;

    public Shipper() {

    }

    public Shipper(People people, ImageIdentification imageIdentification, Account idAccountShipping) {
        this.people = people;
        this.imageIdentification = imageIdentification;
        this.idAccountShipping = idAccountShipping;
    }

    public Shipper(People people, ImageIdentification imageIdentification) {
        this.people = people;
        this.imageIdentification = imageIdentification;
    }

    public int getIdShipper() {
        return idShipper;
    }

    public void setIdShipper(int idShipper) {
        this.idShipper = idShipper;
    }

    public People getPeople() {
        return people;
    }

    public void setPeople(People people) {
        this.people = people;
    }

    public ImageIdentification getImageIdentification() {
        return imageIdentification;
    }

    public void setImageIdentification(ImageIdentification imageIdentification) {
        this.imageIdentification = imageIdentification;
    }

    public Account getIdAccountShipping() {
        return idAccountShipping;
    }

    public void setIdAccountShipping(Account idAccountShipping) {
        this.idAccountShipping = idAccountShipping;
    }
}

