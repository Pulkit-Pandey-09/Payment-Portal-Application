package demo.ongrid.payment.model.dto;

import demo.ongrid.payment.model.entity.Payment;
import demo.ongrid.payment.model.entity.Programme;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class StudentDto implements UserDetails {

    private String rollNumber;

    private String fistName;

    private String lastName;

   // private String collegeId;

    private String password;

    private String created;

    private String updated;

    private Programme theProgramme;

    private Payment thePayment;

    public StudentDto(){

    }

    public StudentDto(String rollNumber, String fistName, String lastName, String password, String created, String updated, Programme theProgramme, Payment thePayment) {
        this.rollNumber = rollNumber;
        this.fistName = fistName;
        this.lastName = lastName;
//        this.collegeId = collegeId;
        this.password = password;
        this.created = created;
        this.updated = updated;
        this.theProgramme = theProgramme;
        this.thePayment = thePayment;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getFistName() {
        return fistName;
    }

    public void setFistName(String fistName) {
        this.fistName = fistName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

//    public String getCollegeId() {
//        return collegeId;
//    }
//
//    public void setCollegeId(String collegeId) {
//        this.collegeId = collegeId;
//    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public Programme getTheProgramme() {
        return theProgramme;
    }

    public void setTheProgramme(Programme theProgramme) {
        this.theProgramme = theProgramme;
    }

    public Payment getThePayment() {
        return thePayment;
    }

    public void setThePayment(Payment thePayment) {
        this.thePayment = thePayment;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return rollNumber;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String toString() {
        return "StudentDto{" +
                "rollNumber='" + rollNumber + '\'' +
                ", fistName='" + fistName + '\'' +
                ", lastName='" + lastName + '\'' +
//                ", collegeId='" + collegeId + '\'' +
                ", password='" + password + '\'' +
                ", created='" + created + '\'' +
                ", updated='" + updated + '\'' +
                ", theProgramme=" + theProgramme +
                ", thePayment=" + thePayment +
                '}';
    }
}
