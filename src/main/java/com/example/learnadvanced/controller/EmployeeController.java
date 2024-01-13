package com.example.learnadvanced.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.learnadvanced.entity.Employee;
import com.example.learnadvanced.repo.EmployeeRepo;

@RestController
public class EmployeeController {

	private EmployeeRepo empRepo;
	
	public EmployeeController(EmployeeRepo empRepo) {
		super();
		this.empRepo = empRepo;
	}

	@PostMapping("/employee")
	public void create(@RequestBody Employee employee)
	{
		empRepo.save(employee);
	}
	
	@GetMapping("/employee")
	public List<Employee> getEmployees()
	{
		return empRepo.findAll();
	}
	
	@GetMapping("/employee/{id}")
	public Employee getParticularEmployee(@PathVariable int id)
	{
		Optional<Employee> emp = empRepo.findById(id);
		if(emp.isEmpty())
			throw new RuntimeException("Not found");
		return emp.get();
	}
	
	@PutMapping("/employee/{id}")
	public void updateEmployee(@PathVariable int id,@RequestBody Employee employee)
	{
		Optional<Employee> emp = empRepo.findById(id);
		if(emp.isEmpty())
			throw new RuntimeException("Not found");
		empRepo.delete(emp.get());
		empRepo.save(employee);
	}
	
	@DeleteMapping("/employee/{id}")
	public void deleteEmployee(@PathVariable int id)
	{
		empRepo.deleteById(id);
	}
}
