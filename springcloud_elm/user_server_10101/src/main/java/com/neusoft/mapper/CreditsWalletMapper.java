package com.neusoft.mapper;

import com.neusoft.po.CreditsRecord;
import com.neusoft.po.CreditsWallet;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface CreditsWalletMapper {
	@Insert("insert into creditsrecord values(null,#{userId},#{credits},#{addDate})")
	public int saveCreditsRecord(CreditsRecord creditsRecord);
	
	@Insert("insert into creditswallet values(null,#{userId},#{credits},#{credits},#{addDate},#{validDate},1)")
	public int saveCreditsWallet(CreditsWallet creditsWallet);
	
	@Select("select * from creditswallet where userId=#{userId} and isValid=1")
	public List<CreditsWallet> getCreditsWalletById(String userId);
	
	@Select("select * from creditsRecord where userId=#{userId}")
	public List<CreditsRecord> getCreditsRecordById(String userId);

	@Update("update creditswallet set remainCredits=#{remainCredits} where creditsId=#{creditsId}")
	public int creditsDeduct(CreditsWallet creditsWallet);
	
	@Update("update creditswallet set isValid=0 where creditsId=#{creditsId}")
	public int updateValidState(Integer creditsId);
}
