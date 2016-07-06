package com.itfvck.wechatframework.api.jsapi;

import java.util.ArrayList;
import java.util.List;

import com.itfvck.wechatframework.core.common.BaseData;

/**
 * @Description 微信JSSDK参数配置
 * @Author vcdemon
 * @CreationDate 2016年5月25日 下午3:11:15
 */
public class JSSDKParams extends BaseData {

	private static final long serialVersionUID = 2376847458258605843L;
	private String ticket;// jsapi_ticket是公众号用于调用微信JS接口的临时票据
	private Long timestamp;// 生成签名的时间戳
	private String nonceStr;// 生成签名的随机串
	private String signature;// 签名
	private List<String> jsApiList = new ArrayList<>();// 需要使用的JS接口列表
	private String url;// 当前应用jssdk的url

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public String getNonceStr() {
		return nonceStr;
	}

	public void setNonceStr(String nonceStr) {
		this.nonceStr = nonceStr;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public List<String> getJsApiList() {
		return jsApiList;
	}

	public void setJsApiList(List<String> jsApiList) {
		this.jsApiList = jsApiList;
	}

	@Override
	public String toString() {
		return "JSSDKConf [ticket=" + ticket + ", timestamp=" + timestamp + ", nonceStr=" + nonceStr + ", signature=" + signature + ", jsApiList=" + jsApiList + ", url=" + url
				+ "]";
	}
}
