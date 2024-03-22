package org.example.shipping_services_for_everyone.repository.Impl;

import org.example.shipping_services_for_everyone.connection_config.BaseRepositoryJDBC;
import org.example.shipping_services_for_everyone.model.TransitVehicle;
import org.example.shipping_services_for_everyone.repository.IRepository;
import org.example.shipping_services_for_everyone.repository.queryStatement.ImageLocationStatement;
import org.example.shipping_services_for_everyone.repository.queryStatement.TransitVehicleQueryStatement;

import javax.servlet.ServletException;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class TransitVehicleRepositoryImpl implements IRepository<TransitVehicle> {
    private BaseRepositoryJDBC baseRepositoryJDBC = new BaseRepositoryJDBC();
    private TransitVehicleQueryStatement transitVehicleQueryStatement = new TransitVehicleQueryStatement();
    private ImageLocationStatement locationStatement = new ImageLocationStatement();
    private ImageRepositoryImpl imageRepository = new ImageRepositoryImpl();
    private final String folderImage = locationStatement.transitVehicleImage;

    @Override
    public List<TransitVehicle> display(TransitVehicle object) {
        return null;
    }

    @Override
    public void addNew(TransitVehicle transitVehicle) {
        try {

            PreparedStatement preparedStatement = this.baseRepositoryJDBC.getConnectionJavaToDB().prepareStatement(transitVehicleQueryStatement.addNewTransitVehicle);
            imageRepository.saveImage(transitVehicle.getPeople().getFileImageSelfie(), folderImage, transitVehicle.getIdAccountShipping().getPhoneNumber() + "FileImageSelfie");
            imageRepository.saveImage(transitVehicle.getPeople().getFileCccdFront(), folderImage, transitVehicle.getIdAccountShipping().getPhoneNumber() + "FileCccdFront");
            imageRepository.saveImage(transitVehicle.getPeople().getFileCccdBack(), folderImage, transitVehicle.getIdAccountShipping().getPhoneNumber() + "FileCccdBack");
            imageRepository.saveImage(transitVehicle.getImageIdentification().getFileImageDriverLicense(), folderImage, transitVehicle.getIdAccountShipping().getPhoneNumber() + "ImageDriverLicense");
            imageRepository.saveImage(transitVehicle.getImageIdentification().getFileImageVehicleRegistration(), folderImage, transitVehicle.getIdAccountShipping().getPhoneNumber() + "ImageVehicleRegistration");
            imageRepository.saveImage(transitVehicle.getImageIdentification().getFileImageCurriculumVitae(), folderImage, transitVehicle.getIdAccountShipping().getPhoneNumber() + "ImageCurriculumVitae");
            imageRepository.saveImage(transitVehicle.getImageIdentification().getFileImageCivilGuaranteeLetter(), folderImage, transitVehicle.getIdAccountShipping().getPhoneNumber() + "ImageCivilGuaranteeLetter");
            imageRepository.saveImage(transitVehicle.getImageIdentification().getFileImageCertificateOfNoCriminalRecord(), folderImage, transitVehicle.getIdAccountShipping().getPhoneNumber() + "ImageCertificateOfNoCriminalRecord");
            imageRepository.saveImage(transitVehicle.getImageIdentification().getFileImageBirthCertificate(), folderImage, transitVehicle.getIdAccountShipping().getPhoneNumber() + "ImageBirthCertificate");
            imageRepository.saveImage(transitVehicle.getImageIdentification().getFileImageHouseholdRegistration(), folderImage, transitVehicle.getIdAccountShipping().getPhoneNumber() + "ImageHouseholdRegistration");
            imageRepository.saveImage(transitVehicle.getImageIdentification().getFileImageHealthExaminationCertificate(), folderImage, transitVehicle.getIdAccountShipping().getPhoneNumber() + "ImageHouseholdRegistration");
            preparedStatement.setString(1, transitVehicle.getPeople().getCccd());
            preparedStatement.setString(2, transitVehicle.getPeople().getFirstName());
            preparedStatement.setString(3, transitVehicle.getPeople().getMiddleName());
            preparedStatement.setString(4, transitVehicle.getPeople().getLastName());
            preparedStatement.setDate(5, Date.valueOf(transitVehicle.getPeople().getDateOfBirth()));
            preparedStatement.setString(6, String.valueOf(transitVehicle.getPeople().getSex()));
            preparedStatement.setString(7, transitVehicle.getPeople().getEmail());
            preparedStatement.setString(8, folderImage + File.separator + transitVehicle.getIdAccountShipping().getPhoneNumber() + "ImageSelfie");
            preparedStatement.setString(9, folderImage + File.separator + transitVehicle.getIdAccountShipping().getPhoneNumber() + "ImageCccdFront");
            preparedStatement.setString(10, folderImage + File.separator + transitVehicle.getIdAccountShipping().getPhoneNumber() + "ImageCccdBack");
            preparedStatement.setString(11, folderImage + File.separator + transitVehicle.getIdAccountShipping().getPhoneNumber() + "ImageDriverLicense");
            preparedStatement.setString(12, folderImage + File.separator + transitVehicle.getIdAccountShipping().getPhoneNumber() + "ImageVehicleRegistration");
            preparedStatement.setString(13, folderImage + File.separator + transitVehicle.getIdAccountShipping().getPhoneNumber() + "ImageCurriculumVitae");
            preparedStatement.setString(14, folderImage + File.separator + transitVehicle.getIdAccountShipping().getPhoneNumber() + "ImageCivilGuaranteeLetter");
            preparedStatement.setString(15, folderImage + File.separator + transitVehicle.getIdAccountShipping().getPhoneNumber() + "ImageCertificateOfNoCriminalRecord");
            preparedStatement.setString(16, folderImage + File.separator + transitVehicle.getIdAccountShipping().getPhoneNumber() + "ImageBirthCertificate");
            preparedStatement.setString(17, folderImage + File.separator + transitVehicle.getIdAccountShipping().getPhoneNumber() + "ImageHouseholdRegistration");
            preparedStatement.setString(18, folderImage + File.separator + transitVehicle.getIdAccountShipping().getPhoneNumber() + "ImageHealthExaminationCertificate");
            preparedStatement.setInt(19, new AccountShippingRepositoryImpl().selectIdForAddNewAccountShipping());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void edit(TransitVehicle object) {

    }

    @Override
    public void delete(TransitVehicle object) {

    }

    @Override
    public List<TransitVehicle> find(TransitVehicle object) {
        return null;
    }

    @Override
    public Boolean checkIdIsExist(TransitVehicle object) {
        return null;
    }
}
