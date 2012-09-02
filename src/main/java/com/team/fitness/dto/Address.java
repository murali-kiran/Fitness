package com.team.fitness.dto;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * @author Kiran Kumar Poosa
 * The persistent class for the Addresses database table.
 * 
 */
@Entity
@Table(name="Addresses")
public class Address implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int addressId;

	private String city;

	private int pincode;

	private String platNumber;

	private String state;

	private String street;

	//bi-directional many-to-one association to CustomerAddress
	@OneToMany(mappedBy="address")
	private List<CustomerAddress> customerAddresses;

	//bi-directional many-to-one association to EmployeeAddress
	@OneToMany(mappedBy="address")
	private List<EmployeeAddress> employeeAddresses;

	public Address() {
	}

	public int getAddressId() {
		return this.addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPincode() {
		return this.pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getPlatNumber() {
		return this.platNumber;
	}

	public void setPlatNumber(String platNumber) {
		this.platNumber = platNumber;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public List<CustomerAddress> getCustomerAddresses() {
		return this.customerAddresses;
	}

	public void setCustomerAddresses(List<CustomerAddress> customerAddresses) {
		this.customerAddresses = customerAddresses;
	}

	public List<EmployeeAddress> getEmployeeAddresses() {
		return this.employeeAddresses;
	}

	public void setEmployeeAddresses(List<EmployeeAddress> employeeAddresses) {
		this.employeeAddresses = employeeAddresses;
	}

}