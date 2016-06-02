package com.itfvck.wechatframework.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CoreController {
    static Logger logger = LoggerFactory.getLogger(CoreController.class);

    @RequestMapping(value = { "test" }, method = { RequestMethod.GET, RequestMethod.POST })
    public ModelAndView test(HttpServletRequest request, HttpServletResponse response, ModelAndView mv) {

        mv.setViewName("test1");
        return mv;
    }
}
