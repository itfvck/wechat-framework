package com.itfvck.wechatframework.api.wxstore.group;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.itfvck.wechatframework.api.wxstore.group.model.Group;
import com.itfvck.wechatframework.api.wxstore.group.model.GroupDetailInfo;
import com.itfvck.wechatframework.api.wxstore.group.model.GroupProductInfo;
import com.itfvck.wechatframework.api.wxstore.group.model.GroupRtnInfo;
import com.itfvck.wechatframework.core.util.http.HttpUtils;

/**
 * 微信小店 - 分组
 * 
 * @author zhangdaihao
 *
 */
public class WxStoreGroupAPI {
	// 增加分组
	private static String create_group_url = "https://api.weixin.qq.com/merchant/group/add?access_token=ACCESS_TOKEN";
	// 修改分组属性
	private static String update_group_url = "https://api.weixin.qq.com/merchant/group/propertymod?access_token=ACCESS_TOKEN";
	// 根据分组ID获取分组信息
	private static String getid_group_url = "https://api.weixin.qq.com/merchant/group/getbyid?access_token=ACCESS_TOKEN";
	// 删除分组
	private static String del_group_url = "https://api.weixin.qq.com/merchant/group/del?access_token=ACCESS_TOKEN";
	// 获取所有分组
	private static String getall_group_url = "https://api.weixin.qq.com/merchant/group/getall?access_token=ACCESS_TOKEN";
	// 修改分组商品
	private static String update_productmod_url = "https://api.weixin.qq.com/merchant/group/productmod?access_token=ACCESS_TOKEN";

	/**
	 * 增加分组
	 * 
	 * @param group
	 * @return
	 */
	public static GroupRtnInfo doAddGroupManager(String newAccessToken, Group group) {
		if (newAccessToken != null) {
			String requestUrl = create_group_url.replace("ACCESS_TOKEN", newAccessToken);
			String json = JSONObject.toJSONString(group);
			String result = HttpUtils.post(requestUrl, json);
			GroupRtnInfo groupRtnInfo = JSON.parseObject(result, GroupRtnInfo.class);
			return groupRtnInfo;
		}
		return null;
	}

	/**
	 * 删除分组
	 * 
	 * @param group_id
	 * @return
	 */
	public static GroupRtnInfo doDelGroupManager(String newAccessToken, Integer group_id) {
		if (newAccessToken != null) {
			String requestUrl = del_group_url.replace("ACCESS_TOKEN", newAccessToken);
			String json = "{\"group_id\": " + group_id + "}";
			String result = HttpUtils.post(requestUrl, json);
			GroupRtnInfo groupRtnInfo = JSON.parseObject(result, GroupRtnInfo.class);
			return groupRtnInfo;
		}
		return null;
	}

	/**
	 * 修改分组属性
	 * 
	 * @param group
	 * @return
	 */
	public static GroupRtnInfo doUpdateGroupManagerProperties(String newAccessToken, Group group) {
		if (newAccessToken != null) {
			String requestUrl = update_group_url.replace("ACCESS_TOKEN", newAccessToken);
			String json = JSONObject.toJSONString(group);
			String result = HttpUtils.post(requestUrl, json);
			GroupRtnInfo groupRtnInfo = JSON.parseObject(result, GroupRtnInfo.class);
			return groupRtnInfo;
		}
		return null;
	}

	/**
	 * 修改分组商品
	 * 
	 * @param groupProductInfo
	 * @return
	 */
	public static GroupRtnInfo doUpdateGroupManagerProduct(String newAccessToken, GroupProductInfo groupProductInfo) {
		if (newAccessToken != null) {
			String requestUrl = update_productmod_url.replace("ACCESS_TOKEN", newAccessToken);
			String json = JSONObject.toJSONString(groupProductInfo);
			String result = HttpUtils.post(requestUrl, json);
			GroupRtnInfo groupRtnInfo = JSON.parseObject(result, GroupRtnInfo.class);
			return groupRtnInfo;
		}
		return null;
	}

	/**
	 * 获取所有分组
	 * 
	 * @return
	 */
	public static List<GroupDetailInfo> getAllGroup(String newAccessToken) {
		if (newAccessToken != null) {
			String requestUrl = getall_group_url.replace("ACCESS_TOKEN", newAccessToken);
			String result = HttpUtils.get(requestUrl);
			GroupDetailInfo groupsDetailInfo = JSON.parseObject(result, GroupDetailInfo.class);
			return groupsDetailInfo.getGroups_detail();
		}
		return null;
	}

	/**
	 * 根据分组ID获取分组信息
	 * 
	 * @return
	 */
	public static GroupDetailInfo getByGroupId(String newAccessToken, Integer group_id) {
		if (newAccessToken != null) {
			String requestUrl = getid_group_url.replace("ACCESS_TOKEN", newAccessToken);
			String json = "{\"group_id\": " + group_id + "}";
			String result = HttpUtils.post(requestUrl, json);
			GroupDetailInfo groupDetailInfo = JSON.parseObject(result, GroupDetailInfo.class);
			return groupDetailInfo.getGroup_detail();
		}
		return null;
	}
}
