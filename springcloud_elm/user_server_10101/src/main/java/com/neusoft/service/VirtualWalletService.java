package com.neusoft.service;

import com.neusoft.po.VirtualWallet;
import com.neusoft.po.VirtualWalletTransaction;

import java.util.List;

public interface VirtualWalletService {
	public VirtualWallet getVirtualWalletById(String userId);

	public int deduct(Double amount, String userId) throws Exception;

	public int withdraw(Double amount, String userId, String walletInId) throws Exception;

	public int topUp(Double amount, String userId, String walletOutId) throws Exception;

	public Double getVirtualWalletBalance(String userId);

	public List<VirtualWalletTransaction> listTransByUserId(String userId);

	public int payByWallet(Integer orderId, String userId) throws Exception;
}
