package com.itfvck.wechatframework.api.third;

import com.itfvck.wechatframework.core.common.BaseData;

/**
 * 选项设置信息返回实体
 */
public class AuthorizerOptionRet extends BaseData {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4360058847655238146L;
	// 授权公众号appid
	private String authorizer_appid;
	// 选项名
	private String option_name;
	// 选项值
	private String option_value;

	public String getAuthorizer_appid() {
		return authorizer_appid;
	}

	public void setAuthorizer_appid(String authorizer_appid) {
		this.authorizer_appid = authorizer_appid;
	}

	public String getOption_name() {
		return option_name;
	}

	public void setOption_name(String option_name) {
		this.option_name = option_name;
	}

	public String getOption_value() {
		return option_value;
	}

	public void setOption_value(String option_value) {
		this.option_value = option_value;
	}

}
