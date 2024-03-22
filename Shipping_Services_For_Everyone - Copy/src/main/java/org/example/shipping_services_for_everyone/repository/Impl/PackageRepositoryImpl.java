package org.example.shipping_services_for_everyone.repository.Impl;

import org.example.shipping_services_for_everyone.connection_config.BaseRepositoryJDBC;
import org.example.shipping_services_for_everyone.model.Package;
import org.example.shipping_services_for_everyone.repository.IRepository;
import org.example.shipping_services_for_everyone.repository.queryStatement.ImageLocationStatement;
import org.example.shipping_services_for_everyone.repository.queryStatement.PackageQueryStatement;

import javax.servlet.ServletException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

public class PackageRepositoryImpl implements IRepository<Package> {
    private ImageLocationStatement locationStatement = new ImageLocationStatement();
    private ImageRepositoryImpl imageRepository = new ImageRepositoryImpl();

    private BaseRepositoryJDBC baseRepositoryJDBC = new BaseRepositoryJDBC();
    private PackageQueryStatement packageQueryStatement = new PackageQueryStatement();
    private OrdersShippingRepositoryImpl ordersShippingRepository = new OrdersShippingRepositoryImpl();
    private final String folderImage = locationStatement.packageImage;

    @Override
    public List<Package> display(Package object) {
        return null;
    }

    @Override
    public void addNew(Package pac) {
        try {
            LocalDateTime currentTime = LocalDateTime.now();
            String image1 = currentTime + "image1";
            String image2 = currentTime + "image2";
            String image3 = currentTime + "image3";
            String image4 = currentTime + "image4";
            PreparedStatement preparedStatement = this.baseRepositoryJDBC.getConnectionJavaToDB().prepareStatement(packageQueryStatement.addNewPackage);
            preparedStatement.setString(1, pac.getNameItem()); // replace itemName with the actual item name
            preparedStatement.setInt(2, pac.getSizeItem().getLength()); // replace length with the actual length
            preparedStatement.setInt(3, pac.getSizeItem().getWidth()); // replace width with the actual width
            preparedStatement.setInt(4, pac.getSizeItem().getHeight()); // replace height with the actual height
            preparedStatement.setInt(5, pac.getSizeItem().getWeight()); // replace weight with the actual weight
            preparedStatement.setString(6, image1); // replace image1 with the actual image URL 1
            preparedStatement.setString(7, image2); // replace image2 with the actual image URL 2
            preparedStatement.setString(8, image3); // replace image3 with the actual image URL 3
            preparedStatement.setString(9, image4); // replace image4 with the actual image URL 4
            preparedStatement.setInt(10, ordersShippingRepository.selectIdForAddNewOrderShipping()); // replace orderId with the actual order ID
            preparedStatement.executeUpdate();
            imageRepository.saveImage(pac.getImageItem().getFileImage1(), folderImage, image1);
            imageRepository.saveImage(pac.getImageItem().getFileImage2(), folderImage, image2);
            imageRepository.saveImage(pac.getImageItem().getFileImage3(), folderImage, image3);
            imageRepository.saveImage(pac.getImageItem().getFileImage4(), folderImage, image4);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void edit(Package object) {

    }

    @Override
    public void delete(Package object) {

    }

    @Override
    public List<Package> find(Package object) {
        return null;
    }

    @Override
    public Boolean checkIdIsExist(Package object) {
        return null;
    }
}
