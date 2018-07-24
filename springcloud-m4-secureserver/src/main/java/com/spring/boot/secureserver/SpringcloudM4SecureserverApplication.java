package com.spring.boot.secureserver;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableResourceServer
public class SpringcloudM4SecureserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudM4SecureserverApplication.class, args);
	}
	@Autowired
	private ResourceServerProperties sso;
	
	@Bean
	public ResourceServerTokenServices myUserInfoTokenServices() {
		return new CustomUserInfoTokenServices(sso.getUserInfoUri(),sso.getClientId());
	}
	
	@PreAuthorize("#oauth2.hasScope('toll_read') and hasAutority('ROLE_OPERATOR')")
	@RequestMapping("/tolldata")
	public ArrayList<TollUsage> getTollData(){
		
		TollUsage instance1=new TollUsage("100","station150","Bfsf","2018-07-10T06:54:45");
		TollUsage instance2=new TollUsage("101","station119","Bffsfffsf","2018-07-10T06:54:45");
		TollUsage instance3=new TollUsage("102","station1102","sfs","2018-07-10T06:54:45");
		
		ArrayList<TollUsage> tolls=new ArrayList<TollUsage>();
		tolls.add(instance3);
		tolls.add(instance2);
		tolls.add(instance1);
		return tolls;
	}
	
	
	public class TollUsage{
		public String Id;
		public String stationId;
		public String licencePlate;
		public String timestamp;
		
		public TollUsage() {
			
		}
		public TollUsage(String id,String stationid,String licencePlate,String timestamp) {
			this.Id=id;
			this.stationId=stationid;
			this.licencePlate=licencePlate;
			this.timestamp=timestamp;
		}
	}
}
