package com.pixeltechnology.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pixeltechnology.employee.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
