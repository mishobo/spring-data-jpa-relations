package com.husseinabdallah287.springdatajparelationships.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.husseinabdallah287.springdatajparelationships.models.Visit;

public interface VisitRepository extends JpaRepository<Visit, Long> {

	public List<Visit> findByMemberNumber(String memberNumber);
	
}
