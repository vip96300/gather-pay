package org.xxpay.dubbo.api.service;

import java.util.Map;

public interface IPayChannel4TenService {
    /**
     * 微信公众号支付
     */
    Map doWxPayGzReq(String jsonParam);

    /**
     * 微信二维码支付
     */
    Map doWxPayQrReq(String jsonParam);

    /**
     * 微信扫码支付
     */
    Map doWxPayScReq(String jsonParam);

    /**
     * 微信H5支付
     */
    Map doWxPayH5Req(String jsonParam);

    /**
     * 支付宝二维码
     */
    Map doAliPayQrReq(String jsonParam);

    /**
     * 支付宝扫码
     */
    Map doAliPayScReq(String jsonParam);

    /**
     * 京东支付
     */
    Map doJDPayReq(String jsonParam);

    /**
     * QQ钱包支付
     */
    Map doQQPayReq(String jsonParam);

    /**
     * 订单查询
     */
    Map getOrderReq(String jsonParam);

    /**
     * 订单退款
     */
    Map doTenRefundReq(String jsonParam);

    /**
     * 订单退款查询
     */
    Map getTenRefundReq(String jsonParam);
}
