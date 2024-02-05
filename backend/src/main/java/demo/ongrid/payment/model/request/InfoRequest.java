package demo.ongrid.payment.model.request;

public class InfoRequest {

	private String rollNumber;

	public InfoRequest(){

	}
	public InfoRequest(String rollNumber) {
		this.rollNumber = rollNumber;
	}

	public String getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(String rollNumber) {
		this.rollNumber = rollNumber;
	}
}
