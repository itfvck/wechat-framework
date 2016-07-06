package com.itfvck.wechatframework.api.wxstore.product.model;

import com.itfvck.wechatframework.core.common.BaseData;

public class PropertiesValue extends BaseData {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6414798579632060662L;
	// 属性值id
	private String id;
	// 属性值名称
	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
