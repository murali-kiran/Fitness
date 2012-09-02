package com.team.fitness.dto;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


/**
 * @author Kiran Kumar Poosa
 * The persistent class for the Users database table.
 * 
 */
@Entity
@Table(name="Users")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdTime;

	private Timestamp modifiedTime;

	private String password;

	private String userName;

	//bi-directional many-to-one association to UserAction
	@OneToMany(mappedBy="user")
	private List<UserAction> userActions;

	//bi-directional many-to-one association to UserRole
	@OneToMany(mappedBy="user")
	private List<UserRole> userRoles;

	public User() {
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Date getCreatedTime() {
		return this.createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Timestamp getModifiedTime() {
		return this.modifiedTime;
	}

	public void setModifiedTime(Timestamp modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<UserAction> getUserActions() {
		return this.userActions;
	}

	public void setUserActions(List<UserAction> userActions) {
		this.userActions = userActions;
	}

	public List<UserRole> getUserRoles() {
		return this.userRoles;
	}

	public void setUserRoles(List<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

}