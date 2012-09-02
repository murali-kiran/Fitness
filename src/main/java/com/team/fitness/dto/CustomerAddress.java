package com.team.fitness.dto;

import java.io.Serializable;
import javax.persistence.*;


/**
 * @author Kiran Kumar Poosa
 * The persistent class for the CustomerAddresses database table.
 * 
 */
@Entity
@Table(name="CustomerAddresses")
public class CustomerAddress implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int customerAddressId;

	//bi-directional many-to-one association to Address
	@ManyToOne
	@JoinColumn(name="addressId")
	private Address address;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="customerId")
	private Customer customer;

	public CustomerAddress() {
	}

	public int getCustomerAddressId() {
		return this.customerAddressId;
	}

	public void setCustomerAddressId(int customerAddressId) {
		this.customerAddressId = customerAddressId;
	}

	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}