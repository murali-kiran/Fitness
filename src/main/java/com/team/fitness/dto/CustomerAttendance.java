package com.team.fitness.dto;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;


/**
 * @author Kiran Kumar Poosa
 * The persistent class for the CustomerAttendance database table.
 * 
 */
@Entity
public class CustomerAttendance implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int customerAttendanceId;

	@Temporal(TemporalType.TIMESTAMP)
	private Date arrivalTime;

	@Temporal(TemporalType.TIMESTAMP)
	private Date leavingTime;

	private Timestamp modifiedTime;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="customerId")
	private Customer customer;

	public CustomerAttendance() {
	}

	public int getCustomerAttendanceId() {
		return this.customerAttendanceId;
	}

	public void setCustomerAttendanceId(int customerAttendanceId) {
		this.customerAttendanceId = customerAttendanceId;
	}

	public Date getArrivalTime() {
		return this.arrivalTime;
	}

	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public Date getLeavingTime() {
		return this.leavingTime;
	}

	public void setLeavingTime(Date leavingTime) {
		this.leavingTime = leavingTime;
	}

	public Timestamp getModifiedTime() {
		return this.modifiedTime;
	}

	public void setModifiedTime(Timestamp modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}