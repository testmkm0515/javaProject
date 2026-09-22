package com.spring_boot.projectEx.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class MemberDTO {
	//테이블컬럼명, DTO 필드명, 파라미터명을 모두 동일하게 구성
	private String memId;
	private String memPwd;
	private String memName;
	private String memEmail;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date memJoinDate;
	private String memHp;
	private String memZipcode;
	private String memAddress1;
	private String memAddress2;
	
	public MemberDTO() {}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getMemPwd() {
		return memPwd;
	}

	public void setMemPwd(String memPwd) {
		this.memPwd = memPwd;
	}

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public String getMemEmail() {
		return memEmail;
	}

	public void setMemEmail(String memEmail) {
		this.memEmail = memEmail;
	}

	public Date getMemJoinDate() {
		return memJoinDate;
	}

	public void setMemJoinDate(Date memJoinDate) {
		this.memJoinDate = memJoinDate;
	}

	public String getMemHp() {
		return memHp;
	}

	public void setMemHp(String memHp) {
		this.memHp = memHp;
	}

	public String getMemZipcode() {
		return memZipcode;
	}

	public void setMemZipcode(String memZipcode) {
		this.memZipcode = memZipcode;
	}

	public String getMemAddress1() {
		return memAddress1;
	}

	public void setMemAddress1(String memAddress1) {
		this.memAddress1 = memAddress1;
	}

	public String getMemAddress2() {
		return memAddress2;
	}

	public void setMemAddress2(String memAddress2) {
		this.memAddress2 = memAddress2;
	}
	
	
}
