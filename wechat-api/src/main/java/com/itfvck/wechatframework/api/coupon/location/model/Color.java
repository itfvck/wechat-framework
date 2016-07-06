package com.itfvck.wechatframework.api.coupon.location.model;

import com.itfvck.wechatframework.core.common.BaseData;

public class Color extends BaseData {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3261169388465122416L;
	// 颜色名称
	private String name;
	// 颜色值
	private String value;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
