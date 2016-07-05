package com.itfvck.wechatframework.api.third.model;

import com.itfvck.wechatframework.core.common.BaseData;

/**
 * 获取预授权码
 * 
 * @author zhangdaihao
 *
 */
public class GetPreAuthCodeParam extends BaseData {
	private static final long serialVersionUID = 233303073301775101L;
	private String component_appid;

	public String getComponent_appid() {
		return component_appid;
	}

	public void setComponent_appid(String component_appid) {
		this.component_appid = component_appid;
	}

}
