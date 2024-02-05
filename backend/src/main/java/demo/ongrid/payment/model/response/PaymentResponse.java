package demo.ongrid.payment.model.response;

public class PaymentResponse {
    private Integer paymentId;
    private String status;

    public PaymentResponse(){

    }

    public PaymentResponse(Integer paymentId, String status) {
        this.paymentId = paymentId;
        this.status = status;
    }

    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "PaymentResponse{" +
                "paymentId=" + paymentId +
                ", status='" + status + '\'' +
                '}';
    }
}
