package com.itfvck.wechatframework.api.third.model;

import com.itfvck.wechatframework.core.common.BaseData;

/**
 * 授权方公众号类型，0代表订阅号，1代表由历史老帐号升级后的订阅号，2代表服务号
 */
public class ApiGetAuthorizerRetAuthorizerSType extends BaseData{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3748187893826402144L;
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
