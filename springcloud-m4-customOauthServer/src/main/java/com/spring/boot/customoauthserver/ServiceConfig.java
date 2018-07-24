package com.spring.boot.customoauthserver;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;

@Configuration
public class ServiceConfig  extends GlobalAuthenticationConfigurerAdapter{
	
	public void init(AuthenticationManagerBuilder auth) throws Exception{
		auth.inMemoryAuthentication().withUser("testing").password("testing").roles("USER")
		.and().withUser("user1").password("user1").roles("USER","OPERATOR");
	}

}
