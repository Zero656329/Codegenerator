package com.sunny.Codegenerator;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.sunny.Codegenerator.dao"})
public class CodegeneratorApplication {
	public static void main(String[] args) {
		SpringApplication.run(CodegeneratorApplication.class, args);
	}

}
