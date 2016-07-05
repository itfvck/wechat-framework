package com.itfvck.wechatframework.api.wxstore.deliveryMoney.model;

import com.itfvck.wechatframework.core.common.BaseData;

public class DeliveryMoneyRtnInfo extends BaseData {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4395048243018978594L;
	// 邮费模板ID
	private Integer template_id;

	public Integer getTemplate_id() {
		return template_id;
	}

	public void setTemplate_id(Integer template_id) {
		this.template_id = template_id;
	}
}
