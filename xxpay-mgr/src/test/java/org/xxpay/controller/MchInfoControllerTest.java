package org.xxpay.controller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.xxpay.BaseTest;
import org.xxpay.mgr.controller.MchInfoController;

/**
 * @Author huanghongfei
 * @Description
 * @Date Create in 17:34 2018/2/28
 */
public class MchInfoControllerTest extends BaseTest{

    @Autowired
    private MchInfoController mchInfoController;

    @Test
    public void save() throws Exception{
        String url="";
        MvcResult mvcResult = super.mvc.perform(MockMvcRequestBuilders.post(url).accept(MediaType.APPLICATION_JSON)).andReturn();
        System.err.println(mvcResult.getResponse().getStatus());
    }
}
