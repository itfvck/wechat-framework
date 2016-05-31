/**
 * 
 */
package com.itfvck.wechatframework.core.token;

import java.util.Timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itfvck.wechatframework.core.token.timer.AccessTokenTimer;
import com.itfvck.wechatframework.core.token.timer.JsApiTicketTimer;

/**
 * Access Token 监听器
 * 
 * @author ChengNing
 * @date 2015年1月8日
 */
public class TokenListener implements ServletContextListener {

    private static Logger log = LoggerFactory.getLogger(TokenListener.class);

    private Timer timer = null;

    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        log.info("accessToken监听器启动..........");
        timer = new Timer(true);
        // 注册定时任务
        registeAccessTokenTimer();
        // 注册jsapi_ticket定时器
        registeJsApiTicketTimer();
    }

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        timer.cancel();
    }

    /**
     * 注册accessToken定时器
     */
    private void registeAccessTokenTimer() {
        AccessTokenTimer accessTokenTimer = new AccessTokenTimer();
        timer.schedule(accessTokenTimer, AccessTokenTimer.DELAY, AccessTokenTimer.PERIOD);
        log.info("accessTokenTimer定时器注册成功，执行间隔为" + AccessTokenTimer.PERIOD);
    }

    /**
     * 注册jsapi_ticket定时器
     */
    private void registeJsApiTicketTimer() {
        JsApiTicketTimer jsApiTicketTimer = new JsApiTicketTimer();
        timer.schedule(jsApiTicketTimer, JsApiTicketTimer.DELAY, JsApiTicketTimer.PERIOD);
        log.info("jsApiTicketTimer定时器注册成功，执行间隔为" + JsApiTicketTimer.PERIOD);
    }

}
