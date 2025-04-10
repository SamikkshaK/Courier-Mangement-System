package entities;

import java.util.Date;

public class Payment {
    private long paymentId;
    private long courierId;
    private double amount;
    private Date paymentDate;

    // Default constructor
    public Payment() {}

    // Parameterized constructor
    public Payment(long paymentId, long courierId, double amount, Date paymentDate) {
        this.paymentId = paymentId;
        this.courierId = courierId;
        this.amount = amount;
        this.paymentDate = paymentDate;
    }

    // Getters and Setters
    public long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(long paymentId) {
        this.paymentId = paymentId;
    }

    public long getCourierId() {
        return courierId;
    }

    public void setCourierId(long courierId) {
        this.courierId = courierId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    // ToString Method
    @Override
    public String toString() {
        return "Payment [PaymentID=" + paymentId +
               ", CourierID=" + courierId +
               ", Amount=" + amount +
               ", PaymentDate=" + paymentDate + "]";
    }
}
