package com.han.adminlogin.config.redis;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.net.UnknownHostException;

/**
 *@author sunq
 *@date2019/8/13 16:39
 *@Description redis 配置
 */
@Configuration
public class RedisAutoConfiguration {


	@Bean("redisTemplate")
	public RedisTemplate<Object, Object> getRedisTemplate(RedisConnectionFactory redisConnectionFactory)
			throws UnknownHostException {
		RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();

		redisTemplate.setConnectionFactory(redisConnectionFactory);

		Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);

		ObjectMapper om = new ObjectMapper();
		om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
		om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
		jackson2JsonRedisSerializer.setObjectMapper(om);

		StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
		redisTemplate.setKeySerializer(stringRedisSerializer);    // key 的序列化类型
		redisTemplate.setHashKeySerializer(stringRedisSerializer);    // hash 的 key 也采用String 序列化方式

		redisTemplate.setValueSerializer(jackson2JsonRedisSerializer); // value 序列化方式采用 Jackson
		redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer); // hash 的 value 序列化方式采用 Jackson


		redisTemplate.afterPropertiesSet();

		return redisTemplate;
	}

}