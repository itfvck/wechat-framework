package com.itfvck.wechatframework.api.wxstore.group.model;

import java.util.List;

import com.itfvck.wechatframework.core.common.BaseData;

public class GroupDetailInfo extends BaseData{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7177142585647043926L;
	// 分组名称
	private String group_id;
	// 分组名称
	private String group_name;
	// 商品ID集合
	private List<String> product_list;

	private List<GroupDetailInfo> groups_detail;
	private GroupDetailInfo group_detail;

	public GroupDetailInfo getGroup_detail() {
		return group_detail;
	}

	public void setGroup_detail(GroupDetailInfo group_detail) {
		this.group_detail = group_detail;
	}

	public List<GroupDetailInfo> getGroups_detail() {
		return groups_detail;
	}

	public void setGroups_detail(List<GroupDetailInfo> groups_detail) {
		this.groups_detail = groups_detail;
	}

	public String getGroup_id() {
		return group_id;
	}

	public void setGroup_id(String group_id) {
		this.group_id = group_id;
	}

	public String getGroup_name() {
		return group_name;
	}

	public void setGroup_name(String group_name) {
		this.group_name = group_name;
	}

	public List<String> getProduct_list() {
		return product_list;
	}

	public void setProduct_list(List<String> product_list) {
		this.product_list = product_list;
	}
}
