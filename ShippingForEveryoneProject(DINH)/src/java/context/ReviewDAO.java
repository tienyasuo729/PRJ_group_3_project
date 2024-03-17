package context;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Address;
import model.OrderShipping;



public class ReviewDAO extends DBcontext {  
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
            Logger.getLogger(ReviewDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       
   }
}
