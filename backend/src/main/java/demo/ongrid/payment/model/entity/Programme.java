package demo.ongrid.payment.model.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//@Configuration
@Entity
@Table(name="programme")
public class Programme {

    // annotate the clas with entity and map to db table
    // create entity fields and annotate the fields
    // create constructor
    // create getter and setter methods

    /*
    Entity Name - programme
    Attributes -
    programmeId - Integer, Primary key
    programmeName - String, Unique Key
    tuitionFee - Integer
    libraryFee -  Integer
    messFee  - Integer
    medicalFee -  Integer
    hostelFee - Integer
    Amount - Integer
    created - Date
    updated - Date
     */

    @Id
    @Column(name="programmeId")
    private Integer programmeId;

    @Column(name="programmeName")
    private String programmeName;

    @Column(name="tuitionFee")
    private Integer tuitionFee;

    @Column(name="libraryFee")
    private Integer libraryFee;

    @Column(name="messFee")
    private Integer messFee;

    @Column(name="medicalFee")
    private Integer medicalFee;

    @Column(name="hostelFee")
    private Integer hostelFee;

    @Column(name="amount")
    private Integer amount;

    @Column(name="created")
    private String created;

    @Column(name="updated")
    private String updated;

    public Programme(){

    }
    public Programme(Integer programmeId, String programmeName, Integer tuitionFee, Integer libraryFee, Integer messFee, Integer medicalFee, Integer hostelFee, Integer amount, String created, String updated) {
        this.programmeId = programmeId;
        this.programmeName = programmeName;
        this.tuitionFee = tuitionFee;
        this.libraryFee = libraryFee;
        this.messFee = messFee;
        this.medicalFee = medicalFee;
        this.hostelFee = hostelFee;
        this.amount = amount;
        this.created = created;
        this.updated = updated;
    }

    public Integer getProgrammeId() {
        return programmeId;
    }

    public void setProgrammeId(Integer programmeId) {
        this.programmeId = programmeId;
    }

    public String getProgrammeName() {
        return programmeName;
    }

    public void setProgrammeName(String programmeName) {
        this.programmeName = programmeName;
    }

    public Integer getTuitionFee() {
        return tuitionFee;
    }

    public void setTuitionFee(Integer tuitionFee) {
        this.tuitionFee = tuitionFee;
    }

    public Integer getLibraryFee() {
        return libraryFee;
    }

    public void setLibraryFee(Integer libraryFee) {
        this.libraryFee = libraryFee;
    }

    public Integer getMessFee() {
        return messFee;
    }

    public void setMessFee(Integer messFee) {
        this.messFee = messFee;
    }

    public Integer getMedicalFee() {
        return medicalFee;
    }

    public void setMedicalFee(Integer medicalFee) {
        this.medicalFee = medicalFee;
    }

    public Integer getHostelFee() {
        return hostelFee;
    }

    public void setHostelFee(Integer hostelFee) {
        this.hostelFee = hostelFee;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
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
}
