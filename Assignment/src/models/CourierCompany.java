package models;

import entities.Courier;

public class CourierCompany {
    private Courier[] couriers = new Courier[100];
    private int count = 0;

    // Adds a new courier to the array
    public void addCourier(Courier courier) {
        if (count < couriers.length) {
            couriers[count++] = courier;
        }
    }

    // Retrieves a courier based on tracking number
    public Courier getCourierByTrackingNumber(String trackingNumber) {
        for (Courier c : couriers) {
            if (c != null && c.getTrackingNumber().equals(trackingNumber)) {
                return c;
            }
        }
        return null;
    }

    // Returns all courier objects
    public Courier[] getAllCouriers() {
        return couriers;
    }
}
