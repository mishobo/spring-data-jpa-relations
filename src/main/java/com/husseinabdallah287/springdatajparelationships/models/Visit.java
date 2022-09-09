package com.husseinabdallah287.springdatajparelationships.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Visit {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "visit_number")
	private Long id;

	@Column(name = "member_number")
	private String memberNumber;

	@Column(name = "member_name")
	private String memberName;

	@Column(name = "hospital_provider_id")
	private Long hospitalProviderId;

	@Column(name = "staff_id")
	private String staffId;

	@Column(name = "staff_name")
	private String staffName;

	@Column(name = "aggregate_id")
	private String aggregateId;

	@Column(name = "category_id")
	private String categoryId;

	@Column(name = "benefit_name")
	private String benefitName;

	@Column(name = "beneficiaryId")
	private Long beneficiaryId;

	@Column(name = "benefit_id")
	private Long benefitId;

	@Column(name = "payer_id")
	private String payerId;

	@Column(name = "policy_number")
	private String policyNumber;

	@Column(name = "balance_amount")
	private BigDecimal balanceAmount;

	@Column(name = "beneficiary_type")
	private String beneficiaryType;

	@Column(name = "total_invoice_amount")
	private BigDecimal totalInvoiceAmount;

	@Enumerated(EnumType.STRING)
	@Column(name = "provider_middleware")
	private MIDDLEWARENAME providerMiddleware;

	@Column(name = "invoice_number")
	private String invoiceNumber;

//	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private String status;

	@Enumerated(EnumType.STRING)
	@Column(name = "middlewareStatus")
	private MiddlewareStatus middlewareStatus = MiddlewareStatus.UNSENT;

	@Enumerated(EnumType.STRING)
	@Column(name = "claim_process_status")
	private ClaimProcessStatus claimProcessStatus = ClaimProcessStatus.UNPROCESSED;


	@CreationTimestamp
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "created_at", updatable = false, nullable = false)
	private LocalDateTime createdAt = null;

	@UpdateTimestamp
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "updated_at", insertable = false)
	private LocalDateTime updatedAt = null;


	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "visit_end")
	private LocalDateTime visitEnd = null;

	@OneToMany(mappedBy = "visit", fetch = FetchType.EAGER)
	private List<Diagnosis> diagnosis = null;
	
}