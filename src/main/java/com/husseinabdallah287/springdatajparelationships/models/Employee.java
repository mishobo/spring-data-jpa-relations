package com.husseinabdallah287.springdatajparelationships.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "EMPLOYEE_TBL")
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="employee_id")
    private int id;
    
    @Column(name="employee_name")
    private String name;
    
    @Column(name="employee_department")
    private String designation;
    
    @Column(name="employee_salary")
    private double salary;
    
    @Column(name="employee_doj")
    private String doj;
	
}
