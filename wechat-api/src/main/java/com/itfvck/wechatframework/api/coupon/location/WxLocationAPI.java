package com.itfvck.wechatframework.api.coupon.location;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.itfvck.wechatframework.api.core.req.model.WexinReqException;
import com.itfvck.wechatframework.api.coupon.location.model.Batchadd;
import com.itfvck.wechatframework.api.coupon.location.model.BatchaddRtn;
import com.itfvck.wechatframework.api.coupon.location.model.Batchget;
import com.itfvck.wechatframework.api.coupon.location.model.BatchgetRtn;
import com.itfvck.wechatframework.api.coupon.location.model.CardInfo;
import com.itfvck.wechatframework.api.coupon.location.model.CardInfoRtn;
import com.itfvck.wechatframework.api.coupon.location.model.Getcolors;
import com.itfvck.wechatframework.api.coupon.location.model.GetcolorsRtn;
import com.itfvck.wechatframework.core.util.http.HttpUtils;

/**
 * 微信卡券 - 创建卡券
 * 
 * @author lihongxuan
 *
 */
public class WxLocationAPI {
	/*
	 * // 上传LOGO 大小限制1MB，像素为300*300，支持JPG格式。 private static String
	 * uploadimg_location_url =
	 * "https://api.weixin.qq.com/cgi-bin/media/uploadimg?access_token=ACCESS_TOKEN";
	 */
	// 批量导入门店信息

	private static String batchadd_location_url = "https://api.weixin.qq.com/card/location/batchadd?access_token=%s";
	// 拉取门店列表
	private static String batchget_location_url = "https://api.weixin.qq.com/card/location/batchget?access_token=%s";
	// 获取颜色列表
	private static String getcolors_location_url = "https://api.weixin.qq.com/card/getcolors?access_token=%s";
	// CreateCard 创建卡
	private static String add_card_url = "https://api.weixin.qq.com/card/create?access_token=%s";

	/**
	 * 批量导入门店信息
	 * 
	 * @throws WexinReqException
	 */
	public BatchaddRtn doBatchadd(String accesstoken, Batchadd batchadd) {
		if (accesstoken != null) {
			batchadd.setAccess_token(accesstoken);
			String json = JSONObject.toJSONString(batchadd);
			String result = HttpUtils.post(String.format(batchadd_location_url, accesstoken), json);
			BatchaddRtn batchaddRtn = JSON.parseObject(result, BatchaddRtn.class);
			return batchaddRtn;
		}
		return null;
	}

	/**
	 * 拉取门店列表
	 */
	public BatchgetRtn doBatchget(String accesstoken, Batchget batchget) {
		if (accesstoken != null) {
			batchget.setAccess_token(accesstoken);
			String json = JSONObject.toJSONString(batchget);
			String result = HttpUtils.post(String.format(batchget_location_url, accesstoken), json);
			BatchgetRtn batchgetRtn = JSON.parseObject(result, BatchgetRtn.class);
			return batchgetRtn;
		}
		return null;
	}

	/**
	 * 获取颜色列表
	 */
	public GetcolorsRtn doGetcolors(String accesstoken) {
		if (accesstoken != null) {
			Getcolors gk = new Getcolors();
			gk.setAccess_token(accesstoken);
			String json = JSONObject.toJSONString(gk);
			String result = HttpUtils.post(String.format(getcolors_location_url, accesstoken), json);
			GetcolorsRtn getcolorsRtn = JSON.parseObject(result, GetcolorsRtn.class);
			return getcolorsRtn;
		}
		return null;
	}

	/**
	 * CreateCard 创建卡
	 */
	public CardInfoRtn doAddCard(String accesstoken, CardInfo cardInfo) {
		if (accesstoken != null) {
			cardInfo.setAccess_token(accesstoken);
			String json = JSONObject.toJSONString(cardInfo);
			String result = HttpUtils.post(String.format(add_card_url, accesstoken), json);
			CardInfoRtn cardInfoRtn = JSON.parseObject(result, CardInfoRtn.class);
			return cardInfoRtn;
		}
		return null;
	}

}
