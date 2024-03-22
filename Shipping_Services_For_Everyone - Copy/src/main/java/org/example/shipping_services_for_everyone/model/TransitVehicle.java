package org.example.shipping_services_for_everyone.model;

public class TransitVehicle {
    private int idTransitVehicle;
    private People people;
    private ImageIdentification imageIdentification;
    private Account idAccountShipping;

    public TransitVehicle() {
    }

    public TransitVehicle(People people, ImageIdentification imageIdentification, Account idAccountShipping) {
        this.people = people;
        this.imageIdentification = imageIdentification;
        this.idAccountShipping = idAccountShipping;
    }

    public TransitVehicle(People people, ImageIdentification imageIdentification) {
        this.people = people;
        this.imageIdentification = imageIdentification;
    }

    public int getIdTransitVehicle() {
        return idTransitVehicle;
    }

    public void setIdTransitVehicle(int idTransitVehicle) {
        this.idTransitVehicle = idTransitVehicle;
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
