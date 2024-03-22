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
    private final String folderImage = locationStatement.packageImage;

    @Override
    public List<Package> display(Package object) {
        return null;
    }

    @Override
    public void addNew(Package pac) {

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
