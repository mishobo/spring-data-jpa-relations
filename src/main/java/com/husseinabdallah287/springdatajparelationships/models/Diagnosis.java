package com.husseinabdallah287.springdatajparelationships.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "diagnosis")
public class Diagnosis {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private int id = 0;
	
	private String code;
	
	private String title;
	
	@Column(name = "invoice_number")
	private String invoiceNumber = null;

	@Column(name = "claim_ref")
	private String claimRef = null;

	@JsonIgnore
	@ManyToOne()
	@JoinColumn(name = "visit_number", nullable = false)
	private Visit visit;

}
