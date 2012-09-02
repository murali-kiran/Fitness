package com.team.fitness.dto;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;


/**
 * @author Kiran Kumar Poosa
 * The persistent class for the EmployeeAttendance database table.
 * 
 */
@Entity
public class EmployeeAttendance implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int employeeAttendanceId;

	@Temporal(TemporalType.TIMESTAMP)
	private Date arrivalTime;

	@Temporal(TemporalType.TIMESTAMP)
	private Date leavingTime;

	private Timestamp modifiedTime;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="employeeId")
	private Employee employee;

	public EmployeeAttendance() {
	}

	public int getEmployeeAttendanceId() {
		return this.employeeAttendanceId;
	}

	public void setEmployeeAttendanceId(int employeeAttendanceId) {
		this.employeeAttendanceId = employeeAttendanceId;
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

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}