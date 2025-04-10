package services;

import entities.Courier;
import entities.CourierCompany;
import exceptions.InvalidEmployeeIdException;
import exceptions.TrackingNumberNotFoundException;

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
        Courier c = companyObj.findCourierByTrackingNumber(trackingNumber);
        if (c == null) {
            throw new TrackingNumberNotFoundException("Tracking number not found: " + trackingNumber);
        }
        return c.getStatus();
    }

    @Override
    public boolean cancelOrder(String trackingNumber) throws TrackingNumberNotFoundException {
        Courier courier = companyObj.findCourierByTrackingNumber(trackingNumber);
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
        Courier[] assigned = companyObj.getCouriersByEmployeeId(employeeId);
        if (assigned.length == 0) 
        	return "Assigned Order for Employee ID: " + employeeId;;

        StringBuilder sb = new StringBuilder("Assigned Orders for ").append(employeeId).append(":\n");
        for (Courier c : assigned) {
            sb.append("Tracking #: ").append(c.getTrackingNumber())
              .append(", Status: ").append(c.getStatus()).append("\n");
        }
        return sb.toString();
    }
}
