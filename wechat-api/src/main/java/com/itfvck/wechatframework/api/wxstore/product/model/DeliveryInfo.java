package com.itfvck.wechatframework.api.wxstore.product.model;

import java.util.List;

import com.itfvck.wechatframework.core.common.BaseData;

public class DeliveryInfo extends BaseData {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4414342592979903971L;
	// 运费类型
	private Integer delivery_type;
	// 邮费模板ID
	private Integer template_id;
	// 快递
	private List<DeliveryInfoExpress> express;
	//
	private Integer weight;
	//
	private Integer volume;

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public Integer getVolume() {
		return volume;
	}

	public void setVolume(Integer volume) {
		this.volume = volume;
	}

	public Integer getDelivery_type() {
		return delivery_type;
	}

	public void setDelivery_type(Integer delivery_type) {
		this.delivery_type = delivery_type;
	}

	public Integer getTemplate_id() {
		return template_id;
	}

	public void setTemplate_id(Integer template_id) {
		this.template_id = template_id;
	}

	public List<DeliveryInfoExpress> getExpress() {
		return express;
	}

	public void setExpress(List<DeliveryInfoExpress> express) {
		this.express = express;
	}
}
