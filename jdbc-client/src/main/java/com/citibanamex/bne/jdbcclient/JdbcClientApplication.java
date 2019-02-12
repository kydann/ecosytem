package com.citibanamex.bne.jdbcclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class JdbcClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(JdbcClientApplication.class, args);
	}
}
