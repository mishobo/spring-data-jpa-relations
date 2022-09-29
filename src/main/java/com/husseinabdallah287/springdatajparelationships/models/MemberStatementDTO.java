package com.husseinabdallah287.springdatajparelationships.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;


public class MemberStatementDTO {
	private String memberName;
	private String memberNumber;
	private String benefitName;
	private String payerId;
	private BigDecimal totalInvoiceAmount;
	private String invoiceNumber;
	private LocalDateTime createdAt;
	private Long hospitalProviderId;
	private String aggregateId;	
	private BigDecimal balanceAmount;
	private BigDecimal initialLimit;
	private BigDecimal balance;

	
	
	public MemberStatementDTO(String memberName, String memberNumber, String benefitName, String payerId,
			BigDecimal totalInvoiceAmount, String invoiceNumber, LocalDateTime createdAt, Long hospitalProviderId,
			String aggregateId, BigDecimal balanceAmount, BigDecimal initialLimit, BigDecimal balance) {
		super();
		this.memberName = memberName;
		this.memberNumber = memberNumber;
		this.benefitName = benefitName;
		this.payerId = payerId;
		this.totalInvoiceAmount = totalInvoiceAmount;
		this.invoiceNumber = invoiceNumber;
		this.createdAt = createdAt;
		this.hospitalProviderId = hospitalProviderId;
		this.aggregateId = aggregateId;
		this.balanceAmount = balanceAmount;
		this.initialLimit = initialLimit;
		this.balance = balance;
	}



	
	public BigDecimal getBalanceAmount() {
		return balanceAmount;
	}




	public void setBalanceAmount(BigDecimal balanceAmount) {
		this.balanceAmount = balanceAmount;
	}




	public BigDecimal getBalance() {
		return balance;
	}



	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}



	public BigDecimal getInitialLimit() {
		return initialLimit;
	}

	public void setInitialLimit(BigDecimal initialLimit) {
		this.initialLimit = initialLimit;
	}

	public String getAggregateId() {
		return aggregateId;
	}
	public void setAggregateId(String aggregateId) {
		this.aggregateId = aggregateId;
	}

	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberNumber() {
		return memberNumber;
	}
	public void setMemberNumber(String memberNumber) {
		this.memberNumber = memberNumber;
	}
	public String getBenefitName() {
		return benefitName;
	}
	public void setBenefitName(String benefitName) {
		this.benefitName = benefitName;
	}
	public String getPayerId() {
		return payerId;
	}
	public void setPayerId(String payerId) {
		this.payerId = payerId;
	}
	public BigDecimal getTotalInvoiceAmount() {
		return totalInvoiceAmount;
	}
	public void setTotalInvoiceAmount(BigDecimal totalInvoiceAmount) {
		this.totalInvoiceAmount = totalInvoiceAmount;
	}
	public String getInvoiceNumber() {
		return invoiceNumber;
	}
	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public Long getHospitalProviderId() {
		return hospitalProviderId;
	}
	public void setHospitalProviderId(Long hospitalProviderId) {
		this.hospitalProviderId = hospitalProviderId;
	}
	
	@Override
	public String toString() {
		return "MemberStatement [memberName=" + memberName + ", memberNumber=" + memberNumber + ", benefitName="
				+ benefitName + ", payerId=" + payerId + ", totalInvoiceAmount=" + totalInvoiceAmount
				+ ", invoiceNumber=" + invoiceNumber + ", createdAt=" + createdAt + ", hospitalProviderId="
				+ hospitalProviderId + "]";
	}
	
	
	

}
