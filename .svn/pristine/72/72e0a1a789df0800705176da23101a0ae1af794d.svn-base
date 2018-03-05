package org.xxpay.mapper;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.xxpay.BaseTest;
import org.xxpay.dal.dao.mapper.MchLogMapper;
import org.xxpay.dal.dao.model.MchLogExample;

import java.util.Calendar;

/**
 * @Author huanghongfei
 * @Description
 * @Date Create in 14:21 2018/3/2
 */
public class MchLogMapperTest extends BaseTest{

    @Autowired
    private MchLogMapper mchLogMapper;

    @Test
    public void delete(){
        MchLogExample mchLogExample=new MchLogExample();
        Calendar date=Calendar.getInstance();
        date.set(Calendar.DATE,date.get(Calendar.DATE)-7);
        mchLogExample.createCriteria().andCreateTimeLessThan(date.getTime());
        mchLogMapper.deleteByExample(mchLogExample);
    }

}
