package com.image.demo.entity;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class UserToken extends BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// @Id
	// @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	// @GenericGenerator(name = "native", strategy = "native")
	// private Long id;

	private String token;

	private String username;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
