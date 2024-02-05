package demo.ongrid.payment.service;

import demo.ongrid.payment.model.response.ReceiptResponse;
import org.springframework.http.ResponseEntity;

public interface ReceiptService {
    ResponseEntity<ReceiptResponse> getPaymentStatus(Integer Id);

}
