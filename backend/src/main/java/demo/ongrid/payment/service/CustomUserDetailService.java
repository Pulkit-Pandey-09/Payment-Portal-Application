package demo.ongrid.payment.service;


import demo.ongrid.payment.dao.StudentDao;
import demo.ongrid.payment.model.dto.StudentDto;
import demo.ongrid.payment.model.entity.Student;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


/*
Custom implementation of UserDetailsService named CustomUserDetailsService. I have override  the loadUserByName method.
During authentication, authenticate manager will use this custom implementation to retrieve users data from database.
 */
@Service
public class CustomUserDetailService implements UserDetailsService {

    private StudentDao studentDAO;
    private ModelMapper modelMapper;
    @Autowired
    public  CustomUserDetailService(StudentDao studentDao, ModelMapper modelMapper){
        this.studentDAO = studentDao;
        this.modelMapper = modelMapper;
    }
    @Override
    public UserDetails loadUserByUsername(String rollNumber) throws UsernameNotFoundException {
        // loading user from database by rollNumber;
         Student tempStudent = studentDAO.findByRollNumber(rollNumber);    //.orElseThrow(()->new UsernameNotFoundException("Student not found")); // need to implement exception here
         StudentDto studentDto = modelMapper.map(tempStudent, StudentDto.class);
         return studentDto;
    }
}
