package com.team.fitness.dto;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * @author Kiran Kumar Poosa
 * The persistent class for the Employees database table.
 * 
 */
@Entity
@Table(name="Employees")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int employeeId;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dob;

	private String emailId;

	private String firstName;

	@Temporal(TemporalType.TIMESTAMP)
	private Date joinTime;

	private String lastName;

	private BigInteger mobileNumber;

	private Timestamp modifiedTime;

	private String occupation;

	private BigInteger phoneNumber;

	private BigDecimal salary;

	//bi-directional many-to-one association to Customer
	@OneToMany(mappedBy="employee")
	private List<Customer> customers;

	//bi-directional many-to-one association to EmployeeAddress
	@OneToMany(mappedBy="employee")
	private List<EmployeeAddress> employeeAddresses;

	//bi-directional many-to-one association to EmployeeAttendance
	@OneToMany(mappedBy="employee")
	private List<EmployeeAttendance> employeeAttendances;

	//bi-directional many-to-one association to EmployeeSalary
	@OneToMany(mappedBy="employee")
	private List<EmployeeSalary> employeeSalaries;

	//bi-directional many-to-one association to Gender
	@ManyToOne
	@JoinColumn(name="genderId")
	private Gender gender;

	public Employee() {
	}

	public int getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public Date getDob() {
		return this.dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getEmailId() {
		return this.emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Date getJoinTime() {
		return this.joinTime;
	}

	public void setJoinTime(Date joinTime) {
		this.joinTime = joinTime;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public BigInteger getMobileNumber() {
		return this.mobileNumber;
	}

	public void setMobileNumber(BigInteger mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Timestamp getModifiedTime() {
		return this.modifiedTime;
	}

	public void setModifiedTime(Timestamp modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	public String getOccupation() {
		return this.occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public BigInteger getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(BigInteger phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public BigDecimal getSalary() {
		return this.salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public List<Customer> getCustomers() {
		return this.customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public List<EmployeeAddress> getEmployeeAddresses() {
		return this.employeeAddresses;
	}

	public void setEmployeeAddresses(List<EmployeeAddress> employeeAddresses) {
		this.employeeAddresses = employeeAddresses;
	}

	public List<EmployeeAttendance> getEmployeeAttendances() {
		return this.employeeAttendances;
	}

	public void setEmployeeAttendances(List<EmployeeAttendance> employeeAttendances) {
		this.employeeAttendances = employeeAttendances;
	}

	public List<EmployeeSalary> getEmployeeSalaries() {
		return this.employeeSalaries;
	}

	public void setEmployeeSalaries(List<EmployeeSalary> employeeSalaries) {
		this.employeeSalaries = employeeSalaries;
	}

	public Gender getGender() {
		return this.gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

}