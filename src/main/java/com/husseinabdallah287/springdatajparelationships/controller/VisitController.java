package com.husseinabdallah287.springdatajparelationships.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.husseinabdallah287.springdatajparelationships.models.Visit;
import com.husseinabdallah287.springdatajparelationships.repository.VisitRepository;

@RestController
@RequestMapping("/api/visit/")
public class VisitController {
	
	@Autowired
	private VisitRepository visitRepository;
	
    @GetMapping("/getClaimsByMemberNumber/{memberNumber}")
    public List<Visit> getClaimsByMemberNumber(@PathVariable(value="memberNumber") String memberNumber) {
    	String familyNumber = splitPJ(memberNumber) + "%";
    	System.out.println(familyNumber);
        return visitRepository.findByMemberNumberLike(familyNumber);
    }
    
    
    public static String splitPJ(String memberNo){
    	System.out.println("Heloooo "+memberNo);
    	String str1=memberNo.substring(0,memberNo.length());
    	String result[]=str1.split("-");
    	return result[0].toString();
    	
    }
      
}

