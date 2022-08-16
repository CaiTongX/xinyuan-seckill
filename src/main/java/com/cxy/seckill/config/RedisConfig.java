package com.cxy.seckill.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * 
 * @author 53429
 *redis配置类
 *主要实现二进制数据的序列化
 */
@Configuration
public class RedisConfig {
	
	@Bean
	//该方法需要带参数,参数为Redis连接工厂
	public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory connectionFactory){
		RedisTemplate<String, Object> redisTemplate=new RedisTemplate<>();
		//key的序列化
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		//value序列化
		redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());//这个GJackson比较通用
		//hash类型 key的序列化
		redisTemplate.setHashKeySerializer(new StringRedisSerializer());
		//hash类型 value序列化
		redisTemplate.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());
		
		//注意必须配置全否则启动会报错
		
		//注入连接工厂
		redisTemplate.setConnectionFactory(connectionFactory);
		return redisTemplate;
	}

}
