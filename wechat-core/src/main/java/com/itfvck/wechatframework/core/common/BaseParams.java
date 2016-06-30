package com.itfvck.wechatframework.core.common;

/**
 * @Description 微信公众号基础配置信息
 * @Author vcdemon
 * @CreationDate 2016年5月12日 上午11:02:13
 */
public class BaseParams extends BaseData {
	private static final long serialVersionUID = -3919019038296486706L;
	private String token;// 令牌(7200s)
	private String encodingAESKey;// 消息加解密密钥
	private String jsapi_ticket;// jsapi_ticket是公众号用于调用微信JS接口的临时票据(7200s)
	private String api_ticket;// 卡券 api_ticket 是用于调用卡券相关接口的临时票据(7200s)

	public String getApi_ticket() {
		return api_ticket;
	}

	public void setApi_ticket(String api_ticket) {
		this.api_ticket = api_ticket;
	}

	public String getJsapi_ticket() {
		return jsapi_ticket;
	}

	public void setJsapi_ticket(String jsapi_ticket) {
		this.jsapi_ticket = jsapi_ticket;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getEncodingAESKey() {
		return encodingAESKey;
	}

	public void setEncodingAESKey(String encodingAESKey) {
		this.encodingAESKey = encodingAESKey;
	}

	@Override
	public String toString() {
		return "BaseConf [token=" + token + ", encodingAESKey=" + encodingAESKey + ", jsapi_ticket=" + jsapi_ticket + ", api_ticket=" + api_ticket + "]";
	}
}
