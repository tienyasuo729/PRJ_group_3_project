package org.example.demo112.model;

public class TransitVehicle {
    private People people;
    private ImageIdentification imageIdentification;

    public TransitVehicle() {
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
