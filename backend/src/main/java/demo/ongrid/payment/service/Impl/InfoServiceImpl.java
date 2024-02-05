package demo.ongrid.payment.service.Impl;

import demo.ongrid.payment.dao.StudentDao;
import demo.ongrid.payment.model.dto.PaymentDto;
import demo.ongrid.payment.model.dto.ProgrammeDto;
import demo.ongrid.payment.model.dto.StudentDto;
import demo.ongrid.payment.model.entity.Payment;
import demo.ongrid.payment.model.entity.Programme;
import demo.ongrid.payment.model.entity.Student;
import demo.ongrid.payment.model.request.InfoRequest;
import demo.ongrid.payment.model.response.InfoResponse;
import demo.ongrid.payment.service.InfoService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class InfoServiceImpl implements InfoService {

	private StudentDao studentDao;
	private ModelMapper modelMapper;

	public InfoServiceImpl(StudentDao studentDao, ModelMapper modelMapper){
		this.studentDao = studentDao;
		this.modelMapper = modelMapper;
	}
	@Override
	public ResponseEntity<InfoResponse> getDetails(InfoRequest Id) {
		String rollNumber = Id.getRollNumber();
		Student student = studentDao.findByRollNumber(rollNumber);
		StudentDto studentDto = modelMapper.map(student,StudentDto.class);


		// creating response
		Map<String, String> user = new HashMap<>();
		Map<String, String> programme = new HashMap<>();
		Map<String, String> payment = new HashMap<>();

		String firstName = studentDto.getFistName();
		String lastName = studentDto.getLastName();
		user.put("firstName", firstName);
		user.put("lastName", lastName);
		user.put("rollNumber", rollNumber);


		Programme programmeDetails = student.getTheProgramme();
		ProgrammeDto programmeDto = modelMapper.map(programmeDetails, ProgrammeDto.class);

		String programmeName = programmeDto.getProgrammeName();
		String amount = String.valueOf(programmeDto.getAmount());
		programme.put("programmeName", programmeName);
		programme.put("amount", amount);


		Payment paymentDetails = student.getThePayment();
		PaymentDto paymentDto = modelMapper.map(paymentDetails, PaymentDto.class);
		String paymentStatus = paymentDto.getStatus();
		Integer paymentId = paymentDto.getPaymentId();

		if(paymentStatus.equals("NO"))  payment.put("paymentStatus", "Payment Pending.");
		else payment.put("paymentStatus", "Payment Received.");
		payment.put("paymentId", String.valueOf(paymentId));

		InfoResponse infoResponse = new InfoResponse(user, programme, payment);
		return new ResponseEntity<>(infoResponse, HttpStatus.OK);
	}
}
