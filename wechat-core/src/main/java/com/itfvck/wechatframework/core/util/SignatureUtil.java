package com.itfvck.wechatframework.core.util;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itfvck.wechatframework.core.common.BaseParams;
import com.itfvck.wechatframework.core.common.WechatParam;

public class SignatureUtil {
	static Logger logger = LoggerFactory.getLogger(SignatureUtil.class);

	/**
	 * 验证签名
	 * 
	 * @param signature
	 * @param timestamp
	 * @param nonce
	 * @return
	 */
	public static boolean checkSignature(WechatParam params, String token) {
		String[] arr = new String[] { token, params.getTimestamp(), params.getNonce() };
		// 将token、timestamp、nonce三个参数进行字典序排序
		Arrays.sort(arr);
		StringBuilder content = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			content.append(arr[i]);
		}
		String sha1 = EncryptUtil.SHA1Encrypt(content.toString());
		logger.info("checkSignature sha1：" + sha1);
		content = null;
		// 将sha1加密后的字符串可与signature对比，标识该请求来源于微信
		return sha1.equalsIgnoreCase(params.getSignature());
	}
}