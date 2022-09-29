package com.husseinabdallah287.springdatajparelationships.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.husseinabdallah287.springdatajparelationships.models.MemberStatementDTO;
import com.husseinabdallah287.springdatajparelationships.models.Visit;

@Repository
public interface VisitRepository extends JpaRepository<Visit, Long> {

	 List<Visit> findByMemberNumberLike(String familyNumber);
	 
	 @Query("SELECT new com.husseinabdallah287.springdatajparelationships.models.MemberStatementDTO(v.memberName, "
	 		+ "v.memberNumber, v.benefitName, v.payerId, v.totalInvoiceAmount,v.invoiceNumber, v.createdAt, "
	 		+ "v.hospitalProviderId, v.aggregateId, v.balanceAmount, bb.initialLimit, bb.balance) FROM Visit v inner join BeneficiaryBenefit bb on bb.aggregateId = v.aggregateId"
	 		+ " where v.memberNumber = :memberNumber")
	 List<MemberStatementDTO> findByMemberNumber(String memberNumber);
	 
	 
	
}
