package demo.ongrid.payment.service.Impl;

import demo.ongrid.payment.dao.ProgrammeDao;
import demo.ongrid.payment.model.dto.ProgrammeDto;
import demo.ongrid.payment.model.entity.Programme;
import demo.ongrid.payment.service.ProgrammeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProgrammeServiceImpl implements ProgrammeService {

    private ProgrammeDao theProgrammeDAO;
    private ModelMapper modelMapper;
    @Autowired
    public ProgrammeServiceImpl(ProgrammeDao theProgrammeDAO, ModelMapper modelMapper){
        this.theProgrammeDAO = theProgrammeDAO;
        this.modelMapper = modelMapper;
    }

    @Override
    public ResponseEntity<ProgrammeDto> getProgrammeById(Integer Id) {
        Programme tempProgramme = theProgrammeDAO.getProgrammeById(Id);
        ProgrammeDto programmeDto = modelMapper.map(tempProgramme, ProgrammeDto.class);

        // creating a response
        ResponseEntity<ProgrammeDto> responseEntity = new ResponseEntity<>(programmeDto, HttpStatus.OK);

//        ProgrammeDto tempProgrammeDTO = new ProgrammeDto(tempProgramme.getProgrammeName(),
//                tempProgramme.getTuitionFee(),
//                tempProgramme.getLibraryFee(),
//                tempProgramme.getMessFee(),
//                tempProgramme.getMedicalFee(),
//                tempProgramme.getHostelFee(),
//                tempProgramme.getAmount());

        return responseEntity;
    }
}
