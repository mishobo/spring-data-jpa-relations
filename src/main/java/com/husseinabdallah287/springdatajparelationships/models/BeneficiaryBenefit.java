package com.husseinabdallah287.springdatajparelationships.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "benefit_beneficiary")
public class BeneficiaryBenefit {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "aggregate_id")
	private String aggregateId;
	
	@Column(name = "benefit_id")
	private Long benefitId;
	
	@Column(name = "beneficiary_id")
	private Long beneficiaryId;
	
	@Column(name = "member_name")
	private String memberName;
	
	@Column(name = "member_number")
	private String memberNumber;
	
	@Column(name = "benefit_name")
	private String benefitName;
	
	@Column(name = "status")
	@Enumerated(EnumType.STRING)
	private BenefitStatus status;
	
	@Column(name = "balance")
	private BigDecimal balance;
	
	@Column(name = "suspension_threshold")
	private BigDecimal suspensionThreshold;
	
	@Column(name = "initial_limit")
	private BigDecimal initialLimit;
	
	@Column(name = "category_id")
	private Long categoryId;
	
	@Column(name = "payer_id")
	private Long payerId;
	
	/*@Column(name = "sharing")
	@Enumerated(EnumType.STRING)
	val sharing: Sharing,*/
	@Column(name = "utilization")
	private BigDecimal utilization;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "parent_id", nullable = true)
	private BeneficiaryBenefit parent;

	@JsonIgnore
	@OneToMany(mappedBy = "parent")
	private List<BeneficiaryBenefit> subBenefits;

	@Column(name = "start_date")
	private LocalDate startDate;
	
	@Column(name = "end_date")
	private LocalDate endDate;
	
	@Column(name = "gender")
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	@Column(name = "member_type")
	@Enumerated(EnumType.STRING)
	private MemberType memberType;
	@Column(name = "catalog_id")
	private Long catalogId;

	@Column(name = "jic_entity_id", nullable = true)
	private Integer jicEntityId;

	@Column(name = "apa_entity_id", nullable = true)
	private Integer apaEntityId;

}
