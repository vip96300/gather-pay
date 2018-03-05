package org.xxpay.dal.dao.mapper;

import org.apache.ibatis.annotations.Param;
import org.xxpay.dal.dao.model.PayConfig;
import org.xxpay.dal.dao.model.PayConfigExample;

import java.util.List;

public interface PayConfigMapper {
    long countByExample(PayConfigExample example);

    int deleteByExample(PayConfigExample example);

    int deleteByPrimaryKey(String code);

    int insert(PayConfig record);

    int insertSelective(PayConfig record);

    List<PayConfig> selectByExample(PayConfigExample example);

    PayConfig selectByPrimaryKey(String code);

    int updateByExampleSelective(@Param("record") PayConfig record, @Param("example") PayConfigExample example);

    int updateByExample(@Param("record") PayConfig record, @Param("example") PayConfigExample example);

    int updateByPrimaryKeySelective(PayConfig record);

    int updateByPrimaryKey(PayConfig record);
}