package com.billing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.billing.feign.feign;
import com.billing.model.Billing;
import com.billing.service.BillingService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@EnableDiscoveryClient
@EnableFeignClients
public class BillingController {

	@Autowired
	DiscoveryClient discoveryClient;

	RestTemplate restTemplate = new RestTemplate();

	@Autowired
	BillingService billingService;

	@Autowired
	public feign feign;

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String getText() {
		String str = "Hey!!! test from Billing Srevice";
		return str;
	}

	@RequestMapping(value = "/billing", method = RequestMethod.POST)
	public String createBilling(@RequestBody Billing billing) {
		try {
			String message = billingService.createBilling(billing);
			return message;
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	@RequestMapping(value = "/billing", method = RequestMethod.GET)
	public ResponseEntity<Object> getBillingList() {

		List<Billing> billingList = billingService.getBillingList();
		return new ResponseEntity<>(billingList, HttpStatus.OK);
	}

	@RequestMapping(value = "/billing/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> getBillingById(@PathVariable int id) {
		try {
			Billing billing = billingService.getBillingById(id);
			return new ResponseEntity<Object>(billing, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>("billing not found", HttpStatus.NOT_FOUND);
		}
	}

}