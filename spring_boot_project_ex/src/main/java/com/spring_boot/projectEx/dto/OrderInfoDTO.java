package com.spring_boot.projectEx.dto;

public class OrderInfoDTO {
	private String ordNo;
	private String ordDate;
	private String memId;
	private String ordRcvReceiver;
	private String ordRcvZipcode;
	private String ordRcvAddress1;
	private String ordRcvAddress2;
	private String ordRcvPhone;
	private String ordRcvMsg;
	private String ordPay;
	
	public String getOrdNo() {
		return ordNo;
	}
	public void setOrdNo(String ordNo) {
		this.ordNo = ordNo;
	}
	public String getOrdDate() {
		return ordDate;
	}
	public void setOrdDate(String ordDate) {
		this.ordDate = ordDate;
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getOrdRcvReceiver() {
		return ordRcvReceiver;
	}
	public void setOrdRcvReceiver(String ordRcvReceiver) {
		this.ordRcvReceiver = ordRcvReceiver;
	}
	public String getOrdRcvZipcode() {
		return ordRcvZipcode;
	}
	public void setOrdRcvZipcode(String ordRcvZipcode) {
		this.ordRcvZipcode = ordRcvZipcode;
	}
	public String getOrdRcvAddress1() {
		return ordRcvAddress1;
	}
	public void setOrdRcvAddress1(String ordRcvAddress1) {
		this.ordRcvAddress1 = ordRcvAddress1;
	}
	public String getOrdRcvAddress2() {
		return ordRcvAddress2;
	}
	public void setOrdRcvAddress2(String ordRcvAddress2) {
		this.ordRcvAddress2 = ordRcvAddress2;
	}
	public String getOrdRcvPhone() {
		return ordRcvPhone;
	}
	public void setOrdRcvPhone(String ordRcvPhone) {
		this.ordRcvPhone = ordRcvPhone;
	}
	public String getOrdRcvMsg() {
		return ordRcvMsg;
	}
	public void setOrdRcvMsg(String ordRcvMsg) {
		this.ordRcvMsg = ordRcvMsg;
	}
	public String getOrdPay() {
		return ordPay;
	}
	public void setOrdPay(String ordPay) {
		this.ordPay = ordPay;
	}
	
	
}
