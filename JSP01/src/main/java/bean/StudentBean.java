package bean;

public class StudentBean {
	private String stdNo;
	private String stdName;
	private String stdPhone;
	private String stdAddress;
	private int stdYear;
    private String[] stdInterest;
	
	public String[] getStdInterest() {
		return stdInterest;
	}
	public void setStdInterest(String[] stdInterest) {
		this.stdInterest = stdInterest;
	}
	public String getStdNo() {
		return stdNo;
	}
	public void setStdNo(String stdNo) {
		this.stdNo = stdNo;
	}
	public String getStdName() {
		return stdName;
	}
	public void setStdName(String stdName) {
		this.stdName = stdName;
	}
	public String getStdPhone() {
		return stdPhone;
	}
	public void setStdPhone(String stdPhone) {
		this.stdPhone = stdPhone;
	}
	public String getStdAddress() {
		return stdAddress;
	}
	public void setStdAddress(String stdAddress) {
		this.stdAddress = stdAddress;
	}
	public int getStdYear() {
		return stdYear;
	}
	public void setStdYear(int stdYear) {
		this.stdYear = stdYear;
	}
	
	
}
