package org.xxpay.mgr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.xxpay.dal.dao.mapper.PayPlatformMapper;
import org.xxpay.dal.dao.model.PayPlatform;
import org.xxpay.dal.dao.model.PayPlatformExample;

import java.util.Date;
import java.util.List;

/**
 * @Author huanghongfei
 * @Description
 * @Date Create in 16:59 2018/3/3
 */
@Service
public class PayPlatformService {

    @Autowired
    private PayPlatformMapper payPlatformMapper;

    public long count(PayPlatform payPlatform){
        PayPlatformExample example = new PayPlatformExample();
        PayPlatformExample.Criteria criteria = example.createCriteria();
        setCriteria(criteria, payPlatform);
        return payPlatformMapper.countByExample(example);
    }

    public List<PayPlatform> list(int offset, int limit,PayPlatform payPlatform) {
        PayPlatformExample example = new PayPlatformExample();
        example.setOrderByClause("create_time DESC");
        example.setOffset(offset);
        example.setLimit(limit);
        PayPlatformExample.Criteria criteria = example.createCriteria();
        setCriteria(criteria, payPlatform);
        return payPlatformMapper.selectByExample(example);
    }

    void setCriteria(PayPlatformExample.Criteria criteria,PayPlatform payPlatform) {
        if(payPlatform != null) {

        }
    }

    @Async
    public void add(PayPlatform payPlatform){
        payPlatformMapper.insert(payPlatform);
    }

    public PayPlatform getById(int id){
        return payPlatformMapper.selectByPrimaryKey(id);
    }

    @Async
    public void update(PayPlatform payPlatform){
        payPlatform.setUpdateTime(new Date());
        payPlatformMapper.updateByPrimaryKey(payPlatform);
    }
    @Async
    public void delete(int id){
        // TODO
    }
}
