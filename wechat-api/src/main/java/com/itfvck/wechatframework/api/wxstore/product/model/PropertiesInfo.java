package com.itfvck.wechatframework.api.wxstore.product.model;

import java.util.List;

import com.itfvck.wechatframework.core.common.BaseData;

public class PropertiesInfo extends BaseData {
	private static final long serialVersionUID = 1238831130635536318L;
	// 属性id
	private String id;
	// 属性名称
	private String name;
	// 属性值
	private List<PropertiesValue> property_value;

	private List<PropertiesInfo> properties;

	public List<PropertiesInfo> getProperties() {
		return properties;
	}

	public void setProperties(List<PropertiesInfo> properties) {
		this.properties = properties;
	}

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

	public List<PropertiesValue> getProperty_value() {
		return property_value;
	}

	public void setProperty_value(List<PropertiesValue> property_value) {
		this.property_value = property_value;
	}

}
