package com.boot.configservergit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class SpringcourdM2Configserver1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringcourdM2Configserver1Application.class, args);
	}
}
