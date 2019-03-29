package com.mrjason.test;


import com.mrjason.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class RedisTest {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;


    /*
    存入一个字符串
     */
    @Test
    public void testSet(){
        this.redisTemplate.opsForValue().set("key","Mrjason");
    }

    /*
    取出一个字符串
     */

    @Test
    public void testGet(){
        String value = (String)this.redisTemplate.opsForValue().get("key");
        System.out.println(value);
    }
}
