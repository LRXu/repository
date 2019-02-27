package com.ssm.tools;

import java.util.UUID;


/**
 * @version 1.0
 */
public class UUIDUtils {
	
	
	/**
	 * 获取带“-”的UUID
	 *@param 
	 */
	public static String getUUID() {
	    return UUID.randomUUID().toString();	
	}
	
	/**
	 *获取无“-”的UUID
	 */
	public static String getUUIDS() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	
	/**
	 * 用于获取商品编号 5位数字
	 * */

	public static String getPidNum() {
		String num = UUID.randomUUID().toString().replaceAll("-", "");
		String pidNum = num.substring(0, 5);
		return pidNum;
	}
	
	

}
