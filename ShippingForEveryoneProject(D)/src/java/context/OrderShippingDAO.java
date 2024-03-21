package context;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdk.vm.ci.meta.Local;
import model.Address;
import model.OrderShipping;

public class OrderShippingDAO extends DBcontext {
//    public void add(Review review) {
//        try {
//            String sql = "INSERT INTO reviews (name, rating, comment) VALUES (?, ?, ?)";
//            PreparedStatement ps = connection.prepareStatement(sql);
//            ps.setString(1, review.getName());
//            ps.setInt(2, review.getRating());
//            ps.setString(3, review.getComment());
//            ps.execute();
//            ps.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(ReviewDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }

//    public ArrayList<Review> getAll() {
//        ArrayList<Review> list = new ArrayList<>();
//        try (PreparedStatement ps = connection.prepareStatement("SELECT * FROM reviews"); 
//                ResultSet rs = ps.executeQuery()) {
//            while (rs.next()) {
//                Review review = new Review();                
//                review.setName(rs.getString("name"));
//                review.setRating(rs.getInt("rating"));
//                review.setComment(rs.getString("comment"));
//                list.add(review);
//            }
//            rs.close();
//            ps.close();
//            return list;
//        } catch (SQLException ex) {
//            Logger.getLogger(ReviewDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return null;
//    }
//public ArrayList<Review> searchOrder() {
//        ArrayList<Review> list = new ArrayList<>();
//        try (PreparedStatement ps = connection.prepareStatement("SELECT * FROM reviews"); 
//                ResultSet rs = ps.executeQuery()) {
//            while (rs.next()) {
//                Review review = new Review();                
//                review.setName(rs.getString("name"));
//                review.setRating(rs.getInt("rating"));
//                review.setComment(rs.getString("comment"));
//                list.add(review);
//            }
//            rs.close();
//            ps.close();
//            return list;
//        } catch (SQLException ex) {
//            Logger.getLogger(ReviewDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return null;
//    }
    public OrderShipping get(int id)  {
        String sql = "SELECT [collection_money], [transportation_cost], [status_order], [apartment_number], [status_order], [street_name], [District], [Ward], [city], [note_for_shipper], [check_package], [order_date], [receiver_name], [receiver_phonenumber] FROM Order_Shipping WHERE id_order = ?";
        try {
            Connection conn = new DBcontext().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
//                OrderShipping orderShipping = new OrderShipping();           
//                orderShipping.setCollectionMoney(rs.getInt("collection_money"));
//                orderShipping.setTransportationCost(rs.getInt("transportation_cost"));
//                orderShipping.setStatusOrder(rs.getBoolean("status_order"));
//                address.setApartmentNumber(rs.getString("apartment_number"));
//                address.setStreetName(rs.getString("street_name"));
//                address.setDistrict(rs.getString("District"));
//                address.setWard(rs.getString("Ward"));
//                address.setCity(rs.getString("city"));
                int CollectionMoney = rs.getInt(1);
                int TransportationCost = rs.getInt(2);
                Boolean StarusOrder = rs.getBoolean(3);
                String ApartmentNumber = rs.getString(4);
                String StreetName = rs.getString(5);
                String District = rs.getString(6);
                String Ward = rs.getString(7);
                String City = rs.getString(8);

                Address address = new Address(ApartmentNumber, StreetName, District, Ward, City);
//                orderShipping.setNoteForShipper(rs.getString("note_for_shipper"));
//                orderShipping.setCheckPackage(rs.getBoolean("check_package"));
//                orderShipping.setOrderDate(rs.getDate("order_date").toLocalDate());
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

    public void addorder(OrderShipping ordershipping) throws Exception {
        try {
            String sql = "INSERT INTO Order_Shipping (id_sender, receiver_name, receiver_phonenumber, collection_money, status_order, city, district, ward, street_name, apartment_number, note_for_shipper, check_package, id_delivery) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            Connection conn = new DBcontext().getConnection();
            
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, ordershipping.getIdSender());
            ps.setString(2, ordershipping.getReceiverName());
            ps.setString(3, ordershipping.getReceiverPhoneNum());
            ps.setInt(4, ordershipping.getCollectionMoney());
            ps.setBoolean(5, false);
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
        } catch (SQLException ex) {
            Logger.getLogger(OrderShipping.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public ArrayList<OrderShipping> getmyOrder(int id)  {
        ArrayList<OrderShipping> list = new ArrayList<>();
        String sql = "SELECT [id_order], [collection_money], [status_order], [apartment_number], [street_name], [District], [Ward], [city], [note_for_shipper], [order_date], [receiver_name], [receiver_phonenumber] FROM Order_Shipping WHERE id_sender = ?";
        try {
            Connection conn = new DBcontext().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int OrderID = rs.getInt(1);
                int CollectionMoney = rs.getInt(2);
                Boolean StarusOrder = rs.getBoolean(3);
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
       public void delete(int id) {
        try (Connection conn = new DBcontext().getConnection();
             PreparedStatement ps = conn.prepareStatement("DELETE FROM Order_Shipping WHERE id_order = ?")) {
            ps.setInt(1, id);
            ps.executeUpdate();       
        } catch (Exception ex) {
            Logger.getLogger(OrderShippingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public void update(OrderShipping orderShipping)
    {
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
            Connection conn = new DBcontext().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
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
      public OrderShipping getIdOrder(int id)  {
        String sql = "SELECT [collection_money], [apartment_number], [street_name], [District], [Ward], [city], [note_for_shipper], [receiver_name], [receiver_phonenumber] FROM Order_Shipping WHERE id_order = ?";
        try {
            Connection conn = new DBcontext().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
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
}
