package com.team.fitness.dto;

import java.io.Serializable;
import javax.persistence.*;


/**
 * @author Kiran Kumar Poosa
 * The persistent class for the EmployeeAddress database table.
 * 
 */
@Entity
public class EmployeeAddress implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int employeeAddressId;

	//bi-directional many-to-one association to Address
	@ManyToOne
	@JoinColumn(name="addressId")
	private Address address;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="employeeId")
	private Employee employee;

	public EmployeeAddress() {
	}

	public int getEmployeeAddressId() {
		return this.employeeAddressId;
	}

	public void setEmployeeAddressId(int employeeAddressId) {
		this.employeeAddressId = employeeAddressId;
	}

	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}