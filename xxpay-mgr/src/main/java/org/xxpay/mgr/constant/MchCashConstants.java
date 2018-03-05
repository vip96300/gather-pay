package org.xxpay.mgr.constant;

/**
 * @Author huanghongfei
 * @Description
 * @Date Create in 9:17 2018/3/3
 */
public class MchCashConstants {

    /**
     * 提现状态
     */
    public enum Status{
        /**
         * 创建
         */
        CREATED(0),
        /**
         * 成功
         */
        SUCCESSED(1),
        /**
         * 失败
         */
        FAILED(2),
        /**
         * 管理员拒绝
         */
        REJECT(9);

        private int status;
        Status(int status){
            this.status=status;
        }
        public int getValue(){
            return status;
        }
    }
}
