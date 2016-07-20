package com.itfvck.wechatframework.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itfvck.wechatframework.token.TokenProxy;

@Controller
public class LoginController {
	private static Logger logger = LoggerFactory.getLogger(LoginController.class);
	@Autowired
	private TokenProxy tokenProxy;

	@RequestMapping(value = "login/index")
	public ModelAndView index(ModelAndView mv) {
		mv.setViewName("login/index");
		return mv;
	}

}
