package com.itfvck.wechatframework.api.wxstore.product.model;

import java.util.List;

import com.itfvck.wechatframework.core.common.BaseData;

public class CateInfo extends BaseData {

	private static final long serialVersionUID = -1418011270829849666L;
	// 子分类ID
	private String id;
	// 子分类名称
	private String name;

	private List<CateInfo> cate_list;

	public List<CateInfo> getCate_list() {
		return cate_list;
	}

	public void setCate_list(List<CateInfo> cate_list) {
		this.cate_list = cate_list;
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

}
