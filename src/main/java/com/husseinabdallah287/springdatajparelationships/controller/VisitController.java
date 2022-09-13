package com.husseinabdallah287.springdatajparelationships.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.husseinabdallah287.springdatajparelationships.models.MemberStatementDTO;
import com.husseinabdallah287.springdatajparelationships.models.Visit;
import com.husseinabdallah287.springdatajparelationships.repository.VisitRepository;
import com.husseinabdallah287.springdatajparelationships.service.ReportService;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import net.sf.jasperreports.engine.JRException;

@RestController
@RequestMapping("/api/visit/")
public class VisitController {
	
	@Autowired
	private VisitRepository visitRepository;
	
	@Autowired
	private ReportService reportService;
	
	
    @GetMapping("/report/{memberNumber}/{format}")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response generateReport(@PathVariable String memberNumber, @PathVariable String format) throws JRException, 
    IOException {
    	String familyNumber = splitPJ(memberNumber) + "%";
    	System.out.println("familyNumber :" + familyNumber);
    	System.out.println("format :" + format);
        return reportService.exportMemberStatement(familyNumber, format);
    }
	
    @GetMapping("/getClaimsByMemberNumber/{memberNumber}")
    public List<Visit> getClaimsByMemberNumber(@PathVariable(value="memberNumber") String memberNumber) {
    	String familyNumber = splitPJ(memberNumber) + "%";
    	System.out.println(familyNumber);
        return visitRepository.findByMemberNumberLike(familyNumber);
    }
    
    @GetMapping("/memberStatementData/{memberNumber}")
    public List<MemberStatementDTO> memberStatementData(@PathVariable(value="memberNumber") String memberNumber) {
        return visitRepository.findByMemberNumber(memberNumber);
    }
    
    
    public static String splitPJ(String memberNo){
    	System.out.println("Heloooo "+memberNo);
    	String str1=memberNo.substring(0,memberNo.length());
    	String result[]=str1.split("-");
    	return result[0].toString();
    	
    }
      
}

