package com.mankevich.databases.warehouseapplication.controller.rest;

import com.mankevich.databases.warehouseapplication.exception.DataErrorException;
import com.mankevich.databases.warehouseapplication.exception.NotFoundException;
import com.mankevich.databases.warehouseapplication.model.CompanyRecord;
import com.mankevich.databases.warehouseapplication.repository.CompanyRepository;
import com.mankevich.databases.warehouseapplication.service.impl.CompanyService;
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
@RequestMapping({"/api/company", "/api/companies"})
public class CompanyController {
  private final CompanyRepository companyRepository;
  private final CompanyService companyService;

  public CompanyController(CompanyRepository companyRepository,
						   CompanyService companyService) {
	this.companyRepository = companyRepository;
	this.companyService = companyService;
  }

  @GetMapping("/{id}")
  public ResponseEntity<CompanyRecord> getById(@PathVariable Long id) {
	return ResponseEntity.ok(companyRepository
		.getById(id).orElseThrow(() ->
			new NotFoundException(String.format("No company found with id [%d]", id))));
  }

  @GetMapping
  public ResponseEntity<List<CompanyRecord>> getAll() {
	return ResponseEntity.ok(companyRepository.findAll());
  }

  @PostMapping
  public ResponseEntity<CompanyRecord> save(@RequestBody CompanyRecord companyRecord) {
	return ResponseEntity.ok(companyService
		.save(companyRecord).orElseThrow(() ->
			new DataErrorException("Company was not saved")));
  }

  @PatchMapping("/{id}")
  public ResponseEntity<CompanyRecord> update(@RequestBody CompanyRecord companyRecord,
											  @PathVariable Long id) {
	return ResponseEntity.ok(companyService
		.update(id, companyRecord).orElseThrow(() ->
			new NotFoundException(String.format("No company with such id: [%d]", id))));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity delete(@PathVariable Long id) {
	if (companyService.deleteById(id)) {
	  return ResponseEntity.ok().build();
	} else {
	  log.info("No company with such id: [{}]", id);
	  throw new NotFoundException(String.format("No company with such id: [%d]", id));
	}
  }
}
