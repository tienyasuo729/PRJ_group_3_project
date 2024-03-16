package org.example.shipping_services_for_everyone.model;

public class Shipper {
    private int idShipper;
    private People people;
    private ImageIdentification imageIdentification;

    public Shipper() {
    }

    public int getIdShipper() {
        return idShipper;
    }

    public void setIdShipper(int idShipper) {
        this.idShipper = idShipper;
    }

    public Shipper(People people, ImageIdentification imageIdentification) {
        this.people = people;
        this.imageIdentification = imageIdentification;
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
}

