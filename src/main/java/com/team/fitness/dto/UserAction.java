package com.team.fitness.dto;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;


/**
 * @author Kiran Kumar Poosa
 * The persistent class for the UserActions database table.
 * 
 */
@Entity
@Table(name="UserActions")
public class UserAction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String userActionId;

	private String action;

	@Temporal(TemporalType.TIMESTAMP)
	private Date actionTime;

	private Timestamp modifiedTime;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="userId")
	private User user;

	public UserAction() {
	}

	public String getUserActionId() {
		return this.userActionId;
	}

	public void setUserActionId(String userActionId) {
		this.userActionId = userActionId;
	}

	public String getAction() {
		return this.action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public Date getActionTime() {
		return this.actionTime;
	}

	public void setActionTime(Date actionTime) {
		this.actionTime = actionTime;
	}

	public Timestamp getModifiedTime() {
		return this.modifiedTime;
	}

	public void setModifiedTime(Timestamp modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}