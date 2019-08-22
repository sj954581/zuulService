package com.billing.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.*;

@Entity
@Table(name = "billing_code")
public class Billing {

	@Id
	@Column(name = "b_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int b_id;

	@Column(name = "b_code")
	private String b_code;

	@Column(name = "b_name")
	private String b_name;

	@Column(name = "b_type")
	private String b_type;

	@Column(name = "b_priceaftertrial")
	private int b_priceaftertrial;

	@Column(name = "b_isactive")
	private String b_isactive;

	@Column(name = "b_freetrialdays")
	private int b_freetrialdays;

	@Column(name = "b_rating")
	private int b_rating;

	@Column(name = "b_actvstart")
	private Date b_actvstart;

	@Column(name = "b_actvends")
	private Date b_actvends;

	public int getB_id() {
		return b_id;
	}

	public void setB_id(int b_id) {
		this.b_id = b_id;
	}

	public String getB_code() {
		return b_code;
	}

	public void setB_code(String b_code) {
		this.b_code = b_code;
	}

	public String getB_Name() {
		return b_name;
	}

	public void setB_Name(String b_Name) {
		this.b_name = b_Name;
	}

	public String getB_type() {
		return b_type;
	}

	public void setB_type(String b_type) {
		this.b_type = b_type;
	}

	public int getB_priceAfterTrial() {
		return b_priceaftertrial;
	}

	public void setB_priceAfterTrial(int b_priceaftertrial) {
		this.b_priceaftertrial = b_priceaftertrial;
	}

	public String getB_isActive() {
		return b_isactive;
	}

	public void setB_isActive(String b_isactive) {
		this.b_isactive = b_isactive;
	}

	public int getB_freeTrialDays() {
		return b_freetrialdays;
	}

	public void setB_freeTrialDays(int b_freetrialdays) {
		this.b_freetrialdays = b_freetrialdays;
	}

	public int getB_rating() {
		return b_rating;
	}

	public void setB_rating(int b_rating) {
		this.b_rating = b_rating;
	}

	public Date getB_ActvStart() {
		return b_actvstart;
	}

	public void setB_ActvStart(Date b_actvstart) {
		this.b_actvstart = b_actvstart;
	}

	public Date getB_ActvEnds() {
		return b_actvends;
	}

	public void setB_ActvEnds(Date b_actvends) {
		this.b_actvends = b_actvends;
	}

	@Override
	public String toString() {
		return "User [id=" + b_id + ", b_code=" + b_code + ", b_Name=" + b_name + ", b_type=" + b_type
				+ ", b_priceAfterTrial=" + b_priceaftertrial + ", b_isActive=" + b_isactive + ", b_freeTrialDays="
				+ b_freetrialdays + ", b_rating=" + b_rating + ", b_ActvStart=" + b_actvstart + ", b_ActvEnds="
				+ b_actvends +

				"]";
	}

}
