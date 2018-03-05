package org.xxpay.mgr.constant;

/**
 * @Author huanghongfei
 * @Description
 * @Date Create in 16:02 2018/3/2
 */
public class MchInfoConstants {

    /**
     * 商户状态
     */
    public enum State{
        /**
         * 禁用
         */
        disable((byte)0),
        /**
         * 启用
         */
        enable((byte)1);
        private byte state;
        State(byte state){
            this.state=state;
        }
        public byte getValue(){
            return state;
        }
    }

    /**
     * 商户类型
     */
    public enum Type{
        /**
         * 平台账户
         */
        ADMIN("1"),
        /**
         * 私有账户
         */
        USER("2");
        private String type;
        Type(String type){
            this.type=type;
        }
        public String getValue(){
            return type;
        }
    }
}
