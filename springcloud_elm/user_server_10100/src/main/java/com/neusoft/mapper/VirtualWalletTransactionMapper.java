package com.neusoft.mapper;

import com.neusoft.po.VirtualWalletTransaction;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface VirtualWalletTransactionMapper {
	public List<VirtualWalletTransaction> listTransByUserId(String userId);

	@Insert("insert into virtualwallettransaction(transactionId,transactionDate,amount,walletInId,walletOutId,transactionType,businessId) values(null,#{transactionDate},#{amount},#{walletInId},#{walletOutId},#{transactionType},#{businessId})")
	public int saveVirtualWalletTransaction(VirtualWalletTransaction virtualWalletTransaction);
}
