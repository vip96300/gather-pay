package org.xxpay.mgr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.xxpay.dal.dao.mapper.MchLogMapper;
import org.xxpay.dal.dao.model.MchLog;

/**
 * @Author huanghongfei
 * @Description
 * @Date Create in 9:33 2018/3/2
 */
@Service
public class MchLogService {

    @Autowired
    private MchLogMapper mchLogMapper;

    @Async
    public void add(MchLog mchLog){
        mchLogMapper.insert(mchLog);
    }

}
