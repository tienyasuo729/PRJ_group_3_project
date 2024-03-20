package org.example.shipping_services_for_everyone.repository.Impl;

import org.example.shipping_services_for_everyone.repository.IRepository;
import org.example.shipping_services_for_everyone.repository.queryStatement.ShipperQueryStatement;
import org.example.shipping_services_for_everyone.connection_config.BaseRepositoryJDBC;
import org.example.shipping_services_for_everyone.model.Shipper;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ShipperRepositoryImpl implements IRepository<Shipper> {
    private BaseRepositoryJDBC baseRepositoryJDBC = new BaseRepositoryJDBC();
    private ShipperQueryStatement shipperQueryStatement = new ShipperQueryStatement();
    @Override
    public List<Shipper> display(Shipper object) {
        return null;
    }

    @Override
    public void addNew(Shipper shipper) {
        try {
            PreparedStatement preparedStatement = this.baseRepositoryJDBC.getConnectionJavaToDB().prepareStatement(shipperQueryStatement.addNewShipper);
            preparedStatement.setString(1, shipper.getPeople().getCccd());
            preparedStatement.setString(2, shipper.getPeople().getFirstName());
            preparedStatement.setString(3, shipper.getPeople().getMiddleName());
            preparedStatement.setString(4, shipper.getPeople().getLastName());
            preparedStatement.setDate(5, Date.valueOf(shipper.getPeople().getDateOfBirth()));
            preparedStatement.setString(6, String.valueOf(shipper.getPeople().getSex()));
            preparedStatement.setString(7, shipper.getPeople().getEmail());
            preparedStatement.setString(8, shipper.getPeople().getImageSelfie());
            preparedStatement.setString(9, shipper.getPeople().getImageCccdFront());
            preparedStatement.setString(10, shipper.getPeople().getImageCccdBack());
            preparedStatement.setString(11, shipper.getImageIdentification().getImageDriverLicense());
            preparedStatement.setString(12, shipper.getImageIdentification().getImageVehicleRegistration());
            preparedStatement.setString(13, shipper.getImageIdentification().getImageCurriculumVitae());
            preparedStatement.setString(14, shipper.getImageIdentification().getImageCivilGuaranteeLetter());
            preparedStatement.setString(15, shipper.getImageIdentification().getImageCertificateOfNoCriminalRecord());
            preparedStatement.setString(16, shipper.getImageIdentification().getImageBirthCertificate());
            preparedStatement.setString(17, shipper.getImageIdentification().getImageHouseholdRegistration());
            preparedStatement.setString(18, shipper.getImageIdentification().getImageHealthExaminationCertificate());
            preparedStatement.setInt(19, new AccountShippingRepositoryImpl().selectIdForAddNewAccountShipping());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
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
