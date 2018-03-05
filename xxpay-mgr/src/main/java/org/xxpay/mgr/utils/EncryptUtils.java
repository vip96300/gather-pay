package org.xxpay.mgr.utils;

import org.apache.shiro.crypto.hash.Md5Hash;

public class EncryptUtils {

    /**
     * 对密码进行md5加密,并返回密文和salt，包含在User对象中
     *
     * @param password       密码
     * @Return 密文
     */
    public static String md5(String password) {
        return new Md5Hash(password).toString();
    }

}
