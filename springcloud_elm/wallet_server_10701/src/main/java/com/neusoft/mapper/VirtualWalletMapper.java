package com.neusoft.mapper;

import com.neusoft.po.VirtualWallet;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface VirtualWalletMapper {

	@Select("select * from virtualWallet where userId=#{userId}")
	public VirtualWallet getVirtualWalletById(String userId);

	@Update("update virtualwallet set balance=#{balance} where userId=#{userId}")
	public int updateBalance(Double balance, String userId);
	
	@Insert("insert into virtualwallet(userId,balance) values(#{userId},0.0)")
	public int saveVirtualWallet(String userId);
	
	@Select("select balance from virtualwallet where userId = #{userId}")
	public Double getVirtualWalletbalance(String userId);
}
