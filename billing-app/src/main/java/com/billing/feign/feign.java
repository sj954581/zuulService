package com.billing.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.netflix.ribbon.proxy.annotation.Hystrix;

@FeignClient(name = "UserApp")
public interface feign {
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    String getTest();
    
    @RequestMapping(value = "/fallBack", method = RequestMethod.GET)
    String getFallBack();
}
