package com.team.fitness.dto;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * @author Kiran Kumar Poosa
 * The persistent class for the CustomerStatuses database table.
 * 
 */
@Entity
@Table(name="CustomerStatuses")
public class CustomerStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int customerStatusId;

	private String customerStatusName;

	//bi-directional many-to-one association to CustomerSubscription
	@OneToMany(mappedBy="customerStatus")
	private List<CustomerSubscription> customerSubscriptions;

	public CustomerStatus() {
	}

	public int getCustomerStatusId() {
		return this.customerStatusId;
	}

	public void setCustomerStatusId(int customerStatusId) {
		this.customerStatusId = customerStatusId;
	}

	public String getCustomerStatusName() {
		return this.customerStatusName;
	}

	public void setCustomerStatusName(String customerStatusName) {
		this.customerStatusName = customerStatusName;
	}

	public List<CustomerSubscription> getCustomerSubscriptions() {
		return this.customerSubscriptions;
	}

	public void setCustomerSubscriptions(List<CustomerSubscription> customerSubscriptions) {
		this.customerSubscriptions = customerSubscriptions;
	}

}