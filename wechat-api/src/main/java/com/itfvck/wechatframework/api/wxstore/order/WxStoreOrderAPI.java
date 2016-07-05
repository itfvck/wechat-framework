package com.itfvck.wechatframework.api.wxstore.order;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.itfvck.wechatframework.api.wxstore.order.model.OrderDelivery;
import com.itfvck.wechatframework.api.wxstore.order.model.OrderInfo;
import com.itfvck.wechatframework.api.wxstore.order.model.OrderPara;
import com.itfvck.wechatframework.api.wxstore.order.model.OrderRtnInfo;
import com.itfvck.wechatframework.core.util.http.HttpUtils;

/**
 * 微信小店 - 订单
 * 
 * @author zhangdaihao
 *
 */
public class WxStoreOrderAPI {
	// 根据订单ID获取订单详情
	private static String getid_order_url = "https://api.weixin.qq.com/merchant/order/getbyid?access_token=ACCESS_TOKEN";
	// 根据订单状态/创建时间获取订单详情
	private static String getfilter_order_url = "https://api.weixin.qq.com/merchant/order/getbyfilter?access_token=ACCESS_TOKEN";
	// 设置订单发货信息
	private static String setdelivery_order_url = "https://api.weixin.qq.com/merchant/order/setdelivery?access_token=ACCESS_TOKEN";
	// 关闭订单
	private static String close_order_url = "https://api.weixin.qq.com/merchant/order/close?access_token=ACCESS_TOKEN";

	/**
	 * 根据订单ID获取订单详情
	 * 
	 * @param order_id
	 * @return
	 */
	public static OrderInfo getByOrderId(String newAccessToken, String order_id) {
		if (newAccessToken != null) {
			String requestUrl = getid_order_url.replace("ACCESS_TOKEN", newAccessToken);
			String json = "{\"order_id\": \"" + order_id + "\"}";
			String result = HttpUtils.post(requestUrl, json);
			OrderInfo orderInfo = JSON.parseObject(result, OrderInfo.class);
			return orderInfo.getOrder();
		}
		return null;
	}

	/**
	 * 根据订单状态/创建时间获取订单详情
	 * 
	 * @param orderPara
	 * @return
	 */
	public static List<OrderInfo> getByFilter(String newAccessToken, OrderPara orderPara) {
		if (newAccessToken != null) {
			String requestUrl = getfilter_order_url.replace("ACCESS_TOKEN", newAccessToken);
			String json = JSONObject.toJSONString(orderPara);
			String result = HttpUtils.post(requestUrl, json);
			OrderInfo orderInfos = JSON.parseObject(result, OrderInfo.class);
			return orderInfos.getOrder_list();
		}
		return null;
	}

	/**
	 * 设置订单发货信息
	 * 
	 * @param orderDelivery
	 * @return
	 */
	public static OrderRtnInfo doDelivery(String newAccessToken, OrderDelivery orderDelivery) {
		if (newAccessToken != null) {
			String requestUrl = setdelivery_order_url.replace("ACCESS_TOKEN", newAccessToken);
			String json = JSONObject.toJSONString(orderDelivery);
			String result = HttpUtils.post(requestUrl, json);
			OrderRtnInfo orderRtnInfo = JSON.parseObject(result, OrderRtnInfo.class);
			return orderRtnInfo;
		}
		return null;
	}

	/**
	 * 关闭订单
	 * 
	 * @param order_id
	 * @return
	 */
	public static OrderRtnInfo doCloseOrder(String newAccessToken, String order_id) {
		if (newAccessToken != null) {
			String requestUrl = close_order_url.replace("ACCESS_TOKEN", newAccessToken);
			String json = "{\"order_id\": \"" + order_id + "\"}";
			String result = HttpUtils.post(requestUrl, json);
			OrderRtnInfo orderRtnInfo = JSON.parseObject(result, OrderRtnInfo.class);
			return orderRtnInfo;
		}
		return null;
	}
}
