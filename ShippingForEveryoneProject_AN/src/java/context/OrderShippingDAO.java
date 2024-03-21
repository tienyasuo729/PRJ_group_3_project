package context;


import Impl.AccountUserImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;
import model.AccountShipping;
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
    public List<OrderShipping> viewAll(int id){
        String idShiper = Integer.toString(id);
        String sqlQuerry_searsh ="select id_order,receiver_name,receiver_phonenumber,collection_money,status_order,transportation_cost,apartment_number,street_name,District,Ward,city,note_for_shipper  from Order_Shipping where id_delivery=?";
        List<OrderShipping> list = new ArrayList<>();
        try {
            Connection conn = new DBcontext().getConnection();
            PreparedStatement ps = conn.prepareStatement(sqlQuerry_searsh);
            ps.setString(1, idShiper);           
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id_order = rs.getInt(1);
                String receiver_name=rs.getString(2);
                String receiver_phonenumber=rs.getString(3);
                int collection_money=rs.getInt(4);
                boolean status_order=rs.getBoolean(5);
                int transportation_cost=rs.getInt(6);
                String apartment_number=rs.getString(7);
                String street_name=rs.getString(8);
                String District=rs.getString(9);     
                String Ward =rs.getString(10);
                String city=rs.getString(11);
                String note_for_shipper=rs.getString(12);
                Address address = new Address(apartment_number, street_name, District, Ward, city);
                OrderShipping ordershipping = new OrderShipping(id_order, collection_money, transportation_cost, status_order, status_order, address, note_for_shipper, receiver_name, receiver_phonenumber);
                list.add(ordershipping);
            }
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(AccountUserImpl.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return list;
    }
    public OrderShipping get(int id) throws Exception {
        String sql = "SELECT [collection_money], [transportation_cost], [status_order], [apartment_number], [street_name], [District], [Ward], [city], [note_for_shipper], [check_package], [order_date] FROM orders WHERE id_order = ?";

        try (Connection conn = new DBcontext().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    OrderShipping orderShipping = new OrderShipping();
                    Address address = new Address();
                    
                    orderShipping.setCollectionMoney(rs.getInt("collection_money"));
                    orderShipping.setTransportationCost(rs.getInt("transportation_cost"));
                    orderShipping.setStatusOrder(rs.getBoolean("status_order"));
                    address.setApartmentNumber(rs.getString("apartment_number"));
                    address.setStreetName(rs.getString("street_name"));
                    address.setDistrict(rs.getString("District"));
                    address.setWard(rs.getString("Ward"));
                    address.setCity(rs.getString("city"));
                    orderShipping.setNoteForShipper(rs.getString("note_for_shipper"));
                    orderShipping.setCheckPackage(rs.getBoolean("check_package"));
                    orderShipping.setOrderDate(rs.getDate("order_date").toLocalDate());
                    
                    return orderShipping;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderShipping.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
   public void addorder(OrderShipping ordershipping,Address address) throws Exception
   {
        try {
            String sql = "INSERT INTO Order_Shipping (" +
                     "collection_money, " +
                     "transportation_cost, " +
                     "status_order, " +
                     "apartment_number, " +
                     "street_name, " +
                     "District, " +
                     "Ward, " +
                     "city, " +
                     "note_for_shipper, " +                   
                     "check_package, " +                    
                     "VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            Connection conn = new DBcontext().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);           
            ps.setInt(1, ordershipping.getCollectionMoney());
            ps.setInt(2, ordershipping.getTransportationCost());
            ps.setBoolean(3, ordershipping.getStatusOrder());                     
            ps.setString(4, address.getApartmentNumber());
            ps.setString(5, address.getStreetName());
            ps.setString(6, address.getDistrict());
            ps.setString(7, address.getWard());
            ps.setString(8, address.getCity());
            ps.setString(9, ordershipping.getNoteForShipper());
            ps.setBoolean(10, ordershipping.getCheckPackage()); 
//            ps.setString(11, ordershipping.getEstimatedDeliveryTime());
                   
            
             ps.execute();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(OrderShipping.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }
    public ArrayList<OrderShipping> ordersStatus(int id){
            String idShiper = Integer.toString(id);
            ArrayList<OrderShipping> list = new ArrayList<>();
            String SQLquery ="select id_order,receiver_name,receiver_phonenumber,collection_money,status_order,transportation_cost,apartment_number,street_name,District,Ward,city,note_for_shipper  from Order_Shipping where id_delivery=? and status_order=0";
            try {
                Connection conn = new DBcontext().getConnection();
                PreparedStatement ps = conn.prepareStatement(SQLquery);
                ps.setString(1, idShiper);           
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                int id_order = rs.getInt(1);
                String receiver_name=rs.getString(2);
                String receiver_phonenumber=rs.getString(3);
                int collection_money=rs.getInt(4);
                boolean status_order=rs.getBoolean(5);
                int transportation_cost=rs.getInt(6);
                String apartment_number=rs.getString(7);
                String street_name=rs.getString(8);
                String District=rs.getString(9);     
                String Ward =rs.getString(10);
                String city=rs.getString(11);
                String note_for_shipper=rs.getString(12);
                Address address = new Address(apartment_number, street_name, District, Ward, city);
                OrderShipping ordershipping = new OrderShipping(id_order, collection_money, transportation_cost, status_order, status_order, address, note_for_shipper, receiver_name, receiver_phonenumber);
                list.add(ordershipping);
                
                }
            } catch (Exception ex) {
                Logger.getLogger(OrderShipping.class.getName()).log(Level.SEVERE, null, ex);
            }
       return null; 
    } 
}
