package com.neusoft.po;

import com.neusoft.util.CommonUtil;

public class CreditsRecord {
	private Integer recordId;
	private String userId;
	private Integer credits;
	private String addDate;

	public CreditsRecord() {
	};

	public CreditsRecord(String userId, Integer credits) {
		setUserId(userId);
		setCredits(credits);
		setAddDate(CommonUtil.getCurrentDate());
	}

	public Integer getRecordId() {
		return recordId;
	}

	public void setRecordId(Integer recordId) {
		this.recordId = recordId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Integer getCredits() {
		return credits;
	}

	public void setCredits(Integer credits) {
		this.credits = credits;
	}

	public String getAddDate() {
		return addDate;
	}

	public void setAddDate(String addDate) {
		this.addDate = addDate;
	}

}
