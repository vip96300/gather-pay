package org.xxpay.dubbo.web.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.xxpay.common.constant.PayConstant;
import org.xxpay.common.util.MyLog;
import org.xxpay.dubbo.web.service.NotifyPayService;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 接收处理XTenPay通知
 *
 * @version V1.0
 */

@RestController
public class Notify4TenPayController {
    private static final MyLog _log = MyLog.getLog(Notify4TenPayController.class);

    @Autowired
    private NotifyPayService notifyPayService;

    /**
     * QQ支钱包付后台通知
     */
    @RequestMapping(value = "/notify/pay/x_ten_pay_al.htm")
    @ResponseBody
    public String aliPayNotifyRes(HttpServletRequest request) {
        _log.info("====== 开始接收XTenPay 支付宝支付回调通知 ======");
        String notifyRes = doXTenPayRes(request, PayConstant.TenConstant.NOTIFY_TYPE_AL);
        _log.info("响应给XTenPay:{}", notifyRes);
        _log.info("====== 完成接收XTenPay 支付宝支付回调通知 ======");
        return notifyRes;
    }

    @RequestMapping(value = "/notify/pay/x_ten_pay_wx.htm")
    @ResponseBody
    public String wxPayNotifyRes(HttpServletRequest request) {
        _log.info("====== 开始接收XTenPay 微信支付回调通知 ======");
        String notifyRes = doXTenPayRes(request, PayConstant.TenConstant.NOTIFY_TYPE_WX);
        _log.info("响应给XTenPay:{}", notifyRes);
        _log.info("====== 完成接收XTenPay 微信支付回调通知 ======");
        return notifyRes;
    }

    @RequestMapping(value = "/notify/pay/x_ten_pay_qq.htm")
    @ResponseBody
    public String qqPayNotifyRes(HttpServletRequest request) {
        _log.info("====== 开始接收XTenPay QQ钱包支付回调通知 ======");
        String notifyRes = doXTenPayRes(request, PayConstant.TenConstant.NOTIFY_TYPE_QQ);
        _log.info("响应给XTenPay:{}", notifyRes);
        _log.info("====== 完成接收XTenPay QQ钱包支付回调通知 ======");
        return notifyRes;
    }

    @RequestMapping(value = "/notify/pay/x_ten_pay_jd.htm")
    @ResponseBody
    public String jdPayNotifyRes(HttpServletRequest request) {
        _log.info("====== 开始接收XTenPay JD支付回调通知 ======");
        String notifyRes = doXTenPayRes(request, PayConstant.TenConstant.NOTIFY_TYPE_JD);
        _log.info("响应给XTenPay:{}", notifyRes);
        _log.info("====== 完成接收XTenPay JD支付回调通知 ======");
        return notifyRes;
    }

    private String doXTenPayRes(HttpServletRequest request, String channel) {
        String logPrefix = "【XTenPay回调通知】";
        Map<String, String> params = new HashMap<>();
        Map requestParams = request.getParameterMap();
        for (Object o : requestParams.keySet()) {
            String name = (String) o;
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
            }
            params.put(name, valueStr);
        }
        _log.info("{}通知请求数据:reqStr={}", logPrefix, params);
        if (params.isEmpty()) {
            _log.error("{}请求参数为空", logPrefix);
            return PayConstant.RETURN_VALUE_FAIL;
        }
        switch (channel) {
            case PayConstant.TenConstant.NOTIFY_TYPE_QQ:
                return notifyPayService.doXTenQQNotify(params);
            case PayConstant.TenConstant.NOTIFY_TYPE_JD:
                return notifyPayService.doXTenJDNotify(params);
            case PayConstant.TenConstant.NOTIFY_TYPE_WX:
                return notifyPayService.doXTenWXNotify(params);
            case PayConstant.TenConstant.NOTIFY_TYPE_AL:
                return notifyPayService.doXTenALNotify(params);
            default:
                _log.info("没有对应的支付类型，不做业务处理：{}, params: {}", channel, params);
                return PayConstant.RETURN_VALUE_SUCCESS;
        }
    }
}
