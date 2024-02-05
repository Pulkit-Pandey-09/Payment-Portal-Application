package demo.ongrid.payment.dao.Impl;

import demo.ongrid.payment.dao.PaymentDao;
import demo.ongrid.payment.model.entity.Payment;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class PaymentDaoImpl implements PaymentDao {

    private EntityManager entityManager;
    @Autowired
    public PaymentDaoImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public Payment getPaymentById(Integer Id) {
        return entityManager.find(Payment.class, Id);
    }

    @Override
    @Transactional
    public Payment updatePayment(Integer Id, Integer amount, String status, String dt) {
        Payment existPayment = getPaymentById(Id);
        existPayment.setAmount(amount);
        existPayment.setStatus(status);

        existPayment.setUpdated(dt);

        entityManager.merge(existPayment);
        return existPayment;
    }
}
