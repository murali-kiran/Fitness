package com.team.fitness.dto;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * @author Kiran Kumar Poosa
 * The persistent class for the Genders database table.
 * 
 */
@Entity
@Table(name="Genders")
public class Gender implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int genderId;

	private String genderName;

	//bi-directional many-to-one association to Customer
	@OneToMany(mappedBy="gender")
	private List<Customer> customers;

	//bi-directional many-to-one association to Employee
	@OneToMany(mappedBy="gender")
	private List<Employee> employees;

	public Gender() {
	}

	public int getGenderId() {
		return this.genderId;
	}

	public void setGenderId(int genderId) {
		this.genderId = genderId;
	}

	public String getGenderName() {
		return this.genderName;
	}

	public void setGenderName(String genderName) {
		this.genderName = genderName;
	}

	public List<Customer> getCustomers() {
		return this.customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public List<Employee> getEmployees() {
		return this.employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

}