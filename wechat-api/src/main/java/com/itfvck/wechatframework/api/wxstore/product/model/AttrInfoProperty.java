package com.itfvck.wechatframework.api.wxstore.product.model;

import com.itfvck.wechatframework.core.common.BaseData;

public class AttrInfoProperty extends BaseData {
	private static final long serialVersionUID = -9197772572415297194L;
	// 属性id
	private String id;
	// 属性值id
	private String vid;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getVid() {
		return vid;
	}

	public void setVid(String vid) {
		this.vid = vid;
	}
}
