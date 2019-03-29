package com.mrjason.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

/**

 * @Description:    完成对Redis 的整合的一些配置

 * @Author:         MrJason

 * @CreateDate:     2019/3/29 2:50 PM

 * @UpdateUser:     Mrjason

 * @UpdateDate:     2019/3/29 2:50 PM

 * @UpdateRemark:   修改内容

 * @Version:        1.0

 */


@Configuration
public class RedisConfig {
    /*
    1.创建JedisPoolConfig对象  在该对象中完成一些链接池配置
     */
    @Bean
    public JedisPoolConfig jedisPoolConfig(){
        JedisPoolConfig config = new JedisPoolConfig();
        //最大空闲
        config.setMaxIdle(10);
        //最小空闲
        config.setMinIdle(5);
        //最大链接数
        config.setMaxTotal(20);
        return  config;
    }




    /*
    2. 创建JedisConnectionFactory   配置redis链接信息
     */
    @Bean
    public JedisConnectionFactory  jedisConnectionFactory(JedisPoolConfig config){
        JedisConnectionFactory factory = new JedisConnectionFactory();
        //关联链接池的配置对象
        factory.setPoolConfig(config);
        //配置链接redis的信息
        factory.setHostName("127.0.0.1");
        //端口
        factory.setPort(6379);
        //factory.setDatabase(0);
        return factory;
    }
    /*
    3.创建RedisTemplate  用于执行redis操作的方法
     */
    @Bean

    public RedisTemplate<String,Object> redisTemplate( JedisConnectionFactory factory){
        RedisTemplate template = new RedisTemplate<>();
        //关联
        template.setConnectionFactory(factory);
        //对 key  设置序列化器
        template.setKeySerializer(new StringRedisSerializer());
        //对 value  设置序列化器
        template.setValueSerializer(new StringRedisSerializer());

        return template;
    }
}
