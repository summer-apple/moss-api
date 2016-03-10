package com.drartisan.moss.entity;
// Generated 2016-1-21 23:21:14 by Hibernate Tools 4.3.1.Final

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Member generated by hbm2java
 */
@Entity
@Table(name = "member", catalog = "moss")
public class Member implements java.io.Serializable {

	private Integer id;
	private String username;
	private String password;
	private String email;
	private String phone;
	private String gender;
	private String avatar;
	private Date expired;

	public Member() {
	}

	public Member(String username, String password, String email, String phone, String gender, String avatar, Date expired) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.gender = gender;
		this.avatar = avatar;
		this.expired = expired;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "username", length = 45)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password", length = 45)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "email", length = 45)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "phone", length = 45)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "gender", length = 45)
	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Column(name = "avatar", length = 100)
	public String getAvatar() {
		return this.avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "expired", length = 19)
	public Date getExpired() {
		return this.expired;
	}

	public void setExpired(Date expired) {
		this.expired = expired;
	}

}
