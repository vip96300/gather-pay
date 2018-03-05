package org.xxpay.mgr.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.xxpay.dal.dao.mapper.MchLogMapper;
import org.xxpay.dal.dao.model.MchLogExample;

import java.util.Calendar;

/**
 * @Author huanghongfei
 * @Description 定时删除商户日志
 * @Date Create in 10:39 2018/3/2
 */
@Component
public class MchLogTask {

    @Autowired
    private MchLogMapper mchLogMapper;

    @Scheduled(cron="0 0 0 ? * MON")
    public void delete(){
        MchLogExample mchLogExample=new MchLogExample();
        Calendar date=Calendar.getInstance();
        date.set(Calendar.DATE,date.get(Calendar.DATE)-7);
        mchLogExample.createCriteria().andCreateTimeLessThan(date.getTime());
        mchLogMapper.deleteByExample(mchLogExample);
    }
}
