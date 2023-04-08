package com.neusoft.po;

public class VirtualWallet {
	private String userId;
	private Double balance;

	public String getuserId() {
		return userId;
	}

	public void setuserId(String userId) {
		this.userId = userId;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public void topUp(Double amount) {
		this.balance += amount;
	}

	public void deduct(Double amount) throws Exception {
		if (this.balance >= amount) {
			this.balance -= amount;
		} else {
			throw new Exception("余额不足");
		}
	}
}