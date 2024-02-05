package demo.ongrid.payment.service.Impl;

import demo.ongrid.payment.config.security.JwtTokenHelper;
import demo.ongrid.payment.dao.StudentDao;
import demo.ongrid.payment.model.dto.PaymentDto;
import demo.ongrid.payment.model.dto.ProgrammeDto;
import demo.ongrid.payment.model.dto.StudentDto;
import demo.ongrid.payment.model.entity.Payment;
import demo.ongrid.payment.model.entity.Programme;
import demo.ongrid.payment.model.entity.Student;
import demo.ongrid.payment.model.request.JwtAuthRequest;
import demo.ongrid.payment.model.response.JwtAuthResponse;
import demo.ongrid.payment.service.LoginService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginServiceImpl implements LoginService {

    private AuthenticationManager authenticationManager;  // provided by spring security
    private UserDetailsService userDetailsService;
    private JwtTokenHelper jwtTokenHelper;
    private StudentDao studentDao;
    private ModelMapper modelMapper;
    @Autowired
    public LoginServiceImpl(AuthenticationManager authenticationManager, UserDetailsService userDetailsService, JwtTokenHelper jwtTokenHelper, StudentDao studentDao, ModelMapper modelMapper){
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtTokenHelper = jwtTokenHelper;
        this.studentDao = studentDao;
        this.modelMapper = modelMapper;
    }

    @Override
    public ResponseEntity<JwtAuthResponse> loginResponse(JwtAuthRequest request) {

        /*
            UsernamePasswordAuthenticationToken: This is a specific implementation of the Authentication
            interface used to encapsulate the user's credentials (username and password) for authentication.

            Once the authentication process is successful, the authentication object will contain details about the
            authenticated user(username, password, etc). This authenticated authentication object is then used for further authentication/authorization
            checks or stored in the security context for the current user session.
            If authentication fails it will throw an error
         */
        // Authentication
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(request.getRollNumber(), request.getPassword());
        Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);  //Once the authentication process is successful, the authentication object will contain details about the authenticated user. This authenticated authentication object is then used for further authentication/authorization checks or stored in the security context for the current user session. If authentication fails it will throw an error

        // Setting authentication in Security context holder
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Generating Jwt token
        String token = jwtTokenHelper.generateToken(authentication);


        // creating response body
        String rollNumber = authentication.getName();
        Student student = studentDao.findByRollNumber(rollNumber);
        StudentDto studentDto = modelMapper.map(student,StudentDto.class);


        Map<String, String> user = new HashMap<>();
        Map<String, String> programme = new HashMap<>();
        Map<String, String> payment = new HashMap<>();
        Map<String, String> accessToken = new HashMap<>();

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
        accessToken.put("token", token);


        JwtAuthResponse jwtAuthResponse = new JwtAuthResponse(user, programme, payment, accessToken);
        return new ResponseEntity<>(jwtAuthResponse, HttpStatus.OK);
    }
}
