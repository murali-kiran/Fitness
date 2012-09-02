package com.team.fitness.dto;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.math.BigDecimal;
import java.util.Date;


/**
 * @author Kiran Kumar Poosa
 * The persistent class for the Expenditures database table.
 * 
 */
@Entity
@Table(name="Expenditures")
public class Expenditure implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int expenditureId;

	private BigDecimal amount;

	private String description;

	@Temporal(TemporalType.TIMESTAMP)
	private Date expenditureTime;

	private Timestamp modifiedTime;

	private String name;

	public Expenditure() {
	}

	public int getExpenditureId() {
		return this.expenditureId;
	}

	public void setExpenditureId(int expenditureId) {
		this.expenditureId = expenditureId;
	}

	public BigDecimal getAmount() {
		return this.amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getExpenditureTime() {
		return this.expenditureTime;
	}

	public void setExpenditureTime(Date expenditureTime) {
		this.expenditureTime = expenditureTime;
	}

	public Timestamp getModifiedTime() {
		return this.modifiedTime;
	}

	public void setModifiedTime(Timestamp modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}