package org.xxpay.mgr.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.xxpay.common.util.AmountUtil;
import org.xxpay.common.util.DateUtil;
import org.xxpay.dal.dao.model.MchCash;
import org.xxpay.dal.dao.model.MchInfo;
import org.xxpay.dal.dao.model.PayOrder;
import org.xxpay.dal.dao.plugin.PageModel;
import org.xxpay.mgr.constant.PageConstants;
import org.xxpay.mgr.service.MchCashService;

import java.util.Date;
import java.util.List;

/**
 * @Author huanghongfei
 * @Description
 * @Date Create in 18:02 2018/3/2
 */
@RequestMapping(value="/mch_cash")
@Controller
public class MchCashController {

    @Autowired
    private MchCashService mchCashService;

    @RequestMapping(value="/list_mchId.html")
    public String list_mchId_html(){
        return "/mch_cash/list_mchId";
    }

    @RequestMapping(value="/list_mchId")
    @ResponseBody
    public PageModel list_mchId(@ModelAttribute MchCash mchCash,
                                @RequestParam(name="pageIndex")int pageIndex){
        PageModel pageModel = new PageModel();
        long count = mchCashService.count(mchCash);
        if(count <= 0) return pageModel;
        List<MchCash> mchCashList = mchCashService.list(mchCash, pageIndex, PageConstants.DEFAULT_SIZE);
        if(!CollectionUtils.isEmpty(mchCashList)) {
            JSONArray array = new JSONArray();
            for(MchCash mc : mchCashList) {
                JSONObject object = (JSONObject) JSONObject.toJSON(mc);
                object.put("createTime", DateUtil.date2Str(mc.getCreateTime()));
                object.put("updateTime", DateUtil.date2Str(mc.getUpdateTime()));
                array.add(object);
            }
            pageModel.setList(array);
        }
        pageModel.setCount(count);
        pageModel.setMsg("ok");
        pageModel.setRel(true);
        return pageModel;
    }

    @RequestMapping("/view.html")
    public String view_html(String cashId, ModelMap model) {
        MchCash item = mchCashService.getByCashId(cashId);
        JSONObject object = (JSONObject) JSON.toJSON(item);
        object.put("amount", AmountUtil.convertCent2Dollar(item.getAmount()+""));
        model.put("item", object);
        return "/mch_cash/view";
    }

    @RequestMapping(value="/delete")
    @ResponseBody
    public void delete(@RequestParam(name="cashId")String cashId){
        mchCashService.delete(cashId);
    }
}
