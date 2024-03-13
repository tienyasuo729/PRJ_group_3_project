package org.example.shipping_services_for_everyone.model;

public class ImageIdentification {
    private String image_driver_license;
    private String image_vehicle_registration;
    private String image_Curriculum_Vitae;
    private String image_Civil_Guarantee_Letter;
    private String image_Certificate_of_No_Criminal_Record;
    private String image_Birth_Certificate;
    private String image_Household_Registration;
    private String image_Health_Examination_Certificate;

    public ImageIdentification(String image_driver_license, String image_vehicle_registration, String image_Curriculum_Vitae, String image_Civil_Guarantee_Letter, String image_Certificate_of_No_Criminal_Record, String image_Birth_Certificate, String image_Household_Registration, String image_Health_Examination_Certificate) {
        this.image_driver_license = image_driver_license;
        this.image_vehicle_registration = image_vehicle_registration;
        this.image_Curriculum_Vitae = image_Curriculum_Vitae;
        this.image_Civil_Guarantee_Letter = image_Civil_Guarantee_Letter;
        this.image_Certificate_of_No_Criminal_Record = image_Certificate_of_No_Criminal_Record;
        this.image_Birth_Certificate = image_Birth_Certificate;
        this.image_Household_Registration = image_Household_Registration;
        this.image_Health_Examination_Certificate = image_Health_Examination_Certificate;
    }

    public String getImage_driver_license() {
        return image_driver_license;
    }

    public void setImage_driver_license(String image_driver_license) {
        this.image_driver_license = image_driver_license;
    }

    public String getImage_vehicle_registration() {
        return image_vehicle_registration;
    }

    public void setImage_vehicle_registration(String image_vehicle_registration) {
        this.image_vehicle_registration = image_vehicle_registration;
    }

    public String getImage_Curriculum_Vitae() {
        return image_Curriculum_Vitae;
    }

    public void setImage_Curriculum_Vitae(String image_Curriculum_Vitae) {
        this.image_Curriculum_Vitae = image_Curriculum_Vitae;
    }

    public String getImage_Civil_Guarantee_Letter() {
        return image_Civil_Guarantee_Letter;
    }

    public void setImage_Civil_Guarantee_Letter(String image_Civil_Guarantee_Letter) {
        this.image_Civil_Guarantee_Letter = image_Civil_Guarantee_Letter;
    }

    public String getImage_Certificate_of_No_Criminal_Record() {
        return image_Certificate_of_No_Criminal_Record;
    }

    public void setImage_Certificate_of_No_Criminal_Record(String image_Certificate_of_No_Criminal_Record) {
        this.image_Certificate_of_No_Criminal_Record = image_Certificate_of_No_Criminal_Record;
    }

    public String getImage_Birth_Certificate() {
        return image_Birth_Certificate;
    }

    public void setImage_Birth_Certificate(String image_Birth_Certificate) {
        this.image_Birth_Certificate = image_Birth_Certificate;
    }

    public String getImage_Household_Registration() {
        return image_Household_Registration;
    }

    public void setImage_Household_Registration(String image_Household_Registration) {
        this.image_Household_Registration = image_Household_Registration;
    }

    public String getImage_Health_Examination_Certificate() {
        return image_Health_Examination_Certificate;
    }

    public void setImage_Health_Examination_Certificate(String image_Health_Examination_Certificate) {
        this.image_Health_Examination_Certificate = image_Health_Examination_Certificate;
    }
}
