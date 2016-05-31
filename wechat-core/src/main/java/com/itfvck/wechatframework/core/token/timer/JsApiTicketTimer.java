/**
 * 
 */
package com.itfvck.wechatframework.core.token.timer;

import java.util.TimerTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itfvck.wechatframework.core.token.Ticket;
import com.itfvck.wechatframework.core.token.TicketType;
import com.itfvck.wechatframework.core.token.server.CustomerServer;
import com.itfvck.wechatframework.core.token.server.JsApiTicketServer;

/**
 * @author ChengNing
 * @date 2015年1月29日
 */
public class JsApiTicketTimer extends TimerTask {

    private static Logger logger = LoggerFactory.getLogger(JsApiTicketTimer.class);
    // jsapi_ticket有效期7200秒,提前200秒请求新的token
    public static final long PERIOD = 7000 * 1000;
    public static final long DELAY = 0; // 此任务的延迟时间为0，即立即执行

    @Override
    public void run() {
        logger.info("jsapi_ticket 定时任务启动，获取新的jsapi_ticket");
        // 得到新的access token
        Ticket jsapiTicket = new Ticket(TicketType.jsapi);
        // 手动获取成功之后持久化accessToken
        if (jsapiTicket.request()) {
            JsApiTicketServer jsapiTicketServer = new JsApiTicketServer();
            if (jsapiTicketServer.customerServer() != null) {
                CustomerServer customerServer = (CustomerServer) jsapiTicketServer.customerServer();
                customerServer.save(jsapiTicket);
            }
        }
        logger.info("jsapi_ticket 定时任务结束，新的jsapi_ticket：" + jsapiTicket.getToken());
    }

}
