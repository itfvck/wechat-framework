package com.itfvck.wechatframework.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.itfvck.wechatframework.web.context.WechatContextLoader;

/**
 * 微信启动监听器
 * 
 * @author
 *
 */
public class WechatContextLoaderListener extends WechatContextLoader implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // TODO Auto-generated method stub

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // TODO Auto-generated method stub

    }

}
