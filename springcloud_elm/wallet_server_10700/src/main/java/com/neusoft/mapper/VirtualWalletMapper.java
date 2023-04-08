package com.neusoft.mapper;

import org.apache.ibatis.annotations.*;

import com.neusoft.po.VirtualWallet;

@Mapper
public interface VirtualWalletMapper {

	@Select("select * from virtualWallet where userId=#{userId}")
	public VirtualWallet getVirtualWalletById(String userId);

	@Update("update virtualwallet set balance=#{balance} where userId=#{userId}")
	public Integer updateBalance(@Param("balance") Double balance, @Param("userId")String userId);

	@Insert("insert into virtualwallet(userId,balance) values(#{userId},0.0)")
	public int saveVirtualWallet(String userId);

	@Select("select balance from virtualwallet where userId = #{userId}")
	public Double getVirtualWalletbalance(String userId);
}
