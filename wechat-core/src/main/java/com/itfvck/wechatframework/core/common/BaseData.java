package com.itfvck.wechatframework.core.common;

import java.io.Serializable;
import java.util.List;

/**
 * 微信公众号基础数据
 * 
 * @CreationDate 2016年5月12日 上午11:02:13
 * @author vcdemon
 *
 */
public class BaseData implements Serializable {
	private static final long serialVersionUID = 5740770864577790852L;
	private String appId;// 应用ID,公众号的唯一标识;
	private String appSecret;// 应用密钥,公众号的appsecret
	private String access_token;// 接口调用凭证
	private long expires_in;// access_token接口调用凭证超时时间，单位（秒）
	private String refresh_token;// 用户刷新access_token
	private int errcode;// 错误码
	private String errmsg;// 错误信息

	private String openid; // 用户唯一标识，请注意，在未关注公众号时，用户访问公众号的网页，也会产生一个用户和公众号唯一的OpenID

	private List<String> ip_list;

	public List<String> getIp_list() {
		return ip_list;
	}

	public void setIp_list(List<String> ip_list) {
		this.ip_list = ip_list;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public long getExpires_in() {
		return expires_in;
	}

	public void setExpires_in(long expires_in) {
		this.expires_in = expires_in;
	}

	public String getRefresh_token() {
		return refresh_token;
	}

	public void setRefresh_token(String refresh_token) {
		this.refresh_token = refresh_token;
	}

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public int getErrcode() {
		return errcode;
	}

	public void setErrcode(int errcode) {
		this.errcode = errcode;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getAppSecret() {
		return appSecret;
	}

	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}

	@Override
	public String toString() {
		return "BaseData [appId=" + appId + ", appSecret=" + appSecret + ", access_token=" + access_token + ", expires_in=" + expires_in + ", refresh_token=" + refresh_token
		        + ", errcode=" + errcode + ", errmsg=" + errmsg + ", openid=" + openid + ", ip_list=" + ip_list + "]";
	}

	public void showMsg() {
		System.out.println("Msg:");
		System.out.println("errcode:" + this.errcode);
		System.out.println("errmsg:" + this.errmsg);
	}

}
