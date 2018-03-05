package org.xxpay.mgr.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.xxpay.dal.dao.model.MchInfo;
import org.xxpay.dal.dao.model.MchLog;
import org.xxpay.dal.dao.model.MchLogSimple;
import org.xxpay.mgr.service.MchLogService;
import org.xxpay.mgr.utils.UuidUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author huanghongfei
 * @Description
 * @Date Create in 9:21 2018/3/2
 */
@Component
public class MchLogInterceptor extends HandlerInterceptorAdapter{

    private static Logger log= LoggerFactory.getLogger(MchLogInterceptor.class);

    @Autowired
    private MchLogService mchLogService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info(">>> {}",request.getRequestURI());
        Object session=request.getSession().getAttribute("mchInfo");
        String mchId=request.getRemoteHost();
        if(!StringUtils.isEmpty(session)){
            MchInfo mchInfo=(MchInfo)session;
            mchId=mchInfo.getMchId();
        }
        mchLogService.add(MchLogSimple.instance(UuidUtil.idGennerator(),mchId,
                request.getRequestURI(),request.getRemoteHost(),
                request.getQueryString(),request.getHeader("user-agent")));
        return true;
    }

}
