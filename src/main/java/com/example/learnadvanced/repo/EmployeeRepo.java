package com.example.learnadvanced.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.learnadvanced.entity.Employee;

public interface EmployeeRepo  extends JpaRepository<Employee, Integer>{

}
