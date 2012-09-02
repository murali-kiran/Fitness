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
 * The persistent class for the Customers database table.
 * 
 */
@Entity
@Table(name="Customers")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int customerId;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dob;

	private String emailId;

	private String firstName;

	private byte height;

	private String lastName;

	private BigInteger mobileNumber;

	private Timestamp modifiedTime;

	private String occupation;

	private BigInteger phoneNumber;

	@Temporal(TemporalType.TIMESTAMP)
	private Date registeredTime;

	private BigDecimal weight;

	//bi-directional many-to-one association to CustomerAddress
	@OneToMany(mappedBy="customer")
	private List<CustomerAddress> customerAddresses;

	//bi-directional many-to-one association to CustomerAttendance
	@OneToMany(mappedBy="customer")
	private List<CustomerAttendance> customerAttendances;

	//bi-directional many-to-one association to CustomerSubscription
	@OneToMany(mappedBy="customer")
	private List<CustomerSubscription> customerSubscriptions;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="trainerId")
	private Employee employee;

	//bi-directional many-to-one association to Gender
	@ManyToOne
	@JoinColumn(name="genderId")
	private Gender gender;

	public Customer() {
	}

	public int getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
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

	public byte getHeight() {
		return this.height;
	}

	public void setHeight(byte height) {
		this.height = height;
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

	public Date getRegisteredTime() {
		return this.registeredTime;
	}

	public void setRegisteredTime(Date registeredTime) {
		this.registeredTime = registeredTime;
	}

	public BigDecimal getWeight() {
		return this.weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}

	public List<CustomerAddress> getCustomerAddresses() {
		return this.customerAddresses;
	}

	public void setCustomerAddresses(List<CustomerAddress> customerAddresses) {
		this.customerAddresses = customerAddresses;
	}

	public List<CustomerAttendance> getCustomerAttendances() {
		return this.customerAttendances;
	}

	public void setCustomerAttendances(List<CustomerAttendance> customerAttendances) {
		this.customerAttendances = customerAttendances;
	}

	public List<CustomerSubscription> getCustomerSubscriptions() {
		return this.customerSubscriptions;
	}

	public void setCustomerSubscriptions(List<CustomerSubscription> customerSubscriptions) {
		this.customerSubscriptions = customerSubscriptions;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Gender getGender() {
		return this.gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

}