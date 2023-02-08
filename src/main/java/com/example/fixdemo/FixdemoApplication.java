package com.example.fixdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.example.fixdemo.dao")
@EnableTransactionManagement
public class FixdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(FixdemoApplication.class, args);
    }

}
