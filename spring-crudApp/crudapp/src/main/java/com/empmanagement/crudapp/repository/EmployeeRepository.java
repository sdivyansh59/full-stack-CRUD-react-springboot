package com.empmanagement.crudapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empmanagement.crudapp.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
