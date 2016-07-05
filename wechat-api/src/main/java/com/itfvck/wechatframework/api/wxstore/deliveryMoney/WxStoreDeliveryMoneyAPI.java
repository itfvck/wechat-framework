package com.itfvck.wechatframework.api.wxstore.deliveryMoney;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.itfvck.wechatframework.api.wxstore.deliveryMoney.model.DeliveryMoney;
import com.itfvck.wechatframework.api.wxstore.deliveryMoney.model.DeliveryMoneyRtnInfo;
import com.itfvck.wechatframework.core.util.http.HttpUtils;

/**
 * 微信小店 - 邮费模板
 * 
 * @author zhangdaihao
 *
 */
public class WxStoreDeliveryMoneyAPI {
	// 增加邮费模板
	private static String create_postage_url = "https://api.weixin.qq.com/merchant/express/add?access_token=ACCESS_TOKEN";
	// 修改邮费模板
	private static String update_postage_url = "https://api.weixin.qq.com/merchant/express/update?access_token=ACCESS_TOKEN";
	// 获取指定ID的邮费模板
	private static String get_postage_url = "https://api.weixin.qq.com/merchant/express/getbyid?access_token=ACCESS_TOKEN";
	// 删除邮费模板
	private static String del_postage_url = "https://api.weixin.qq.com/merchant/express/del?access_token=ACCESS_TOKEN";
	// 获取所有邮费模板
	private static String getall_postage_url = "https://api.weixin.qq.com/merchant/express/getall?access_token=ACCESS_TOKEN";

	/**
	 * 增加邮费模板
	 * 
	 * @param postage
	 * @return
	 */
	public static DeliveryMoneyRtnInfo doAddExpress(String newAccessToken, DeliveryMoney postage) {
		if (newAccessToken != null) {
			String requestUrl = create_postage_url.replace("ACCESS_TOKEN", newAccessToken);
			String json = JSONObject.toJSONString(postage);
			String result = HttpUtils.post(requestUrl, json);
			DeliveryMoneyRtnInfo postageRtnInfo = JSON.parseObject(result, DeliveryMoneyRtnInfo.class);
			return postageRtnInfo;
		}
		return null;
	}

	/**
	 * 删除邮费模板
	 * 
	 * @param template_id
	 * @return
	 */
	public static DeliveryMoneyRtnInfo doDelExpress(String newAccessToken, Integer template_id) {
		if (newAccessToken != null) {
			String requestUrl = del_postage_url.replace("ACCESS_TOKEN", newAccessToken);
			String json = "{\"template_id\": " + template_id + "}";
			String result = HttpUtils.post(requestUrl, json);
			DeliveryMoneyRtnInfo postageRtnInfo = JSON.parseObject(result, DeliveryMoneyRtnInfo.class);
			return postageRtnInfo;
		}
		return null;
	}

	/**
	 * 修改邮费模板
	 * 
	 * @param postage
	 * @return
	 */
	public static DeliveryMoneyRtnInfo doUpdateExpress(String newAccessToken, DeliveryMoney postage) {
		if (newAccessToken != null) {
			String requestUrl = update_postage_url.replace("ACCESS_TOKEN", newAccessToken);
			String json = JSONObject.toJSONString(postage);
			String result = HttpUtils.post(requestUrl, json);
			DeliveryMoneyRtnInfo postageRtnInfo = JSON.parseObject(result, DeliveryMoneyRtnInfo.class);
			return postageRtnInfo;
		}
		return null;
	}

	/**
	 * 获取指定ID的邮费模板
	 * 
	 * @param template_id
	 * @return
	 */
	public static DeliveryMoney getByIdExpress(String newAccessToken, Integer template_id) {
		if (newAccessToken != null) {
			String requestUrl = get_postage_url.replace("ACCESS_TOKEN", newAccessToken);
			String json = "{\"template_id\": " + template_id + "}";
			// 正常返回
			String result = HttpUtils.post(requestUrl, json);
			DeliveryMoney postageRtnInfo = JSON.parseObject(result, DeliveryMoney.class);
			return postageRtnInfo.getTemplate_info();
		}
		return null;
	}

	/**
	 * 获取所有邮费模板
	 * 
	 * @return
	 */
	public static List<DeliveryMoney> getAllExpress(String newAccessToken) {
		if (newAccessToken != null) {
			String requestUrl = getall_postage_url.replace("ACCESS_TOKEN", newAccessToken);
			String result = HttpUtils.get(requestUrl);
			DeliveryMoney postages = JSON.parseObject(result, DeliveryMoney.class);
			return postages.getTemplates_info();
		}
		return null;
	}
}
