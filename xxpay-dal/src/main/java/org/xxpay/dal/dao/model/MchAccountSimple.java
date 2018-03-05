package org.xxpay.dal.dao.model;

/**
 * @Author huanghongfei
 * @Description
 * @Date Create in 15:57 2018/3/2
 */
public class MchAccountSimple {

    public static MchAccount instance(String accountId,String mchId){
        MchAccount mchAccount=new MchAccount();
        mchAccount.setAccountId(accountId);
        mchAccount.setMchId(mchId);
        mchAccount.setUsableBalance(0L);
        mchAccount.setLockedBalance(0L);
        return mchAccount;
    }
}
