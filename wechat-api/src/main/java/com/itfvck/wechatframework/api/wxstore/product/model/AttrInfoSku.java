package com.itfvck.wechatframework.api.wxstore.product.model;

import com.itfvck.wechatframework.core.common.BaseData;

public class AttrInfoSku extends BaseData {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2684440104434036957L;
	// sku属性id
	private String id;
	// sku值
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
