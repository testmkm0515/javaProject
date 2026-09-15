package com.spring.jdbcProject.dto;

import java.util.Date;

public class MemberDTO {
	private String memId;
	private String memPwd;
	private String memName;
	private String memEmail;
	private Date memJoinDate;
	
	public MemberDTO() {}
	
	public MemberDTO(String memId, String memPwd, String memName, String memEmail, Date memJoinDate) {
		super();
		this.memId = memId;
		this.memPwd = memPwd;
		this.memEmail=memEmail;
		this.memName=memName;
		this.memJoinDate = memJoinDate;
		
	}

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
	
	
}
