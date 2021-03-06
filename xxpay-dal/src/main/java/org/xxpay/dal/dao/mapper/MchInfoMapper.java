package org.xxpay.dal.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.xxpay.dal.dao.model.MchInfo;
import org.xxpay.dal.dao.model.MchInfoExample;

public interface MchInfoMapper {

    long countByExample(MchInfoExample example);

    int deleteByExample(MchInfoExample example);

    int deleteByPrimaryKey(String mchId);

    int insert(MchInfo record);

    int insertSelective(MchInfo record);

    List<MchInfo> selectByExample(MchInfoExample example);

    MchInfo selectByPrimaryKey(String mchId);

    int updateByExampleSelective(@Param("record") MchInfo record, @Param("example") MchInfoExample example);

    int updateByExample(@Param("record") MchInfo record, @Param("example") MchInfoExample example);

    int updateByPrimaryKeySelective(MchInfo record);

    int updateByPrimaryKey(MchInfo record);

    @Select(value="select * from t_mch_info o where o.username=#{username,jdbcType=VARCHAR}")
    MchInfo selectByUsername(@Param("username")String username);

}