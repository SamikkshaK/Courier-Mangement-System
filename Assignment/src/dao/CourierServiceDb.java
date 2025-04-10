package dao;

import java.sql.*;
import java.util.*;

import util.DBConnUtil;
import entities.Courier;

public class CourierServiceDb {
    private static Connection connection;
    

    
    public CourierServiceDb() {
        connection = DBConnUtil.getDbConnection();
        if (connection != null) {
            System.out.println("Database connection established in CourierServiceDb.");
        } else {
            System.out.println("Failed to establish database connection.");
        }
    }

    
    public boolean insertCourier(Courier courier) {
        String sql = "INSERT INTO couriers (tracking_number, sender_name, receiver_name, status, employee_id) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, courier.getTrackingNumber());
            ps.setString(2, courier.getSenderName());
            ps.setString(3, courier.getReceiverName());
            ps.setString(4, courier.getStatus());
            ps.setString(5, courier.getEmployeeId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error inserting courier: " + e.getMessage());
            return false;
        }
    }

    
    public boolean updateCourierStatus(String trackingNumber, String newStatus) {
        String sql = "UPDATE couriers SET status = ? WHERE tracking_number = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, newStatus);
            ps.setString(2, trackingNumber);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error updating status: " + e.getMessage());
            return false;
        }
    }

    
    public Courier getCourierByTrackingNumber(String trackingNumber) {
        String sql = "SELECT * FROM couriers WHERE tracking_number = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, trackingNumber);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Courier(
                    rs.getString("tracking_number"),
                    rs.getString("sender_name"),
                    rs.getString("receiver_name"),
                    rs.getString("employee_id"),
                    rs.getString("status")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving courier: " + e.getMessage());
        }
        return null;
    }


    public List<String> getDeliveryHistory(String trackingNumber) {
        List<String> history = new ArrayList<>();
        String sql = "SELECT status, location, timestamp FROM delivery_history WHERE tracking_number = ? ORDER BY timestamp";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, trackingNumber);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                String status = rs.getString("status");
                String location = rs.getString("location");
                String time = rs.getTimestamp("timestamp").toString();
                history.add("[" + time + "] " + status + " at " + location);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return history;
    }

    
    public Map<String, Integer> getShipmentStatusReport() {
        Map<String, Integer> report = new HashMap<>();
        String sql = "SELECT status, COUNT(*) AS count FROM couriers GROUP BY status";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String status = rs.getString("status");
                int count = rs.getInt("count");
                report.put(status, count);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return report;
    }

    
    public double getTotalRevenue() {
        double total = 0.0;
        String sql = "SELECT SUM(amount) FROM payments";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            if (rs.next()) {
                total = rs.getDouble(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return total;
    }
}
