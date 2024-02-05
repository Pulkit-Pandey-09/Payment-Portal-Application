package demo.ongrid.payment.service;

import demo.ongrid.payment.model.dto.ProgrammeDto;
import demo.ongrid.payment.model.entity.Programme;
import org.springframework.http.ResponseEntity;

public interface ProgrammeService {
    ResponseEntity<ProgrammeDto> getProgrammeById(Integer Id);
}
