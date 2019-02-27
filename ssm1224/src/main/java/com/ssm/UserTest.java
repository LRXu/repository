package com.ssm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value="com.ssm.dao")
public class UserTest {

public static void main(String [] args) {
		
		SpringApplication.run(UserTest.class, args);
		
	}
}
