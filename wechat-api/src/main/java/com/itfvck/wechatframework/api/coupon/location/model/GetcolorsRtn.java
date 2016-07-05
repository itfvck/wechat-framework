package com.itfvck.wechatframework.api.coupon.location.model;

import java.util.List;

import com.itfvck.wechatframework.core.common.BaseData;

public class GetcolorsRtn extends BaseData {
	private static final long serialVersionUID = 8439925459397607503L;
	// 颜色集合
	private List<Color> colors;

	public List<Color> getColors() {
		return colors;
	}

	public void setColors(List<Color> colors) {
		this.colors = colors;
	}

}
