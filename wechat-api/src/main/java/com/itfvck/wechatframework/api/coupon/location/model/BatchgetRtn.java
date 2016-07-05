package com.itfvck.wechatframework.api.coupon.location.model;

import java.util.List;

import com.itfvck.wechatframework.core.common.BaseData;

public class BatchgetRtn extends BaseData {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6215288140689430522L;
	// 错误信息
	private Integer count;
	// 门店信息
	private List<LocationList> location_list;

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public List<LocationList> getLocation_list() {
		return location_list;
	}

	public void setLocation_list(List<LocationList> location_list) {
		this.location_list = location_list;
	}

}
