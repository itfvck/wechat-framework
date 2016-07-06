package com.itfvck.wechatframework.api.wxstore.product.model;

import com.itfvck.wechatframework.core.common.BaseData;

public class AttrInfoDetail extends BaseData {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6012075618474735542L;
	// 文字描述
	private String text;
	// 图片
	private String img;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}
}
