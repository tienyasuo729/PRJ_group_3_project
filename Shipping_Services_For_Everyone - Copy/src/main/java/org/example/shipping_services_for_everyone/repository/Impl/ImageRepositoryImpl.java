package org.example.shipping_services_for_everyone.repository.Impl;

import org.example.shipping_services_for_everyone.model.Image;
import org.example.shipping_services_for_everyone.repository.IRepository;
import org.example.shipping_services_for_everyone.repository.queryStatement.ImageLocationStatement;

import javax.servlet.ServletException;
import javax.servlet.http.Part;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ImageRepositoryImpl implements IRepository<Image> {
    private ImageLocationStatement imageLocationStatement = new ImageLocationStatement();

    @Override
    public List<Image> display(Image object) {
        return null;
    }

    @Override
    public void addNew(Image image) {

    }

    @Override
    public void edit(Image object) {

    }

    @Override
    public void delete(Image object) {

    }

    @Override
    public List<Image> find(Image object) {
        return null;
    }

    @Override
    public Boolean checkIdIsExist(Image object) {
        return null;
    }

    void saveImage(Part part, String savePath, String newFileName) throws IOException, ServletException {

        String fullPath = savePath + File.separator + newFileName;
        part.write(fullPath);
    }

}
