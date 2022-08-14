package com.cxy.seckill;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.cxy.seckill.mapper")//包扫描
public class SeckillSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeckillSystemApplication.class, args);
	}

}
