package com.team.fitness.dto;

import java.io.Serializable;
import javax.persistence.*;


/**
 * @author Kiran Kumar Poosa
 * The persistent class for the UserRoles database table.
 * 
 */
@Entity
@Table(name="UserRoles")
public class UserRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userRoleId;

	//bi-directional many-to-one association to Role
	@ManyToOne
	@JoinColumn(name="roleId")
	private Role role;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="userId")
	private User user;

	public UserRole() {
	}

	public int getUserRoleId() {
		return this.userRoleId;
	}

	public void setUserRoleId(int userRoleId) {
		this.userRoleId = userRoleId;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}