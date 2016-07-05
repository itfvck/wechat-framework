package com.itfvck.wechatframework.api.wxstore.product.model;

import java.util.List;

import com.itfvck.wechatframework.core.common.BaseData;

public class SkuInfo extends BaseData {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2213113822434865883L;
	// sku id
	private String id;
	// sku 名称
	private String name;
	// sku vid列表
	private List<SkuValue> value_list;

	private List<SkuInfo> sku_table;

	public List<SkuInfo> getSku_table() {
		return sku_table;
	}

	public void setSku_table(List<SkuInfo> sku_table) {
		this.sku_table = sku_table;
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

	public List<SkuValue> getValue_list() {
		return value_list;
	}

	public void setValue_list(List<SkuValue> value_list) {
		this.value_list = value_list;
	}

}
