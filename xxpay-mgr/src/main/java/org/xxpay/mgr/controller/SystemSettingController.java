package org.xxpay.mgr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author huanghongfei
 * @Description
 * @Date Create in 14:25 2018/3/3
 */
@RequestMapping(value="/system_setting")
@Controller
public class SystemSettingController {

    @RequestMapping(value="/index.html")
    public String index_html(){
        return "/system_setting/index";
    }
}
