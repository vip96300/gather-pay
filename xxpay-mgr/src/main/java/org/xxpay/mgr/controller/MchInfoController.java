package org.xxpay.mgr.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.xxpay.common.util.DateUtil;
import org.xxpay.common.util.MyLog;
import org.xxpay.dal.dao.model.MchInfo;
import org.xxpay.dal.dao.plugin.PageModel;
import org.xxpay.mgr.constant.MchInfoConstants;
import org.xxpay.mgr.constant.PageConstants;
import org.xxpay.mgr.service.MchInfoService;
import org.xxpay.mgr.utils.EncryptUtils;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/mch_info")
public class MchInfoController {

    private final static MyLog _log = MyLog.getLog(MchInfoController.class);

    @Autowired
    private MchInfoService mchInfoService;


    /**
     * 商户列表页面
     * @param model
     * @return
     */
    @RequestMapping("/list.html")
    public String listInput(ModelMap model) {
        return "/mch_info/list";
    }

    /**
     * 商户编辑页面
     * @param mchId
     * @param model
     * @return
     */
    @RequestMapping("/edit.html")
    public String editInput(String mchId, ModelMap model) {
        MchInfo item = null;
        if(StringUtils.isEmpty(mchId)) {
            item = new MchInfo();
        }else{
            item = mchInfoService.selectMchInfo(mchId);
        }
        model.put("item", item);
        return "/mch_info/edit";
    }

    /**
     * 查看商户列表信息
     * @param mchInfo
     * @param pageIndex
     * @param pageSize
     * @return
     */

    @RequestMapping("/list")
    @ResponseBody
    public PageModel list(@ModelAttribute MchInfo mchInfo, Integer pageIndex, Integer pageSize) {
        PageModel pageModel = new PageModel();
        long count = mchInfoService.count(mchInfo);
        if(count <= 0) return pageModel;
        List<MchInfo> mchInfoList = mchInfoService.list((pageIndex-1)*pageSize, pageSize, mchInfo);
        if(!mchInfoList.isEmpty()){
            JSONArray array = new JSONArray();
            for(MchInfo mi : mchInfoList) {
                JSONObject object = (JSONObject) JSONObject.toJSON(mi);
                object.put("createTime", DateUtil.date2Str(mi.getCreateTime()));
                array.add(object);
            }
            pageModel.setList(array);
        }
        pageModel.setCount(count);
        pageModel.setMsg("ok");
        pageModel.setRel(true);
        return pageModel;
    }

    /**
     * 管理员页面
     * @return
     */
    @RequestMapping("/list_type.html")
    public String list_type_html() {
        return "/mch_info/list_type";
    }

    /**
     * 查看管理员列表信息
     * @return
     */

    @RequestMapping("/list_type")
    @ResponseBody
    public PageModel list_type(@ModelAttribute MchInfo mchInfo,
                               @RequestParam(value="pageIndex") int pageIndex) {
        PageModel pageModel = new PageModel();
        long count = mchInfoService.count(mchInfo);
        if(count <= 0) return pageModel;
        List<MchInfo> mchInfoList = mchInfoService.list(pageIndex, PageConstants.DEFAULT_SIZE,mchInfo);
        if(!mchInfoList.isEmpty()){
            JSONArray array = new JSONArray();
            for(MchInfo mi : mchInfoList) {
                JSONObject object = (JSONObject) JSONObject.toJSON(mi);
                object.put("createTime", DateUtil.date2Str(mi.getCreateTime()));
                array.add(object);
            }
            pageModel.setList(array);
        }
        pageModel.setCount(count);
        pageModel.setMsg("ok");
        pageModel.setRel(true);
        return pageModel;
    }
    /**
     * 保存商户
     * @return
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public String save(@RequestParam String params) {
        JSONObject po = JSONObject.parseObject(params);
        MchInfo mchInfo =null;
        if(StringUtils.isEmpty(po.getString("mchId"))){
            mchInfo=new MchInfo();
            mchInfo.setUsername(po.getString("username"));
            mchInfo.setPassword(EncryptUtils.md5(po.getString("password")));
            mchInfo.setCreateTime(new Date());
            mchInfo.setUpdateTime(new Date());
        }else{
            mchInfo=mchInfoService.selectMchInfo(po.getString("mchId"));
        }
        mchInfo.setName(po.getString("name"));
        mchInfo.setType(po.getString("type"));
        mchInfo.setState(("on".equals(po.getString("state")) ? MchInfoConstants.State.enable.getValue() : MchInfoConstants.State.disable.getValue()));
        mchInfo.setReqKey(po.getString("reqKey"));
        mchInfo.setResKey(po.getString("resKey"));
        return mchInfoService.saveOrUpdate(mchInfo)+"";
    }

    /**
     * 查看商户信息
     * @param mchId
     * @param model
     * @return
     */
    @RequestMapping("/view.html")
    public String viewInput(String mchId, ModelMap model) {
        MchInfo item = mchInfoService.selectMchInfo(mchId);
        model.put("item", item);
        return "/mch_info/view";
    }

    /**
     * 删除商户
     * @param mchId
     * @param model
     * @return
     */
    @RequestMapping(value="/del")
    public void del(String mchId, ModelMap model){

    }

    @RequestMapping(value="/view_mchId.html")
    public String view_mchId_html(String mchId, ModelMap model){
        MchInfo item = mchInfoService.selectMchInfo(mchId);
        model.put("item", item);
        return "/mch_info/view_mchId";
    }

}