package com.itfvck.wechatframework.web.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itfvck.wechatframework.core.common.BaseParams;
import com.itfvck.wechatframework.core.common.WechatParam;

public interface WechatWebService {

	public boolean check(WechatParam params, List<BaseParams> baseParamList);

	public String getResponse(HttpServletRequest request, HttpServletResponse response, WechatParam params, List<BaseParams> baseParamList);

}
