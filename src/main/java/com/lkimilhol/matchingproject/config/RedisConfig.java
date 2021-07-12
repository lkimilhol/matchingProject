package com.lkimilhol.matchingproject.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.RedisConnectionFailureException;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.lkimilhol.matchingproject.exception.CustomException;
import com.lkimilhol.matchingproject.exception.ErrorInfo;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class RedisConfig {
	@Value("${spring.redis.host}")
	private String host;

	@Value("${spring.redis.port}")
	private int port;

	@Bean
	public JedisConnectionFactory jedisConnectionFactory() {
		JedisConnectionFactory jedisConnectionFactory = null;

		try {
			RedisStandaloneConfiguration conn = new RedisStandaloneConfiguration();
			conn.setHostName(host);
			conn.setPort(port);

			jedisConnectionFactory = new JedisConnectionFactory(conn);

		} catch (Exception e) {
			throw new RedisConnectionFailureException("redis connect failed");
		}

		return jedisConnectionFactory;
	}

	@Bean
	public RedisTemplate<String, String> redisTemplate(JedisConnectionFactory jedisConnectionFactory) {
		final RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();

		redisTemplate.setDefaultSerializer(new StringRedisSerializer());
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplate.setHashKeySerializer(new StringRedisSerializer());
		redisTemplate.setHashValueSerializer(new GenericToStringSerializer<>(Object.class));
		redisTemplate.setValueSerializer(new GenericToStringSerializer<>(Object.class));

		redisTemplate.setConnectionFactory(jedisConnectionFactory);

		return redisTemplate;
	}
}