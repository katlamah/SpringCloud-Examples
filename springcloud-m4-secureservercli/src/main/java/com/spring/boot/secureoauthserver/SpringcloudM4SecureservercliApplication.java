package com.spring.boot.secureoauthserver;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.security.oauth2.common.AuthenticationScheme;

@SpringBootApplication
public class SpringcloudM4SecureservercliApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudM4SecureservercliApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("Starting cron job");
		ResourceOwnerPasswordResourceDetails resourcedetails=new ResourceOwnerPasswordResourceDetails();
		resourcedetails.setClientAuthenticationScheme(AuthenticationScheme.header);
		resourcedetails.setAccessTokenUri("http://localhost:9005/services/oauth/token");
		resourcedetails.setScope(Arrays.asList("toll_read"));
		
		resourcedetails.setClientId("cloudtest");
		resourcedetails.setClientSecret("cloudtestsecret");
		resourcedetails.setUsername("user1");
		resourcedetails.setPassword("user1");
		
		OAuth2RestTemplate template=new OAuth2RestTemplate(resourcedetails);
		String token=template.getAccessToken().toString();
		String s=template.getForObject("http://localhost:9001/services/tolldata",String.class);
		System.out.println("Result ::: "+s);
	}
	
}
