package com.bb.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class ZuulProxyServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulProxyServiceApplication.class, args);
	}

}
