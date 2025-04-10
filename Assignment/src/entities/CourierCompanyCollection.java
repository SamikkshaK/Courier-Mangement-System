package entities;

import java.util.ArrayList;
import java.util.List;

public class CourierCompanyCollection {
    private List<Courier> couriers;

    public CourierCompanyCollection() {
        this.couriers = new ArrayList<>();
    }

    public void addCourier(Courier courier) {
        couriers.add(courier);
    }

    public Courier getCourierByTrackingNumber(String trackingNumber) {
        for (Courier c : couriers) {
            if (c.getTrackingNumber().equals(trackingNumber)) {
                return c;
            }
        }
        return null;
    }

    public List<Courier> getCouriersByEmployee(String employeeId) {
        List<Courier> assigned = new ArrayList<>();
        for (Courier c : couriers) {
            if (c.getEmployeeId().equals(employeeId)) {
                assigned.add(c);
            }
        }
        return assigned;
    }

    public boolean cancelCourier(String trackingNumber) {
        Courier c = getCourierByTrackingNumber(trackingNumber);
        if (c != null) {
            c.setStatus("Cancelled");
            return true;
        }
        return false;
    }

    public List<Courier> getAllCouriers() {
        return couriers;
    }
}
