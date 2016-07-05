package com.itfvck.wechatframework.api.wxshop;

import java.io.File;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.itfvck.wechatframework.api.material.WxMaterialAPI;
import com.itfvck.wechatframework.api.wxshop.model.BaseInfo;
import com.itfvck.wechatframework.api.wxshop.model.Business;
import com.itfvck.wechatframework.api.wxshop.model.BusinessReq;
import com.itfvck.wechatframework.api.wxshop.model.PoiId;
import com.itfvck.wechatframework.api.wxshop.model.ShopInfo;
import com.itfvck.wechatframework.api.wxshop.model.ShopRtnInfo;
import com.itfvck.wechatframework.core.util.http.HttpUtils;

/**
 * 微信门店
 * 
 * @author lihongxuan
 *
 */
public class WxShopAPI {
	// 创建门店
	private static String create_shop_url = "http://api.weixin.qq.com/cgi-bin/poi/addpoi?access_token=TOKEN";
	// 查询门店信息
	private static String get_shop_url = "http://api.weixin.qq.com/cgi-bin/poi/getpoi?access_token=TOKEN";
	// 查询门店列表
	private static String search_shop_url = "https://api.weixin.qq.com/cgi-bin/poi/getpoilist?access_token=TOKEN";
	// 删除门店
	private static String del_shop_url = "https://api.weixin.qq.com/cgi-bin/poi/delpoi?access_token=TOKEN";
	// 上传图片
	private static String upload_img_shop_url = "https://api.weixin.qq.com/cgi-bin/media/uploadimg?access_token=ACCESS_TOKEN";
	// 修改门店服务信息
	private static String updatebystatus_shop_url = "https://api.weixin.qq.com/cgi-bin/poi/updatepoi?access_token=TOKEN";
	// 门店类目表
	private static String shop_category_url = "http://api.weixin.qq.com/cgi-bin/api_getwxcategory?access_token=TOKEN";

	/**
	 * 增加门店
	 */
	public static String getShopCategorys(String newAccessToken) {
		if (newAccessToken != null) {
			String requestUrl = shop_category_url.replace("ACCESS_TOKEN", newAccessToken);
			String result = HttpUtils.get(requestUrl);
			ShopInfo shopInfo = JSON.parseObject(result, ShopInfo.class);
			return shopInfo.getCategory_list();
		}
		return null;
	}

	/**
	 * 增加门店
	 */
	public static ShopRtnInfo doAddshop(String newAccessToken, Business business) {
		if (newAccessToken != null) {
			String requestUrl = create_shop_url.replace("ACCESS_TOKEN", newAccessToken);
			String json = JSONObject.toJSONString(business);
			String result = HttpUtils.post(requestUrl, json);
			ShopRtnInfo shopRtnInfo = JSON.parseObject(result, ShopRtnInfo.class);
			return shopRtnInfo;
		}
		return null;
	}

	/**
	 * 修改门店服务信息
	 */
	public static ShopRtnInfo updateShop(String newAccessToken, Business business) {
		if (newAccessToken != null) {
			String requestUrl = updatebystatus_shop_url.replace("ACCESS_TOKEN", newAccessToken);
			String json = JSONObject.toJSONString(business);
			String result = HttpUtils.post(requestUrl, json);
			ShopRtnInfo shopRtnInfo = JSON.parseObject(result, ShopRtnInfo.class);
			return shopRtnInfo;
		}
		return null;
	}

	/**
	 * 删除门店
	 */
	public static ShopRtnInfo delShop(String newAccessToken, PoiId poiId) {
		if (newAccessToken != null) {
			String requestUrl = del_shop_url.replace("ACCESS_TOKEN", newAccessToken);
			String json = JSONObject.toJSONString(poiId);
			String result = HttpUtils.post(requestUrl, json);
			ShopRtnInfo shopRtnInfo = JSON.parseObject(result, ShopRtnInfo.class);
			return shopRtnInfo;
		}
		return null;
	}

	/**
	 * 查询门店信息
	 */
	public static BaseInfo getshop(String newAccessToken, PoiId poiId) {
		if (newAccessToken != null) {
			String requestUrl = get_shop_url.replace("ACCESS_TOKEN", newAccessToken);
			String json = JSONObject.toJSONString(poiId);
			String result = HttpUtils.post(requestUrl, json);
			BaseInfo baseInfo = JSON.parseObject(result, BaseInfo.class);
			return baseInfo.getBusiness();
		}
		return null;
	}

	/**
	 * 查询门店列表
	 */
	public static List<BaseInfo> getshops(String newAccessToken, BusinessReq businessReq) {
		if (newAccessToken != null) {
			String requestUrl = search_shop_url.replace("ACCESS_TOKEN", newAccessToken);
			String json = JSONObject.toJSONString(businessReq);
			String result = HttpUtils.post(requestUrl, json);
			BaseInfo baseInfo = JSON.parseObject(result, BaseInfo.class);
			return baseInfo.getBusiness_list();
		}
		return null;
	}

	/**
	 * 上传图片
	 * 
	 * @param fileName
	 * @param accountid
	 * @return
	 */
	public static String uploadImg(String newAccessToken, String filePath, String fileName) {
		if (newAccessToken != null) {
			String result = WxMaterialAPI.uploadNewsImg(new File(filePath + fileName), newAccessToken);
			return result;
		}
		return "";
	}
}
