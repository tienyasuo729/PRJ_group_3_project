package org.example.demo112.model;

public class ImageIdentification {
    private String imageDriverLicense;
    private String imageVehicleRegistration;
    private String imageCurriculumVitae;
    private String imageCivilGuaranteeLetter;
    private String imageCertificateOfNoCriminalRecord;
    private String imageBirthCertificate;
    private String imageHouseholdRegistration;
    private String imageHealthExaminationCertificate;

    public ImageIdentification() {
    }

    public ImageIdentification(String imageDriverLicense, String imageVehicleRegistration, String imageCurriculumVitae, String imageCivilGuaranteeLetter, String imageCertificateOfNoCriminalRecord, String imageBirthCertificate, String imageHouseholdRegistration, String imageHealthExaminationCertificate) {
        this.imageDriverLicense = imageDriverLicense;
        this.imageVehicleRegistration = imageVehicleRegistration;
        this.imageCurriculumVitae = imageCurriculumVitae;
        this.imageCivilGuaranteeLetter = imageCivilGuaranteeLetter;
        this.imageCertificateOfNoCriminalRecord = imageCertificateOfNoCriminalRecord;
        this.imageBirthCertificate = imageBirthCertificate;
        this.imageHouseholdRegistration = imageHouseholdRegistration;
        this.imageHealthExaminationCertificate = imageHealthExaminationCertificate;
    }

    public String getImageDriverLicense() {
        return imageDriverLicense;
    }

    public void setImageDriverLicense(String imageDriverLicense) {
        this.imageDriverLicense = imageDriverLicense;
    }

    public String getImageVehicleRegistration() {
        return imageVehicleRegistration;
    }

    public void setImageVehicleRegistration(String imageVehicleRegistration) {
        this.imageVehicleRegistration = imageVehicleRegistration;
    }

    public String getImageCurriculumVitae() {
        return imageCurriculumVitae;
    }

    public void setImageCurriculumVitae(String imageCurriculumVitae) {
        this.imageCurriculumVitae = imageCurriculumVitae;
    }

    public String getImageCivilGuaranteeLetter() {
        return imageCivilGuaranteeLetter;
    }

    public void setImageCivilGuaranteeLetter(String imageCivilGuaranteeLetter) {
        this.imageCivilGuaranteeLetter = imageCivilGuaranteeLetter;
    }

    public String getImageCertificateOfNoCriminalRecord() {
        return imageCertificateOfNoCriminalRecord;
    }

    public void setImageCertificateOfNoCriminalRecord(String imageCertificateOfNoCriminalRecord) {
        this.imageCertificateOfNoCriminalRecord = imageCertificateOfNoCriminalRecord;
    }

    public String getImageBirthCertificate() {
        return imageBirthCertificate;
    }

    public void setImageBirthCertificate(String imageBirthCertificate) {
        this.imageBirthCertificate = imageBirthCertificate;
    }

    public String getImageHouseholdRegistration() {
        return imageHouseholdRegistration;
    }

    public void setImageHouseholdRegistration(String imageHouseholdRegistration) {
        this.imageHouseholdRegistration = imageHouseholdRegistration;
    }

    public String getImageHealthExaminationCertificate() {
        return imageHealthExaminationCertificate;
    }

    public void setImageHealthExaminationCertificate(String imageHealthExaminationCertificate) {
        this.imageHealthExaminationCertificate = imageHealthExaminationCertificate;
    }
}
