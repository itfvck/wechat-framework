package com.itfvck.wechatframework.api.third.model;

import com.itfvck.wechatframework.core.common.BaseData;

public class ReOpenAccessToken extends BaseData {

	private static final long serialVersionUID = -3810236806046006377L;
	/**
	 * access_token 接口调用凭证 expires_in access_token接口调用凭证超时时间，单位（秒） refresh_token
	 * 用户刷新access_token openid 授权用户唯一标识 scope 用户授权的作用域，使用逗号（,）分隔
	 */
	private String scope;

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}
}
