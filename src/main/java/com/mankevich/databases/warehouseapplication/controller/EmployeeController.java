package com.mankevich.databases.warehouseapplication.controller;

import com.mankevich.databases.warehouseapplication.exception.DataErrorException;
import com.mankevich.databases.warehouseapplication.exception.NotFoundException;
import com.mankevich.databases.warehouseapplication.model.EmployeeRecord;
import com.mankevich.databases.warehouseapplication.repository.EmployeeRepository;
import com.mankevich.databases.warehouseapplication.service.impl.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Bogdan Shishkin bogdanshishkin1998@gmail.com
 * created on 12/13/2018
 */
@Slf4j
@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
  private final EmployeeRepository employeeRepository;
  private final EmployeeService employeeService;

  public EmployeeController(EmployeeRepository employeeRepository, 
							EmployeeService employeeService) {
	this.employeeRepository = employeeRepository;
	this.employeeService = employeeService;
  }

  @GetMapping("/{id}")
  public ResponseEntity<EmployeeRecord> getById(@PathVariable Long id) {
	return ResponseEntity.ok(employeeRepository
		.getById(id).orElseThrow(() ->
			new NotFoundException(String.format("No employee found with id [%d]", id))));
  }

  @GetMapping
  public ResponseEntity<List<EmployeeRecord>> getAll() {
	return ResponseEntity.ok(employeeRepository.findAll());
  }

  @PostMapping
  public ResponseEntity<EmployeeRecord> save(@RequestBody EmployeeRecord employeeRecord) {
	return ResponseEntity.ok(employeeService
		.save(employeeRecord).orElseThrow(() ->
			new DataErrorException("Product was not saved")));
  }

  @PatchMapping("/{id}")
  public ResponseEntity<EmployeeRecord> update(@RequestBody EmployeeRecord employeeRecord,
											  @PathVariable Long id) {
	return ResponseEntity.ok(employeeService
		.update(id, employeeRecord).orElseThrow(() ->
			new NotFoundException(String.format("No employee with such id: [%d]", id))));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity delete(@PathVariable Long id) {
	if (employeeService.deleteById(id)) {
	  return ResponseEntity.ok().build();
	} else {
	  log.info("No employee with such id: [{}]", id);
	  throw new NotFoundException(String.format("No employee with such id: [%d]", id));
	}
  }
}
