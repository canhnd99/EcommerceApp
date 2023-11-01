package com.httt.entities;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_account_manager")
public class AccountManager {
	@Id
	@Column(name = "managerId")
	private Integer managerId;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "role")
	private Integer role;	
	
	@Column(name = "fullname")
	private String fullname;

	@Column(name = "avatar")
	private String avatar;
	
	@Column(name = "createDate")
	private Date createDate;
	
	@Column(name = "modifyDate")
	private Date modifyDate;
}
