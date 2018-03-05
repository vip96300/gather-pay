package org.xxpay.dubbo.web.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xxpay.common.constant.PayTypeEnum;
import org.xxpay.common.util.RpcUtil;

import java.util.HashMap;
import java.util.Map;

@Service
public class PayPlatformService {

    @Autowired
    private RpcCommonService rpcCommonService;

    /**
     * 根据通道商户池获取通道商户信息
     *
     * @param mchId   平台商户ID
     * @param channel 平台商户支付渠道ID
     * @return 通道商户信息
     */
    public JSONObject getByPayType(String mchId, String channel) {
        PayTypeEnum payType = PayTypeEnum.valueOf(channel);
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("mchId", mchId);
        paramMap.put("payType", payType.getCode());
        String jsonParam = RpcUtil.createBaseParam(paramMap);
        Map<String, Object> result = rpcCommonService.rpcPayPlatformService.selectPlatform(jsonParam);
        String s = RpcUtil.mkRet(result);
        if (s == null) return null;
        return JSONObject.parseObject(s);
    }
}
