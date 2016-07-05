package com.itfvck.wechatframework.api.third.model;

import com.itfvck.wechatframework.core.common.BaseData;

/**
 * 授权方的账户信息 实体
 * 
 * @author machaolin
 */
public class ApiGetAuthorizerRet extends BaseData {
	private static final long serialVersionUID = -8883872039150424422L;
	// 授权方的账户信息
	private ApiGetAuthorizerRetAuthorizer authorizer_info;
	// 二维码地址
	private String qrcode_url;
	// 授权第三方相关信息
	private ApiGetAuthorizerRetAuthortion authorization_info;

	public ApiGetAuthorizerRetAuthorizer getAuthorizer_info() {
		return authorizer_info;
	}

	public void setAuthorizer_info(ApiGetAuthorizerRetAuthorizer authorizer_info) {
		this.authorizer_info = authorizer_info;
	}

	public String getQrcode_url() {
		return qrcode_url;
	}

	public void setQrcode_url(String qrcode_url) {
		this.qrcode_url = qrcode_url;
	}

	public ApiGetAuthorizerRetAuthortion getAuthorization_info() {
		return authorization_info;
	}

	public void setAuthorization_info(ApiGetAuthorizerRetAuthortion authorization_info) {
		this.authorization_info = authorization_info;
	}

}
