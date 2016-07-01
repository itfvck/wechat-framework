import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.StringRedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import junit.framework.TestCase;

public class RedisTest extends TestCase {
	public ApplicationContext ctx;

	public JedisConnectionFactory jedisConnetionFactory;

	public RedisTemplate redisTemplate;

	@BeforeClass
	public void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		ctx = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
		jedisConnetionFactory = (JedisConnectionFactory) ctx.getBean("jedisConnFactory");
		redisTemplate = (StringRedisTemplate) ctx.getBean("redisTemplate");
	}

	@Test
	public void testA() {
		System.out.println(redisTemplate);

	}

	// 测试RedisTemplate,自主处理key的可读性(String序列号)
	@Test
	public void test4() {
		String key = "spring";
		ListOperations<String, String> lop = redisTemplate.opsForList();
		RedisSerializer<String> serializer = new StringRedisSerializer();
		redisTemplate.setKeySerializer(serializer);
		redisTemplate.setValueSerializer(serializer);
		// rt.setDefaultSerializer(serializer);

		lop.leftPush(key, "aaa");
		lop.leftPush(key, "bbb");
		long size = lop.size(key); // rt.boundListOps(key).size();
		Assert.assertEquals(2, size);
	}

	// 测试便捷对象StringRedisTemplate
	@Test
	public void test5() {
		ValueOperations<String, String> vop = redisTemplate.opsForValue();
		String key = "string_redis_template";
		String v = "use StringRedisTemplate set k v";
		vop.set(key, v);
		String value = vop.get(key);
		Assert.assertEquals(v, value);
	}

	// 测试Callback
	@Test
	public void test61() {
		Long dbsize = (Long) redisTemplate.execute(new RedisCallback<Object>() {
			public Long doInRedis(RedisConnection connection) throws DataAccessException {
				StringRedisConnection stringRedisConnection = (StringRedisConnection) connection;
				return stringRedisConnection.dbSize();
			}
		});
		System.out.println("dbsize:" + dbsize);
	}

	// 测试SessionCallback代码示例：
	@Test
	public void test62() {
		List<Object> txresult = (List<Object>) redisTemplate.execute(new SessionCallback<List<Object>>() {
			public List<Object> execute(RedisOperations operations) throws DataAccessException {
				operations.multi();
				operations.opsForHash().put("hkey", "multikey4", "multivalue4");
				operations.opsForHash().get("hkey", "k1");
				return operations.exec();
			}
		});
		for (Object o : txresult) {
			System.out.println(o);
			/**
			 * 0. false/true 1. v1
			 */
		}
	}

}
