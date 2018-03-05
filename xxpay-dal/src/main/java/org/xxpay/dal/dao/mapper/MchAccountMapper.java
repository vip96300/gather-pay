package org.xxpay.dal.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.xxpay.dal.dao.model.MchAccount;
import org.xxpay.dal.dao.model.MchAccountExample;

public interface MchAccountMapper {
    long countByExample(MchAccountExample example);

    int deleteByExample(MchAccountExample example);

    int deleteByPrimaryKey(String accountId);

    int insert(MchAccount record);

    int insertSelective(MchAccount record);

    List<MchAccount> selectByExample(MchAccountExample example);

    MchAccount selectByPrimaryKey(String accountId);

    int updateByExampleSelective(@Param("record") MchAccount record, @Param("example") MchAccountExample example);

    int updateByExample(@Param("record") MchAccount record, @Param("example") MchAccountExample example);

    int updateByPrimaryKeySelective(MchAccount record);

    int updateByPrimaryKey(MchAccount record);
}