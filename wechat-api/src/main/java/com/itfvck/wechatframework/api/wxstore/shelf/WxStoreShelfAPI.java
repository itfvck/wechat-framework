package com.itfvck.wechatframework.api.wxstore.shelf;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.itfvck.wechatframework.api.wxstore.shelf.model.Shelf;
import com.itfvck.wechatframework.api.wxstore.shelf.model.ShelfRInfo;
import com.itfvck.wechatframework.api.wxstore.shelf.model.ShelfRtnInfo;
import com.itfvck.wechatframework.core.util.http.HttpUtils;

/**
 * 微信小店 - 货架
 * 
 * @author zhangdaihao
 *
 */
public class WxStoreShelfAPI {

	// 增加货架
	private static String create_shelf_url = "https://api.weixin.qq.com/merchant/shelf/add?access_token=ACCESS_TOKEN";

	// 根据货架ID获取货架信息
	private static String getid_shelf_url = "https://api.weixin.qq.com/merchant/shelf/getbyid?access_token=ACCESS_TOKEN";

	// 获取所有货架
	private static String getall_shelf_url = "https://api.weixin.qq.com/merchant/shelf/getall?access_token=ACCESS_TOKEN";

	// 修改货架
	private static String update_shelf_url = "https://api.weixin.qq.com/merchant/shelf/mod?access_token=ACCESS_TOKEN";

	// 删除货架
	private static String del_shelf_url = "https://api.weixin.qq.com/merchant/shelf/del?access_token=ACCESS_TOKEN";

	/**
	 * 增加货架
	 * 
	 * @param postage
	 * @return
	 */
	public static ShelfRtnInfo doAddExpress(String newAccessToken, Shelf shelf) {
		if (newAccessToken != null) {
			String requestUrl = create_shelf_url.replace("ACCESS_TOKEN", newAccessToken);
			String json = JSONObject.toJSONString(shelf);
			String result = HttpUtils.post(requestUrl, json);
			ShelfRtnInfo shelfRtnInfo = JSON.parseObject(result, ShelfRtnInfo.class);
			return shelfRtnInfo;
		}
		return null;
	}

	/**
	 * 修改货架
	 * 
	 * @param postage
	 * @return
	 */
	public static ShelfRtnInfo doUpdateExpress(String newAccessToken, Shelf shelf) {
		if (newAccessToken != null) {
			String requestUrl = update_shelf_url.replace("ACCESS_TOKEN", newAccessToken);
			String json = JSONObject.toJSONString(shelf);
			String result = HttpUtils.post(requestUrl, json);
			ShelfRtnInfo shelfRtnInfo = JSON.parseObject(result, ShelfRtnInfo.class);
			return shelfRtnInfo;
		}
		return null;
	}

	/**
	 * 删除货架
	 * 
	 * @param shelf_id
	 * @return
	 */
	public static ShelfRtnInfo doDelShelfManager(String newAccessToken, Integer shelf_id) {
		if (newAccessToken != null) {
			String requestUrl = del_shelf_url.replace("ACCESS_TOKEN", newAccessToken);
			String json = "{\"shelf_id\": " + shelf_id + "}";
			String result = HttpUtils.post(requestUrl, json);
			ShelfRtnInfo shelfRtnInfo = JSON.parseObject(result, ShelfRtnInfo.class);
			return shelfRtnInfo;
		}
		return null;
	}

	/**
	 * 根据货架ID获取货架信息
	 * 
	 * @param shelf_id
	 * @return
	 */
	public static ShelfRInfo getByShelfId(String newAccessToken, Integer shelf_id) {
		if (newAccessToken != null) {
			String requestUrl = getid_shelf_url.replace("ACCESS_TOKEN", newAccessToken);
			String json = "{\"shelf_id\": " + shelf_id + "}";
			String result = HttpUtils.post(requestUrl, json);
			ShelfRInfo shelfRInfo = JSON.parseObject(result, ShelfRInfo.class);
			return shelfRInfo;
		}
		return null;
	}

	/**
	 * 获取所有货架信息
	 * 
	 * @return
	 */
	public static List<ShelfRInfo> getAllShelf(String newAccessToken) {
		if (newAccessToken != null) {
			String requestUrl = getall_shelf_url.replace("ACCESS_TOKEN", newAccessToken);
			String result = HttpUtils.post(requestUrl);
			ShelfRInfo shelfRInfos = JSON.parseObject(result, ShelfRInfo.class);
			return shelfRInfos.getShelves();
		}
		return null;
	}
}
