package org.xxpay.mgr.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
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
import org.xxpay.dal.dao.model.MchCard;
import org.xxpay.dal.dao.model.MchCardSimple;
import org.xxpay.dal.dao.model.MchCash;
import org.xxpay.dal.dao.plugin.PageModel;
import org.xxpay.mgr.constant.PageConstants;
import org.xxpay.mgr.service.MchCardService;
import org.xxpay.mgr.utils.RetModel;

import java.util.Date;
import java.util.List;

/**
 * @Author huanghongfei
 * @Description
 * @Date Create in 18:03 2018/3/2
 */
@RequestMapping(value="/mch_card")
@Controller
public class MchCardController {

    @Autowired
    private MchCardService mchCardService;

    @RequestMapping(value="/list_mchId.html")
    public String list_mchId_html(){
        return "/mch_card/list_mchId";
    }

    @RequestMapping(value="/list_mchId")
    @ResponseBody
    public PageModel list_mchId(@ModelAttribute MchCard mchCard,
                                @RequestParam(name="pageIndex")int pageIndex){
        PageModel pageModel = new PageModel();
        long count = mchCardService.count(mchCard);
        if(count <= 0) return pageModel;
        List<MchCard> mchCashList = mchCardService.list(mchCard, pageIndex, PageConstants.DEFAULT_SIZE);
        if(!CollectionUtils.isEmpty(mchCashList)) {
            JSONArray array = new JSONArray();
            for(MchCard mc : mchCashList) {
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

    @RequestMapping(value="/delete")
    @ResponseBody
    public void delete(@RequestParam(name="cardId")String cardId){
        mchCardService.delete(cardId);
    }

    @RequestMapping("/view.html")
    public String view_html(@RequestParam(name="cardId")String cardId, ModelMap model) {
        MchCard item = mchCardService.getByCardId(cardId);
        JSONObject object = (JSONObject) JSON.toJSON(item);
        model.put("item", object);
        return "/mch_card/view";
    }

    @RequestMapping(value="/edit.html")
    public String edit_html(@RequestParam(name="cardId")String cardId, ModelMap model){
        MchCard item = mchCardService.getByCardId(cardId);
        JSONObject object = (JSONObject) JSON.toJSON(item);
        model.put("item", object);
        return "/mch_card/edit";
    }

    @RequestMapping(value="/update")
    @ResponseBody
    public void update(@RequestParam String params){
        JSONObject jo = JSONObject.parseObject(params);
        MchCard mchCard=mchCardService.getByCardId(jo.getString("cardId"));
        mchCard.setBankName(jo.getString("bankName"));
        mchCard.setBankNo(jo.getString("bankNo"));
        mchCard.setUserName(jo.getString("userName"));
        mchCard.setIdNo(jo.getString("idNo"));
        mchCard.setMobile(jo.getString("mobile"));
        mchCard.setUpdateTime(new Date());
        mchCardService.update(mchCard);
    }

    @RequestMapping(value="/add.html")
    public String add_html(){
        return "/mch_card/add";
    }

    @RequestMapping(value="/add")
    @ResponseBody
    public RetModel add(@RequestParam String params){
        JSONObject jo = JSONObject.parseObject(params);
        MchCard mchCard=MchCardSimple.instance();
        mchCard.setMchId(jo.getString("mchId"));
        mchCard.setBankName(jo.getString("bankName"));
        mchCard.setBankNo(jo.getString("bankNo"));
        mchCard.setUserName(jo.getString("userName"));
        mchCard.setIdNo(jo.getString("idNo"));
        mchCard.setMobile(jo.getString("mobile"));
        mchCardService.add(mchCard);
        return new RetModel(200,null,null);
    }
}
