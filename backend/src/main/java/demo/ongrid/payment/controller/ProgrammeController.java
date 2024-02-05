package demo.ongrid.payment.controller;

import demo.ongrid.payment.model.dto.ProgrammeDto;
import demo.ongrid.payment.model.entity.Programme;
import demo.ongrid.payment.service.ProgrammeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/programme")
@CrossOrigin(origins = {"http://localhost:3000"}, methods = {RequestMethod.OPTIONS,RequestMethod.GET, RequestMethod.POST})
public class ProgrammeController {

    private ProgrammeService programmeService;
    @Autowired
    public ProgrammeController(ProgrammeService theProgrammeService){
        this.programmeService = theProgrammeService;
    }

    @GetMapping("/{programmeId}")
    public ResponseEntity<ProgrammeDto> getProgrammeFee(@PathVariable("programmeId") int programme_Id){
        return programmeService.getProgrammeById(programme_Id);
    }
}
