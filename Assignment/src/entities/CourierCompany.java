package entities;

import java.util.ArrayList;
import java.util.List;

public class CourierCompany {
    private String companyName;
    private List<Courier> courierDetails = new ArrayList<>();
    private List<Employee> employeeDetails = new ArrayList<>();
    private List<Location> locationDetails = new ArrayList<>();

    public CourierCompany() {}

    public CourierCompany(String companyName, List<Courier> courierDetails,
                          List<Employee> employeeDetails, List<Location> locationDetails) {
        this.companyName = companyName;
        this.courierDetails = courierDetails;
        this.employeeDetails = employeeDetails;
        this.locationDetails = locationDetails;
    }

    // Getters and setters
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public List<Courier> getCourierDetails() {
        return courierDetails;
    }

    public void setCourierDetails(List<Courier> courierDetails) {
        this.courierDetails = courierDetails;
    }

    public List<Employee> getEmployeeDetails() {
        return employeeDetails;
    }

    public void setEmployeeDetails(List<Employee> employeeDetails) {
        this.employeeDetails = employeeDetails;
    }

    public List<Location> getLocationDetails() {
        return locationDetails;
    }

    public void setLocationDetails(List<Location> locationDetails) {
        this.locationDetails = locationDetails;
    }

    // Business methods
    public void addCourier(Courier courier) {
        courierDetails.add(courier);
    }

    public Courier getCourierByTrackingNumber(String trackingNumber) {
        for (Courier c : courierDetails) {
            if (c.getTrackingNumber().equals(trackingNumber)) {
                return c;
            }
        }
        return null;
    }

    public Courier[] getAllCouriers() {
        return courierDetails.toArray(new Courier[0]);
    }

    public Courier[] getCouriersByEmployeeId(String employeeId) {
        List<Courier> result = new ArrayList<>();
        for (Courier c : courierDetails) {
            if (c.getEmployeeId().equals(employeeId)) {
                result.add(c);
            }
        }
        return result.toArray(new Courier[0]);
    }

    @Override
    public String toString() {
        return "CourierCompany [CompanyName=" + companyName +
               ", Couriers=" + courierDetails +
               ", Employees=" + employeeDetails +
               ", Locations=" + locationDetails + "]";
    }
}
