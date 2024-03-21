package org.example.shipping_services_for_everyone.repository.Impl;

import org.example.shipping_services_for_everyone.repository.IRepository;
import org.example.shipping_services_for_everyone.repository.queryStatement.ImageLocationStatement;
import org.example.shipping_services_for_everyone.repository.queryStatement.ShipperQueryStatement;
import org.example.shipping_services_for_everyone.connection_config.BaseRepositoryJDBC;
import org.example.shipping_services_for_everyone.model.Shipper;

import javax.servlet.ServletException;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ShipperRepositoryImpl implements IRepository<Shipper> {
    private BaseRepositoryJDBC baseRepositoryJDBC = new BaseRepositoryJDBC();
    private ShipperQueryStatement shipperQueryStatement = new ShipperQueryStatement();
    private ImageLocationStatement locationStatement = new ImageLocationStatement();
    private ImageRepositoryImpl imageRepository = new ImageRepositoryImpl();
    private final String folderImage = locationStatement.shipperImage;
    @Override
    public List<Shipper> display(Shipper object) {
        return null;
    }

    @Override
    public void addNew(Shipper shipper) {
        try {
            PreparedStatement preparedStatement = this.baseRepositoryJDBC.getConnectionJavaToDB().prepareStatement(shipperQueryStatement.addNewShipper);
            imageRepository.saveImage(shipper.getPeople().getFileImageSelfie(), folderImage, shipper.getIdAccountShipping().getPhoneNumber() + "ImageSelfie");
            imageRepository.saveImage(shipper.getPeople().getFileCccdFront(), folderImage, shipper.getIdAccountShipping().getPhoneNumber() + "ImageCccdFront");
            imageRepository.saveImage(shipper.getPeople().getFileCccdBack(), folderImage, shipper.getIdAccountShipping().getPhoneNumber() + "imageCccdBack");
            imageRepository.saveImage(shipper.getImageIdentification().getFileImageDriverLicense(), folderImage, shipper.getIdAccountShipping().getPhoneNumber() + "ImageDriverLicense");
            imageRepository.saveImage(shipper.getImageIdentification().getFileImageVehicleRegistration(), folderImage, shipper.getIdAccountShipping().getPhoneNumber() + "ImageVehicleRegistration");
            imageRepository.saveImage(shipper.getImageIdentification().getFileImageCurriculumVitae(), folderImage, shipper.getIdAccountShipping().getPhoneNumber() + "ImageCurriculumVitae");
            imageRepository.saveImage(shipper.getImageIdentification().getFileImageCivilGuaranteeLetter(), folderImage, shipper.getIdAccountShipping().getPhoneNumber() + "ImageCivilGuaranteeLetter");
            imageRepository.saveImage(shipper.getImageIdentification().getFileImageCertificateOfNoCriminalRecord(), folderImage, shipper.getIdAccountShipping().getPhoneNumber() + "ImageCertificateOfNoCriminalRecord");
            imageRepository.saveImage(shipper.getImageIdentification().getFileImageBirthCertificate(), folderImage, shipper.getIdAccountShipping().getPhoneNumber() + "ImageBirthCertificate");
            imageRepository.saveImage(shipper.getImageIdentification().getFileImageHouseholdRegistration(), folderImage, shipper.getIdAccountShipping().getPhoneNumber() + "ImageHouseholdRegistration");
            imageRepository.saveImage(shipper.getImageIdentification().getFileImageHealthExaminationCertificate(), folderImage, shipper.getIdAccountShipping().getPhoneNumber() + "ImageHouseholdRegistration");
            preparedStatement.setString(1, shipper.getPeople().getCccd());
            preparedStatement.setString(2, shipper.getPeople().getFirstName());
            preparedStatement.setString(3, shipper.getPeople().getMiddleName());
            preparedStatement.setString(4, shipper.getPeople().getLastName());
            preparedStatement.setDate(5, Date.valueOf(shipper.getPeople().getDateOfBirth()));
            preparedStatement.setString(6, String.valueOf(shipper.getPeople().getSex()));
            preparedStatement.setString(7, shipper.getPeople().getEmail());
            preparedStatement.setString(8, folderImage + File.separator + shipper.getIdAccountShipping().getPhoneNumber()+ "ImageSelfie");
            preparedStatement.setString(9, folderImage + File.separator + shipper.getIdAccountShipping().getPhoneNumber() + "ImageCccdFront");
            preparedStatement.setString(10, folderImage + File.separator + shipper.getIdAccountShipping().getPhoneNumber() + "imageCccdBack");
            preparedStatement.setString(11, folderImage + File.separator + shipper.getIdAccountShipping().getPhoneNumber() + "ImageDriverLicense");
            preparedStatement.setString(12, folderImage + File.separator + shipper.getIdAccountShipping().getPhoneNumber() + "ImageVehicleRegistration");
            preparedStatement.setString(13, folderImage + File.separator + shipper.getIdAccountShipping().getPhoneNumber() + "ImageCurriculumVitae");
            preparedStatement.setString(14, folderImage + File.separator + shipper.getIdAccountShipping().getPhoneNumber() + "ImageCivilGuaranteeLetter");
            preparedStatement.setString(15, folderImage + File.separator + shipper.getIdAccountShipping().getPhoneNumber() + "ImageCertificateOfNoCriminalRecord");
            preparedStatement.setString(16, folderImage + File.separator + shipper.getIdAccountShipping().getPhoneNumber() + "ImageBirthCertificate");
            preparedStatement.setString(17, folderImage + File.separator + shipper.getIdAccountShipping().getPhoneNumber() + "ImageHouseholdRegistration");
            preparedStatement.setString(18, folderImage + File.separator + shipper.getIdAccountShipping().getPhoneNumber() + "ImageHealthExaminationCertificate");
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
    public void edit(Shipper object) {

    }

    @Override
    public void delete(Shipper object) {

    }

    @Override
    public List<Shipper> find(Shipper object) {
        return null;
    }

    @Override
    public Boolean checkIdIsExist(Shipper object) {
        return null;
    }
}
