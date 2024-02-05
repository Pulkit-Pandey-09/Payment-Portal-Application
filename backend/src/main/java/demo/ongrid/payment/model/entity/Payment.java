package demo.ongrid.payment.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name="payment")
public class Payment {

    /*
    Entity Name - payment
    Attributes -
    paymentId - Integer, Primary Key
    amount - Integer
    status - String
    //userId - string, foreign key
    programmeId - Integer, Foreign Key
    Created - Date
    updated - Date
     */

    @Id
    @Column(name="paymentId")
    private Integer paymentId;

    @Column(name="amount")
    private Integer amount;

    @Column(name="status")
    private String status;

    @Column(name="created")
    private String created;

    @Column(name="updated")
    private String updated;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="programmeId")
    private Programme theProgramme;

    @OneToOne(mappedBy = "thePayment", fetch = FetchType.EAGER)
    private Student student;

    public Payment(){

    }

    public Payment(Integer paymentId, Integer amount, String status, String created, String updated) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.status = status;
        this.created = created;
        this.updated = updated;
    }

    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public Programme getTheProgramme() {
        return theProgramme;
    }

    public void setTheProgramme(Programme theProgramme) {
        this.theProgramme = theProgramme;
    }

    public Student getStudent() {
        return student;
    }
    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "payment{" +
                "paymentId=" + paymentId +
                ", amount=" + amount +
                ", status='" + status + '\'' +
                ", created=" + created +
                ", updated=" + updated +
                ", theProgramme=" + theProgramme +
                '}';
    }
}
