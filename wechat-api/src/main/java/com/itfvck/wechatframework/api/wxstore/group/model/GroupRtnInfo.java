package com.itfvck.wechatframework.api.wxstore.group.model;

import com.itfvck.wechatframework.core.common.BaseData;

public class GroupRtnInfo extends BaseData {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1547804553951506243L;
	// 分组ID
	private Integer group_id;

	public Integer getGroup_id() {
		return group_id;
	}

	public void setGroup_id(Integer group_id) {
		this.group_id = group_id;
	}
}
