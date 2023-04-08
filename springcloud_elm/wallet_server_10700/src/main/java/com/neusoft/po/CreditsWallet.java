package com.neusoft.po;

import com.neusoft.util.CommonUtil;

public class CreditsWallet {
	private Integer creditsId;
	private String userId;
	private Integer credits;
	private Integer remainCredits;
	private String addDate;
	private String validDate;
	private int isValid;

	public CreditsWallet() {
	};
	public CreditsWallet(String userId, Integer credits) {
		setUserId(userId);
		setCredits(credits);
		setRemainCredits(credits);
		setAddDate(CommonUtil.getCurrentDate());
		setValidDate(CommonUtil.creditsValidDate());
		setIsValid(1);
	}

	public Integer getCreditsId() {
		return creditsId;
	}

	public void setCreditsId(Integer creditsId) {
		this.creditsId = creditsId;
	}

	public Integer getRemainCredits() {
		return remainCredits;
	}

	public void setRemainCredits(Integer remainCredits) {
		this.remainCredits = remainCredits;
	}

	public int getIsValid() {
		return isValid;
	}

	public void setIsValid(int isValid) {
		this.isValid = isValid;
	}

	public String getValidDate() {
		return validDate;
	}

	public void setValidDate(String validDate) {
		this.validDate = validDate;
	}

	public String getAddDate() {
		return addDate;
	}

	public void setAddDate(String addDate) {
		this.addDate = addDate;
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

	public void creditsDeduct(Integer amount) {
		this.remainCredits -= amount;
	}

	public boolean isCreditsValid(CreditsWallet creditsWallet) {
		String validDateStr = creditsWallet.getValidDate();
		String[] validDate = validDateStr.substring(0, 10).split("-");
		String[] validTime = validDateStr.substring(11).split(":");

		String currentDate = CommonUtil.getCurrentDate();
		String[] curDate = currentDate.substring(0, 10).split("-");
		String[] curTime = currentDate.substring(11).split(":");

		Integer[] validDateInt = new Integer[3];
		Integer[] validTimeInt = new Integer[3];
		Integer[] curDateInt = new Integer[3];
		Integer[] curTimeInt = new Integer[3];
		for (int i = 0; i < 3; i++) {
			validDateInt[i] = Integer.valueOf(validDate[i]).intValue();
			validTimeInt[i] = Integer.valueOf(validTime[i]).intValue();
			curDateInt[i] = Integer.valueOf(curDate[i]).intValue();
			curTimeInt[i] = Integer.valueOf(curTime[i]).intValue();
		}
		for (int i = 0; i < 3; i++) {
			if (validDateInt[i] > curDateInt[i])
				return true;
			else if (validDateInt[i] < curDateInt[i])
				return false;
		}
		for (int i = 0; i < 3; i++) {
			if (validTimeInt[i] > curTimeInt[i])
				return true;
			else if (validTimeInt[i] < curTimeInt[i])
				return false;
		}
		return true;
	}
}
