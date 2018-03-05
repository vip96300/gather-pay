package org.xxpay.mgr.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.xxpay.dal.dao.mapper.MchCashMapper;
import org.xxpay.dal.dao.model.MchCash;
import org.xxpay.dal.dao.model.MchCashExample;

import java.util.List;

/**
 * @Author huanghongfei
 * @Description
 * @Date Create in 17:50 2018/3/2
 */
@Service
public class MchCashService {

    @Autowired
    private MchCashMapper mchCashMapper;

    public long count(MchCash mchCash){
        MchCashExample example = new MchCashExample();
        MchCashExample.Criteria criteria = example.createCriteria();
        setCriteria(criteria, mchCash);
        return mchCashMapper.countByExample(example);
    }

    public List<MchCash> list(MchCash mchCash,int page,int size){
        MchCashExample example = new MchCashExample();
        example.setOrderByClause("createTime DESC");
        example.setOffset((page-1)*size);
        example.setLimit(size);
        MchCashExample.Criteria criteria = example.createCriteria();
        setCriteria(criteria, mchCash);
        return mchCashMapper.selectByExample(example);
    }

    void setCriteria(MchCashExample.Criteria criteria, MchCash mchCash) {
        if(mchCash != null) {
            if(StringUtils.isNotBlank(mchCash.getMchId())) criteria.andMchIdEqualTo(mchCash.getMchId());criteria.andIsDelEqualTo(0);
            if(mchCash.getStatus() != null && -99!=mchCash.getStatus()) criteria.andStatusEqualTo(mchCash.getStatus());
        }
    }
    @Async
    public void delete(String cashId){
        MchCash mchCash=mchCashMapper.selectByPrimaryKey(cashId);
        mchCash.setIsDel(1);
        mchCashMapper.updateByPrimaryKey(mchCash);
    }

    public MchCash getByCashId(String cashId){
        return mchCashMapper.selectByPrimaryKey(cashId);
    }
}
