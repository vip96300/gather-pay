package org.xxpay.dal.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.xxpay.dal.dao.model.MchLog;
import org.xxpay.dal.dao.model.MchLogExample;

public interface MchLogMapper {
    long countByExample(MchLogExample example);

    int deleteByExample(MchLogExample example);

    int deleteByPrimaryKey(String logId);

    int insert(MchLog record);

    int insertSelective(MchLog record);

    List<MchLog> selectByExample(MchLogExample example);

    MchLog selectByPrimaryKey(String logId);

    int updateByExampleSelective(@Param("record") MchLog record, @Param("example") MchLogExample example);

    int updateByExample(@Param("record") MchLog record, @Param("example") MchLogExample example);

    int updateByPrimaryKeySelective(MchLog record);

    int updateByPrimaryKey(MchLog record);
}