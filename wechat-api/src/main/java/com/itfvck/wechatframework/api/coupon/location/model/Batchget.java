package com.itfvck.wechatframework.api.coupon.location.model;

import com.itfvck.wechatframework.core.common.BaseData;

public class Batchget extends BaseData {

	private static final long serialVersionUID = -7374709805309168982L;
	// 偏移量，0 开始
	private Integer offset;
	// 拉取数量
	private Integer count;

	public Integer getOffset() {
		return offset;
	}

	public void setOffset(Integer offset) {
		this.offset = offset;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

}
