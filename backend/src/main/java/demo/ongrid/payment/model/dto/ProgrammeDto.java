package demo.ongrid.payment.model.dto;


public class ProgrammeDto {

    private String programmeName;
    private Integer tuitionFee;
    private Integer libraryFee;
    private Integer messFee;
    private Integer medicalFee;
    private Integer hostelFee;
    private Integer amount;

    public ProgrammeDto(){

    }

    public ProgrammeDto(String programmeName, Integer tuitionFee, Integer libraryFee, Integer messFee, Integer medicalFee, Integer hostelFee, Integer amount) {
        this.programmeName = programmeName;
        this.tuitionFee = tuitionFee;
        this.libraryFee = libraryFee;
        this.messFee = messFee;
        this.medicalFee = medicalFee;
        this.hostelFee = hostelFee;
        this.amount = amount;
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
}
