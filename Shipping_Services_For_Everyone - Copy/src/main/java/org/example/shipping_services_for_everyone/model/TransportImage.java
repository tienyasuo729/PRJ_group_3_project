package org.example.shipping_services_for_everyone.model;

import javax.servlet.http.Part;

public class TransportImage {
    private String imageVehicleFront;
    private String imageVehicleLeft;
    private String imageVehicleRight;
    private String imageVehicleBehind;
    private Part fileImageVehicleFront;
    private Part fileImageVehicleLeft;
    private Part fileImageVehicleRight;
    private Part fileImageVehicleBehind;

    public TransportImage() {
    }

    public TransportImage(Part fileImageVehicleFront, Part fileImageVehicleLeft, Part fileImageVehicleRight, Part fileImageVehicleBehind) {
        this.fileImageVehicleFront = fileImageVehicleFront;
        this.fileImageVehicleLeft = fileImageVehicleLeft;
        this.fileImageVehicleRight = fileImageVehicleRight;
        this.fileImageVehicleBehind = fileImageVehicleBehind;
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

    public Part getFileImageVehicleFront() {
        return fileImageVehicleFront;
    }

    public void setFileImageVehicleFront(Part fileImageVehicleFront) {
        this.fileImageVehicleFront = fileImageVehicleFront;
    }

    public Part getFileImageVehicleLeft() {
        return fileImageVehicleLeft;
    }

    public void setFileImageVehicleLeft(Part fileImageVehicleLeft) {
        this.fileImageVehicleLeft = fileImageVehicleLeft;
    }

    public Part getFileImageVehicleRight() {
        return fileImageVehicleRight;
    }

    public void setFileImageVehicleRight(Part fileImageVehicleRight) {
        this.fileImageVehicleRight = fileImageVehicleRight;
    }

    public Part getFileImageVehicleBehind() {
        return fileImageVehicleBehind;
    }

    public void setFileImageVehicleBehind(Part fileImageVehicleBehind) {
        this.fileImageVehicleBehind = fileImageVehicleBehind;
    }
}
