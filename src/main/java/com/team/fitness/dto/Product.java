package com.team.fitness.dto;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * @author Kiran Kumar Poosa
 * The persistent class for the Products database table.
 * 
 */
@Entity
@Table(name="Products")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int productId;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdTime;

	private String inhand;

	private Timestamp modifiedTime;

	private BigDecimal pricePerOne;

	private String productName;

	private int totalQuantity;

	private int totalSaled;

	private BigDecimal totalValue;

	//bi-directional many-to-one association to ProductSale
	@OneToMany(mappedBy="product")
	private List<ProductSale> productSales;

	public Product() {
	}

	public int getProductId() {
		return this.productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public Date getCreatedTime() {
		return this.createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public String getInhand() {
		return this.inhand;
	}

	public void setInhand(String inhand) {
		this.inhand = inhand;
	}

	public Timestamp getModifiedTime() {
		return this.modifiedTime;
	}

	public void setModifiedTime(Timestamp modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	public BigDecimal getPricePerOne() {
		return this.pricePerOne;
	}

	public void setPricePerOne(BigDecimal pricePerOne) {
		this.pricePerOne = pricePerOne;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getTotalQuantity() {
		return this.totalQuantity;
	}

	public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

	public int getTotalSaled() {
		return this.totalSaled;
	}

	public void setTotalSaled(int totalSaled) {
		this.totalSaled = totalSaled;
	}

	public BigDecimal getTotalValue() {
		return this.totalValue;
	}

	public void setTotalValue(BigDecimal totalValue) {
		this.totalValue = totalValue;
	}

	public List<ProductSale> getProductSales() {
		return this.productSales;
	}

	public void setProductSales(List<ProductSale> productSales) {
		this.productSales = productSales;
	}

}