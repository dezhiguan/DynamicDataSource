package com.gdz.dynamicdatasource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = {"com.gdz.dynamicdatasource.mapper"})
@SpringBootApplication
public class DynamicdatasourceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DynamicdatasourceApplication.class, args);
	}

}
