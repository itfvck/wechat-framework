package com.itfvck.wechatframework.core.util;

import com.alibaba.fastjson.JSONObject;
import com.itfvck.wechatframework.core.exception.WeChatException;
import com.itfvck.wechatframework.core.exception.WeChatReturnCode;
/**
 * 工具类
 * @author Zhangxs
 * @version 2015-7-4
 */
public class WeChatUtil {
	/**
	 * 判断是否请求成功
	 * @param resultStr
	 * @throws WeChatException
	 */
	public static void isSuccess(String resultStr) throws WeChatException{		
		JSONObject jsonObject = JSONObject.parseObject(resultStr);
		Integer errCode =jsonObject.getIntValue("errcode");
		if (errCode!=null && errCode!=0) {
			String errMsg = WeChatReturnCode.getMsg(errCode);
			if (errMsg.equals("")) {
				errMsg = jsonObject.getString("errmsg");
			}
			throw new WeChatException("异常码:"+errCode+";异常说明:"+errMsg);
		}
	}
}
