package com.itfvck.wechatframework.api.oauth;

import com.itfvck.wechatframework.core.common.BaseData;

/**
 * @Description 微信授权请求或返回参数集合
 * @Author vcdemon
 * @CreationDate 2016年5月9日 上午9:52:21
 */
public class OAuthData extends BaseData {

	private static final long serialVersionUID = -2542530758925143225L;

	private String redirect_uri;// 授权后重定向的回调链接地址，请使用urlencode对链接进行处理
	private String response_type = "code";// 返回类型，请填写code
	private String scope;// 应用授权作用域，snsapi_base
							// （不弹出授权页面，直接跳转，只能获取用户openid），snsapi_userinfo
							// （弹出授权页面，可通过openid拿到昵称、性别、所在地。并且，即使在未关注的情况下，只要用户授权，也能获取其信息）
	private String state;// 重定向后会带上state参数，开发者可以填写a-zA-Z0-9的参数值，最多128字节
	private String wechat_redirect = "#wechat_redirect";// 是
														// 无论直接打开还是做页面302重定向时候，必须带此参数

	private String code;// 填写第一步获取的code参数
	private String grant_type = "authorization_code";// 填写为authorization_code
														// [刷新access_token（如果需要）填写为refresh_token]

	private String lang;// 返回国家地区语言版本，zh_CN 简体，zh_TW 繁体，en 英语

	public String getRedirect_uri() {
		return redirect_uri;
	}

	public void setRedirect_uri(String redirect_uri) {
		this.redirect_uri = redirect_uri;
	}

	public String getResponse_type() {
		return response_type;
	}

	public void setResponse_type(String response_type) {
		this.response_type = response_type;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getWechat_redirect() {
		return wechat_redirect;
	}

	public void setWechat_redirect(String wechat_redirect) {
		this.wechat_redirect = wechat_redirect;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getGrant_type() {
		return grant_type;
	}

	public void setGrant_type(String grant_type) {
		this.grant_type = grant_type;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	@Override
	public String toString() {
		return "GrantData [redirect_uri=" + redirect_uri + ", response_type=" + response_type + ", scope=" + scope + ", state=" + state + ", wechat_redirect=" + wechat_redirect
				+ ", code=" + code + ", grant_type=" + grant_type + ", lang=" + lang + "]";
	}

}
