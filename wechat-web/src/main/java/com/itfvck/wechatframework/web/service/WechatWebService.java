package com.itfvck.wechatframework.web.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itfvck.wechatframework.core.common.BaseParams;
import com.itfvck.wechatframework.core.common.WechatParam;

public interface WechatWebService {

	/**
	 * 批量验证微信公众号URL接入
	 * 
	 * @param params
	 *            接收到的微信服务器的请求参数
	 * @param baseParamList
	 *            微信公众号列表
	 * @return 验证通过为true
	 */
	public boolean check(WechatParam params, List<BaseParams> baseParamList);

	/**
	 * 批量处理微信公众号的消息，得到返回结果
	 * 
	 * @param request
	 * @param response
	 * @param params
	 *            接收到的微信服务器的请求参数
	 * @param baseParamList
	 *            微信公众号列表
	 * @return
	 */
	public String getResponse(HttpServletRequest request, HttpServletResponse response, WechatParam params, List<BaseParams> baseParamList);

}
