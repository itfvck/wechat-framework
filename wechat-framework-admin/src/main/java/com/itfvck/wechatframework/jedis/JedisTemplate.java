package com.itfvck.wechatframework.jedis;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.RedisTemplate;

import com.alibaba.fastjson.JSONObject;
import com.itfvck.wechatframework.common.Constant;

/**
 * jedis封装
 * 
 * @author vcdemon
 *
 */
public class JedisTemplate extends RedisTemplate<String, String> {
	/**
	 * @Description 字符串存入redis，有默认过期时间,通常用于存放session数据
	 * @see Constant.SESSION_EXPIRE_TIME 时间常量
	 * @param key
	 *            键
	 * @param value
	 *            值:字符串
	 * @return
	 */
	public void setSession(String key, String value) {
		setex(key, Constant.SESSION_EXPIRE_TIME, value);
	}

	/**
	 * @Description 对象存入redis，有默认过期时间,通常用于存放session数据
	 * @see Constant.SESSION_EXPIRE_TIME 时间常量
	 * @param key
	 *            键
	 * @param instance
	 *            值：对象
	 * @return
	 * @CreationDate 2016年7月13日 下午5:20:55
	 */
	public void setSession(String key, Object object) {
		setex(key, Constant.SESSION_EXPIRE_TIME, object);
	}

	/**
	 * @Description 将对象存入redis，不限制有效期
	 * @param key
	 * @param object
	 * @CreationDate 2016年7月14日 下午2:14:49
	 */
	public void set(String key, Object object) {
		if (object != null) {
			this.opsForValue().set(key, JSONObject.toJSONString(object));
		}
	}

	/**
	 * @Description 将对象存入redis，设置有效期
	 * @param key
	 * @param seconds
	 *            过期时间，单位秒
	 * @param object
	 * @return
	 * @CreationDate 2016年7月14日 下午2:27:26
	 */
	public void setex(String key, long seconds, Object object) {
		if (object != null) {
			this.opsForValue().set(key, JSONObject.toJSONString(object), seconds, TimeUnit.SECONDS);
		}
	}

	/**
	 * @Description 将字符串存入redis，设置有效期
	 * @param key
	 * @param seconds
	 *            过期时间，单位秒
	 * @param object
	 * @return
	 * @CreationDate 2016年7月14日 下午2:27:26
	 */
	public void setex(String key, long seconds, String value) {
		if (StringUtils.isNotEmpty(value)) {
			this.opsForValue().set(key, value, seconds, TimeUnit.SECONDS);
		}
	}

	/**
	 * 将对象存入redis，设置有效期
	 * 
	 * @param key
	 * @param timeout
	 *            过期时间
	 * @param object
	 * @param unit
	 *            时间单位
	 */
	public void setex(String key, long timeout, Object object, TimeUnit unit) {
		if (object != null) {
			this.opsForValue().set(key, JSONObject.toJSONString(object), timeout, unit);
		}
	}

	/**
	 * 将字符串存入redis，设置有效期
	 * 
	 * @param key
	 * @param timeout
	 *            过期时间
	 * @param object
	 * @param unit
	 *            时间单位
	 */
	public void setex(String key, long timeout, String value, TimeUnit unit) {
		if (StringUtils.isNotEmpty(value)) {
			this.opsForValue().set(key, value, timeout, unit);
		}
	}

	/**
	 * @Description 将对象从redis中取出
	 * @param key
	 * @param clazz
	 *            对象类型
	 * @return
	 * @CreationDate 2016年7月14日 下午2:15:09
	 */
	public <T> T get(String key, Class<T> clazz) {
		String value = get(key);
		if (StringUtils.isNotEmpty(value)) {
			return JSONObject.parseObject(value, clazz);
		}
		return null;
	}

	/**
	 * 将字符串从redis中取出
	 * 
	 * @param key
	 * @return
	 */
	public String get(String key) {
		String value = this.opsForValue().get(key);
		if (StringUtils.isNotEmpty(value)) {
			return value;
		}
		return null;
	}
}
