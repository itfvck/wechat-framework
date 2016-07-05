package com.itfvck.wechatframework.api.wxstore.stock;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.itfvck.wechatframework.api.wxstore.stock.model.StockInfo;
import com.itfvck.wechatframework.api.wxstore.stock.model.StockRtnInfo;
import com.itfvck.wechatframework.core.util.http.HttpUtils;

/**
 * 微信小店 - 库存
 * 
 * @author zhangdaihao
 *
 */
public class WxStoreStockAPI {
	// 增加库存
	private static String add_stock_url = "https://api.weixin.qq.com/merchant/stock/add?access_token=ACCESS_TOKEN";
	// 减少库存
	private static String sub_stock_url = "https://api.weixin.qq.com/merchant/stock/reduce?access_token=ACCESS_TOKEN";

	/**
	 * 增加库存
	 */
	public static StockRtnInfo doAddStock(String newAccessToken, StockInfo stockInfo) {
		if (newAccessToken != null) {
			String requestUrl = add_stock_url.replace("ACCESS_TOKEN", newAccessToken);
			String json = JSONObject.toJSONString(stockInfo);
			String result = HttpUtils.post(requestUrl, json);
			StockRtnInfo stockRtnInfo = JSON.parseObject(result, StockRtnInfo.class);
			return stockRtnInfo;
		}
		return null;
	}

	/**
	 * 减少库存
	 */
	public static StockRtnInfo doSubStock(String newAccessToken, StockInfo stockInfo) {
		if (newAccessToken != null) {
			String requestUrl = sub_stock_url.replace("ACCESS_TOKEN", newAccessToken);
			String json = JSONObject.toJSONString(stockInfo);
			String result = HttpUtils.post(requestUrl, json);
			StockRtnInfo stockRtnInfo = JSON.parseObject(result, StockRtnInfo.class);
			return stockRtnInfo;
		}
		return null;
	}

}
