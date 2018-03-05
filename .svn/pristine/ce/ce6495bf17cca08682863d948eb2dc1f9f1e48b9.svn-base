package org.xxpay.dal.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.xxpay.dal.dao.model.MchCard;
import org.xxpay.dal.dao.model.MchCardExample;

public interface MchCardMapper {
    long countByExample(MchCardExample example);

    int deleteByExample(MchCardExample example);

    int deleteByPrimaryKey(String cardId);

    int insert(MchCard record);

    int insertSelective(MchCard record);

    List<MchCard> selectByExample(MchCardExample example);

    MchCard selectByPrimaryKey(String cardId);

    int updateByExampleSelective(@Param("record") MchCard record, @Param("example") MchCardExample example);

    int updateByExample(@Param("record") MchCard record, @Param("example") MchCardExample example);

    int updateByPrimaryKeySelective(MchCard record);

    int updateByPrimaryKey(MchCard record);

    @Select("select * from t_mch_card o where o.bankNo=#{bankNo}")
    MchCard getByBankNo(@Param("bankNo") String bankNo);
}