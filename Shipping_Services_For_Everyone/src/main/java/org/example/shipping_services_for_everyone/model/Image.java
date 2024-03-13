package org.example.shipping_services_for_everyone.model;

import java.time.LocalDate;

public class Image {
    private LocalDate current_location_date;
    private String image1;
    private String image2;
    private String image3;
    private String image4;

    public Image() {
    }

    public Image(LocalDate current_location_date, String image1, String image2, String image3, String image4) {
        this.current_location_date = current_location_date;
        this.image1 = image1;
        this.image2 = image2;
        this.image3 = image3;
        this.image4 = image4;
    }

    public LocalDate getCurrent_location_date() {
        return current_location_date;
    }

    public void setCurrent_location_date(LocalDate current_location_date) {
        this.current_location_date = current_location_date;
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
}
