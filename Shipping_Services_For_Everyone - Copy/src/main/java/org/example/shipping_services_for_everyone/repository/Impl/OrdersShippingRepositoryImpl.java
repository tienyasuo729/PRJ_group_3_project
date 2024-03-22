package org.example.shipping_services_for_everyone.repository.Impl;

import org.example.shipping_services_for_everyone.connection_config.BaseRepositoryJDBC;
import org.example.shipping_services_for_everyone.model.OrderShipping;
import org.example.shipping_services_for_everyone.repository.IRepository;
import org.example.shipping_services_for_everyone.repository.queryStatement.OrderShippingQueryStatement;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class OrdersShippingRepositoryImpl implements IRepository<OrderShipping> {
    private BaseRepositoryJDBC baseRepositoryJDBC = new BaseRepositoryJDBC();
    private OrderShippingQueryStatement orderShippingQueryStatement = new OrderShippingQueryStatement();
    @Override
    public List<OrderShipping> display(OrderShipping object) {
        return null;
    }

    @Override
    public void addNew(OrderShipping orderShipping) {
        try {
            PreparedStatement preparedStatement = this.baseRepositoryJDBC.getConnectionJavaToDB().prepareStatement(orderShippingQueryStatement.addNewOrder);
            preparedStatement.setInt(1, orderShipping.getIdSender().getAccount().getIdAccount()); // replace senderId with the actual sender ID
            preparedStatement.setInt(2, orderShipping.getIdReceiver().getAccount().getIdAccount()); // replace receiverId with the actual receiver ID
            preparedStatement.setInt(3, orderShipping.getCollectionMoney()); // replace collectionMoney with the actual collection money
            preparedStatement.setInt(4, orderShipping.getTransportationCost()); // replace transportationCost with the actual transportation cost
            preparedStatement.setString(5, String.valueOf(orderShipping.getStatusOrder())); // replace statusOrder with the actual status order
            preparedStatement.setString(6, orderShipping.getAddressSender().getApartmentNumber()); // replace apartmentNumberSender with the actual sender apartment number
            preparedStatement.setString(7, orderShipping.getAddressSender().getStreetName()); // replace streetNameSender with the actual sender street name
            preparedStatement.setString(8, orderShipping.getAddressSender().getDistrict()); // replace districtSender with the actual sender district
            preparedStatement.setString(9, orderShipping.getAddressSender().getWard()); // replace wardSender with the actual sender ward
            preparedStatement.setString(10, orderShipping.getAddressSender().getCity()); // replace citySender with the actual sender city
            preparedStatement.setString(11, orderShipping.getAddressReceiver().getApartmentNumber()); // replace apartmentNumberReceiver with the actual receiver apartment number
            preparedStatement.setString(12, orderShipping.getAddressReceiver().getStreetName()); // replace streetNameReceiver with the actual receiver street name
            preparedStatement.setString(13, orderShipping.getAddressReceiver().getDistrict()); // replace districtReceiver with the actual receiver district
            preparedStatement.setString(14, orderShipping.getAddressReceiver().getWard()); // replace wardReceiver with the actual receiver ward
            preparedStatement.setString(15, orderShipping.getAddressReceiver().getCity()); // replace cityReceiver with the actual receiver city
            preparedStatement.setString(16, orderShipping.getNoteForShipper()); // replace noteForShipper with the actual note for shipper
            preparedStatement.setDate(17, Date.valueOf(orderShipping.getEstimatedDeliveryTime())); // replace estimatedDeliveryTime with the actual estimated delivery time
            preparedStatement.setBoolean(18, orderShipping.getCheckPackage()); // replace checkPackage with the actual check package value
            preparedStatement.setInt(19, orderShipping.getIdPickup().getAccount().getIdAccount()); // replace pickupId with the actual pickup ID
            preparedStatement.setInt(20, orderShipping.getIdDelivery().getAccount().getIdAccount()); // replace deliveryId with the actual delivery ID
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void edit(OrderShipping object) {

    }

    @Override
    public void delete(OrderShipping object) {

    }

    @Override
    public List<OrderShipping> find(OrderShipping object) {
        return null;
    }

    @Override
    public Boolean checkIdIsExist(OrderShipping object) {
        return null;
    }

    public int selectIdForAddNewOrderShipping(){
        try {
            PreparedStatement preparedStatement = this.baseRepositoryJDBC.getConnectionJavaToDB().prepareStatement(orderShippingQueryStatement.selectID);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return resultSet.getInt("max_id");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
