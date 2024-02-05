package demo.ongrid.payment.model.dto;

import demo.ongrid.payment.model.entity.Programme;
import demo.ongrid.payment.model.entity.Student;

public class PaymentDto {

    private Integer paymentId;

    private Integer amount;

    private String status;

    private String created;

    private String updated;

    private Programme theProgramme;

    private Student student;

    public PaymentDto(){

    }

    public PaymentDto(Integer paymentId, Integer amount, String status, String created, String updated, Programme theProgramme, Student student) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.status = status;
        this.created = created;
        this.updated = updated;
        this.theProgramme = theProgramme;
        this.student = student;
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

}
