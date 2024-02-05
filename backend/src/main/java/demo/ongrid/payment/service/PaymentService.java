package demo.ongrid.payment.service;

import demo.ongrid.payment.model.request.PaymentRequest;
import demo.ongrid.payment.model.response.PaymentResponse;
import org.springframework.http.ResponseEntity;

public interface PaymentService {

    ResponseEntity<PaymentResponse> updatePayment(PaymentRequest paymentRequest);
}
