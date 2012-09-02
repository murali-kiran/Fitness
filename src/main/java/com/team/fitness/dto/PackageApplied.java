package com.team.fitness.dto;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * @author Kiran Kumar Poosa
 * The persistent class for the Packages database table.
 * 
 */
@Entity
@Table(name="Packages")
public class PackageApplied implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int packageId;

	private int duration;

	private String packageDesc;

	private String packageName;

	private String packageTitle;

	private BigDecimal price;

	private BigDecimal renewalPrice;

	//bi-directional many-to-one association to CustomerSubscription
	@OneToMany(mappedBy="packageApplied")
	private List<CustomerSubscription> customerSubscriptions;

	public PackageApplied() {
	}

	public int getPackageId() {
		return this.packageId;
	}

	public void setPackageId(int packageId) {
		this.packageId = packageId;
	}

	public int getDuration() {
		return this.duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getPackageDesc() {
		return this.packageDesc;
	}

	public void setPackageDesc(String packageDesc) {
		this.packageDesc = packageDesc;
	}

	public String getPackageName() {
		return this.packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getPackageTitle() {
		return this.packageTitle;
	}

	public void setPackageTitle(String packageTitle) {
		this.packageTitle = packageTitle;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getRenewalPrice() {
		return this.renewalPrice;
	}

	public void setRenewalPrice(BigDecimal renewalPrice) {
		this.renewalPrice = renewalPrice;
	}

	public List<CustomerSubscription> getCustomerSubscriptions() {
		return this.customerSubscriptions;
	}

	public void setCustomerSubscriptions(List<CustomerSubscription> customerSubscriptions) {
		this.customerSubscriptions = customerSubscriptions;
	}

}