package org.xxpay.dal.dao.model;

import org.xxpay.dal.dao.plugin.UuidUtil;

import java.util.Date;

/**
 * @Author huanghongfei
 * @Description
 * @Date Create in 15:53 2018/3/3
 */
public class MchCardSimple {

    public static MchCard instance(){
        MchCard mchCard=new MchCard();
        mchCard.setCardId(UuidUtil.idGennerator());
        mchCard.setCreateTime(new Date());
        mchCard.setUpdateTime(new Date());
        mchCard.setIsDel(0);
        return mchCard;
    }
}
