package com.husseinabdallah287.springdatajparelationships.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.husseinabdallah287.springdatajparelationships.models.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
