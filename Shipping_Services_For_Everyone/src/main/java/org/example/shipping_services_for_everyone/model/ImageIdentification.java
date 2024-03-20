package org.example.shipping_services_for_everyone.model;

import javax.servlet.http.Part;

public class ImageIdentification {
    private String imageDriverLicense;
    private String imageVehicleRegistration;
    private String imageCurriculumVitae;
    private String imageCivilGuaranteeLetter;
    private String imageCertificateOfNoCriminalRecord;
    private String imageBirthCertificate;
    private String imageHouseholdRegistration;
    private String imageHealthExaminationCertificate;
    private Part fileImageDriverLicense;
    private Part fileImageVehicleRegistration;
    private Part fileImageCurriculumVitae;
    private Part fileImageCivilGuaranteeLetter;
    private Part fileImageCertificateOfNoCriminalRecord;
    private Part fileImageBirthCertificate;
    private Part fileImageHouseholdRegistration;
    private Part fileImageHealthExaminationCertificate;

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

    public ImageIdentification(Part fileImageDriverLicense, Part fileImageVehicleRegistration, Part fileImageCurriculumVitae, Part fileImageCivilGuaranteeLetter, Part fileImageCertificateOfNoCriminalRecord, Part fileImageBirthCertificate, Part fileImageHouseholdRegistration, Part fileImageHealthExaminationCertificate) {
        this.fileImageDriverLicense = fileImageDriverLicense;
        this.fileImageVehicleRegistration = fileImageVehicleRegistration;
        this.fileImageCurriculumVitae = fileImageCurriculumVitae;
        this.fileImageCivilGuaranteeLetter = fileImageCivilGuaranteeLetter;
        this.fileImageCertificateOfNoCriminalRecord = fileImageCertificateOfNoCriminalRecord;
        this.fileImageBirthCertificate = fileImageBirthCertificate;
        this.fileImageHouseholdRegistration = fileImageHouseholdRegistration;
        this.fileImageHealthExaminationCertificate = fileImageHealthExaminationCertificate;
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

    public Part getFileImageDriverLicense() {
        return fileImageDriverLicense;
    }

    public void setFileImageDriverLicense(Part fileImageDriverLicense) {
        this.fileImageDriverLicense = fileImageDriverLicense;
    }

    public Part getFileImageVehicleRegistration() {
        return fileImageVehicleRegistration;
    }

    public void setFileImageVehicleRegistration(Part fileImageVehicleRegistration) {
        this.fileImageVehicleRegistration = fileImageVehicleRegistration;
    }

    public Part getFileImageCurriculumVitae() {
        return fileImageCurriculumVitae;
    }

    public void setFileImageCurriculumVitae(Part fileImageCurriculumVitae) {
        this.fileImageCurriculumVitae = fileImageCurriculumVitae;
    }

    public Part getFileImageCivilGuaranteeLetter() {
        return fileImageCivilGuaranteeLetter;
    }

    public void setFileImageCivilGuaranteeLetter(Part fileImageCivilGuaranteeLetter) {
        this.fileImageCivilGuaranteeLetter = fileImageCivilGuaranteeLetter;
    }

    public Part getFileImageCertificateOfNoCriminalRecord() {
        return fileImageCertificateOfNoCriminalRecord;
    }

    public void setFileImageCertificateOfNoCriminalRecord(Part fileImageCertificateOfNoCriminalRecord) {
        this.fileImageCertificateOfNoCriminalRecord = fileImageCertificateOfNoCriminalRecord;
    }

    public Part getFileImageBirthCertificate() {
        return fileImageBirthCertificate;
    }

    public void setFileImageBirthCertificate(Part fileImageBirthCertificate) {
        this.fileImageBirthCertificate = fileImageBirthCertificate;
    }

    public Part getFileImageHouseholdRegistration() {
        return fileImageHouseholdRegistration;
    }

    public void setFileImageHouseholdRegistration(Part fileImageHouseholdRegistration) {
        this.fileImageHouseholdRegistration = fileImageHouseholdRegistration;
    }

    public Part getFileImageHealthExaminationCertificate() {
        return fileImageHealthExaminationCertificate;
    }

    public void setFileImageHealthExaminationCertificate(Part fileImageHealthExaminationCertificate) {
        this.fileImageHealthExaminationCertificate = fileImageHealthExaminationCertificate;
    }
}
