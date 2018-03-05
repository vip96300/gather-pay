package org.xxpay.dubbo.web.ctrl;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.xxpay.common.constant.PayConstant;
import org.xxpay.common.util.MyLog;
import org.xxpay.common.util.MySeq;
import org.xxpay.common.util.XXPayUtil;
import org.xxpay.dubbo.web.service.*;

import java.util.Map;

/**
 * @Description: 退款订单
 * @author dingzhiwei jmdhappy@126.com
 * @date 2017-10-30
 * @version V1.0
 * @Copyright: www.xxpay.org
 */
@RestController
public class RefundOrderController {

    private final MyLog _log = MyLog.getLog(RefundOrderController.class);

    @Autowired
    private RefundOrderService refundOrderService;

    @Autowired
    private PayOrderService payOrderService;

    @Autowired
    private PayChannelService payChannelService;

    @Autowired
    private MchInfoService mchInfoService;

    /**
     * 统一退款接口:
     * 1)先验证接口参数以及签名信息
     * 2)验证通过创建支付订单
     * 3)根据商户选择渠道,调用支付服务进行下单
     * 4)返回下单数据
     * @param params
     * @return
     */
    @RequestMapping(value = "/api/refund/create_order")
    public String payOrder(@RequestParam String params) {
        _log.info("###### 开始接收商户统一退款请求 ######");
        String logPrefix = "【商户统一退款】";
        try {
            JSONObject po = JSONObject.parseObject(params);
            JSONObject refundContext = new JSONObject();
            JSONObject refundOrder = null;
            // 验证参数有效性
            Object object = validateParams(po, refundContext);
            if (object instanceof String) {
                _log.info("{}参数校验不通过:{}", logPrefix, object);
                return XXPayUtil.makeRetFail(XXPayUtil.makeRetMap(PayConstant.RETURN_VALUE_FAIL, object.toString(), null, null));
            }
            if (object instanceof JSONObject) refundOrder = (JSONObject) object;
            if(refundOrder == null) {
                return XXPayUtil.makeRetFail(XXPayUtil.makeRetMap(PayConstant.RETURN_VALUE_FAIL, "支付中心退款失败", null, null));
            }
            int result = refundOrderService.create(refundOrder);
            _log.info("{}创建退款订单,结果:{}", logPrefix, result);
            if(result != 1) {
                return XXPayUtil.makeRetFail(XXPayUtil.makeRetMap(PayConstant.RETURN_VALUE_FAIL, "创建退款订单失败", null, null));
            }
            // 发送异步退款消息
            String transOrderId = refundOrder.getString("refundOrderId");
            String channelName = refundContext.getString("channelName");
            refundOrderService.sendRefundNotify(transOrderId, channelName);
            _log.info("{}发送转账任务完成,transOrderId={}", logPrefix, transOrderId);

            Map<String, Object> map = XXPayUtil.makeRetMap(PayConstant.RETURN_VALUE_SUCCESS, "", PayConstant.RETURN_VALUE_SUCCESS, null);
            map.put("refundOrderId", refundOrder.getString("refundOrderId"));
            return XXPayUtil.makeRetData(map, refundContext.getString("resKey"));
        }catch (Exception e) {
            _log.error(e, "");
            return XXPayUtil.makeRetFail(XXPayUtil.makeRetMap(PayConstant.RETURN_VALUE_FAIL, "支付中心系统异常", null, null));
        }
    }

    /**
     * 验证创建订单请求参数,参数通过返回JSONObject对象,否则返回错误文本信息
     * @param params
     * @return
     */
    private Object validateParams(JSONObject params, JSONObject refundContext) {
        // 验证请求参数,参数有问题返回错误提示
        String errorMessage;
        // 支付参数
        String mchId = params.getString("mchId"); 			    // 商户ID
        String payOrderId = params.getString("payOrderId");     // 支付订单号
        String mchRefundNo = params.getString("mchRefundNo"); 	// 商户退款单号
        String amount = params.getString("amount"); 		    // 退款金额（单位分）
        String notifyUrl = params.getString("notifyUrl"); 		// 转账结果回调URL
        String sign = params.getString("sign"); 				// 签名
        String remarkInfo = params.getString("remarkInfo");	    // 备注
        // 验证请求参数有效性（必选项）
        if(StringUtils.isBlank(mchId)) {
            errorMessage = "request params[mchId] error.";
            return errorMessage;
        }
        if(StringUtils.isBlank(payOrderId)) {
            errorMessage = "request params[payOrderId,mchOrderNo] error.";
            return errorMessage;
        }
        if(StringUtils.isBlank(mchRefundNo)) {
            errorMessage = "request params[mchRefundNo] error.";
            return errorMessage;
        }
        if(!NumberUtils.isNumber(amount)) {
            errorMessage = "request params[amount] error.";
            return errorMessage;
        }
        if(StringUtils.isBlank(notifyUrl)) {
            errorMessage = "request params[notifyUrl] error.";
            return errorMessage;
        }
        // 签名信息
        if (StringUtils.isEmpty(sign)) {
            errorMessage = "request params[sign] error.";
            return errorMessage;
        }
        // 查询商户信息
        JSONObject mchInfo = mchInfoService.getByMchId(mchId);
        if(mchInfo == null) {
            errorMessage = "Can't found mchInfo[mchId="+mchId+"] record in db.";
            return errorMessage;
        }
        if(mchInfo.getByte("state") != 1) {
            errorMessage = "mchInfo not available [mchId="+mchId+"] record in db.";
            return errorMessage;
        }

        String reqKey = mchInfo.getString("reqKey");
        if (StringUtils.isBlank(reqKey)) {
            errorMessage = "reqKey is null[mchId="+mchId+"] record in db.";
            return errorMessage;
        }
        refundContext.put("resKey", mchInfo.getString("resKey"));

        // 验证签名数据
        boolean verifyFlag = XXPayUtil.verifyPaySign(params, reqKey);
        if(!verifyFlag) {
            errorMessage = "Verify XX refund sign failed.";
            return errorMessage;
        }

        // 验证支付订单是否存在
        JSONObject payOrder = payOrderService.query(mchId, payOrderId, null, "false");
        if (payOrder == null) {
            return "payOrder is not exist.";
        } else if (payOrder.getIntValue("status") != 2 && payOrder.getIntValue("status") != 3) {
            return "payOrder is not exist.";
        }

        // 查询商户对应的支付渠道
        JSONObject payChannel = payChannelService.getByMchIdAndChannelId(mchId, payOrder.getString("channelId"));
        if (payChannel == null) {
            return "Can't found payChannel[mchId=" + mchId + "] record in db.";
        } else if (payChannel.getByte("state") != 1) {
            return "channel not available [mchId=" + mchId + "]";
        }
        refundContext.put("channelName", payChannel.getString("channelName"));

        String channelPayOrderNo = payOrder.getString("channelOrderNo");    // 渠道测支付单号
        Long payAmount = payOrder.getLong("amount");

        // 验证参数通过,返回JSONObject对象
        JSONObject refundOrder = new JSONObject();
        refundOrder.put("refundOrderId", MySeq.getRefund());
        refundOrder.put("payOrderId", payOrderId);
        refundOrder.put("channelPayOrderNo", channelPayOrderNo);
        refundOrder.put("mchId", mchId);
        refundOrder.put("mchRefundNo", mchRefundNo);
        refundOrder.put("channelId", payOrder.getString("channelId"));
        refundOrder.put("refundAmount", Long.parseLong(amount));    // 退款金额
        refundOrder.put("payAmount", payAmount);                    // 退款金额
        refundOrder.put("currency", payOrder.getString("currency"));
        refundOrder.put("clientIp", payOrder.getString("clientIp"));
        refundOrder.put("device", payOrder.getString("device"));
        refundOrder.put("channelUser", payOrder.getString("channelUser"));
        refundOrder.put("userName", payOrder.getString("userName"));
        refundOrder.put("remarkInfo", remarkInfo);
        refundOrder.put("extra", payOrder.getString("extra"));
        refundOrder.put("channelMchId", payChannel.getString("channelMchId"));
        refundOrder.put("channelOrderNo", payOrder.getString("channelOrderNo"));
        refundOrder.put("param1", payOrder.getString("param1"));
        refundOrder.put("param2", payOrder.getString("param2"));
        refundOrder.put("notifyUrl", notifyUrl);
        return refundOrder;
    }

}
