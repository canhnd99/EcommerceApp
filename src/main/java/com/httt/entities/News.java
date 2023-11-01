package com.httt.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "EFARM_NEWS")
public class News {
	@Id
	@Column(name = "NEWID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer newId;
	
	@Column(name = "TITLE")
	private String title;
	
	@Column(name = "CONTENT")
	private String content;
	
	@Column(name = "PICTURE")
	private String picture;
	
	@Column(name = "CREATEDATE")
	private Date createDate;
}
