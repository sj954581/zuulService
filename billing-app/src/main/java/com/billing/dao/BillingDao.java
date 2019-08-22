package com.billing.dao;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.billing.model.Billing;


@Transactional
public interface BillingDao extends CrudRepository<Billing, Integer> {
	@Query(value = "select * from billing_code b where b.b_id=?", nativeQuery = true)
	Billing getCompanybyId(int id);
	
}
