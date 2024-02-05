package demo.ongrid.payment.service;

import demo.ongrid.payment.model.request.JwtAuthRequest;
import demo.ongrid.payment.model.response.JwtAuthResponse;
import org.springframework.http.ResponseEntity;

public interface LoginService {
    ResponseEntity<JwtAuthResponse> loginResponse(JwtAuthRequest request);
}
