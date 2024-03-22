package org.example.shipping_services_for_everyone.repository.Impl;


import org.example.shipping_services_for_everyone.connection_config.BaseRepositoryJDBC;
import org.example.shipping_services_for_everyone.model.Address;
import org.example.shipping_services_for_everyone.model.OrderShipping;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class OrderShippingDAO {
    private BaseRepositoryJDBC baseRepositoryJDBC = new BaseRepositoryJDBC();

    public List<OrderShipping> viewAll(int id){
        String idShiper = Integer.toString(id);
        String sqlQuerry_searsh ="select id_order,receiver_name,receiver_phonenumber,collection_money,status_order,transportation_cost,apartment_number,street_name,District,Ward,city,note_for_shipper  from Order_Shipping where id_delivery=?";
        List<OrderShipping> list = new ArrayList<>();
        try {
            PreparedStatement ps = this.baseRepositoryJDBC.getConnectionJavaToDB().prepareStatement(sqlQuerry_searsh);
            ps.setString(1, idShiper);           
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id_order = rs.getInt(1);
                String receiver_name=rs.getString(2);
                String receiver_phonenumber=rs.getString(3);
                int collection_money=rs.getInt(4);
                char status_order=rs.getString(5).charAt(0);
                int transportation_cost=rs.getInt(6);
                String apartment_number=rs.getString(7);
                String street_name=rs.getString(8);
                String District=rs.getString(9);     
                String Ward =rs.getString(10);
                String city=rs.getString(11);
                String note_for_shipper=rs.getString(12);
                Address address = new Address(apartment_number, street_name, District, Ward, city);
                OrderShipping ordershipping = new OrderShipping(id_order, collection_money, transportation_cost, status_order, address, note_for_shipper, receiver_name, receiver_phonenumber, id_order);
                list.add(ordershipping);
            }
        } catch (Exception ex) {
            Logger.getLogger(UserAccountRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return list;
    }
    public OrderShipping get(int id)  {
        String sql = "SELECT [collection_money], [transportation_cost], [status_order], [apartment_number], [street_name], [District], [Ward], [city], [note_for_shipper], [check_package], [order_date], [receiver_name], [receiver_phonenumber] FROM Order_Shipping WHERE id_order = ?";
        try {
            PreparedStatement ps = this.baseRepositoryJDBC.getConnectionJavaToDB().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int CollectionMoney = rs.getInt(1);
                int TransportationCost = rs.getInt(2);
                char StarusOrder = rs.getString(3).charAt(0);
                String ApartmentNumber = rs.getString(4);
                String StreetName = rs.getString(5);
                String District = rs.getString(6);
                String Ward = rs.getString(7);
                String City = rs.getString(8);               
                Address address = new Address(ApartmentNumber, StreetName, District, Ward, City);
                String NoteForShipper = rs.getString(9);
                Boolean CheckPackage = rs.getBoolean(10);
                LocalDate OrederDate = rs.getDate(11).toLocalDate();
                String ReceiverName = rs.getString(12);
                String ReceiverPhoneNum = rs.getString(13);
                OrderShipping orderShipping = new OrderShipping(CollectionMoney, TransportationCost, OrederDate, CheckPackage, StarusOrder, address, NoteForShipper, ReceiverName, ReceiverPhoneNum);
                return orderShipping;

            }
        } catch (Exception ex) {
            Logger.getLogger(OrderShipping.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void addorder(OrderShipping ordershipping)  {
        try {
            String sql = "INSERT INTO order_shipping (id_sender, receiver_name, receiver_phonenumber, collection_money, status_order, city, district, ward, street_name, apartment_number, note_for_shipper, check_package, id_delivery) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = this.baseRepositoryJDBC.getConnectionJavaToDB().prepareStatement(sql);
            ps.setInt(1, ordershipping.getIdSender());
            ps.setString(2, ordershipping.getReceiverName());
            ps.setString(3, ordershipping.getReceiverPhoneNum());
            ps.setInt(4, ordershipping.getCollectionMoney());
            ps.setString(5,"" + ordershipping.getStatusOrder().charAt(0));
            ps.setString(6, ordershipping.getAddress().getCity());
            ps.setString(7, ordershipping.getAddress().getDistrict());
            ps.setString(8, ordershipping.getAddress().getWard());
            ps.setString(9, ordershipping.getAddress().getStreetName());
            ps.setString(10, ordershipping.getAddress().getApartmentNumber());
            ps.setString(11, ordershipping.getNoteForShipper());
            ps.setBoolean(12, ordershipping.getCheckPackage());
            ps.setInt(13, ordershipping.getIdDelivery());
            ps.execute();
            ps.close();
        } catch (Exception ex) {
            Logger.getLogger(OrderShipping.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public ArrayList<OrderShipping> ordersStatus(int id){
            String idShiper = Integer.toString(id);
            ArrayList<OrderShipping> list = new ArrayList<>();
            String SQLquery ="select id_order,receiver_name,receiver_phonenumber,collection_money,status_order,transportation_cost,apartment_number,street_name,District,Ward,city,note_for_shipper  from Order_Shipping where id_delivery=? and status_order=0";
            try {
                PreparedStatement ps = this.baseRepositoryJDBC.getConnectionJavaToDB().prepareStatement(SQLquery);
                ps.setString(1, idShiper);           
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                int id_order = rs.getInt(1);
                String receiver_name=rs.getString(2);
                String receiver_phonenumber=rs.getString(3);
                int collection_money=rs.getInt(4);
                char status_order=rs.getString(5).charAt(0);
                int transportation_cost=rs.getInt(6);
                String apartment_number=rs.getString(7);
                String street_name=rs.getString(8);
                String District=rs.getString(9);     
                String Ward =rs.getString(10);
                String city=rs.getString(11);
                String note_for_shipper=rs.getString(12);
                Address address = new Address(apartment_number, street_name, District, Ward, city);
                OrderShipping ordershipping = new OrderShipping(id_order, collection_money, transportation_cost, status_order, address, note_for_shipper, receiver_name, receiver_phonenumber, id_order);
                list.add(ordershipping);
                
                }
            } catch (Exception ex) {
                Logger.getLogger(OrderShipping.class.getName()).log(Level.SEVERE, null, ex);
            }
       return null; 
    }
    public boolean updateOrderStatusProgress (int id){
        String SQLquery="UPDATE Order_Shipping Set status_order='D' where id_order =?";
        try {
            String id_order = Integer.toString(id);
            PreparedStatement ps = this.baseRepositoryJDBC.getConnectionJavaToDB().prepareStatement(SQLquery);
            ps.setString(1, id_order);
            int rowsAffected=ps.executeUpdate();
            if(rowsAffected!=0) {
                return true;
            }
        } catch (Exception ex) {
            Logger.getLogger(OrderShipping.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public boolean updateOrderStatusSuccess (int id){
        String SQLquery="UPDATE Order_Shipping Set status_order='T' where id_order =?";
        try {
            String id_order = Integer.toString(id);
            PreparedStatement ps = this.baseRepositoryJDBC.getConnectionJavaToDB().prepareStatement(SQLquery);
            ps.setString(1, id_order);
            int rowsAffected=ps.executeUpdate();
            if(rowsAffected!=0) {
                return true;
            }
        } catch (Exception ex) {
            Logger.getLogger(OrderShipping.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public ArrayList<OrderShipping> getmyOrder(int id)  {
        ArrayList<OrderShipping> list = new ArrayList<>();
        String sql = "SELECT [id_order], [collection_money], [status_order], [apartment_number], [street_name], [District], [Ward], [city], [note_for_shipper], [order_date], [receiver_name], [receiver_phonenumber] FROM Order_Shipping WHERE id_sender = ?";
        try {
            PreparedStatement ps = this.baseRepositoryJDBC.getConnectionJavaToDB().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int OrderID = rs.getInt(1);
                int CollectionMoney = rs.getInt(2);
                char StarusOrder = rs.getString(3).charAt(0);
                String ApartmentNumber = rs.getString(4);
                String StreetName = rs.getString(5);
                String District = rs.getString(6);
                String Ward = rs.getString(7);
                String City = rs.getString(8);
                Address address = new Address(ApartmentNumber, StreetName, District, Ward, City);
                String NoteForShipper = rs.getString(9);
                LocalDate OrederDate = rs.getDate(10).toLocalDate();
                String ReceiverName = rs.getString(11);
                String ReceiverPhoneNum = rs.getString(12);
                OrderShipping orderShipping = new OrderShipping(OrderID, CollectionMoney, OrederDate, StarusOrder, address, NoteForShipper, ReceiverName, ReceiverPhoneNum);
                list.add(orderShipping);
            }
            rs.close();
            ps.close();
            return list;
        } catch (Exception ex) {
            Logger.getLogger(OrderShipping.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public OrderShipping getIdOrder(int id)  {
        String sql = "SELECT [collection_money], [apartment_number], [street_name], [District], [Ward], [city], [note_for_shipper], [receiver_name], [receiver_phonenumber] FROM Order_Shipping WHERE id_order = ?";
        try {
            PreparedStatement ps = this.baseRepositoryJDBC.getConnectionJavaToDB().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int CollectionMoney = rs.getInt(1);                        
                String ApartmentNumber = rs.getString(2);
                String StreetName = rs.getString(3);
                String District = rs.getString(4);
                String Ward = rs.getString(5);
                String City = rs.getString(6);
                Address address = new Address(ApartmentNumber, StreetName, District, Ward, City);
                String NoteForShipper = rs.getString(7);                             
                String ReceiverName = rs.getString(8);
                String ReceiverPhoneNum = rs.getString(9);
                OrderShipping orderShipping = new OrderShipping(CollectionMoney, address, NoteForShipper, ReceiverName, ReceiverPhoneNum);
                return orderShipping;
            }
        } catch (Exception ex) {
            Logger.getLogger(OrderShipping.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
      public void update(OrderShipping orderShipping) {
        String sql = "UPDATE Order_Shipping " +
             "SET collection_money = ?, " +
             "    apartment_number = ?, " +
             "    street_name = ?, " +
             "    District = ?, " +
             "    Ward = ?, " +
             "    city = ?, " +
             "    note_for_shipper = ?, " +
             "    receiver_name = ?, " +
             "    receiver_phonenumber = ? " +
             "WHERE id_order = ?";
        try {
            PreparedStatement ps = this.baseRepositoryJDBC.getConnectionJavaToDB().prepareStatement(sql);
            Address address = new Address();
            ps.setInt(1, orderShipping.getCollectionMoney());
            ps.setString(2, orderShipping.getAddress().getApartmentNumber());
            ps.setString(3, orderShipping.getAddress().getStreetName());
            ps.setString(4, orderShipping.getAddress().getDistrict());
            ps.setString(5, orderShipping.getAddress().getWard());
            ps.setString(6, orderShipping.getAddress().getCity());
            ps.setString(7, orderShipping.getNoteForShipper());
            ps.setString(8, orderShipping.getReceiverName());
            ps.setString(9, orderShipping.getReceiverPhoneNum());
            
//            ps.setString(1, c.getName());
//            ps.setString(2, c.getDescribe());
//            ps.setInt(3, c.getId());
             ps.execute();
        
        } catch (Exception ex) {
            Logger.getLogger(OrderShippingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public void delete(int id) {
        try (
                PreparedStatement ps = this.baseRepositoryJDBC.getConnectionJavaToDB().prepareStatement("DELETE FROM Order_Shipping WHERE id_order = ?")) {
            ps.setInt(1, id);
            ps.executeUpdate();       
        } catch (Exception ex) {
            Logger.getLogger(OrderShippingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
}
