package dao;

import entities.Employee;
import util.DBConnUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CourierAdminServiceImpl implements ICourierAdminService {

	@Override
	public int addCourierStaff(Employee obj) {
	    int id = -1;
	    String query = "INSERT INTO employee (Name, ContactNumber, Email, Role, Salary) VALUES (?, ?, ?, ?, ?)";
	    try (Connection conn = DBConnUtil.getDbConnection();
	         PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

	        stmt.setString(1, obj.getName());
	        stmt.setInt(2, obj.getContactNumber());
	        stmt.setString(3, obj.getEmail());
	        stmt.setString(4, obj.getRole());
	        stmt.setFloat(5, obj.getSalary());

	        int rows = stmt.executeUpdate();

	        if (rows > 0) {
	            ResultSet rs = stmt.getGeneratedKeys();
	            if (rs.next()) {
	                id = rs.getInt(1);
	            }
	        }
	    } catch (SQLException e) {
	        System.out.println(" Error adding courier staff: " + e.getMessage());
	    }
	    return id;
	}
}

