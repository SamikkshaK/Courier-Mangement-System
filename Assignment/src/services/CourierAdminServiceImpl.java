package services;

import entities.Courier;

public class CourierAdminServiceImpl extends CourierUserServiceImpl implements ICourierAdminService {

    @Override
    public String getAllCourierDetails() {
        Courier[] allCouriers = companyObj.getAllCouriers();
        StringBuilder sb = new StringBuilder("All Courier Details:\n");
        for (Courier c : allCouriers) {
            sb.append("Tracking #: ").append(c.getTrackingNumber())
              .append(", Sender: ").append(c.getSenderName())
              .append(", Receiver: ").append(c.getReceiverName())
              .append(", Status: ").append(c.getStatus()).append("\n");
        }
        return sb.toString();
    }
}
