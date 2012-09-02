package com.team.fitness.dto;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * @author Kiran Kumar Poosa
 * The persistent class for the CustomerPaidDetails database table.
 * 
 */
@Entity
@Table(name="CustomerPaidDetails")
public class CustomerPaidDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int customerPaidDetailId;

	private BigDecimal amountBalance;

	private BigDecimal amountPaid;

	private BigDecimal discoutAmount;

	private Timestamp modifiedTime;

	private int packageId;

	@Temporal(TemporalType.TIMESTAMP)
	private Date paidTime;

	private String remarks;

	//bi-directional many-to-one association to CustomerPaidDetail
	@ManyToOne
	@JoinColumn(name="customerId")
	private CustomerPaidDetail customerPaidDetail;

	//bi-directional many-to-one association to CustomerPaidDetail
	@OneToMany(mappedBy="customerPaidDetail")
	private List<CustomerPaidDetail> customerPaidDetails;

	public CustomerPaidDetail() {
	}

	public int getCustomerPaidDetailId() {
		return this.customerPaidDetailId;
	}

	public void setCustomerPaidDetailId(int customerPaidDetailId) {
		this.customerPaidDetailId = customerPaidDetailId;
	}

	public BigDecimal getAmountBalance() {
		return this.amountBalance;
	}

	public void setAmountBalance(BigDecimal amountBalance) {
		this.amountBalance = amountBalance;
	}

	public BigDecimal getAmountPaid() {
		return this.amountPaid;
	}

	public void setAmountPaid(BigDecimal amountPaid) {
		this.amountPaid = amountPaid;
	}

	public BigDecimal getDiscoutAmount() {
		return this.discoutAmount;
	}

	public void setDiscoutAmount(BigDecimal discoutAmount) {
		this.discoutAmount = discoutAmount;
	}

	public Timestamp getModifiedTime() {
		return this.modifiedTime;
	}

	public void setModifiedTime(Timestamp modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	public int getPackageId() {
		return this.packageId;
	}

	public void setPackageId(int packageId) {
		this.packageId = packageId;
	}

	public Date getPaidTime() {
		return this.paidTime;
	}

	public void setPaidTime(Date paidTime) {
		this.paidTime = paidTime;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public CustomerPaidDetail getCustomerPaidDetail() {
		return this.customerPaidDetail;
	}

	public void setCustomerPaidDetail(CustomerPaidDetail customerPaidDetail) {
		this.customerPaidDetail = customerPaidDetail;
	}

	public List<CustomerPaidDetail> getCustomerPaidDetails() {
		return this.customerPaidDetails;
	}

	public void setCustomerPaidDetails(List<CustomerPaidDetail> customerPaidDetails) {
		this.customerPaidDetails = customerPaidDetails;
	}

}