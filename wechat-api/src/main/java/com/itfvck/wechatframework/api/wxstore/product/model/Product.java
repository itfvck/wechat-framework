package com.itfvck.wechatframework.api.wxstore.product.model;

import java.util.List;

import com.itfvck.wechatframework.core.common.BaseData;

public class Product extends BaseData{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1840682514666809109L;
	// 商品id
	private String product_id;
	// 基本属性
	private AttrInfo product_base;
	// sku信息列表
	private List<Sku> sku_list;
	// 商品其他属性
	private AttrExt attrext;
	// 运费信息
	private DeliveryInfo delivery_info;
	// 状态
	private Integer status;
	private Product product_info;

	public Product getProduct_info() {
		return product_info;
	}

	public void setProduct_info(Product product_info) {
		this.product_info = product_info;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	public AttrInfo getProduct_base() {
		return product_base;
	}

	public void setProduct_base(AttrInfo product_base) {
		this.product_base = product_base;
	}

	public List<Sku> getSku_list() {
		return sku_list;
	}

	public void setSku_list(List<Sku> sku_list) {
		this.sku_list = sku_list;
	}

	public AttrExt getAttrext() {
		return attrext;
	}

	public void setAttrext(AttrExt attrext) {
		this.attrext = attrext;
	}

	public DeliveryInfo getDelivery_info() {
		return delivery_info;
	}

	public void setDelivery_info(DeliveryInfo delivery_info) {
		this.delivery_info = delivery_info;
	}
}
