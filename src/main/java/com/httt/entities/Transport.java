package com.httt.entities;

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
@Table(name = "EFARM_TRANSPORT")
public class Transport {
	@Id
	@Column(name = "transportId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer transportId;
	
	@Column(name = "transportName")
	private String transportName;
}
