package demo.ongrid.payment.service;

import demo.ongrid.payment.model.dto.StudentDto;
import demo.ongrid.payment.model.request.InfoRequest;
import demo.ongrid.payment.model.response.InfoResponse;
import org.springframework.http.ResponseEntity;

public interface InfoService {

	ResponseEntity<InfoResponse> getDetails(InfoRequest Id);
}
