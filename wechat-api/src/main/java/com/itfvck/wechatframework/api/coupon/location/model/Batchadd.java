package com.itfvck.wechatframework.api.coupon.location.model;

import java.util.List;

import com.itfvck.wechatframework.core.common.BaseData;

public class Batchadd extends BaseData {
	private static final long serialVersionUID = 5796039322217440404L;
	// 门店信息
	private List<LocationList> location_list;

	public List<LocationList> getLocation_list() {
		return location_list;
	}

	public void setLocation_list(List<LocationList> location_list) {
		this.location_list = location_list;
	}

}
