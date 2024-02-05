package demo.ongrid.payment.controller;

import demo.ongrid.payment.model.request.InfoRequest;
import demo.ongrid.payment.model.request.JwtAuthRequest;
import demo.ongrid.payment.model.request.PaymentRequest;
import demo.ongrid.payment.model.response.InfoResponse;
import demo.ongrid.payment.model.response.JwtAuthResponse;
import demo.ongrid.payment.model.response.PaymentResponse;
import demo.ongrid.payment.model.response.ReceiptResponse;
import demo.ongrid.payment.service.InfoService;
import demo.ongrid.payment.service.LoginService;
import demo.ongrid.payment.service.PaymentService;
import demo.ongrid.payment.service.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
@CrossOrigin(origins = {"http://localhost:3000"}, methods = {RequestMethod.OPTIONS, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
public class StudentController {

    LoginService loginService;
    PaymentService paymentService;
    ReceiptService receiptService;
    InfoService infoService;

    @Autowired
    public StudentController(LoginService loginService, PaymentService paymentService, ReceiptService receiptService, InfoService infoService){
        this.loginService = loginService;
        this.paymentService = paymentService;
        this.receiptService = receiptService;
        this.infoService = infoService;
    }

    @PostMapping("/login")
    public ResponseEntity<JwtAuthResponse> studentLogin(@RequestBody JwtAuthRequest request) {
//        System.out.println(request.getRollNumber());
        return loginService.loginResponse(request);

    }

    @PostMapping("/logout")
    public ResponseEntity<String> studentLogout() {
        return ResponseEntity.ok("Log out successful");
    }

    @PostMapping("/info")
    public ResponseEntity<InfoResponse> studentDetails(@RequestBody InfoRequest Id) {
        return infoService.getDetails(Id);
    }

//    @PostMapping("/payment")
    @PutMapping("/payment")
    public ResponseEntity<PaymentResponse> studentPayment(@RequestBody PaymentRequest request){
        ResponseEntity<PaymentResponse> paymentResponseResponseEntity = paymentService.updatePayment(request);;
        return paymentResponseResponseEntity;
    }


    @GetMapping("/payment/{paymentId}")
    public ResponseEntity<ReceiptResponse> paymentReceipt(@PathVariable("paymentId") Integer payment_Id){
        return receiptService.getPaymentStatus(payment_Id);
    }
}

