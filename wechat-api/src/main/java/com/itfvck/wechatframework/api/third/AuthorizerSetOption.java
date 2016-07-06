package com.itfvck.wechatframework.api.third;

import com.itfvck.wechatframework.core.common.BaseData;

/**
 * 设置选项信息参数实体
 */
public class AuthorizerSetOption extends BaseData {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3513644530839730904L;
	// 第三方平台appid
	private String component_appid;
	// 授权公众号appid
	private String authorizer_appid;
	// 选项名称
	private String option_name;
	// 设置的选项值
	private String option_value;

	public String getComponent_appid() {
		return component_appid;
	}

	public void setComponent_appid(String component_appid) {
		this.component_appid = component_appid;
	}

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
