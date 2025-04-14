package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entities.Courier;
import entities.CourierCompany;
import exceptions.InvalidEmployeeIdException;
import exceptions.TrackingNumberNotFoundException;
import util.DBConnUtil;

public class CourierServiceImpl implements ICourierUserService {
    protected CourierCompany companyObj = new CourierCompany();

    @Override
    public String placeOrder(Courier courier) {
        if (!courier.getEmployeeId().startsWith("EMP")) {
            throw new InvalidEmployeeIdException("Invalid Employee ID: " + courier.getEmployeeId());
        }

        companyObj.addCourier(courier);
        return courier.getTrackingNumber();
    }

    @Override
    public String getOrderStatus(String trackingNumber) throws TrackingNumberNotFoundException {
        Courier c = companyObj.getCourierByTrackingNumber(trackingNumber);
        if (c == null) {
            throw new TrackingNumberNotFoundException("Tracking number not found: " + trackingNumber);
        }
        return c.getStatus();
    }

    
    public String getOrderStatusFromDB(String trackingNumber) {
        String query = "SELECT Status FROM courier WHERE TrackingNumber = ?";
        try (Connection conn = DBConnUtil.getDbConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, trackingNumber.trim());
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getString("Status");
            } else {
                throw new TrackingNumberNotFoundException("Tracking number not found: " + trackingNumber);
            }

        } catch (TrackingNumberNotFoundException e) {
            return " " + e.getMessage();
        } catch (SQLException e) {
            return " Database error: " + e.getMessage();
        }
    }

    @Override
 
    public boolean cancelOrderInDB(String trackingNumber) {
        String selectQuery = "SELECT Status FROM courier WHERE TrackingNumber = ?";
        String updateQuery = "UPDATE courier SET Status = 'Cancelled' WHERE TrackingNumber = ?";

        try (Connection conn = util.DBConnUtil.getDbConnection();
             PreparedStatement selectStmt = conn.prepareStatement(selectQuery);
             PreparedStatement updateStmt = conn.prepareStatement(updateQuery)) {

            selectStmt.setString(1, trackingNumber);
            ResultSet rs = selectStmt.executeQuery();

            if (!rs.next()) {
                throw new TrackingNumberNotFoundException("Tracking number not found: " + trackingNumber);
            }

            String status = rs.getString("Status");
            if ("Cancelled".equalsIgnoreCase(status)) {
                System.out.println("Order already cancelled.");
                return false;
            }

            updateStmt.setString(1, trackingNumber);
            int updated = updateStmt.executeUpdate();
            return updated > 0;

        } catch (TrackingNumberNotFoundException e) {
            System.out.println(" " + e.getMessage());
            return false;
        } catch (SQLException e) {
            System.out.println(" DB Error: " + e.getMessage());
            return false;
        }
    }



    @Override
    public String getAssignedOrder(String employeeId) {
        Courier[] assigned = companyObj.getCouriersByEmployeeId(employeeId);
        if (assigned.length == 0)
            return "Assigned Order for Employee ID: " + employeeId;

        StringBuilder sb = new StringBuilder("Assigned Orders for ").append(employeeId).append(":\n");
        for (Courier c : assigned) {
            sb.append("Tracking #: ").append(c.getTrackingNumber())
              .append(", Status: ").append(c.getStatus()).append("\n");
        }
        return sb.toString();
    }

	@Override
	public boolean cancelOrder(String trackingNumber) throws TrackingNumberNotFoundException {
		
		return false;
	}
}
