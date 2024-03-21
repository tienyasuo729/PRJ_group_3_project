package org.example.shipping_services_for_everyone.model;

public class Sex {
    private char sign;
    private String gender;

    public Sex(char sign, String gender) {
        this.sign = sign;
        this.gender = gender;
    }

    public char getSign() {
        return sign;
    }

    public void setSign(char sign) {
        this.sign = sign;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
