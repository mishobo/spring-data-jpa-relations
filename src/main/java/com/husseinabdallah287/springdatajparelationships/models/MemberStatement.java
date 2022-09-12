package com.husseinabdallah287.springdatajparelationships.models;

import java.math.BigDecimal;

public class MemberStatement {
	private String memberName;
	private String memberNumber;
	private String benefitName;
	private String payerId;
	private BigDecimal totalInvoiceAmount;
	private String invoiceNumber;
	private String createdAt;
	private String hospitalProviderId;
	
	
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
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	public String getHospitalProviderId() {
		return hospitalProviderId;
	}
	public void setHospitalProviderId(String hospitalProviderId) {
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
