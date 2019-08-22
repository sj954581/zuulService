package com.bb.zuulService;

import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;

import jdk.internal.org.jline.utils.Log;

@Component
public class PreFilter extends ZuulFilter {
	
	@Override
	public String filterType() {
		return "pre";
	}
	
	@Override
	public int filterOrder() {
		return 1;
	}
	
	@Override
	public boolean shouldFilter() {
		return true;
	}
	
	@Override
	public Object run() {
		
		System.out.println("Sj PreFilter called...");
		return "pre";
	}

}
