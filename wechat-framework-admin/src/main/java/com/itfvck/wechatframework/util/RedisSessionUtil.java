package com.itfvck.wechatframework.util;

import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.itfvck.wechatframework.common.Constant;
import com.itfvck.wechatframework.jedis.JedisTemplate;

@Service(value = "redisSessionUtil")
public class RedisSessionUtil {
	@Autowired
	private JedisTemplate jedisTemplate;

	/**
	 * @Description 获取sessionid，session存入redis中的key值
	 * @return
	 * @CreationDate 2016年7月14日 上午9:51:31
	 */
	public String getSessionid() {
		return CookieUtil.getValue(Constant.SYS_LOGINUSER);
	}

	/**
	 * @Description 从redis中取出session对象
	 * @return HttpSession
	 * @CreationDate 2016年7月14日 上午9:52:09
	 */
	public JSONObject getSession() {
		String sessionid = getSessionid();
		if (StringUtils.isNotEmpty(sessionid)) {
			JSONObject jsonObject = jedisTemplate.get(sessionid, JSONObject.class);
			if (jsonObject == null) {
				return new JSONObject();
			}
			return jsonObject;
		}
		return null;
	}

	/**
	 * @Description 获取session中的对象元素
	 * @param key
	 * @param clazz
	 *            对象类型
	 * @return
	 * @CreationDate 2016年7月14日 下午3:17:45
	 */
	public <T> T getObject(String key, Class<T> clazz) {
		JSONObject session = getSession();
		if (session != null) {
			Object object = getSession().get(key);
			if (object != null) {
				return JSONObject.parseObject(JSONObject.toJSONString(object), clazz);
			}
		}
		return null;
	}

	/**
	 * @Description 取出session中的json字符串
	 * @param key
	 * @return
	 * @CreationDate 2016年7月14日 下午7:38:59
	 */
	public String getObject(String key) {
		JSONObject session = getSession();
		if (session != null) {
			Object object = getSession().get(key);
			if (object != null) {
				return JSONObject.toJSONString(object);
			}
		}
		return null;
	}

	/**
	 * @Description session使用完成后，重新存入redis中,该方法用于持久化JSONObject session
	 * @param session
	 * @CreationDate 2016年7月14日 上午9:52:53
	 */
	public void setSession(JSONObject session) {
		String sessionid = getSessionid();
		if (StringUtils.isNotEmpty(sessionid)) {
			jedisTemplate.setSession(sessionid, session);
		}
	}

	/**
	 * @Description 将对象存入session，并自动将session存入redis，该方法适用于只有一次session保存操作.
	 *              <p>
	 *              若要多次保存session数据，则建议先取出session 方法：public JSONObject getSession()，
	 *              <p>
	 *              完成将数据存入session中之后,session.put(key,value)，
	 *              <p>
	 *              再调用public void setSession(JSONObject session)统一存入redis
	 * @param key
	 * @param object
	 * @CreationDate 2016年7月20日 上午10:02:02
	 */
	public void setSession(String key, Object object) {
		JSONObject session = getSession();
		session.put(key, object);
		String sessionid = getSessionid();
		if (StringUtils.isNotEmpty(sessionid)) {
			jedisTemplate.setSession(sessionid, session);
		}
	}

	/**
	 * @Description 用户登出，清除redis、cookie
	 * @param response
	 * @CreationDate 2016年7月14日 上午9:16:59
	 */
	public void invalidate(HttpServletResponse response) {
		String sessionid = getSessionid();
		if (StringUtils.isNotEmpty(sessionid)) {
			// 删除redis中session
			jedisTemplate.delete(sessionid);
		}
	}

	/**
	 * @Description 用户发出新的请求，刷新用户redis信息，模拟session的更新有效时间机制
	 * @param response
	 * @CreationDate 2016年7月14日 上午9:28:49
	 */
	public void refresh(HttpServletResponse response) {
		String sessionid = getSessionid();
		if (StringUtils.isNotEmpty(sessionid)) {
			// 刷新session信息,保持有效时间最新
			jedisTemplate.expire(sessionid, Constant.SESSION_EXPIRE_TIME, TimeUnit.SECONDS);
		}
	}
}
