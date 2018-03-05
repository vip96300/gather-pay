package org.xxpay.mgr.utils;

import java.util.UUID;

public class UuidUtil {
	/***
	 * 主键生成器
	 * @return
	 */
	public static String idGennerator(){
		int hashCode=UUID.randomUUID().toString().hashCode();
		if(hashCode<0){
			hashCode=-hashCode;
		}
		return hashCode+"";
	}
}
