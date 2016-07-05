package com.itfvck.wechatframework.api.coupon.consume.model;

import com.itfvck.wechatframework.core.common.BaseData;

public class ConsumeRtnInfo extends BaseData {
	private static final long serialVersionUID = 4108079035686776402L;
	// 核销卡券信息仅包含card_id
	private ConsumeRtnInfoCard card;

	public ConsumeRtnInfoCard getCard() {
		return card;
	}

	public void setCard(ConsumeRtnInfoCard card) {
		this.card = card;
	}

}
