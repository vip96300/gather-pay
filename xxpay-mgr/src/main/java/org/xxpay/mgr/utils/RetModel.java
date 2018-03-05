package org.xxpay.mgr.utils;

import java.io.Serializable;

/**
 * @Author huanghongfei
 * @Description
 * @Date Create in 16:16 2018/3/3
 */
public class RetModel implements Serializable{

    public RetModel(int code,String depict,Object data){
        this.code=code;
        this.depict=depict;
        this.data=data;
    }
    /**
     * 状态码
     */
    private int code;
    /**
     * 描述
     */
    private String depict;
    /**
     * 数据
     */
    private Object data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDepict() {
        return depict;
    }

    public void setDepict(String depict) {
        this.depict = depict;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
