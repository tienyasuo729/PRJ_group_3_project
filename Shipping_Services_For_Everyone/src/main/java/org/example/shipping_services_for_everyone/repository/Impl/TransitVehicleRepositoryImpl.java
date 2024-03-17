package org.example.shipping_services_for_everyone.repository.Impl;

import org.example.shipping_services_for_everyone.connection_config.BaseRepositoryJDBC;
import org.example.shipping_services_for_everyone.model.TransitVehicle;
import org.example.shipping_services_for_everyone.repository.IRepository;
import org.example.shipping_services_for_everyone.repository.queryStatement.TransitVehicleQueryStatement;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class TransitVehicleRepositoryImpl implements IRepository<TransitVehicle> {
    private BaseRepositoryJDBC baseRepositoryJDBC = new BaseRepositoryJDBC();
    private TransitVehicleQueryStatement transitVehicleQueryStatement = new TransitVehicleQueryStatement();

    @Override
    public List<TransitVehicle> display(TransitVehicle object) {
        return null;
    }

    @Override
    public void addNew(TransitVehicle transitVehicle) {
        try {
            PreparedStatement preparedStatement = this.baseRepositoryJDBC.getConnectionJavaToDB().prepareStatement(transitVehicleQueryStatement.addNewTransitVehicle);
            preparedStatement.setString(1, transitVehicle.getPeople().getCccd());
            preparedStatement.setString(2, transitVehicle.getPeople().getFirstName());
            preparedStatement.setString(3, transitVehicle.getPeople().getMiddleName());
            preparedStatement.setString(4, transitVehicle.getPeople().getLastName());
            preparedStatement.setDate(5, Date.valueOf(transitVehicle.getPeople().getDateOfBirth()));
            preparedStatement.setString(6, String.valueOf(transitVehicle.getPeople().getSex()));
            preparedStatement.setString(7, transitVehicle.getPeople().getEmail());
            preparedStatement.setString(8, transitVehicle.getPeople().getImageSelfie());
            preparedStatement.setString(9, transitVehicle.getPeople().getImageCccdFront());
            preparedStatement.setString(10, transitVehicle.getPeople().getImageCccdBack());
            preparedStatement.setString(11, transitVehicle.getImageIdentification().getImageDriverLicense());
            preparedStatement.setString(12, transitVehicle.getImageIdentification().getImageVehicleRegistration());
            preparedStatement.setString(13, transitVehicle.getImageIdentification().getImageCurriculumVitae());
            preparedStatement.setString(14, transitVehicle.getImageIdentification().getImageCivilGuaranteeLetter());
            preparedStatement.setString(15, transitVehicle.getImageIdentification().getImageCertificateOfNoCriminalRecord());
            preparedStatement.setString(16, transitVehicle.getImageIdentification().getImageBirthCertificate());
            preparedStatement.setString(17, transitVehicle.getImageIdentification().getImageHouseholdRegistration());
            preparedStatement.setString(18, transitVehicle.getImageIdentification().getImageHealthExaminationCertificate());
            preparedStatement.setInt(19, new AccountShippingRepositoryImpl().selectIdForAddNewAccountShipping());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
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
