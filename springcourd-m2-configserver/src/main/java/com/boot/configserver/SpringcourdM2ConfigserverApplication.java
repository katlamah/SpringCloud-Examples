package com.boot.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class SpringcourdM2ConfigserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcourdM2ConfigserverApplication.class, args);
	}
}
