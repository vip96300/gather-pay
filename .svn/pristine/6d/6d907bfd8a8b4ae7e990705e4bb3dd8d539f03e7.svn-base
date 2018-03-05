package org.xxpay.dubbo.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.xxpay.common.constant.PayConstant;
import org.xxpay.common.domain.BaseParam;
import org.xxpay.common.enumm.RetEnum;
import org.xxpay.common.util.*;
import org.xxpay.dal.dao.mapper.PayPlatformMapper;
import org.xxpay.dal.dao.model.PayOrder;
import org.xxpay.dal.dao.model.PayPlatform;
import org.xxpay.dal.dao.model.RefundOrder;
import org.xxpay.dubbo.api.service.IPayChannel4TenService;
import org.xxpay.dubbo.service.BaseNotify4MchPay;
import org.xxpay.dubbo.service.BaseService;
import org.xxpay.dubbo.service.BaseService4PayOrder;
import org.xxpay.dubbo.service.channel.tenpay.TenpayConfig;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

@Service(version = "1.0.0")
public class PayChannel4TenServiceImpl extends BaseService implements IPayChannel4TenService {

    private static final MyLog _log = MyLog.getLog(PayChannel4TenServiceImpl.class);
    @Autowired
    private BaseService4PayOrder baseService4PayOrder;
    @Autowired
    private BaseNotify4MchPay baseNotify4MchPay;
    @Autowired
    private PayPlatformMapper payPlatformMapper;

    @Override
    public Map doWxPayGzReq(String jsonParam) {
        String logPrefix = "【微信公众号支付下单】";
        BaseParam baseParam = JsonUtil.getObjectFromJson(jsonParam, BaseParam.class);
        Map<String, Object> bizParamMap = baseParam.getBizParamMap();
        if (ObjectValidUtil.isInvalid(bizParamMap)) {
            _log.warn("{}失败, {}. jsonParam={}", logPrefix, RetEnum.RET_PARAM_NOT_FOUND.getMessage(), jsonParam);
            return RpcUtil.createFailResult(baseParam, RetEnum.RET_PARAM_NOT_FOUND);
        }
        JSONObject payOrderObj = baseParam.isNullValue("payOrder") ? null : JSONObject.parseObject(bizParamMap.get("payOrder").toString());
        PayOrder payOrder = JSON.toJavaObject(payOrderObj, PayOrder.class);
        if (ObjectValidUtil.isInvalid(payOrder)) {
            _log.warn("{}失败, {}. jsonParam={}", logPrefix, RetEnum.RET_PARAM_INVALID.getMessage(), jsonParam);
            return RpcUtil.createFailResult(baseParam, RetEnum.RET_PARAM_INVALID);
        }
        JSONObject payPlatformObj = baseParam.isNullValue("payPlatform") ? null : JSONObject.parseObject(bizParamMap.get("payPlatform").toString());
        PayPlatform payPlatform = JSON.toJavaObject(payPlatformObj, PayPlatform.class);
        if (payPlatform == null) {
            _log.warn("{}失败. 支付平台设置不存在", logPrefix);
            return RpcUtil.createFailResult(baseParam, RetEnum.RET_REMOTE_DEAL_EXCEPTION);
        }
        JSONObject expand = JSONObject.parseObject(payPlatform.getExpandParams());
        JSONObject extra = JSON.parseObject(payOrder.getExtra());
        Map<String, Object> content = new HashMap<>();
        content.put("merchant_no", payPlatform.getMerchId());
        content.put("out_trade_no", payOrder.getPayOrderId());
        content.put("order_name", payOrder.getSubject());
        content.put("total_amount", AmountUtil.convertCent2Dollar(String.valueOf(payOrder.getAmount())));
        content.put("sub_appid", expand == null ? "" : expand.getString("gz_app_id"));
        content.put("sub_openid", extra == null ? "" : extra.getString("openId"));
        content.put("spbill_create_ip", payOrder.getClientIp());
        content.put("notify_url", payPlatform.getNotifyUrl());
        content.put("success_url", payPlatform.getReturnUrl());
        content.put("cancel_url", payPlatform.getCancelUrl());
        Map<String, Object> params = getParams(TenpayConfig.Method.METHOD_PAY_WX_MP, JsonUtil.object2Json(content), payPlatform.getAppId(), payPlatform.getMerchKey());
        if (params != null) {
            String queryStr = XXPayUtil.genUrlParams(params);
            _log.info("{} XTenPay 请求数据: {}", logPrefix, queryStr);
            String result = XXPayUtil.call4Post(TenpayConfig.gateway + "?" + queryStr);
            _log.info("{} XTenPay 响应数据: {}", logPrefix, result);
            JSONObject obj = JsonUtil.getJSONObjectFromJson(result);
            String payUrl = obj.getString("pay_url");
            if (StringUtils.isNotBlank(payUrl)) {
                baseService4PayOrder.baseUpdateStatus4Ing(payOrder.getPayOrderId(), null);
                Map<String, Object> map = XXPayUtil.makeRetMap(PayConstant.RETURN_VALUE_SUCCESS, "", PayConstant.RETURN_VALUE_SUCCESS, null);
                map.put("payAction", "GET");
                map.put("payUrl", payUrl);
                map.put("payOrderId", payOrder.getPayOrderId());
                return RpcUtil.createBizResult(baseParam, map);
            } else {
                baseService4PayOrder.baseUpdateStatus4Fail(payOrder.getPayOrderId(), obj.getString("error_code"), obj.getString("error_msg"));
                return RpcUtil.createFailResult(baseParam, RetEnum.RET_BIZ_WX_PAY_CREATE_FAIL);
            }
        } else {
            return RpcUtil.createFailResult(baseParam, RetEnum.RET_BIZ_WX_PAY_CREATE_FAIL);
        }
    }

    @Override
    public Map doWxPayQrReq(String jsonParam) {
        String logPrefix = "【微信二维码支付下单】";
        BaseParam baseParam = JsonUtil.getObjectFromJson(jsonParam, BaseParam.class);
        Map<String, Object> bizParamMap = baseParam.getBizParamMap();
        if (ObjectValidUtil.isInvalid(bizParamMap)) {
            _log.warn("{}失败, {}. jsonParam={}", logPrefix, RetEnum.RET_PARAM_NOT_FOUND.getMessage(), jsonParam);
            return RpcUtil.createFailResult(baseParam, RetEnum.RET_PARAM_NOT_FOUND);
        }
        JSONObject payOrderObj = baseParam.isNullValue("payOrder") ? null : JSONObject.parseObject(bizParamMap.get("payOrder").toString());
        PayOrder payOrder = JSON.toJavaObject(payOrderObj, PayOrder.class);
        if (ObjectValidUtil.isInvalid(payOrder)) {
            _log.warn("{}失败, {}. jsonParam={}", logPrefix, RetEnum.RET_PARAM_INVALID.getMessage(), jsonParam);
            return RpcUtil.createFailResult(baseParam, RetEnum.RET_PARAM_INVALID);
        }
        JSONObject payPlatformObj = baseParam.isNullValue("payPlatform") ? null : JSONObject.parseObject(bizParamMap.get("payPlatform").toString());
        PayPlatform payPlatform = JSON.toJavaObject(payPlatformObj, PayPlatform.class);
        if (payPlatform == null) {
            _log.warn("{}失败. 支付平台设置不存在", logPrefix);
            return RpcUtil.createFailResult(baseParam, RetEnum.RET_REMOTE_DEAL_EXCEPTION);
        }
        JSONObject expand = JSONObject.parseObject(payPlatform.getExpandParams());
        Map<String, Object> content = new HashMap<>();
        content.put("merchant_no", payPlatform.getMerchId());
        content.put("out_trade_no", payOrder.getPayOrderId());
        content.put("order_name", payOrder.getSubject());
        content.put("total_amount", AmountUtil.convertCent2Dollar(String.valueOf(payOrder.getAmount())));
        content.put("sub_appid", expand == null ? "" : expand.getString("qr_app_id"));
        content.put("spbill_create_ip", payOrder.getClientIp());
        content.put("notify_url", payPlatform.getNotifyUrl());
        Map<String, Object> params = getParams(TenpayConfig.Method.METHOD_PAY_WX_QR, JsonUtil.object2Json(content), payPlatform.getAppId(), payPlatform.getMerchKey());
        if (params != null) {
            String queryStr = XXPayUtil.genUrlParams(params);
            _log.info("{}XTenPay 请求数据: {}", logPrefix, queryStr);
            String result = XXPayUtil.call4Post(TenpayConfig.gateway + "?" + queryStr);
            _log.info("{}XTenPay 响应数据: {}", logPrefix, result);
            JSONObject obj = JsonUtil.getJSONObjectFromJson(result);
            String qrCode = obj.getString("qr_code");
            if (StringUtils.isNotBlank(qrCode)) {
                baseService4PayOrder.baseUpdateStatus4Ing(payOrder.getPayOrderId(), null);
                Map<String, Object> map = XXPayUtil.makeRetMap(PayConstant.RETURN_VALUE_SUCCESS, "", PayConstant.RETURN_VALUE_SUCCESS, null);
                map.put("payAction", "GET");
                map.put("payOrderId", payOrder.getPayOrderId());
                map.put("qrCode", qrCode);
                return RpcUtil.createBizResult(baseParam, map);
            } else {
                baseService4PayOrder.baseUpdateStatus4Fail(payOrder.getPayOrderId(), obj.getString("error_code"), obj.getString("error_msg"));
                return RpcUtil.createFailResult(baseParam, RetEnum.RET_BIZ_WX_PAY_CREATE_FAIL);
            }
        } else {
            return RpcUtil.createFailResult(baseParam, RetEnum.RET_BIZ_WX_PAY_CREATE_FAIL);
        }
    }

    @Override
    public Map doWxPayScReq(String jsonParam) {
        String logPrefix = "【微信扫码支付下单】";
        BaseParam baseParam = JsonUtil.getObjectFromJson(jsonParam, BaseParam.class);
        Map<String, Object> bizParamMap = baseParam.getBizParamMap();
        if (ObjectValidUtil.isInvalid(bizParamMap)) {
            _log.warn("{}失败, {}. jsonParam={}", logPrefix, RetEnum.RET_PARAM_NOT_FOUND.getMessage(), jsonParam);
            return RpcUtil.createFailResult(baseParam, RetEnum.RET_PARAM_NOT_FOUND);
        }
        JSONObject payOrderObj = baseParam.isNullValue("payOrder") ? null : JSONObject.parseObject(bizParamMap.get("payOrder").toString());
        PayOrder payOrder = JSON.toJavaObject(payOrderObj, PayOrder.class);
        if (ObjectValidUtil.isInvalid(payOrder)) {
            _log.warn("{}失败, {}. jsonParam={}", logPrefix, RetEnum.RET_PARAM_INVALID.getMessage(), jsonParam);
            return RpcUtil.createFailResult(baseParam, RetEnum.RET_PARAM_INVALID);
        }
        JSONObject payPlatformObj = baseParam.isNullValue("payPlatform") ? null : JSONObject.parseObject(bizParamMap.get("payPlatform").toString());
        PayPlatform payPlatform = JSON.toJavaObject(payPlatformObj, PayPlatform.class);
        if (payPlatform == null) {
            _log.warn("{}失败. 支付平台设置不存在", logPrefix);
            return RpcUtil.createFailResult(baseParam, RetEnum.RET_REMOTE_DEAL_EXCEPTION);
        }
        JSONObject expand = JSONObject.parseObject(payPlatform.getExpandParams());
        JSONObject extra = JSON.parseObject(payOrder.getExtra());
        Map<String, Object> content = new HashMap<>();
        content.put("merchant_no", payPlatform.getMerchId());
        content.put("out_trade_no", payOrder.getPayOrderId());
        content.put("order_name", payOrder.getSubject());
        content.put("total_amount", AmountUtil.convertCent2Dollar(String.valueOf(payOrder.getAmount())));
        content.put("sub_appid", expand == null ? "" : expand.getString("sc_app_id"));
        content.put("auth_code", extra == null ? "" : extra.getString("authCode"));
        content.put("spbill_create_ip", payOrder.getClientIp());
        Map<String, Object> params = getParams(TenpayConfig.Method.METHOD_PAY_WX_SC, JsonUtil.object2Json(content), payPlatform.getAppId(), payPlatform.getMerchKey());
        if (params != null) {
            String queryStr = XXPayUtil.genUrlParams(params);
            _log.info("{}XTenPay 请求数据: {}", logPrefix, queryStr);
            String result = XXPayUtil.call4Post(TenpayConfig.gateway + "?" + queryStr);
            _log.info("{}XTenPay 响应数据: {}", logPrefix, result);
            JSONObject obj = JsonUtil.getJSONObjectFromJson(result);
            String tradeNo = obj.getString("trade_no");
            if (StringUtils.isNotBlank(tradeNo)) {
                baseService4PayOrder.baseUpdateStatus4Ing(payOrder.getPayOrderId(), null);
                Map<String, Object> map = XXPayUtil.makeRetMap(PayConstant.RETURN_VALUE_SUCCESS, "", PayConstant.RETURN_VALUE_SUCCESS, null);
                map.put("status", "SUCCESS");
                map.put("payOrderId", payOrder.getPayOrderId());
                baseService4PayOrder.baseUpdateStatus4Success(payOrder.getPayOrderId(), tradeNo, System.currentTimeMillis(), result);
                // 业务系统后端通知
                baseNotify4MchPay.doNotify(payOrder, true);
                return RpcUtil.createBizResult(baseParam, map);
            } else {
                baseService4PayOrder.baseUpdateStatus4Fail(payOrder.getPayOrderId(), obj.getString("error_code"), obj.getString("error_msg"));
                return RpcUtil.createFailResult(baseParam, RetEnum.RET_BIZ_WX_PAY_CREATE_FAIL);
            }
        } else {
            return RpcUtil.createFailResult(baseParam, RetEnum.RET_BIZ_WX_PAY_CREATE_FAIL);
        }
    }

    @Override
    public Map doWxPayH5Req(String jsonParam) {
        String logPrefix = "【微信H5支付下单】";
        BaseParam baseParam = JsonUtil.getObjectFromJson(jsonParam, BaseParam.class);
        Map<String, Object> bizParamMap = baseParam.getBizParamMap();
        if (ObjectValidUtil.isInvalid(bizParamMap)) {
            _log.warn("{}失败, {}. jsonParam={}", logPrefix, RetEnum.RET_PARAM_NOT_FOUND.getMessage(), jsonParam);
            return RpcUtil.createFailResult(baseParam, RetEnum.RET_PARAM_NOT_FOUND);
        }
        JSONObject payOrderObj = baseParam.isNullValue("payOrder") ? null : JSONObject.parseObject(bizParamMap.get("payOrder").toString());
        PayOrder payOrder = JSON.toJavaObject(payOrderObj, PayOrder.class);
        if (ObjectValidUtil.isInvalid(payOrder)) {
            _log.warn("{}失败, {}. jsonParam={}", logPrefix, RetEnum.RET_PARAM_INVALID.getMessage(), jsonParam);
            return RpcUtil.createFailResult(baseParam, RetEnum.RET_PARAM_INVALID);
        }
        JSONObject payPlatformObj = baseParam.isNullValue("payPlatform") ? null : JSONObject.parseObject(bizParamMap.get("payPlatform").toString());
        PayPlatform payPlatform = JSON.toJavaObject(payPlatformObj, PayPlatform.class);
        if (payPlatform == null) {
            _log.warn("{}失败. 支付平台设置不存在", logPrefix);
            return RpcUtil.createFailResult(baseParam, RetEnum.RET_REMOTE_DEAL_EXCEPTION);
        }

        JSONObject expand = JSONObject.parseObject(payPlatform.getExpandParams());
        Map<String, Object> content = new HashMap<>();
        content.put("merchant_no", payPlatform.getMerchId());
        content.put("out_trade_no", payOrder.getPayOrderId());
        content.put("order_name", payOrder.getSubject());
        content.put("total_amount", AmountUtil.convertCent2Dollar(String.valueOf(payOrder.getAmount())));
        content.put("sub_mch_id", expand == null ? "" : expand.getString("h5_sub_mch_id"));
        content.put("spbill_create_ip", payOrder.getClientIp());
        content.put("goods_tag", "-");
        content.put("sceneInfo", "{\"h5_info\": {\"type\":\"Wap\",\"wap_url\": \"https://pay.qq.com\",\"wap_name\": \"腾讯充值\"}}");
        content.put("notify_url", payPlatform.getNotifyUrl());
        Map<String, Object> params = getParams(TenpayConfig.Method.METHOD_PAY_WX_H5, JsonUtil.object2Json(content), payPlatform.getAppId(), payPlatform.getMerchKey());
        if (params != null) {
            String queryStr = XXPayUtil.genUrlParams(params);
            _log.info("{}XTenPay 请求数据: {}", logPrefix, queryStr);
            String result = XXPayUtil.call4Post(TenpayConfig.gateway + "?" + queryStr);
            _log.info("{}XTenPay 响应数据: {}", logPrefix, result);
            JSONObject obj = JsonUtil.getJSONObjectFromJson(result);
            String payUrl = obj.getString("pay_url");
            if (StringUtils.isNotBlank(payUrl)) {
                baseService4PayOrder.baseUpdateStatus4Ing(payOrder.getPayOrderId(), null);
                Map<String, Object> map = XXPayUtil.makeRetMap(PayConstant.RETURN_VALUE_SUCCESS, "", PayConstant.RETURN_VALUE_SUCCESS, null);
                map.put("payAction", "GET");
                map.put("payOrderId", payOrder.getPayOrderId());
                map.put("payUrl", payUrl);
                return RpcUtil.createBizResult(baseParam, map);
            } else {
                baseService4PayOrder.baseUpdateStatus4Fail(payOrder.getPayOrderId(), obj.getString("error_code"), obj.getString("error_msg"));
                return RpcUtil.createFailResult(baseParam, RetEnum.RET_BIZ_WX_PAY_CREATE_FAIL);
            }
        } else {
            return RpcUtil.createFailResult(baseParam, RetEnum.RET_BIZ_WX_PAY_CREATE_FAIL);
        }
    }

    @Override
    public Map doAliPayQrReq(String jsonParam) {
        return null;
    }

    @Override
    public Map doAliPayScReq(String jsonParam) {
        return null;
    }

    @Override
    public Map doJDPayReq(String jsonParam) {
        String logPrefix = "【JD支付下单】";
        BaseParam baseParam = JsonUtil.getObjectFromJson(jsonParam, BaseParam.class);
        Map<String, Object> bizParamMap = baseParam.getBizParamMap();
        if (ObjectValidUtil.isInvalid(bizParamMap)) {
            _log.warn("{}失败, {}. jsonParam={}", logPrefix, RetEnum.RET_PARAM_NOT_FOUND.getMessage(), jsonParam);
            return RpcUtil.createFailResult(baseParam, RetEnum.RET_PARAM_NOT_FOUND);
        }
        JSONObject payOrderObj = baseParam.isNullValue("payOrder") ? null : JSONObject.parseObject(bizParamMap.get("payOrder").toString());
        PayOrder payOrder = JSON.toJavaObject(payOrderObj, PayOrder.class);
        if (ObjectValidUtil.isInvalid(payOrder)) {
            _log.warn("{}失败, {}. jsonParam={}", logPrefix, RetEnum.RET_PARAM_INVALID.getMessage(), jsonParam);
            return RpcUtil.createFailResult(baseParam, RetEnum.RET_PARAM_INVALID);
        }
        JSONObject payPlatformObj = baseParam.isNullValue("payPlatform") ? null : JSONObject.parseObject(bizParamMap.get("payPlatform").toString());
        PayPlatform payPlatform = JSON.toJavaObject(payPlatformObj, PayPlatform.class);
        if (payPlatform == null) {
            _log.warn("{}失败. 支付平台设置不存在", logPrefix);
            return RpcUtil.createFailResult(baseParam, RetEnum.RET_REMOTE_DEAL_EXCEPTION);
        }

        Map<String, Object> content = new HashMap<>();
        content.put("merchant_no", payPlatform.getMerchId());
        content.put("out_trade_no", payOrder.getPayOrderId());
        content.put("order_name", payOrder.getSubject());
        content.put("order_type", 1);
        content.put("total_amount", AmountUtil.convertCent2Dollar(String.valueOf(payOrder.getAmount())));
        content.put("notify_url", payPlatform.getNotifyUrl());

        Map<String, Object> params = getParams(TenpayConfig.Method.METHOD_PAY_JD, JsonUtil.object2Json(content), payPlatform.getAppId(), payPlatform.getMerchKey());
        if (params != null) {
            String queryStr = XXPayUtil.genUrlParams(params);
            _log.info("{}XTenPay 请求数据: {}", logPrefix, queryStr);
            String result = XXPayUtil.call4Post(TenpayConfig.gateway + "?" + queryStr);
            _log.info("{}XTenPay 响应数据: {}", logPrefix, result);
            JSONObject obj = JsonUtil.getJSONObjectFromJson(result);
            if (obj.getIntValue("error_code") == 0) {
                baseService4PayOrder.baseUpdateStatus4Ing(payOrder.getPayOrderId(), null);
                Map<String, Object> map = XXPayUtil.makeRetMap(PayConstant.RETURN_VALUE_SUCCESS, "", PayConstant.RETURN_VALUE_SUCCESS, null);
                map.put("payAction", "GET");
                map.put("payOrderId", payOrder.getPayOrderId());
                map.put("payUrl", obj.getString("qr_code"));
                return RpcUtil.createBizResult(baseParam, map);
            } else {
                baseService4PayOrder.baseUpdateStatus4Fail(payOrder.getPayOrderId(), obj.getString("error_code"), obj.getString("error_msg"));
                return RpcUtil.createFailResult(baseParam, RetEnum.RET_BIZ_WX_PAY_CREATE_FAIL);
            }
        } else {
            return RpcUtil.createFailResult(baseParam, RetEnum.RET_BIZ_WX_PAY_CREATE_FAIL);
        }
    }

    @Override
    public Map doQQPayReq(String jsonParam) {
        String logPrefix = "【QQ钱包支付下单】";
        BaseParam baseParam = JsonUtil.getObjectFromJson(jsonParam, BaseParam.class);
        Map<String, Object> bizParamMap = baseParam.getBizParamMap();
        if (ObjectValidUtil.isInvalid(bizParamMap)) {
            _log.warn("{}失败, {}. jsonParam={}", logPrefix, RetEnum.RET_PARAM_NOT_FOUND.getMessage(), jsonParam);
            return RpcUtil.createFailResult(baseParam, RetEnum.RET_PARAM_NOT_FOUND);
        }
        JSONObject payOrderObj = baseParam.isNullValue("payOrder") ? null : JSONObject.parseObject(bizParamMap.get("payOrder").toString());
        PayOrder payOrder = JSON.toJavaObject(payOrderObj, PayOrder.class);
        if (ObjectValidUtil.isInvalid(payOrder)) {
            _log.warn("{}失败, {}. jsonParam={}", logPrefix, RetEnum.RET_PARAM_INVALID.getMessage(), jsonParam);
            return RpcUtil.createFailResult(baseParam, RetEnum.RET_PARAM_INVALID);
        }
        JSONObject payPlatformObj = baseParam.isNullValue("payPlatform") ? null : JSONObject.parseObject(bizParamMap.get("payPlatform").toString());
        PayPlatform payPlatform = JSON.toJavaObject(payPlatformObj, PayPlatform.class);
        if (payPlatform == null) {
            _log.warn("{}失败. 支付平台设置不存在", logPrefix);
            return RpcUtil.createFailResult(baseParam, RetEnum.RET_REMOTE_DEAL_EXCEPTION);
        }

        Map<String, Object> content = new HashMap<>();
        content.put("merchant_no", payPlatform.getMerchId());
        content.put("out_trade_no", payOrder.getPayOrderId());
        content.put("order_name", payOrder.getSubject());
        content.put("spbill_create_ip", payOrder.getClientIp());
        content.put("total_amount", AmountUtil.convertCent2Dollar(String.valueOf(payOrder.getAmount())));
        content.put("notify_url", payPlatform.getNotifyUrl());

        Map<String, Object> params = getParams(TenpayConfig.Method.METHOD_PAY_QQ, JsonUtil.object2Json(content), payPlatform.getAppId(), payPlatform.getMerchKey());
        if (params != null) {
            String queryStr = XXPayUtil.genUrlParams(params);
            _log.info("{} XTenPay 请求数据 : {}", logPrefix, queryStr);
            String result = XXPayUtil.call4Post(TenpayConfig.gateway + "?" + queryStr);
            _log.info("{} XTenPay 响应数据 : {}", logPrefix, result);
            JSONObject obj = JsonUtil.getJSONObjectFromJson(result);
            if (obj.getIntValue("error_code") == 0) {
                baseService4PayOrder.baseUpdateStatus4Ing(payOrder.getPayOrderId(), null);
                Map<String, Object> map = XXPayUtil.makeRetMap(PayConstant.RETURN_VALUE_SUCCESS, "", PayConstant.RETURN_VALUE_SUCCESS, null);
                map.put("payOrderId", payOrder.getPayOrderId());
                map.put("payUrl", obj.getString("code_url"));
                map.put("payAction", "GET");
                return RpcUtil.createBizResult(baseParam, map);
            } else {
                baseService4PayOrder.baseUpdateStatus4Fail(payOrder.getPayOrderId(), obj.getString("error_code"), obj.getString("error_msg"));
                return RpcUtil.createFailResult(baseParam, RetEnum.RET_BIZ_WX_PAY_CREATE_FAIL);
            }
        } else {
            return RpcUtil.createFailResult(baseParam, RetEnum.RET_BIZ_WX_PAY_CREATE_FAIL);
        }
    }

    @Override
    public Map getOrderReq(String jsonParam) {
        return null;
    }

    @Override
    public Map doTenRefundReq(String jsonParam) {
        String logPrefix = "【XTenPay退款】";
        BaseParam baseParam = JsonUtil.getObjectFromJson(jsonParam, BaseParam.class);
        Map<String, Object> bizParamMap = baseParam.getBizParamMap();
        if (ObjectValidUtil.isInvalid(bizParamMap)) {
            _log.warn("{}失败, {}. jsonParam={}", logPrefix, RetEnum.RET_PARAM_NOT_FOUND.getMessage(), jsonParam);
            return RpcUtil.createFailResult(baseParam, RetEnum.RET_PARAM_NOT_FOUND);
        }
        JSONObject refundOrderObj = baseParam.isNullValue("refundOrder") ? null : JSONObject.parseObject(bizParamMap.get("refundOrder").toString());
        RefundOrder refundOrder = JSON.toJavaObject(refundOrderObj, RefundOrder.class);
        if (ObjectValidUtil.isInvalid(refundOrder)) {
            _log.warn("{}失败, {}. jsonParam={}", logPrefix, RetEnum.RET_PARAM_INVALID.getMessage(), jsonParam);
            return RpcUtil.createFailResult(baseParam, RetEnum.RET_PARAM_INVALID);
        }
        PayPlatform payPlatform = payPlatformMapper.selectPlatformByOrderId(refundOrder.getPayOrderId());
        Map<String, Object> content = new HashMap<>();
        content.put("out_trade_no", refundOrder.getPayOrderId());
        content.put("out_refund_no", refundOrder.getRefundOrderId());
        Map<String, Object> params = getParams(TenpayConfig.Method.METHOD_REFUND, JsonUtil.object2Json(content), payPlatform.getAppId(), payPlatform.getMerchKey());
        if (params != null) {
            String queryStr = XXPayUtil.genUrlParams(params);
            _log.info("{} XTenPay 请求数据 : {}", logPrefix, queryStr);
            String result = XXPayUtil.call4Post(TenpayConfig.gateway + "?" + queryStr);
            _log.info("{} XTenPay 响应数据 : {}", logPrefix, result);
            JSONObject obj = JsonUtil.getJSONObjectFromJson(result);
            System.out.println(obj);
        }
        return null;
    }

    @Override
    public Map getTenRefundReq(String jsonParam) {
        return null;
    }

    private Map<String, Object> getParams(String methodType, String content, String appId, String appKey) {
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("app_id", appId);
            params.put("method", methodType);
            params.put("version", "1.0");
            params.put("content", content);
            params.put("sign", PayDigestUtil.getSign(params, appKey).toLowerCase());
            params.put("sign_type", "MD5");
            params.put("content", URLEncoder.encode(content, "UTF-8"));
            return params;
        } catch (Exception e) {
            _log.error("生成请求参数异常：", e);
        }
        return null;
    }
}
