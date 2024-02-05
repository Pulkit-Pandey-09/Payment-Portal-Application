package demo.ongrid.payment.service.Impl;

import demo.ongrid.payment.dao.PaymentDao;
import demo.ongrid.payment.model.dto.PaymentDto;
import demo.ongrid.payment.model.entity.Payment;
import demo.ongrid.payment.model.entity.Programme;
import demo.ongrid.payment.model.entity.Student;
import demo.ongrid.payment.model.response.ReceiptResponse;
import demo.ongrid.payment.service.ReceiptService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ReceiptServiceImpl implements ReceiptService {

    private PaymentDao paymentDao;
    private ModelMapper modelMapper;
    @Autowired
    public ReceiptServiceImpl(PaymentDao paymentDao, ModelMapper modelMapper){
        this.paymentDao = paymentDao;
        this.modelMapper = modelMapper;
    }


    @Override
    public ResponseEntity<ReceiptResponse> getPaymentStatus(Integer Id) {

        Payment payment = paymentDao.getPaymentById(Id);
        PaymentDto paymentDto = modelMapper.map(payment, PaymentDto.class);


        Student student = paymentDto.getStudent();
        Programme programme = paymentDto.getTheProgramme();

        // creating response
        Map<String, String> tempUser = new HashMap<>();
        tempUser.put("firstName",student.getFistName());
        tempUser.put("lastName",student.getLastName());
        tempUser.put("rollNumber",String.valueOf(student.getRollNumber()));

        Map<String, String> tempProgramme = new HashMap<>();
        tempProgramme.put("programmeName", programme.getProgrammeName());


        Map<String, String> tempPayment = new HashMap<>();
        tempPayment.put("paymentId", String.valueOf(payment.getPaymentId()));
        tempPayment.put("amount", String.valueOf(payment.getAmount()));
        tempPayment.put("status", payment.getStatus());
        tempPayment.put("paymentDate", payment.getUpdated());

        ReceiptResponse paymentResponse = new ReceiptResponse(tempUser, tempProgramme, tempPayment);
        ResponseEntity<ReceiptResponse> responseEntity = new ResponseEntity<>(paymentResponse, HttpStatus.OK);

        return responseEntity;
    }
}