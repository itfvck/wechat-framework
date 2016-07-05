package com.itfvck.wechatframework.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itfvck.wechatframework.api.oauth.WxOAuth2API;
import com.itfvck.wechatframework.api.oauth.OAuthData;
import com.itfvck.wechatframework.api.user.User;
import com.itfvck.wechatframework.api.user.WxUserAPI;
import com.itfvck.wechatframework.token.TokenProxy;

@Controller
public class IndexController {
	private static Logger logger = LoggerFactory.getLogger(IndexController.class);
	@Autowired
	private TokenProxy tokenProxy;

	@RequestMapping(value = "wechat/index")
	public ModelAndView index(ModelAndView mv) {
		String redirectURI = WxOAuth2API.generateRedirectURI("http://itfvck.ittun.com/wechat/oath2", "wx44d483e10bee9fc1");
		mv.addObject("redirectURI", redirectURI);
		mv.setViewName("index");
		return mv;
	}

	@RequestMapping(value = "wechat/oath2")
	public ModelAndView oath2(ModelAndView mv, OAuthData authData) {
		authData = WxOAuth2API.getAccess_token("wx44d483e10bee9fc1", "353df047c6100ad4922e08f150306bbe", authData.getCode());
		if (authData != null) {
			User userInfo = WxUserAPI.getUserInfo(authData.getOpenid(), tokenProxy.accessToken("wx44d483e10bee9fc1", "353df047c6100ad4922e08f150306bbe"));
			if (userInfo != null) {
				mv.addObject("userInfo", userInfo);
			} else {
				logger.error("网页授权获取用户信息出错");
				mv.setViewName("error/404");
				return mv;
			}
		} else {
			logger.error("获取网页授权信息出错");
			mv.setViewName("error/404");
			return mv;
		}
		String redirectURI = WxOAuth2API.generateRedirectURI("http://itfvck.ittun.com/wechat/oath2", "wx44d483e10bee9fc1");
		mv.addObject("redirectURI", redirectURI);
		mv.setViewName("index");
		return mv;
	}
}
