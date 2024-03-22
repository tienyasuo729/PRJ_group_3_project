package org.example.shipping_services_for_everyone.model;

import javax.servlet.http.Part;
import java.time.LocalDate;

public class Image {
    private String image1;
    private String image2;
    private String image3;
    private String image4;
    private Part fileImage1;
    private Part fileImage2;
    private Part fileImage3;
    private Part fileImage4;
    private LocalDate currentLocationDate;

    public Image() {
    }

    public Image(Part fileImage1, Part fileImage2, Part fileImage3, Part fileImage4) {
        this.fileImage1 = fileImage1;
        this.fileImage2 = fileImage2;
        this.fileImage3 = fileImage3;
        this.fileImage4 = fileImage4;
    }

    public Part getFileImage1() {
        return fileImage1;
    }

    public void setFileImage1(Part fileImage1) {
        this.fileImage1 = fileImage1;
    }

    public Part getFileImage2() {
        return fileImage2;
    }

    public void setFileImage2(Part fileImage2) {
        this.fileImage2 = fileImage2;
    }

    public Part getFileImage3() {
        return fileImage3;
    }

    public void setFileImage3(Part fileImage3) {
        this.fileImage3 = fileImage3;
    }

    public Part getFileImage4() {
        return fileImage4;
    }

    public void setFileImage4(Part fileImage4) {
        this.fileImage4 = fileImage4;
    }
    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public String getImage3() {
        return image3;
    }

    public void setImage3(String image3) {
        this.image3 = image3;
    }

    public String getImage4() {
        return image4;
    }

    public void setImage4(String image4) {
        this.image4 = image4;
    }

    public LocalDate getCurrentLocationDate() {
        return currentLocationDate;
    }

    public void setCurrentLocationDate(LocalDate currentLocationDate) {
        this.currentLocationDate = currentLocationDate;
    }
}
