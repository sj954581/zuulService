package com.billing.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.client.discovery.DiscoveryClient;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.h2.engine.UserAggregate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.billing.dao.BillingDao;
import com.billing.model.Billing;

@Component
public class BillingService {

	@Autowired
	BillingDao billingDao;

	RestTemplate restTemplate = new RestTemplate();

	public String createBilling(Billing billing) throws Exception {

		if (!isBillingExist(billing)) {
			Billing createdBilling = billingDao.save(billing);
			return "Billing created/added successfully for Billing id : " + createdBilling.getB_id();
		} else {
			throw new Exception("Billing already exists");
		}
	}

	public boolean isBillingExist(Billing billing) {

		Iterable<Billing> list =  billingDao.findAll();

		for (Billing single_Billing : list) {
			if (single_Billing.getB_id() == billing.getB_id()
					) {
				return true;
			}
		}
		return false;
	}

	public List<Billing> getBillingList() {

		List<Billing> billingList = new ArrayList<>();
		Iterable<Billing> list = billingDao.findAll();

		for (Billing billing : list) {
			billingList.add(billing);
		}
		return billingList;
	}

	public Billing getBillingById(int id) throws Exception {

		Optional<Billing> billing = billingDao.findById(id);
		if (billing.isPresent()) {
			return billing.get();
		} else {
			throw new Exception("billing not found");
		}
	}

}
