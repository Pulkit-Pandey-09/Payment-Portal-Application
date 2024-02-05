package demo.ongrid.payment.model.entity;


import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;


@Entity
@Table(name="student")
public class Student implements UserDetails {

    // annotate the clas with entity and map to db table
    // create entity fields and annotate the fields
    // set up mapping with programme and payment
    // create constructor
    // create getter and setter methods
    // create to_string() method

    /* Entity Name - student
    Attributes -
    rollNumber - String, Primary key
    firstName - String
    lastName - String
    collegeId - String, Unique Key
    password - String/hash Value
    programme_Id - Integer , Foreign Key  - left
    payment_Id  - Integer, Foreign Key    - left
    created - Date
    updated - Date
    Deleted - boolean */

    @Id
    @Column(name="rollNumber")
    private String rollNumber;

    @Column(name="firstName")
    private String fistName;

    @Column(name="lastName")
    private String lastName;

//    @Column(name="collegeId")
//    private String collegeId;

    @Column(name="password")
    private String password;

    @Column(name="created")
    private String created;

    @Column(name="updated")
    private String updated;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="programme_Id")
    private Programme theProgramme;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="payment_Id")
    private Payment thePayment;

    public Student(){

    }

    public Student(String rollNumber, String fistName, String lastName,
                   String password,
                   String created, String updated) {
        this.rollNumber = rollNumber;
        this.fistName = fistName;
        this.lastName = lastName;
//        this.collegeId = collegeId;
        this.password = password;
        this.created = created;
        this.updated = updated;
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


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return this.rollNumber;
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
    public String toString() {
        return "student{" +
                "rollNumber='" + rollNumber + '\'' +
                ", fistName='" + fistName + '\'' +
                ", lastName='" + lastName + '\'' +
//                ", collegeId='" + collegeId + '\'' +
                ", password='" + password + '\'' +
                ", created=" + created +
                ", updated=" + updated +
                ", theProgramme=" + theProgramme +
                ", thePayment=" + thePayment +
                '}';
    }
}
