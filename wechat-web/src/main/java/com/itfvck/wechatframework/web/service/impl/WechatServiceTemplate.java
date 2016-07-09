package com.itfvck.wechatframework.web.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itfvck.wechatframework.core.common.BaseParams;
import com.itfvck.wechatframework.core.common.WechatCommonConst;
import com.itfvck.wechatframework.core.common.WechatParam;
import com.itfvck.wechatframework.core.util.SignatureUtil;
import com.itfvck.wechatframework.web.service.AbstractWechatService;

/**
 * 默认公众号消息批量处理工具
 * 
 * @author vcdemon
 *
 */
public class WechatServiceTemplate extends AbstractWechatService {
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.itfvck.wechatframework.web.service.AbstractWechatService#check(com. itfvck.wechatframework.core.common.WechatParam, java.util.List)
	 */
	@Override
	public boolean check(WechatParam params, List<BaseParams> baseParamList) {
		for (BaseParams baseParams : baseParamList) {
			// 逐一验证公众号URL
			boolean result = SignatureUtil.checkSignature(params, baseParams.getToken());
			// 一旦通过即刻返回验证通过
			if (result) {
				return result;
			}
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.itfvck.wechatframework.web.service.AbstractWechatService#getResponse( javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse,
	 * com.itfvck.wechatframework.core.common.WechatParam, java.util.List)
	 */
	@Override
	public String getResponse(HttpServletRequest request, HttpServletResponse response, WechatParam params, List<BaseParams> baseParamList) {
		for (BaseParams baseParams : baseParamList) {
			// 逐一处理公众号请求
			String result = wechatService.service(request, baseParams, params,baseParamList);
			// 一旦消息处理正确，即刻返回
			if (!WechatCommonConst.SERVICE_ERROR.getValue().equals(result)) {
				return result;
			}
		}
		return null;
	}
}
