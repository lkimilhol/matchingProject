package com.lkimilhol.matchingProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lkimilhol.matchingProject.config.RedisConfig;
import com.lkimilhol.matchingProject.domain.Order;

@Service
@Transactional
public class RedisService {
	RedisTemplate<String, String> redisTemplate;

	public RedisService(RedisConfig redisConfig) {
		redisTemplate = redisConfig.redisTemplate((redisConfig.jedisConnectionFactory()));
	}

	public void addOrder(Order order) {
		//TODO 데이터 저장 필요
	}
}
