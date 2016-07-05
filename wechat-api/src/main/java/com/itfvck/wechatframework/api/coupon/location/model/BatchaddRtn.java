package com.itfvck.wechatframework.api.coupon.location.model;

import java.util.List;

import com.itfvck.wechatframework.core.common.BaseData;

public class BatchaddRtn extends BaseData {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6480769626070405386L;
	// 门店ID
	private List<String> location_id_list;

	public List<String> getLocation_id_list() {
		return location_id_list;
	}

	public void setLocation_id_list(List<String> location_id_list) {
		this.location_id_list = location_id_list;
	}

}
