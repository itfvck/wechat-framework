package com.itfvck.wechatframework.web.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itfvck.wechatframework.core.common.BaseParams;
import com.itfvck.wechatframework.core.common.WechatCommonConst;
import com.itfvck.wechatframework.core.common.WechatParam;
import com.itfvck.wechatframework.core.util.SignatureUtil;
import com.itfvck.wechatframework.web.service.AbstractWechatService;

public class WechatServiceTemplate extends AbstractWechatService {
	@Override
	public boolean check(WechatParam params, List<BaseParams> baseParamList) {
		for (BaseParams baseParams : baseParamList) {
			boolean result = SignatureUtil.checkSignature(params, baseParams.getToken());
			if (result) {
				return result;
			}
		}
		return false;
	}

	@Override
	public String getResponse(HttpServletRequest request, HttpServletResponse response, WechatParam params, List<BaseParams> baseParamList) {
		for (BaseParams baseParams : baseParamList) {
			String result = wechatService.service(request, baseParams, params);
			if (!WechatCommonConst.SERVICE_ERROR.getValue().equals(result)) {
				return result;
			}
		}
		return null;
	}
}
