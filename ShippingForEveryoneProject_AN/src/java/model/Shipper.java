package model;

public class Shipper {
    private People people;
    private ImageIdentification imageIdentification;

    public Shipper() {
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

