package com.itfvck.wechatframework.api.commom;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSON;
import com.itfvck.wechatframework.core.common.BaseParams;
import com.itfvck.wechatframework.core.util.http.HttpUtils;

/**
 * @Description 基础API
 * @Author vcdemon
 * @CreationDate 2016年5月12日 上午10:31:55
 */
public class BaseAPI {
	private static final String GET_IP_LIST = "https://api.weixin.qq.com/cgi-bin/getcallbackip?access_token=%s";

	/**
	 * @Description 获取微信服务器IP地址
	 * @param BaseParams
	 *            传入access_token
	 * @return
	 * @CreationDate 2016年5月12日 上午11:54:09
	 * @Author vcdemon
	 */
	public static BaseParams getIp_list(BaseParams baseData) {
		try {
			String responseBody = HttpUtils.get(String.format(GET_IP_LIST, baseData.getAccess_token()));
			if (StringUtils.isNotEmpty(responseBody)) {
				baseData.setIp_list(JSON.parseObject(responseBody, BaseParams.class).getIp_list());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return baseData;
	}

}
