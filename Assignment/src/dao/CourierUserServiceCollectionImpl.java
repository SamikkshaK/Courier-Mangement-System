package dao;

import entities.Courier;
import entities.CourierCompanyCollection;
import exceptions.InvalidEmployeeIdException;
import exceptions.TrackingNumberNotFoundException;
import services.ICourierUserService;

import java.util.List;

public class CourierUserServiceCollectionImpl implements ICourierUserService {

    protected CourierCompanyCollection companyObj = new CourierCompanyCollection();

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

    @Override
    public boolean cancelOrder(String trackingNumber) throws TrackingNumberNotFoundException {
        Courier courier = companyObj.getCourierByTrackingNumber(trackingNumber);
        if (courier == null) {
            throw new TrackingNumberNotFoundException("Cannot cancel. Tracking number not found: " + trackingNumber);
        }
        if ("Cancelled".equalsIgnoreCase(courier.getStatus())) {
            System.out.println("Order already cancelled.");
            return false;
        }
        courier.setStatus("Cancelled");
        return true;
        
    }

    @Override
    public String getAssignedOrder(String employeeId) {
        List<Courier> assignedCouriers = companyObj.getCouriersByEmployee(employeeId);
        if (assignedCouriers.isEmpty()) {
            return "No couriers assigned to employee ID: " + employeeId;
        }
        StringBuilder sb = new StringBuilder("Couriers assigned to " + employeeId + ":\n");
        for (Courier c : assignedCouriers) {
            sb.append("Tracking #: ").append(c.getTrackingNumber())
              .append(", Status: ").append(c.getStatus()).append("\n");
        }
        return sb.toString();
    }
}
