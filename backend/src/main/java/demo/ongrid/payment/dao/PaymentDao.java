package demo.ongrid.payment.dao;

import demo.ongrid.payment.model.entity.Payment;
import jakarta.persistence.EntityManager;

public interface PaymentDao {

    Payment getPaymentById(Integer Id);
    Payment updatePayment(Integer Id, Integer amount, String status, String dt);
}
