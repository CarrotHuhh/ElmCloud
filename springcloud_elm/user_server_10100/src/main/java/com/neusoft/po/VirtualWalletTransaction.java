package com.neusoft.po;

import com.neusoft.util.CommonUtil;

public class VirtualWalletTransaction {
	private String transactionId;
	private String transactionDate;
	private Double amount;
	private String walletInId;
	private String walletOutId;
	private Integer businessId;
	private String businessName;
	private Integer transactionType;

	public VirtualWalletTransaction() {
	};

	public VirtualWalletTransaction(Double amount, Integer transactionType, String walletOutId, String walletInId) {
		setAmount(amount);
		setTransactionDate(CommonUtil.getCurrentDate());
		setTransactionType(transactionType);
		setWalletOutId(walletOutId);
		setWalletInId(walletInId);
		if (transactionType == 1)
			setBusinessId(Integer.valueOf(walletInId));
		else {
			setBusinessId(null);
		}
	}

	public Integer getBusinessId() {
		return businessId;
	}

	public void setBusinessId(Integer businessId) {
		this.businessId = businessId;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public Integer getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(Integer transactionType) {
		this.transactionType = transactionType;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getWalletInId() {
		return walletInId;
	}

	public void setWalletInId(String walletInId) {
		this.walletInId = walletInId;
	}

	public String getWalletOutId() {
		return walletOutId;
	}

	public void setWalletOutId(String walletOutId) {
		this.walletOutId = walletOutId;
	}

}
