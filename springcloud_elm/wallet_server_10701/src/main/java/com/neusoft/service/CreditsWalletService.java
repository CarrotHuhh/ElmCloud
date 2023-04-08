package com.neusoft.service;

import com.neusoft.po.CreditsRecord;

import java.util.List;

public interface CreditsWalletService {
	public Integer getCreditsById(String userId);

	public int creditsAdd(Integer amount, String userId);

	public int creditsDeduct(Integer amount, String userId);

	public int updateValidState(String userId);
	
	public List<CreditsRecord> getCreditsRecordById(String userId);
}
