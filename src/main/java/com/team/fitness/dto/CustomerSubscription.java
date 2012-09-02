package com.team.fitness.dto;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.math.BigDecimal;
import java.util.Date;


/**
 * @author Kiran Kumar Poosa
 * The persistent class for the CustomerSubscriptions database table.
 * 
 */
@Entity
@Table(name="CustomerSubscriptions")
public class CustomerSubscription implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int customerSubscriptionId;

	private BigDecimal dueAmount;

	@Temporal(TemporalType.TIMESTAMP)
	private Date lastRenewalTime;

	private Timestamp modifiedTime;

	@Temporal(TemporalType.TIMESTAMP)
	private Date nextRenewalTime;

	private String remarks;

	@Temporal(TemporalType.TIMESTAMP)
	private Date subscriptionTime;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="customerId")
	private Customer customer;

	//bi-directional many-to-one association to Package
	@ManyToOne
	@JoinColumn(name="packageId")
	private PackageApplied packageApplied;

	//bi-directional many-to-one association to CustomerStatus
	@ManyToOne
	@JoinColumn(name="customerStatusId")
	private CustomerStatus customerStatus;

	public CustomerSubscription() {
	}

	public int getCustomerSubscriptionId() {
		return this.customerSubscriptionId;
	}

	public void setCustomerSubscriptionId(int customerSubscriptionId) {
		this.customerSubscriptionId = customerSubscriptionId;
	}

	public BigDecimal getDueAmount() {
		return this.dueAmount;
	}

	public void setDueAmount(BigDecimal dueAmount) {
		this.dueAmount = dueAmount;
	}

	public Date getLastRenewalTime() {
		return this.lastRenewalTime;
	}

	public void setLastRenewalTime(Date lastRenewalTime) {
		this.lastRenewalTime = lastRenewalTime;
	}

	public Timestamp getModifiedTime() {
		return this.modifiedTime;
	}

	public void setModifiedTime(Timestamp modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	public Date getNextRenewalTime() {
		return this.nextRenewalTime;
	}

	public void setNextRenewalTime(Date nextRenewalTime) {
		this.nextRenewalTime = nextRenewalTime;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Date getSubscriptionTime() {
		return this.subscriptionTime;
	}

	public void setSubscriptionTime(Date subscriptionTime) {
		this.subscriptionTime = subscriptionTime;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public PackageApplied getPackageApplied() {
		return this.packageApplied;
	}

	public void setPackageApplied(PackageApplied packageApplied) {
		this.packageApplied = packageApplied;
	}

	public CustomerStatus getCustomerStatus() {
		return this.customerStatus;
	}

	public void setCustomerStatus(CustomerStatus customerStatus) {
		this.customerStatus = customerStatus;
	}

}