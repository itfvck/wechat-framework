package com.itfvck.wechatframework.web.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itfvck.wechatframework.web.support.WechatSupport;

public class WechatDefaultService extends WechatSupport {
    static Logger logger = LoggerFactory.getLogger(WechatDefaultService.class);

    private static class SingletonClassInstance {
        private static final WechatDefaultService instance = new WechatDefaultService();
    }

    public static WechatDefaultService instance() {
        return SingletonClassInstance.instance;
    }

    private WechatDefaultService() {

    }
}
