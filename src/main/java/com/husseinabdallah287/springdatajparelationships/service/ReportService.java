package com.husseinabdallah287.springdatajparelationships.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.husseinabdallah287.springdatajparelationships.models.Employee;
import com.husseinabdallah287.springdatajparelationships.models.Visit;
import com.husseinabdallah287.springdatajparelationships.repository.EmployeeRepository;
import com.husseinabdallah287.springdatajparelationships.repository.VisitRepository;

import javax.ws.rs.core.Response;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class ReportService{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private VisitRepository visitRepository;
	
	private static final Logger logger = Logger.getLogger(ReportService.class.getName());
	
	public String exportReport(String reportFormat) throws FileNotFoundException, JRException {
		String path = "E:\\LCT\\version 2\\pdf statements";
		
		List<Employee> employees = employeeRepository.findAll();

		File file = ResourceUtils.getFile("classpath: /employeesReport.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(employees);
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("createdBy", "Java Techie");
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        if (reportFormat.equalsIgnoreCase("html")) {
            JasperExportManager.exportReportToHtmlFile(jasperPrint, path + "\\employees.html");
        }
        if (reportFormat.equalsIgnoreCase("pdf")) {
            JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\employees.pdf");
        }
		
		return "report generated in path : " + path;
	}
	
	
	public ResponseEntity<byte[]>  exportMemberStatement(String familyNumber, String format) throws JRException, IOException {
	
		
		List<Visit> claims = visitRepository.findByMemberNumberLike(familyNumber);
	

		File file = ResourceUtils.getFile("E:\\LCT\\version 2\\statements\\memberStatement.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(claims);
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("createdBy", "Java Techie");
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        if (format.equalsIgnoreCase("html")) {
        }
        if (format.equalsIgnoreCase("pdf")) {
            
            byte data[] = JasperExportManager.exportReportToPdf(jasperPrint);
            
            System.err.println(data);
            
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Disposition", "inline; filename=citiesreport.pdf");
            return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(data);
        }
		return null;
		
		
	}
	
	
	private Response download(String filePath) {
		String fileLocation = filePath;
		Response response = null;
		NumberFormat myFormat = NumberFormat.getInstance();
		myFormat.setGroupingUsed(true);
		// Retrieve the file
		File file = new File(fileLocation);
		if (file.exists()) {
			Response.ResponseBuilder builder = Response.ok(file);
			System.out.println("file path::" + fileLocation);
			builder.header("Content-Disposition", "attachment; filename=" + file.getName());
			response = builder.build();
			long file_size = file.length();
			logger.info(String.format("Inside downloadFile ==> fileName: %s, fileSize: %s bytes", filePath,
					myFormat.format(file_size)));
		} else {
			logger.info(String.format("Inside downloadFile==> FILE NOT FOUND: fileName: %s", fileLocation));

			response = Response.status(404).entity("FILE NOT FOUND: " + fileLocation).type("text/plain").build();
		}

		return response;
	}
	

    	
	
}