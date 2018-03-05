package org.xxpay.dal.dao.model;

import java.util.Date;

/**
 * @Author huanghongfei
 * @Description
 * @Date Create in 11:47 2018/3/2
 */
public class MchLogSimple {

    public static MchLog instance(String logId,String mchId,String requestUrl,String ipAddress,String args,String userAgent){
        MchLog mchLog=new MchLog();
        mchLog.setLogId(logId);
        mchLog.setMchId(mchId);
        mchLog.setRequestUrl(requestUrl);
        mchLog.setIpAddress(ipAddress);
        mchLog.setArgs(args);
        mchLog.setUserAgent(userAgent);
        mchLog.setCreateTime(new Date());
        return mchLog;
    }

}
