package com.itfvck.wechatframework.api.third.model;

import com.itfvck.wechatframework.core.common.BaseData;

/**
 * （刷新）授权公众号的令牌返回数据
 */
public class ApiAuthorizerTokenRet extends BaseData {
	
	private static final long serialVersionUID = -278793329699343167L;
	// 授权方令牌
	private String authorizer_access_token;
	// 刷新令牌
	private String authorizer_refresh_token;

	public String getAuthorizer_access_token() {
		return authorizer_access_token;
	}

	public void setAuthorizer_access_token(String authorizer_access_token) {
		this.authorizer_access_token = authorizer_access_token;
	}

	public String getAuthorizer_refresh_token() {
		return authorizer_refresh_token;
	}

	public void setAuthorizer_refresh_token(String authorizer_refresh_token) {
		this.authorizer_refresh_token = authorizer_refresh_token;
	}

}
