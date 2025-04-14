package dao;

import entities.Courier;
import entities.Employee;

public class CourierAdminServiceCollection extends CourierUserServiceCollectionImpl implements ICourierAdminService {

    @Override
    public String getAllCourierDetails() {
        StringBuilder sb = new StringBuilder("All Courier Details:\n");
        for (Courier c : companyObj.getAllCouriers()) {
            sb.append("Tracking #: ").append(c.getTrackingNumber())
              .append(", Sender: ").append(c.getSenderName())
              .append(", Receiver: ").append(c.getReceiverName())
              .append(", Status: ").append(c.getStatus()).append("\n");
        }
        return sb.toString();
    }

	@Override
	public int addCourierStaff(Employee obj) {

		return 0;
	}
}
