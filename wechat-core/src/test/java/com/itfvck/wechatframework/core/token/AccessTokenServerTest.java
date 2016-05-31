/**
 * 
 */
package com.itfvck.wechatframework.core.token;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itfvck.wechatframework.core.token.server.AccessTokenServer;
import com.itfvck.wechatframework.core.util.HttpUtils;

/**
 * @author ChengNing
 * @date 2015年1月30日
 */
public class AccessTokenServerTest {

    private static Logger logger = LoggerFactory.getLogger(AccessTokenServerTest.class);

    @Test
    public void test() {
        AccessTokenServer accessTokenServer = new AccessTokenServer();
        accessTokenServer.defaultServer();
    }

    @Test
    public void testGet() {
        try {
            String result = HttpUtils.get("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wx925a77489e94a7e6&secret=d29ae7a0b55d2f8570107d90985034dc");
            logger.info(result);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
