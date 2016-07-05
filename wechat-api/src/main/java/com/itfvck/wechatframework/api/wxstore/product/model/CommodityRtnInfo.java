package com.itfvck.wechatframework.api.wxstore.product.model;

import com.itfvck.wechatframework.core.common.BaseData;

public class CommodityRtnInfo extends BaseData {
	private static final long serialVersionUID = 7294586426530317764L;
	// 错误信息
	private String errmsg;
	// 商品ID
	private String product_id;

	private String image_url;

	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

}
