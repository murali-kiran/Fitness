package com.team.fitness.dto;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.math.BigDecimal;
import java.util.Date;


/**
 * @author Kiran Kumar Poosa
 * The persistent class for the EmployeeSalaries database table.
 * 
 */
@Entity
@Table(name="EmployeeSalaries")
public class EmployeeSalary implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int employeeSalaryId;

	private BigDecimal actualSalary;

	private BigDecimal deductionInSalary;

	private Timestamp modifiedTime;

	private BigDecimal salaryPaid;

	@Temporal(TemporalType.TIMESTAMP)
	private Date salaryPaidTime;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="employeeId")
	private Employee employee;

	public EmployeeSalary() {
	}

	public int getEmployeeSalaryId() {
		return this.employeeSalaryId;
	}

	public void setEmployeeSalaryId(int employeeSalaryId) {
		this.employeeSalaryId = employeeSalaryId;
	}

	public BigDecimal getActualSalary() {
		return this.actualSalary;
	}

	public void setActualSalary(BigDecimal actualSalary) {
		this.actualSalary = actualSalary;
	}

	public BigDecimal getDeductionInSalary() {
		return this.deductionInSalary;
	}

	public void setDeductionInSalary(BigDecimal deductionInSalary) {
		this.deductionInSalary = deductionInSalary;
	}

	public Timestamp getModifiedTime() {
		return this.modifiedTime;
	}

	public void setModifiedTime(Timestamp modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	public BigDecimal getSalaryPaid() {
		return this.salaryPaid;
	}

	public void setSalaryPaid(BigDecimal salaryPaid) {
		this.salaryPaid = salaryPaid;
	}

	public Date getSalaryPaidTime() {
		return this.salaryPaidTime;
	}

	public void setSalaryPaidTime(Date salaryPaidTime) {
		this.salaryPaidTime = salaryPaidTime;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}