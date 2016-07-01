package com.itfvck.wechatframework.api.jsapi;

import java.util.UUID;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSON;
import com.itfvck.wechatframework.core.util.EncryptUtil;
import com.itfvck.wechatframework.core.util.http.HttpUtils;

/**
 * JS-SDK操作API
 * 
 * @Author vcdemon
 * @CreationDate 2016年5月12日 上午10:31:55
 *
 */
public class JSSDKAPI {
	private static final String GET_JS_SDK_CONF = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=%s&type=jsapi";

	/**
	 * @Description 获取ticket(jsapi_ticket)
	 * @param access_token
	 *            传入access_token
	 * @return
	 * @CreationDate 2016年5月25日 下午3:59:07
	 * @Author vcdemon
	 */
	public static String getJs_tiket(String access_token) {
		JSSDKParams jssdkConf = new JSSDKParams();
		jssdkConf.setAccess_token(access_token);
		jssdkConf = getJSSDKConf(jssdkConf);
		if (jssdkConf != null && StringUtils.isNotEmpty(jssdkConf.getTicket())) {
			return jssdkConf.getTicket();
		}
		return null;
	}

	/**
	 * @Description 获取ticket(jsapi_ticket)
	 * @param jssdkConf
	 *            传入access_token
	 * @return
	 * @CreationDate 2016年5月25日 下午3:59:07
	 * @Author vcdemon
	 */
	private static JSSDKParams getJSSDKConf(JSSDKParams jssdkConf) {
		try {
			String responseBody = HttpUtils.get(String.format(GET_JS_SDK_CONF, jssdkConf.getAccess_token()));
			if (StringUtils.isNotEmpty(responseBody)) {
				jssdkConf.setTicket(JSON.parseObject(responseBody, JSSDKParams.class).getTicket());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jssdkConf;
	}

	/**
	 * @Description JS-SDK使用权限签名算法
	 * @param ticket
	 *            (jsapi_ticket)
	 * @param url
	 *            当前网页url
	 * @return
	 * @CreationDate 2016年5月25日 下午4:00:42
	 * @Author lidong(dli@gdeng.cn)
	 */
	public static JSSDKParams signatureJS_SDK(String ticket, String url,String appid) {
		JSSDKParams jssdkConf = new JSSDKParams();
		jssdkConf = signatureJSSDKConf(jssdkConf);
		jssdkConf.setTicket(ticket);
		jssdkConf.setUrl(url);
		return jssdkConf;
	}

	/**
	 * @Description JS-SDK使用权限签名算法
	 * @param jssdkConf
	 *            传入ticket(jsapi_ticket),url
	 * @return
	 * @CreationDate 2016年5月25日 下午4:00:42
	 * @Author lidong(dli@gdeng.cn)
	 */
	private static JSSDKParams signatureJSSDKConf(JSSDKParams jssdkConf) {
		jssdkConf.setNonceStr(UUID.randomUUID().toString());
		jssdkConf.setTimestamp(System.currentTimeMillis() / 1000);
		jssdkConf.setSignature(EncryptUtil.SHA1Encrypt(new StringBuilder().append("jsapi_ticket=").append(jssdkConf.getTicket()).append("&noncestr=")
		        .append(jssdkConf.getNonceStr()).append("&timestamp=").append(jssdkConf.getTimestamp()).append("&url=").append(jssdkConf.getUrl()).toString()));
		return jssdkConf;
	}

}
