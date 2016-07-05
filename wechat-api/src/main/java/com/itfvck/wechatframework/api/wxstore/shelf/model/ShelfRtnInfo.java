package com.itfvck.wechatframework.api.wxstore.shelf.model;

import com.itfvck.wechatframework.core.common.BaseData;

public class ShelfRtnInfo extends BaseData {
	private static final long serialVersionUID = -5153005202179640040L;
	// 错误信息
	private String errmsg;
	// 货架ID
	private Integer shelf_id;

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	public Integer getShelf_id() {
		return shelf_id;
	}

	public void setShelf_id(Integer shelf_id) {
		this.shelf_id = shelf_id;
	}

}
