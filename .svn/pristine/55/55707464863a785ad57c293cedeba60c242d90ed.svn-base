package org.xxpay.dubbo.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.xxpay.common.domain.BaseParam;
import org.xxpay.common.enumm.RetEnum;
import org.xxpay.common.util.JsonUtil;
import org.xxpay.common.util.ObjectValidUtil;
import org.xxpay.common.util.RpcUtil;
import org.xxpay.dal.dao.mapper.PayPlatformMapper;
import org.xxpay.dal.dao.model.PayPlatform;
import org.xxpay.dubbo.api.service.IPayPlatformService;

import java.util.Map;

@Service(version = "1.0.0")
public class PayPlatformServiceImpl implements IPayPlatformService {

    private static Logger log = LoggerFactory.getLogger(PayPlatformServiceImpl.class);
    @Autowired
    private PayPlatformMapper payPlatformMapper;

    @Override
    public Map selectPlatform(String jsonParam) {
        BaseParam baseParam = JsonUtil.getObjectFromJson(jsonParam, BaseParam.class);
        Map<String, Object> bizParamMap = baseParam.getBizParamMap();
        if (ObjectValidUtil.isInvalid(bizParamMap)) {
            log.warn("查询支付平台失败, {}. jsonParam={} ", RetEnum.RET_PARAM_NOT_FOUND.getMessage(), jsonParam);
            return RpcUtil.createFailResult(baseParam, RetEnum.RET_PARAM_NOT_FOUND);
        }
        String payType = baseParam.isNullValue("payType") ? null : bizParamMap.get("payType").toString();
        if (ObjectValidUtil.isInvalid(payType)) {
            log.warn("查询支付平台失败, {}. jsonParam={} ", RetEnum.RET_PARAM_INVALID.getMessage(), jsonParam);
            return RpcUtil.createFailResult(baseParam, RetEnum.RET_PARAM_INVALID);
        }
        PayPlatform payPlatform = payPlatformMapper.selectPlatform(payType);
        if(payPlatform == null) return RpcUtil.createFailResult(baseParam, RetEnum.RET_BIZ_DATA_NOT_EXISTS);
        String jsonResult = JsonUtil.object2Json(payPlatform);
        return RpcUtil.createBizResult(baseParam, jsonResult);
    }
}
