package org.example.shipping_services_for_everyone.repository.Impl;

import org.example.shipping_services_for_everyone.connection_config.BaseRepositoryJDBC;
import org.example.shipping_services_for_everyone.model.Sex;
import org.example.shipping_services_for_everyone.model.TypeVehicle;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HtmlSupport {
    private static BaseRepositoryJDBC baseRepositoryJDBC = new BaseRepositoryJDBC();

    public static List<Sex> listSex(){
        List<Sex> list = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = baseRepositoryJDBC.getConnectionJavaToDB().prepareStatement("SELECT sign, gender FROM sex;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                char sign = resultSet.getString("sign").charAt(0);
                String gender = resultSet.getString("gender");
                list.add(new Sex(sign,gender));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public static List<TypeVehicle> listType(){
        List<TypeVehicle> list = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = baseRepositoryJDBC.getConnectionJavaToDB().prepareStatement("SELECT id_type, name_type FROM type_vehicle;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id_type = resultSet.getInt("id_type");
                String name_type = resultSet.getString("name_type");
                list.add(new TypeVehicle(id_type,name_type));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
