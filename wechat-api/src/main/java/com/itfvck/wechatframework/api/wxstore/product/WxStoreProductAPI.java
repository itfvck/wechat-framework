package com.itfvck.wechatframework.api.wxstore.product;

import java.io.File;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.itfvck.wechatframework.api.wxstore.product.model.CateInfo;
import com.itfvck.wechatframework.api.wxstore.product.model.CommodityRtnInfo;
import com.itfvck.wechatframework.api.wxstore.product.model.Product;
import com.itfvck.wechatframework.api.wxstore.product.model.PropertiesInfo;
import com.itfvck.wechatframework.api.wxstore.product.model.SkuInfo;
import com.itfvck.wechatframework.core.util.http.HttpUtils;

/**
 * 微信小店 - 商品
 * 
 * @author zhangdaihao
 *
 */
public class WxStoreProductAPI {
	// 增加商品
	private static String create_commodity_url = "https://api.weixin.qq.com/merchant/create?access_token=%s";
	// 修改商品
	private static String update_commodity_url = "https://api.weixin.qq.com/merchant/update?access_token=%s";
	// 查询商品
	private static String get_commodity_url = "https://api.weixin.qq.com/merchant/get?access_token=ACCESS_TOKEN";
	// 删除商品
	private static String del_commodity_url = "https://api.weixin.qq.com/merchant/del?access_token=ACCESS_TOKEN";
	// 上传图片
	private static String upload_img_commodity_url = "https://api.weixin.qq.com/merchant/common/upload_img?access_token=ACCESS_TOKEN&filename=IMG_NAME";
	// 获取指定状态商品
	private static String getbystatus_commodity_url = "https://api.weixin.qq.com/merchant/getbystatus?access_token=ACCESS_TOKEN";
	// 商品上下架
	private static String modproductstatus_commodity_url = "https://api.weixin.qq.com/merchant/modproductstatus?access_token=ACCESS_TOKEN";
	// 指定分类的所有子分类
	private static String getsub_commodity_url = "https://api.weixin.qq.com/merchant/category/getsub?access_token=ACCESS_TOKEN";
	// 指定子分类的所有SKU
	private static String getsku_commodity_url = "https://api.weixin.qq.com/merchant/category/getsku?access_token=ACCESS_TOKEN";
	// 指定分类的所有属性
	private static String getproperty_commodity_url = "https://api.weixin.qq.com/merchant/category/getproperty?access_token=ACCESS_TOKEN";

	/**
	 * 增加商品
	 */
	public static CommodityRtnInfo doAddCommodity(String newAccessToken, Product product) {
		if (newAccessToken != null) {
			String requestUrl = String.format(create_commodity_url, newAccessToken);
			String json = JSONObject.toJSONString(product);
			String result = HttpUtils.post(requestUrl, json);
			CommodityRtnInfo commodityRtnInfo = JSON.parseObject(result, CommodityRtnInfo.class);
			return commodityRtnInfo;
		}
		return null;
	}

	/**
	 * 删除商品
	 */
	public static CommodityRtnInfo doDelCommodity(String newAccessToken, String product_id) {
		if (newAccessToken != null) {
			String json = "{\"product_id\": \"" + product_id + "\"}";
			String requestUrl = String.format(del_commodity_url, newAccessToken);
			String result = HttpUtils.post(requestUrl, json);
			CommodityRtnInfo commodityRtnInfo = JSON.parseObject(result, CommodityRtnInfo.class);
			return commodityRtnInfo;
		}
		return null;
	}

	/**
	 * 修改商品
	 */
	public static CommodityRtnInfo doUpdateCommodity(String newAccessToken, Product product, String accountid) {
		if (newAccessToken != null) {
			String requestUrl = update_commodity_url.replace("ACCESS_TOKEN", newAccessToken);
			String json = JSONObject.toJSONString(product);
			String result = HttpUtils.post(requestUrl, json);
			CommodityRtnInfo commodityRtnInfo = JSON.parseObject(result, CommodityRtnInfo.class);
			return commodityRtnInfo;
		}
		return null;
	}

	/**
	 * 获取商品详细
	 */
	public static Product getCommodity(String newAccessToken, String product_id) {
		if (newAccessToken != null) {
			String requestUrl = get_commodity_url.replace("ACCESS_TOKEN", newAccessToken);
			String json = "{\"product_id\": \"" + product_id + "\"}";
			String result = HttpUtils.post(requestUrl, json);
			Product product = JSON.parseObject(result, Product.class);
			return product.getProduct_info();
		}
		return null;
	}

	/**
	 * 获取指定状态的所有商品 商品状态(0-全部, 1-上架, 2-下架)
	 */
	public static CommodityRtnInfo getByStatus(String newAccessToken, Integer status) {
		if (newAccessToken != null) {
			String requestUrl = getbystatus_commodity_url.replace("ACCESS_TOKEN", newAccessToken);
			String json = "{\"status\": " + status + "}";
			String result = HttpUtils.post(requestUrl, json);
			CommodityRtnInfo commodityRtnInfo = JSON.parseObject(result, CommodityRtnInfo.class);
			return commodityRtnInfo;
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
			String requestUrl = upload_img_commodity_url.replace("ACCESS_TOKEN", newAccessToken).replace("IMG_NAME", fileName);
			JSONObject result = JSONObject.parseObject(HttpUtils.postFile(requestUrl, new File(filePath + fileName)));
			if (result.getInteger("errcode") == 0) {
				return result.getString("image_url");
			}
		}
		return "";
	}

	/**
	 * 商品上下架 上下架标识(0-下架, 1-上架)
	 */
	public static CommodityRtnInfo doModproductstatus(String newAccessToken, String product_id, Integer status) {
		if (newAccessToken != null) {
			String requestUrl = modproductstatus_commodity_url.replace("ACCESS_TOKEN", newAccessToken);
			String json = "{\"product_id\":\"" + product_id + "\",\"status\": " + status + "}";
			String result = HttpUtils.post(requestUrl, json);
			CommodityRtnInfo commodityRtnInfo = JSON.parseObject(result, CommodityRtnInfo.class);
			return commodityRtnInfo;
		}
		return null;
	}

	/**
	 * 获取指定分类的所有子分类
	 */
	public static List<CateInfo> getCateSub(String newAccessToken, Integer cate_id) {
		if (newAccessToken != null) {
			String requestUrl = getsub_commodity_url.replace("ACCESS_TOKEN", newAccessToken);
			String json = "{\"cate_id\": " + cate_id + "}";
			String result = HttpUtils.post(requestUrl, json);
			CateInfo cateInfos = JSON.parseObject(result, CateInfo.class);
			return cateInfos.getCate_list();
		}
		return null;
	}

	/**
	 * 获取指定子分类的所有SKU
	 */
	public static List<SkuInfo> getCateSubSku(String newAccessToken, Integer cate_id) {
		if (newAccessToken != null) {
			String requestUrl = getsku_commodity_url.replace("ACCESS_TOKEN", newAccessToken);
			String json = "{\"cate_id\": " + cate_id + "}";
			String result = HttpUtils.post(requestUrl, json);
			SkuInfo skuInfos = JSON.parseObject(result, SkuInfo.class);
			return skuInfos.getSku_table();
		}
		return null;
	}

	/**
	 * 获取指定分类的所有属性
	 */
	public static List<PropertiesInfo> getPropertyByCateId(String newAccessToken, Integer cate_id) {
		if (newAccessToken != null) {
			String requestUrl = getproperty_commodity_url.replace("ACCESS_TOKEN", newAccessToken);
			String json = "{\"cate_id\": " + cate_id + "}";
			String result = HttpUtils.post(requestUrl, json);
			PropertiesInfo propertiesInfos = JSON.parseObject(result, PropertiesInfo.class);
			return propertiesInfos.getProperties();
		}
		return null;
	}
}
