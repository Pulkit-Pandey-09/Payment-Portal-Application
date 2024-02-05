package demo.ongrid.payment.service.Impl;

import demo.ongrid.payment.dao.PaymentDao;
import demo.ongrid.payment.dao.StudentDao;
import demo.ongrid.payment.model.dto.PaymentDto;
import demo.ongrid.payment.model.entity.Payment;
import demo.ongrid.payment.model.entity.Student;
import demo.ongrid.payment.model.request.PaymentRequest;
import demo.ongrid.payment.model.response.PaymentResponse;
import demo.ongrid.payment.service.PaymentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    private StudentDao studentDao;
    private PaymentDao paymentDao;
    private ModelMapper modelMapper;
    @Autowired
    public PaymentServiceImpl(StudentDao studentDao, PaymentDao paymentDao, ModelMapper modelMapper){
        this.studentDao = studentDao;
        this.paymentDao = paymentDao;
        this.modelMapper = modelMapper;
    }

    @Override
    public ResponseEntity<PaymentResponse> updatePayment(PaymentRequest paymentRequest) {
        String rollNumber = paymentRequest.getRollNumber();
        Integer amount = paymentRequest.getAmount();

        Student student = studentDao.findByRollNumber(rollNumber);
        Integer paymentId = student.getThePayment().getPaymentId();

        java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = sdf.format(dt);

        Payment updatedPayment = paymentDao.updatePayment(paymentId, amount, "Payment Received!!", currentTime);
        PaymentDto paymentDto = modelMapper.map(updatedPayment, PaymentDto.class);


        // creating a response
        PaymentResponse paymentResponse = new PaymentResponse(paymentDto.getPaymentId(), paymentDto.getStatus());
        return new ResponseEntity<>(paymentResponse, HttpStatus.OK);

    }
}
