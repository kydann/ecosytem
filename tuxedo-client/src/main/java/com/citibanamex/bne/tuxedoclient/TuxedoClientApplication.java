package com.citibanamex.bne.tuxedoclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class TuxedoClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(TuxedoClientApplication.class, args);
	}
}
