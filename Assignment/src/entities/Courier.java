package entities;

public class Courier {
    private String trackingNumber;
    private String senderName;
    private String receiverName;
    private String employeeId;
    private String status;

    
    public Courier(String trackingNumber, String senderName, String receiverName, String employeeId, String status) {
        this.trackingNumber = trackingNumber;
        this.senderName = senderName;
        this.receiverName = receiverName;
        this.employeeId = employeeId;
        this.status = status;
    }

    
    public Courier(String trackingNumber, String senderName, String receiverName, String employeeId) {
        this.trackingNumber = trackingNumber;
        this.senderName = senderName;
        this.receiverName = receiverName;
        this.employeeId = employeeId;
        this.status = "Placed"; 
    }

    // Getters and Setters
    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

   
    @Override
    public String toString() {
        return "Courier{" +
                "TrackingNumber='" + trackingNumber + '\'' +
                ", SenderName='" + senderName + '\'' +
                ", ReceiverName='" + receiverName + '\'' +
                ", EmployeeId='" + employeeId + '\'' +
                ", Status='" + status + '\'' +
                '}';
    }
}
