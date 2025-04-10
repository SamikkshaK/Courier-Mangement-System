package services;

import entities.Courier;
import exceptions.InvalidEmployeeIdException;
import exceptions.TrackingNumberNotFoundException;

public interface ICourierUserService {
    String placeOrder(Courier courier) throws InvalidEmployeeIdException;
    String getOrderStatus(String trackingNumber) throws TrackingNumberNotFoundException;
    boolean cancelOrder(String trackingNumber) throws TrackingNumberNotFoundException;
    String getAssignedOrder(String employeeId);
}
