package services;

import entities.Courier;
import entities.CourierCompany;
import exceptions.InvalidEmployeeIdException;
import exceptions.TrackingNumberNotFoundException;

public class CourierUserServiceImpl implements ICourierUserService {
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
        Courier c = companyObj.findCourierByTrackingNumber(trackingNumber);
        if (c == null) {
            throw new TrackingNumberNotFoundException("Tracking number not found: " + trackingNumber);
        }
        return c.getStatus();
    }

    @Override
    public boolean cancelOrder(String trackingNumber) throws TrackingNumberNotFoundException {
        Courier c = companyObj.findCourierByTrackingNumber(trackingNumber);
        if (c == null) {
            throw new TrackingNumberNotFoundException("Cannot cancel. Tracking number not found: " + trackingNumber);
        }
        c.setStatus("Cancelled");
        return true;
    }

    @Override
    public String getAssignedOrder(String employeeId) {
        Courier[] assigned = companyObj.getCouriersByEmployeeId(employeeId);
        if (assigned.length == 0) return "No orders assigned.";

        StringBuilder sb = new StringBuilder("Assigned Orders for ").append(employeeId).append(":\n");
        for (Courier c : assigned) {
            sb.append("Tracking #: ").append(c.getTrackingNumber())
              .append(", Status: ").append(c.getStatus()).append("\n");
        }
        return sb.toString();
    }
}
