package model;

public class TransportImage {
    private String imageVehicleFront;
    private String imageVehicleLeft;
    private String imageVehicleRight;
    private String imageVehicleBehind;

    public TransportImage() {
    }

    public TransportImage(String imageVehicleFront, String imageVehicleLeft, String imageVehicleRight, String imageVehicleBehind) {
        this.imageVehicleFront = imageVehicleFront;
        this.imageVehicleLeft = imageVehicleLeft;
        this.imageVehicleRight = imageVehicleRight;
        this.imageVehicleBehind = imageVehicleBehind;
    }

    public String getImageVehicleFront() {
        return imageVehicleFront;
    }

    public void setImageVehicleFront(String imageVehicleFront) {
        this.imageVehicleFront = imageVehicleFront;
    }

    public String getImageVehicleLeft() {
        return imageVehicleLeft;
    }

    public void setImageVehicleLeft(String imageVehicleLeft) {
        this.imageVehicleLeft = imageVehicleLeft;
    }

    public String getImageVehicleRight() {
        return imageVehicleRight;
    }

    public void setImageVehicleRight(String imageVehicleRight) {
        this.imageVehicleRight = imageVehicleRight;
    }

    public String getImageVehicleBehind() {
        return imageVehicleBehind;
    }

    public void setImageVehicleBehind(String imageVehicleBehind) {
        this.imageVehicleBehind = imageVehicleBehind;
    }
}
