package org.xxpay.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.xxpay.dal.dao.model.PayOrder;
import org.xxpay.mgr.constant.PageConstants;
import org.xxpay.mgr.service.PayOrderService;

import org.xxpay.BaseTest;

import java.util.List;

/**
 * @Author huanghongfei
 * @Description
 * @Date Create in 11:51 2018/2/26
 */
public class PayOrderServiceTest extends BaseTest{

    @Autowired
    private PayOrderService payOrderService;

    @Test
    public void listByMchId(){

    }
}
