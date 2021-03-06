package org.xxpay.mgr.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.xxpay.common.util.AmountUtil;
import org.xxpay.dal.dao.model.PayPlatform;
import org.xxpay.dal.dao.model.PayPlatformSimple;
import org.xxpay.dal.dao.plugin.PageModel;
import org.xxpay.mgr.constant.PageConstants;
import org.xxpay.mgr.service.PayPlatformService;
import org.xxpay.mgr.utils.RetModel;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author huanghongfei
 * @Description
 * @Date Create in 16:58 2018/3/3
 */
@Controller
@RequestMapping(value="/pay_platform")
public class PayPlatformController {

    @Autowired
    private PayPlatformService payPlatformService;

    @RequestMapping(value="/list.html")
    public String list_html(){
        return "/pay_platform/list";
    }

    @RequestMapping(value="/list")
    @ResponseBody
    public PageModel list(@ModelAttribute PayPlatform payPlatform, Integer pageIndex){
        PageModel pageModel = new PageModel();
        long count = payPlatformService.count(payPlatform);
        if(count <= 0) return pageModel;
        List<PayPlatform> payPlatformList = payPlatformService.list((pageIndex-1)*PageConstants.DEFAULT_SIZE, PageConstants.DEFAULT_SIZE, payPlatform);
        List<PayPlatform> data=new ArrayList<PayPlatform>();
        payPlatformList.forEach(o->{
            data.add(this.cent2Dollar(o));
        });
        pageModel.setList(data);
        pageModel.setCount(count);
        pageModel.setMsg("ok");
        pageModel.setRel(true);
        return pageModel;
    }

    @RequestMapping(value="/delete")
    @ResponseBody
    public RetModel delete(@RequestParam(name="id")int id){
        return new RetModel(200,null,null);
    }

    @RequestMapping(value="/add.html")
    public String add_html(){
        return "/pay_platform/add";
    }

    @RequestMapping(value="/add")
    @ResponseBody
    public RetModel add(@RequestParam String params){
        JSONObject jo = JSONObject.parseObject(params);
        PayPlatform payPlatform= PayPlatformSimple.instance();
        payPlatform.setName(jo.getString("name"));
        payPlatform.setShortName(jo.getString("shortName"));
        payPlatform.setAppId(jo.getString("appId"));
        payPlatform.setMerchId(jo.getString("merchId"));
        payPlatform.setMerchKey(jo.getString("merchKey"));
        payPlatform.setMerchPublicKey(jo.getString("merchPublicKey"));
        payPlatform.setExpandParams(jo.getString("expandParams"));
        payPlatform.setPayType(jo.getString("payType"));
        payPlatform.setMerchRate(jo.getDouble("merchRate"));
        payPlatform.setTotalMoney(jo.getLong("totalMoney"));
        payPlatform.setSingleQuota(jo.getLong("singleQuota"));
        payPlatform.setTotalQuota(jo.getLong("totalQuota"));
        payPlatform.setNotifyUrl(jo.getString("notifyUrl"));
        payPlatform.setReturnUrl(jo.getString("returnUrl"));
        payPlatform.setCancelUrl(jo.getString("cancelUrl"));
        payPlatform.setDepict(jo.getString("cancelUrl"));
        payPlatform.setRemark(jo.getString("remark"));
        payPlatform.setStatus(jo.getInteger("status"));
        payPlatformService.add(this.dollar2Centd(payPlatform));
        return new RetModel(200,null,null);
    }

    @RequestMapping(value="/view.html")
    public String view_html(@RequestParam(name="id")int id,ModelMap model){
        PayPlatform payPlatform=payPlatformService.getById(id);
        model.put("item",this.cent2Dollar(payPlatform));
        return "/pay_platform/view";
    }

    @RequestMapping(value="/edit.html")
    public String edit_html(@RequestParam(name="id")int id,ModelMap model){
        PayPlatform payPlatform=payPlatformService.getById(id);
        model.put("item",this.cent2Dollar(payPlatform));
        return "/pay_platform/edit";
    }

    @RequestMapping(value="/update")
    @ResponseBody
    public RetModel update(@RequestParam String params){
        JSONObject jo = JSONObject.parseObject(params);
        PayPlatform payPlatform=payPlatformService.getById(jo.getInteger("id"));
        payPlatform.setName(jo.getString("name"));
        payPlatform.setShortName(jo.getString("shortName"));
        payPlatform.setAppId(jo.getString("appId"));
        payPlatform.setMerchId(jo.getString("merchId"));
        payPlatform.setMerchKey(jo.getString("merchKey"));
        payPlatform.setMerchPublicKey(jo.getString("merchPublicKey"));
        payPlatform.setExpandParams(jo.getString("expandParams"));
        payPlatform.setPayType(jo.getString("payType"));
        payPlatform.setMerchRate(jo.getDouble("merchRate"));
        payPlatform.setTotalMoney(jo.getLong("totalMoney"));
        payPlatform.setSingleQuota(jo.getLong("singleQuota"));
        payPlatform.setTotalQuota(jo.getLong("totalQuota"));
        payPlatform.setNotifyUrl(jo.getString("notifyUrl"));
        payPlatform.setReturnUrl(jo.getString("returnUrl"));
        payPlatform.setCancelUrl(jo.getString("cancelUrl"));
        payPlatform.setDepict(jo.getString("cancelUrl"));
        payPlatform.setRemark(jo.getString("remark"));
        payPlatform.setStatus(jo.getInteger("status"));
        payPlatformService.update(this.dollar2Centd(payPlatform));
        return new RetModel(200,null,null);
    }

    /**
     * 分转元
     * @param payPlatform
     * @return
     */
    private PayPlatform cent2Dollar(PayPlatform payPlatform){
        payPlatform.setTotalMoney((long)Double.parseDouble(AmountUtil.convertCent2Dollar(payPlatform.getTotalMoney()+"")));
        payPlatform.setSingleQuota((long)Double.parseDouble(AmountUtil.convertCent2Dollar(payPlatform.getSingleQuota()+"")));
        payPlatform.setTotalQuota((long)Double.parseDouble(AmountUtil.convertCent2Dollar(payPlatform.getTotalQuota()+"")));
        return payPlatform;
    }

    /**
     * 元转分
     * @param payPlatform
     * @return
     */
    public PayPlatform dollar2Centd(PayPlatform payPlatform){
        payPlatform.setTotalMoney(Long.parseLong(AmountUtil.convertDollar2Cent(payPlatform.getTotalMoney()+"")));
        payPlatform.setSingleQuota(Long.parseLong(AmountUtil.convertDollar2Cent(payPlatform.getSingleQuota()+"")));
        payPlatform.setTotalQuota(Long.parseLong(AmountUtil.convertDollar2Cent(payPlatform.getTotalQuota()+"")));
        return payPlatform;
    }
}
