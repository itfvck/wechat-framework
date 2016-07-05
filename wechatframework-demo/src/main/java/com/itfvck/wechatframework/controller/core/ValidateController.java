package com.itfvck.wechatframework.controller.core;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.itfvck.wechatframework.api.jsapi.WxJsSDKAPI;
import com.itfvck.wechatframework.api.jsapi.JSSDKParams;
import com.itfvck.wechatframework.token.TokenProxy;

@Controller
public class ValidateController {
	private static Logger logger = LoggerFactory.getLogger(ValidateController.class);
	@Autowired
	private TokenProxy tokenProxy;

	/**
	 * 微信JS-SDK权限验证
	 * 
	 * @param url
	 *            JS-SDK所在的当前页面地址
	 * @return
	 * @author
	 */
	@RequestMapping(value = "wechat/jssdk")
	@ResponseBody
	public Map<String, Object> signatureJSSDK(String url) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			String jsTiket = tokenProxy.jsTiket("wx44d483e10bee9fc1", "353df047c6100ad4922e08f150306bbe");
			JSSDKParams signature = WxJsSDKAPI.signatureJS_SDK(jsTiket, url, "wx44d483e10bee9fc1");
			map.put("msg", "success");
			map.put("result", signature);
		} catch (Exception e) {
			map.put("msg", "验证错误");
			logger.error("jssdk验证错误", e);
			return map;
		}
		return map;
	}

	/**
	 * 非微信浏览器跳转地址
	 * 
	 * @param mv
	 * @return
	 * @author
	 */
	@RequestMapping(value = "wechat/invalidBs")
	public ModelAndView invalidBS(ModelAndView mv) {
		mv.setViewName("error/40001");
		logger.error("非微信浏览器");
		return mv;
	}

}
