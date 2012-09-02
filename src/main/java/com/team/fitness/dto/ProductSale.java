package com.team.fitness.dto;

import java.io.Serializable;
import javax.persistence.*;

import java.sql.Timestamp;
import java.math.BigDecimal;
import java.util.Date;


/**
 * @author Kiran Kumar Poosa
 * The persistent class for the ProductSales database table.
 * 
 */
@Entity
@Table(name="ProductSales")
public class ProductSale implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int productSaleId;

	private BigDecimal actualPrice;

	private BigDecimal amountBalance;

	private BigDecimal amountReceived;

	@ManyToOne
	@JoinColumn(name="customerId")
	private Customer customer;

	private BigDecimal discountPrice;

	private Timestamp modifiedTime;

	private String remarks;

	@Temporal(TemporalType.TIMESTAMP)
	private Date saleTime;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="productId")
	private Product product;

	public ProductSale() {
	}

	public int getProductSaleId() {
		return this.productSaleId;
	}

	public void setProductSaleId(int productSaleId) {
		this.productSaleId = productSaleId;
	}

	public BigDecimal getActualPrice() {
		return this.actualPrice;
	}

	public void setActualPrice(BigDecimal actualPrice) {
		this.actualPrice = actualPrice;
	}

	public BigDecimal getAmountBalance() {
		return this.amountBalance;
	}

	public void setAmountBalance(BigDecimal amountBalance) {
		this.amountBalance = amountBalance;
	}

	public BigDecimal getAmountReceived() {
		return this.amountReceived;
	}

	public void setAmountReceived(BigDecimal amountReceived) {
		this.amountReceived = amountReceived;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomerId(Customer customer) {
		this.customer = customer;
	}

	public BigDecimal getDiscountPrice() {
		return this.discountPrice;
	}

	public void setDiscountPrice(BigDecimal discountPrice) {
		this.discountPrice = discountPrice;
	}

	public Timestamp getModifiedTime() {
		return this.modifiedTime;
	}

	public void setModifiedTime(Timestamp modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Date getSaleTime() {
		return this.saleTime;
	}

	public void setSaleTime(Date saleTime) {
		this.saleTime = saleTime;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}