package com.itfvck.wechatframework.timer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository(value = "timertaskService")
public class TimerTask {
    static Logger logger = LoggerFactory.getLogger(TimerTask.class);
    private static int time = 0;

    /**
     * 定时更新access_token,jsapi_ticket
     */
    public void run() {
//        String accessToken = TokenProxy.accessToken();
//        logger.info("系统中access_token:" + accessToken);
//        String jsApiTicket = TokenProxy.jsApiTicket();
//        logger.info("系统中jsapi_ticket:" + jsApiTicket);
    }

}